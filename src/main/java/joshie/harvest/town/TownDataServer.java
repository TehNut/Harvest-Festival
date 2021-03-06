package joshie.harvest.town;

import joshie.harvest.api.npc.INPC;
import joshie.harvest.buildings.BuildingImpl;
import joshie.harvest.buildings.BuildingStage;
import joshie.harvest.core.handlers.HFTrackers;
import joshie.harvest.core.helpers.EntityHelper;
import joshie.harvest.core.helpers.NBTHelper;
import joshie.harvest.core.network.PacketHandler;
import joshie.harvest.gathering.GatheringData;
import joshie.harvest.npc.HFNPCs;
import joshie.harvest.npc.NPC;
import joshie.harvest.npc.NPCHelper;
import joshie.harvest.npc.NPCRegistry;
import joshie.harvest.npc.entity.EntityNPCBuilder;
import joshie.harvest.npc.entity.EntityNPCHuman;
import joshie.harvest.town.packet.PacketSyncBuilding;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.Mirror;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class TownDataServer extends TownData {
    public final GatheringData gathering = new GatheringData();
    private Set<ResourceLocation> deadVillagers = new HashSet<>();

    public TownDataServer() {}
    public TownDataServer(BlockPos pos) {
        townCentre = pos;
        uuid = UUID.randomUUID();
    }

    public boolean isDead(INPC npc) {
        return deadVillagers.contains(((NPC)npc).getRegistryName());
    }

    public void markNPCDead(ResourceLocation name) {
        deadVillagers.add(name);
    }

    public EntityNPCBuilder getBuilder(WorldServer world) {
        return (EntityNPCBuilder) world.getEntityFromUuid(getID());
    }

    public void syncBuildings(World world) {
        PacketHandler.sendToDimension(world.provider.getDimension(), new PacketSyncBuilding(getID(), this.building));
    }

    public boolean setBuilding(World world, BuildingImpl building, BlockPos pos, Mirror mirror, Rotation rotation) {
        BuildingStage stage = new BuildingStage(building, pos, mirror, rotation);
        if (!this.building.contains(stage)) {
            this.building.addLast(stage);
            HFTrackers.markDirty(world);
            syncBuildings(world);
            return true;
        }

        return false;
    }

    public void finishBuilding(World world) {
        this.building.removeFirst(); //Remove the first building
        HFTrackers.markDirty(world);
    }

    @Override
    public void newDay(World world) {
        gathering.newDay(world, buildings.values());
        for (ResourceLocation villager: deadVillagers) {
            NPC npc = NPCRegistry.REGISTRY.getValue(villager);
            if (npc != HFNPCs.GODDESS) {
                EntityNPCHuman entity = NPCHelper.getEntityForNPC(world, npc);
                entity.setPosition(townCentre.getX(), townCentre.getY(), townCentre.getZ());
                entity.resetSpawnHome();
                BlockPos pos = entity.getHomeCoordinates();
                int attempts = 0;
                while (!EntityHelper.isSpawnable(world, pos) && attempts < 64) {
                    pos = pos.add(world.rand.nextInt(16) - 8, world.rand.nextInt(8), world.rand.nextInt(16) - 8);
                    attempts++;
                }

                entity.setPositionAndUpdate(pos.getX(), pos.getY(), pos.getZ());
                if (npc == HFNPCs.BUILDER) entity.setUniqueId(getID()); //Keep the Unique ID the same
                world.spawnEntityInWorld(entity);
            }
        }

        deadVillagers = new HashSet<>(); //Reset the dead villagers
    }

    @Override
    public void readFromNBT(NBTTagCompound nbt) {
        super.readFromNBT(nbt);
        gathering.readFromNBT(nbt);
        deadVillagers = NBTHelper.readResourceSet(nbt, "DeadVillagers");
    }

    @Override
    public void writeToNBT(NBTTagCompound nbt) {
        super.writeToNBT(nbt);
        gathering.writeToNBT(nbt);
        nbt.setTag("DeadVillagers", NBTHelper.writeResourceSet(deadVillagers));
    }
}
