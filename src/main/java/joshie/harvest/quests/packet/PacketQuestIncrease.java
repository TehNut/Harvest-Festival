package joshie.harvest.quests.packet;

import io.netty.buffer.ByteBuf;
import joshie.harvest.api.quests.Quest;
import joshie.harvest.core.handlers.HFTrackers;
import joshie.harvest.core.network.Packet;
import joshie.harvest.core.network.PenguinPacket;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.network.ByteBufUtils;

import static joshie.harvest.core.network.PacketHandler.sendToClient;

@Packet
public class PacketQuestIncrease extends PenguinPacket {
    private Quest quest;
    private NBTTagCompound tag;

    public PacketQuestIncrease() {}

    public PacketQuestIncrease(Quest quest) {
        this.quest = quest;
    }

    public PacketQuestIncrease(Quest quest, NBTTagCompound tag) {
        this.quest = quest;
        this.tag = tag;
    }

    @Override
    public void toBytes(ByteBuf buf) {
        ByteBufUtils.writeUTF8String(buf, quest.getRegistryName().toString());
        buf.writeBoolean(tag != null);
        if (tag != null) ByteBufUtils.writeTag(buf, tag);
    }

    @Override
    public void fromBytes(ByteBuf buf) {
        quest = Quest.REGISTRY.getValue(new ResourceLocation(ByteBufUtils.readUTF8String(buf)));
        if (buf.readBoolean()) tag = ByteBufUtils.readTag(buf);
    }

    @Override
    public void handlePacket(EntityPlayer player) {
        Quest real = HFTrackers.getPlayerTrackerFromPlayer(player).getQuests().getAQuest(quest);
        if (real != null) {
            if (!player.worldObj.isRemote) {
                int previous = real.quest_stage;
                real.quest_stage++;
                real.onStageChanged(player, previous, real.quest_stage);
                sendToClient(new PacketQuestIncrease(real, real.writeToNBT(new NBTTagCompound())), player);
            } else real.readFromNBT(tag);
        }
    }
}