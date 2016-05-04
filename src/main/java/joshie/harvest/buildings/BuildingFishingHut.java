package joshie.harvest.buildings;

import joshie.harvest.api.buildings.IBuilding;
import joshie.harvest.buildings.placeable.Placeable;
import joshie.harvest.buildings.placeable.blocks.PlaceableBlock;
import joshie.harvest.buildings.placeable.blocks.PlaceableChest;
import joshie.harvest.buildings.placeable.blocks.PlaceableDecorative;
import joshie.harvest.buildings.placeable.blocks.PlaceableFlowerPot;
import joshie.harvest.buildings.placeable.entities.PlaceableItemFrame;
import joshie.harvest.buildings.placeable.entities.PlaceableNPC;
import joshie.harvest.buildings.placeable.entities.PlaceablePainting;
import joshie.harvest.core.handlers.HFTrackers;
import joshie.harvest.core.lib.LootStrings;
import joshie.harvest.player.town.TownData;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.ArrayList;

public class BuildingFishingHut extends Building {
    public BuildingFishingHut() {
        super("fishingHut");
    }

    @Override
    public long getCost() {
        return 6000L;
    }

    @Override
    public int getWoodCount() {
        return 96;
    }

    @Override
    public int getStoneCount() {
        return 0;
    }

    @Override
    public boolean canBuy(World world, EntityPlayer player) {
        return HFTrackers.getPlayerTracker(player).getTown().hasBuilding(HFBuildings.miningHill) &&
                HFTrackers.getPlayerTracker(player).getTown().hasBuilding(HFBuildings.miningHut) &&
                HFTrackers.getPlayerTracker(player).getTown().hasBuilding(HFBuildings.goddessPond);
    }

    @Override
    public IBuilding addBlocks() {
        offsetY = -1;
        list = new ArrayList<Placeable>(345);
        list.add(new PlaceableBlock(Blocks.PLANKS, 5, 2, 0, 1));
        list.add(new PlaceableBlock(Blocks.PLANKS, 5, 2, 0, 5));
        list.add(new PlaceableBlock(Blocks.PLANKS, 5, 3, 0, 0));
        list.add(new PlaceableBlock(Blocks.LOG, 1, 3, 0, 1));
        list.add(new PlaceableBlock(Blocks.PLANKS, 5, 3, 0, 2));
        list.add(new PlaceableBlock(Blocks.PLANKS, 5, 3, 0, 3));
        list.add(new PlaceableBlock(Blocks.PLANKS, 5, 3, 0, 4));
        list.add(new PlaceableBlock(Blocks.LOG, 1, 3, 0, 5));
        list.add(new PlaceableBlock(Blocks.PLANKS, 5, 3, 0, 6));
        list.add(new PlaceableBlock(Blocks.PLANKS, 1, 4, 0, 1));
        list.add(new PlaceableBlock(Blocks.PLANKS, 5, 4, 0, 2));
        list.add(new PlaceableBlock(Blocks.PLANKS, 1, 4, 0, 3));
        list.add(new PlaceableBlock(Blocks.PLANKS, 5, 4, 0, 4));
        list.add(new PlaceableBlock(Blocks.PLANKS, 1, 4, 0, 5));
        list.add(new PlaceableBlock(Blocks.PLANKS, 5, 5, 0, 0));
        list.add(new PlaceableBlock(Blocks.LOG, 1, 5, 0, 1));
        list.add(new PlaceableBlock(Blocks.PLANKS, 5, 5, 0, 2));
        list.add(new PlaceableBlock(Blocks.PLANKS, 1, 5, 0, 3));
        list.add(new PlaceableBlock(Blocks.PLANKS, 5, 5, 0, 4));
        list.add(new PlaceableBlock(Blocks.PLANKS, 1, 5, 0, 5));
        list.add(new PlaceableBlock(Blocks.PLANKS, 5, 6, 0, 1));
        list.add(new PlaceableBlock(Blocks.PLANKS, 1, 6, 0, 2));
        list.add(new PlaceableBlock(Blocks.PLANKS, 1, 6, 0, 3));
        list.add(new PlaceableBlock(Blocks.PLANKS, 1, 6, 0, 4));
        list.add(new PlaceableBlock(Blocks.LOG, 1, 6, 0, 5));
        list.add(new PlaceableBlock(Blocks.PLANKS, 5, 6, 0, 6));
        list.add(new PlaceableBlock(Blocks.PLANKS, 5, 7, 0, 0));
        list.add(new PlaceableBlock(Blocks.LOG, 1, 7, 0, 1));
        list.add(new PlaceableBlock(Blocks.PLANKS, 5, 7, 0, 2));
        list.add(new PlaceableBlock(Blocks.PLANKS, 1, 7, 0, 3));
        list.add(new PlaceableBlock(Blocks.PLANKS, 5, 7, 0, 4));
        list.add(new PlaceableBlock(Blocks.PLANKS, 1, 7, 0, 5));
        list.add(new PlaceableBlock(Blocks.PLANKS, 1, 8, 0, 1));
        list.add(new PlaceableBlock(Blocks.PLANKS, 5, 8, 0, 2));
        list.add(new PlaceableBlock(Blocks.PLANKS, 5, 8, 0, 3));
        list.add(new PlaceableBlock(Blocks.PLANKS, 5, 8, 0, 4));
        list.add(new PlaceableBlock(Blocks.PLANKS, 1, 8, 0, 5));
        list.add(new PlaceableBlock(Blocks.PLANKS, 5, 9, 0, 0));
        list.add(new PlaceableBlock(Blocks.LOG, 1, 9, 0, 1));
        list.add(new PlaceableBlock(Blocks.PLANKS, 1, 9, 0, 2));
        list.add(new PlaceableBlock(Blocks.PLANKS, 1, 9, 0, 3));
        list.add(new PlaceableBlock(Blocks.PLANKS, 1, 9, 0, 4));
        list.add(new PlaceableBlock(Blocks.LOG, 1, 9, 0, 5));
        list.add(new PlaceableBlock(Blocks.PLANKS, 5, 9, 0, 6));
        list.add(new PlaceableBlock(Blocks.PLANKS, 5, 10, 0, 1));
        list.add(new PlaceableBlock(Blocks.PLANKS, 5, 10, 0, 5));
        list.add(new PlaceableBlock(Blocks.DARK_OAK_STAIRS, 0, 2, 1, 1));
        list.add(new PlaceableDecorative(Blocks.TRAPDOOR, 14, 2, 1, 2));
        list.add(new PlaceableDecorative(Blocks.TRAPDOOR, 14, 2, 1, 3));
        list.add(new PlaceableDecorative(Blocks.TRAPDOOR, 14, 2, 1, 4));
        list.add(new PlaceableBlock(Blocks.DARK_OAK_STAIRS, 0, 2, 1, 5));
        list.add(new PlaceableBlock(Blocks.DARK_OAK_STAIRS, 2, 3, 1, 0));
        list.add(new PlaceableBlock(Blocks.LOG, 1, 3, 1, 1));
        list.add(new PlaceableBlock(Blocks.STAINED_HARDENED_CLAY, 0, 3, 1, 2));
        list.add(new PlaceableBlock(Blocks.STAINED_HARDENED_CLAY, 0, 3, 1, 3));
        list.add(new PlaceableBlock(Blocks.STAINED_HARDENED_CLAY, 0, 3, 1, 4));
        list.add(new PlaceableBlock(Blocks.LOG, 1, 3, 1, 5));
        list.add(new PlaceableBlock(Blocks.DARK_OAK_STAIRS, 3, 3, 1, 6));
        list.add(new PlaceableDecorative(Blocks.TRAPDOOR, 12, 4, 1, 0));
        list.add(new PlaceableBlock(Blocks.STAINED_HARDENED_CLAY, 0, 4, 1, 1));
        list.add(new PlaceableDecorative(Blocks.TRAPDOOR, 11, 4, 1, 2));
        list.add(new PlaceableBlock(Blocks.CAULDRON, 3, 4, 1, 3));
        list.add(new PlaceableDecorative(Blocks.TRAPDOOR, 11, 4, 1, 4));
        list.add(new PlaceableBlock(Blocks.STAINED_HARDENED_CLAY, 0, 4, 1, 5));
        list.add(new PlaceableDecorative(Blocks.TRAPDOOR, 13, 4, 1, 6));
        list.add(new PlaceableBlock(Blocks.DARK_OAK_STAIRS, 2, 5, 1, 0));
        list.add(new PlaceableBlock(Blocks.LOG, 1, 5, 1, 1));
        list.add(new PlaceableDecorative(Blocks.VINE, 4, 5, 1, 2));
        list.add(new PlaceableNPC("jacob", new BlockPos(5, 1, 3)));
        npc_offsets.put(TownData.JACOB, new PlaceableNPC("", new BlockPos(5, 1, 3)));
        list.add(new PlaceableBlock(Blocks.AIR, 0, 5, 1, 3));
        list.add(new PlaceableFlowerPot(Blocks.FLOWER_POT, 6, 5, 1, 4));
        list.add(new PlaceableBlock(Blocks.STAINED_HARDENED_CLAY, 0, 5, 1, 5));
        list.add(new PlaceableDecorative(Blocks.TRAPDOOR, 13, 5, 1, 6));
        list.add(new PlaceableDecorative(Blocks.OAK_DOOR, 3, 6, 1, 1));
        list.add(new PlaceableBlock(Blocks.OAK_FENCE, 0, 6, 1, 4));
        list.add(new PlaceableBlock(Blocks.LOG, 1, 6, 1, 5));
        list.add(new PlaceableBlock(Blocks.DARK_OAK_STAIRS, 3, 6, 1, 6));
        list.add(new PlaceableBlock(Blocks.DARK_OAK_STAIRS, 2, 7, 1, 0));
        list.add(new PlaceableBlock(Blocks.LOG, 1, 7, 1, 1));
        list.add(new PlaceableDecorative(Blocks.VINE, 4, 7, 1, 2));
        list.add(new PlaceableDecorative(Blocks.LADDER, 2, 7, 1, 4));
        list.add(new PlaceableBlock(Blocks.STAINED_HARDENED_CLAY, 0, 7, 1, 5));
        list.add(new PlaceableDecorative(Blocks.TRAPDOOR, 13, 7, 1, 6));
        list.add(new PlaceableDecorative(Blocks.TRAPDOOR, 12, 8, 1, 0));
        list.add(new PlaceableBlock(Blocks.STAINED_HARDENED_CLAY, 0, 8, 1, 1));
        list.add(new PlaceableBlock(Blocks.DARK_OAK_STAIRS, 7, 8, 1, 2));
        list.add(new PlaceableBlock(Blocks.DARK_OAK_STAIRS, 4, 8, 1, 3));
        list.add(new PlaceableBlock(Blocks.DARK_OAK_STAIRS, 6, 8, 1, 4));
        list.add(new PlaceableBlock(Blocks.STAINED_HARDENED_CLAY, 0, 8, 1, 5));
        list.add(new PlaceableDecorative(Blocks.TRAPDOOR, 13, 8, 1, 6));
        list.add(new PlaceableBlock(Blocks.DARK_OAK_STAIRS, 2, 9, 1, 0));
        list.add(new PlaceableBlock(Blocks.LOG, 1, 9, 1, 1));
        list.add(new PlaceableBlock(Blocks.STAINED_HARDENED_CLAY, 0, 9, 1, 2));
        list.add(new PlaceableBlock(Blocks.STAINED_HARDENED_CLAY, 0, 9, 1, 3));
        list.add(new PlaceableBlock(Blocks.STAINED_HARDENED_CLAY, 0, 9, 1, 4));
        list.add(new PlaceableBlock(Blocks.LOG, 1, 9, 1, 5));
        list.add(new PlaceableBlock(Blocks.DARK_OAK_STAIRS, 3, 9, 1, 6));
        list.add(new PlaceableBlock(Blocks.DARK_OAK_STAIRS, 1, 10, 1, 1));
        list.add(new PlaceableDecorative(Blocks.TRAPDOOR, 15, 10, 1, 2));
        list.add(new PlaceableDecorative(Blocks.TRAPDOOR, 15, 10, 1, 3));
        list.add(new PlaceableDecorative(Blocks.TRAPDOOR, 15, 10, 1, 4));
        list.add(new PlaceableBlock(Blocks.DARK_OAK_STAIRS, 1, 10, 1, 5));
        list.add(new PlaceableDecorative(Blocks.WOODEN_BUTTON, 2, 2, 2, 1));
        list.add(new PlaceableDecorative(Blocks.VINE, 8, 2, 2, 2));
        list.add(new PlaceableDecorative(Blocks.VINE, 8, 2, 2, 4));
        list.add(new PlaceableDecorative(Blocks.WOODEN_BUTTON, 2, 2, 2, 5));
        list.add(new PlaceableDecorative(Blocks.WOODEN_BUTTON, 4, 3, 2, 0));
        list.add(new PlaceableBlock(Blocks.LOG, 1, 3, 2, 1));
        list.add(new PlaceableBlock(Blocks.PLANKS, 1, 3, 2, 2));
        list.add(new PlaceableBlock(Blocks.STAINED_GLASS_PANE, 0, 3, 2, 3));
        list.add(new PlaceableBlock(Blocks.PLANKS, 1, 3, 2, 4));
        list.add(new PlaceableBlock(Blocks.LOG, 1, 3, 2, 5));
        list.add(new PlaceableDecorative(Blocks.WOODEN_BUTTON, 3, 3, 2, 6));
        list.add(new PlaceableBlock(Blocks.PLANKS, 1, 4, 2, 1));
        list.add(new PlaceableDecorative(Blocks.LEVER, 1, 4, 2, 2));
        list.add(new PlaceableDecorative(Blocks.LEVER, 1, 4, 2, 4));
        list.add(new PlaceableBlock(Blocks.PLANKS, 1, 4, 2, 5));
        list.add(new PlaceableDecorative(Blocks.TORCH, 4, 5, 2, 0));
        list.add(new PlaceableItemFrame(new ItemStack(Blocks.TRAPDOOR, 1, 0), 0, EnumFacing.NORTH, 5, 2, 0));
        list.add(new PlaceableBlock(Blocks.LOG, 1, 5, 2, 1));
        list.add(new PlaceableDecorative(Blocks.VINE, 4, 5, 2, 2));
        list.add(new PlaceableDecorative(Blocks.VINE, 1, 5, 2, 4));
        list.add(new PlaceableBlock(Blocks.PLANKS, 1, 5, 2, 5));
        list.add(new PlaceableDecorative(Blocks.VINE, 4, 5, 2, 6));
        list.add(new PlaceableDecorative(Blocks.OAK_DOOR, 8, 6, 2, 1));
        list.add(new PlaceableDecorative(Blocks.TORCH, 5, 6, 2, 4));
        list.add(new PlaceableBlock(Blocks.LOG, 1, 6, 2, 5));
        list.add(new PlaceableDecorative(Blocks.WOODEN_BUTTON, 3, 6, 2, 6));
        list.add(new PlaceableDecorative(Blocks.TORCH, 4, 7, 2, 0));
        list.add(new PlaceableItemFrame(new ItemStack(Blocks.TRAPDOOR, 1, 0), 0, EnumFacing.NORTH, 7, 2, 0));
        list.add(new PlaceableBlock(Blocks.LOG, 1, 7, 2, 1));
        list.add(new PlaceableDecorative(Blocks.LADDER, 2, 7, 2, 4));
        list.add(new PlaceableBlock(Blocks.PLANKS, 1, 7, 2, 5));
        list.add(new PlaceableDecorative(Blocks.VINE, 4, 7, 2, 6));
        list.add(new PlaceableDecorative(Blocks.VINE, 1, 8, 2, 0));
        list.add(new PlaceableBlock(Blocks.PLANKS, 1, 8, 2, 1));
        list.add(new PlaceableFlowerPot(Blocks.FLOWER_POT, 5, 8, 2, 2));
        list.add(new PlaceableBlock(Blocks.WOODEN_PRESSURE_PLATE, 0, 8, 2, 3));
        list.add(new PlaceableChest(Blocks.CHEST, 4, 8, 2, 4, LootStrings.FISHING_CHEST));
        list.add(new PlaceableBlock(Blocks.PLANKS, 1, 8, 2, 5));
        list.add(new PlaceableDecorative(Blocks.VINE, 4, 8, 2, 6));
        list.add(new PlaceableDecorative(Blocks.WOODEN_BUTTON, 4, 9, 2, 0));
        list.add(new PlaceableBlock(Blocks.LOG, 1, 9, 2, 1));
        list.add(new PlaceableBlock(Blocks.PLANKS, 1, 9, 2, 2));
        list.add(new PlaceableBlock(Blocks.STAINED_GLASS_PANE, 0, 9, 2, 3));
        list.add(new PlaceableBlock(Blocks.PLANKS, 1, 9, 2, 4));
        list.add(new PlaceableBlock(Blocks.LOG, 1, 9, 2, 5));
        list.add(new PlaceableDecorative(Blocks.WOODEN_BUTTON, 3, 9, 2, 6));
        list.add(new PlaceableDecorative(Blocks.WOODEN_BUTTON, 1, 10, 2, 1));
        list.add(new PlaceableDecorative(Blocks.VINE, 2, 10, 2, 4));
        list.add(new PlaceableDecorative(Blocks.WOODEN_BUTTON, 1, 10, 2, 5));
        list.add(new PlaceableBlock(Blocks.DARK_OAK_STAIRS, 4, 2, 3, 1));
        list.add(new PlaceableDecorative(Blocks.VINE, 8, 2, 3, 2));
        list.add(new PlaceableBlock(Blocks.DARK_OAK_STAIRS, 4, 2, 3, 5));
        list.add(new PlaceableBlock(Blocks.DARK_OAK_STAIRS, 6, 3, 3, 0));
        list.add(new PlaceableBlock(Blocks.LOG, 1, 3, 3, 1));
        list.add(new PlaceableBlock(Blocks.PLANKS, 1, 3, 3, 2));
        list.add(new PlaceableBlock(Blocks.STAINED_GLASS_PANE, 0, 3, 3, 3));
        list.add(new PlaceableBlock(Blocks.PLANKS, 1, 3, 3, 4));
        list.add(new PlaceableBlock(Blocks.LOG, 1, 3, 3, 5));
        list.add(new PlaceableBlock(Blocks.DARK_OAK_STAIRS, 7, 3, 3, 6));
        list.add(new PlaceableBlock(Blocks.SPRUCE_STAIRS, 2, 4, 3, 1));
        list.add(new PlaceableDecorative(Blocks.TRAPDOOR, 9, 4, 3, 2));
        list.add(new PlaceableBlock(Blocks.WOODEN_SLAB, 9, 4, 3, 3));
        list.add(new PlaceableDecorative(Blocks.TRAPDOOR, 8, 4, 3, 4));
        list.add(new PlaceableBlock(Blocks.SPRUCE_STAIRS, 3, 4, 3, 5));
        list.add(new PlaceableBlock(Blocks.SPRUCE_STAIRS, 2, 5, 3, 1));
        list.add(new PlaceableDecorative(Blocks.TRAPDOOR, 9, 5, 3, 2));
        list.add(new PlaceableBlock(Blocks.WOODEN_SLAB, 9, 5, 3, 3));
        list.add(new PlaceableDecorative(Blocks.TRAPDOOR, 8, 5, 3, 4));
        list.add(new PlaceableBlock(Blocks.SPRUCE_STAIRS, 3, 5, 3, 5));
        list.add(new PlaceableBlock(Blocks.DARK_OAK_STAIRS, 6, 6, 3, 0));
        list.add(new PlaceableBlock(Blocks.LOG, 1, 6, 3, 1));
        list.add(new PlaceableBlock(Blocks.WOODEN_SLAB, 9, 6, 3, 2));
        list.add(new PlaceableBlock(Blocks.WOODEN_SLAB, 9, 6, 3, 4));
        list.add(new PlaceableBlock(Blocks.LOG, 1, 6, 3, 5));
        list.add(new PlaceableBlock(Blocks.DARK_OAK_STAIRS, 7, 6, 3, 6));
        list.add(new PlaceableBlock(Blocks.SPRUCE_STAIRS, 2, 7, 3, 1));
        list.add(new PlaceableDecorative(Blocks.TRAPDOOR, 9, 7, 3, 2));
        list.add(new PlaceableBlock(Blocks.WOODEN_SLAB, 9, 7, 3, 3));
        list.add(new PlaceableDecorative(Blocks.TRAPDOOR, 9, 7, 3, 4));
        list.add(new PlaceableBlock(Blocks.SPRUCE_STAIRS, 3, 7, 3, 5));
        list.add(new PlaceableBlock(Blocks.SPRUCE_STAIRS, 2, 8, 3, 1));
        list.add(new PlaceableDecorative(Blocks.TRAPDOOR, 9, 8, 3, 2));
        list.add(new PlaceableBlock(Blocks.WOODEN_SLAB, 9, 8, 3, 3));
        list.add(new PlaceableDecorative(Blocks.TRAPDOOR, 8, 8, 3, 4));
        list.add(new PlaceableBlock(Blocks.SPRUCE_STAIRS, 3, 8, 3, 5));
        list.add(new PlaceableBlock(Blocks.DARK_OAK_STAIRS, 6, 9, 3, 0));
        list.add(new PlaceableBlock(Blocks.LOG, 1, 9, 3, 1));
        list.add(new PlaceableBlock(Blocks.PLANKS, 1, 9, 3, 2));
        list.add(new PlaceableBlock(Blocks.STAINED_GLASS_PANE, 0, 9, 3, 3));
        list.add(new PlaceableBlock(Blocks.PLANKS, 1, 9, 3, 4));
        list.add(new PlaceableBlock(Blocks.LOG, 1, 9, 3, 5));
        list.add(new PlaceableBlock(Blocks.DARK_OAK_STAIRS, 7, 9, 3, 6));
        list.add(new PlaceableBlock(Blocks.DARK_OAK_STAIRS, 5, 10, 3, 1));
        list.add(new PlaceableDecorative(Blocks.VINE, 2, 10, 3, 4));
        list.add(new PlaceableBlock(Blocks.DARK_OAK_STAIRS, 5, 10, 3, 5));
        list.add(new PlaceableBlock(Blocks.OAK_FENCE, 0, 2, 4, 1));
        list.add(new PlaceableBlock(Blocks.OAK_FENCE, 0, 2, 4, 5));
        list.add(new PlaceableBlock(Blocks.OAK_FENCE, 0, 3, 4, 0));
        list.add(new PlaceableBlock(Blocks.STAINED_HARDENED_CLAY, 0, 3, 4, 1));
        list.add(new PlaceableBlock(Blocks.SPRUCE_STAIRS, 0, 3, 4, 2));
        list.add(new PlaceableBlock(Blocks.SPRUCE_STAIRS, 4, 3, 4, 3));
        list.add(new PlaceableBlock(Blocks.SPRUCE_STAIRS, 0, 3, 4, 4));
        list.add(new PlaceableBlock(Blocks.STAINED_HARDENED_CLAY, 0, 3, 4, 5));
        list.add(new PlaceableBlock(Blocks.OAK_FENCE, 0, 3, 4, 6));
        list.add(new PlaceableBlock(Blocks.SPRUCE_STAIRS, 6, 4, 4, 1));
        list.add(new PlaceableBlock(Blocks.DOUBLE_WOODEN_SLAB, 5, 4, 4, 2));
        list.add(new PlaceableBlock(Blocks.WOOL, 0, 4, 4, 3));
        list.add(new PlaceableBlock(Blocks.DOUBLE_WOODEN_SLAB, 5, 4, 4, 4));
        list.add(new PlaceableBlock(Blocks.SPRUCE_STAIRS, 7, 4, 4, 5));
        list.add(new PlaceableBlock(Blocks.SPRUCE_STAIRS, 6, 5, 4, 1));
        list.add(new PlaceableBlock(Blocks.WOODEN_SLAB, 5, 5, 4, 2));
        list.add(new PlaceableBlock(Blocks.WOOL, 9, 5, 4, 3));
        list.add(new PlaceableBlock(Blocks.WOODEN_SLAB, 5, 5, 4, 4));
        list.add(new PlaceableBlock(Blocks.SPRUCE_STAIRS, 7, 5, 4, 5));
        list.add(new PlaceableBlock(Blocks.OAK_FENCE, 0, 6, 4, 0));
        list.add(new PlaceableBlock(Blocks.STAINED_HARDENED_CLAY, 0, 6, 4, 1));
        list.add(new PlaceableBlock(Blocks.DOUBLE_WOODEN_SLAB, 1, 6, 4, 2));
        list.add(new PlaceableBlock(Blocks.WOODEN_SLAB, 5, 6, 4, 3));
        list.add(new PlaceableBlock(Blocks.DOUBLE_WOODEN_SLAB, 1, 6, 4, 4));
        list.add(new PlaceableBlock(Blocks.STAINED_HARDENED_CLAY, 0, 6, 4, 5));
        list.add(new PlaceableBlock(Blocks.OAK_FENCE, 0, 6, 4, 6));
        list.add(new PlaceableBlock(Blocks.SPRUCE_STAIRS, 6, 7, 4, 1));
        list.add(new PlaceableBlock(Blocks.WOODEN_SLAB, 5, 7, 4, 2));
        list.add(new PlaceableBlock(Blocks.SPRUCE_STAIRS, 7, 7, 4, 5));
        list.add(new PlaceableBlock(Blocks.SPRUCE_STAIRS, 6, 8, 4, 1));
        list.add(new PlaceableBlock(Blocks.WOODEN_SLAB, 5, 8, 4, 2));
        list.add(new PlaceableDecorative(Blocks.LADDER, 4, 8, 4, 3));
        list.add(new PlaceableBlock(Blocks.WOODEN_SLAB, 5, 8, 4, 4));
        list.add(new PlaceableBlock(Blocks.SPRUCE_STAIRS, 7, 8, 4, 5));
        list.add(new PlaceableBlock(Blocks.OAK_FENCE, 0, 9, 4, 0));
        list.add(new PlaceableBlock(Blocks.STAINED_HARDENED_CLAY, 0, 9, 4, 1));
        list.add(new PlaceableBlock(Blocks.SPRUCE_STAIRS, 1, 9, 4, 2));
        list.add(new PlaceableBlock(Blocks.SPRUCE_STAIRS, 5, 9, 4, 3));
        list.add(new PlaceableBlock(Blocks.SPRUCE_STAIRS, 1, 9, 4, 4));
        list.add(new PlaceableBlock(Blocks.STAINED_HARDENED_CLAY, 0, 9, 4, 5));
        list.add(new PlaceableBlock(Blocks.OAK_FENCE, 0, 9, 4, 6));
        list.add(new PlaceableBlock(Blocks.OAK_FENCE, 0, 10, 4, 1));
        list.add(new PlaceableBlock(Blocks.OAK_FENCE, 0, 10, 4, 5));
        list.add(new PlaceableBlock(Blocks.WOODEN_SLAB, 13, 0, 5, 3));
        list.add(new PlaceableBlock(Blocks.DARK_OAK_STAIRS, 2, 2, 5, 1));
        list.add(new PlaceableBlock(Blocks.DARK_OAK_STAIRS, 7, 2, 5, 2));
        list.add(new PlaceableBlock(Blocks.DARK_OAK_STAIRS, 6, 2, 5, 4));
        list.add(new PlaceableBlock(Blocks.DARK_OAK_STAIRS, 3, 2, 5, 5));
        list.add(new PlaceableBlock(Blocks.WOODEN_SLAB, 5, 3, 5, 0));
        list.add(new PlaceableBlock(Blocks.SPRUCE_STAIRS, 2, 3, 5, 1));
        list.add(new PlaceableBlock(Blocks.PLANKS, 1, 3, 5, 2));
        list.add(new PlaceableBlock(Blocks.SPRUCE_STAIRS, 4, 3, 5, 3));
        list.add(new PlaceableBlock(Blocks.PLANKS, 1, 3, 5, 4));
        list.add(new PlaceableBlock(Blocks.SPRUCE_STAIRS, 3, 3, 5, 5));
        list.add(new PlaceableBlock(Blocks.WOODEN_SLAB, 5, 3, 5, 6));
        list.add(new PlaceableBlock(Blocks.DARK_OAK_STAIRS, 2, 4, 5, 0));
        list.add(new PlaceableBlock(Blocks.DARK_OAK_STAIRS, 7, 4, 5, 1));
        list.add(new PlaceableDecorative(Blocks.TORCH, 5, 4, 5, 2));
        list.add(new PlaceableBlock(Blocks.AIR, 0, 4, 5, 3));
        list.add(new PlaceablePainting("Bomb", EnumFacing.EAST, 4, 5, 3));
        list.add(new PlaceableFlowerPot(Blocks.FLOWER_POT, 7, 4, 5, 4));
        list.add(new PlaceableBlock(Blocks.DARK_OAK_STAIRS, 6, 4, 5, 5));
        list.add(new PlaceableBlock(Blocks.DARK_OAK_STAIRS, 3, 4, 5, 6));
        list.add(new PlaceableBlock(Blocks.DARK_OAK_STAIRS, 2, 5, 5, 0));
        list.add(new PlaceableBlock(Blocks.DARK_OAK_STAIRS, 7, 5, 5, 1));
        list.add(new PlaceableBlock(Blocks.DARK_OAK_STAIRS, 6, 5, 5, 5));
        list.add(new PlaceableBlock(Blocks.DARK_OAK_STAIRS, 3, 5, 5, 6));
        list.add(new PlaceableBlock(Blocks.WOODEN_SLAB, 5, 6, 5, 0));
        list.add(new PlaceableBlock(Blocks.SPRUCE_STAIRS, 2, 6, 5, 1));
        list.add(new PlaceableBlock(Blocks.SPRUCE_STAIRS, 7, 6, 5, 2));
        list.add(new PlaceableBlock(Blocks.SPRUCE_STAIRS, 6, 6, 5, 4));
        list.add(new PlaceableBlock(Blocks.SPRUCE_STAIRS, 3, 6, 5, 5));
        list.add(new PlaceableBlock(Blocks.WOODEN_SLAB, 5, 6, 5, 6));
        list.add(new PlaceableBlock(Blocks.DARK_OAK_STAIRS, 2, 7, 5, 0));
        list.add(new PlaceableBlock(Blocks.DARK_OAK_STAIRS, 7, 7, 5, 1));
        list.add(new PlaceableBlock(Blocks.DARK_OAK_STAIRS, 6, 7, 5, 5));
        list.add(new PlaceableBlock(Blocks.DARK_OAK_STAIRS, 3, 7, 5, 6));
        list.add(new PlaceableBlock(Blocks.DARK_OAK_STAIRS, 2, 8, 5, 0));
        list.add(new PlaceableBlock(Blocks.DARK_OAK_STAIRS, 7, 8, 5, 1));
        list.add(new PlaceableDecorative(Blocks.WOODEN_BUTTON, 2, 8, 5, 2));
        list.add(new PlaceableDecorative(Blocks.TORCH, 2, 8, 5, 3));
        list.add(new PlaceableItemFrame(new ItemStack(Blocks.TRAPDOOR, 1, 0), 0, EnumFacing.WEST, 8, 5, 3));
        list.add(new PlaceableDecorative(Blocks.WOODEN_BUTTON, 2, 8, 5, 4));
        list.add(new PlaceableBlock(Blocks.DARK_OAK_STAIRS, 6, 8, 5, 5));
        list.add(new PlaceableBlock(Blocks.DARK_OAK_STAIRS, 3, 8, 5, 6));
        list.add(new PlaceableBlock(Blocks.WOODEN_SLAB, 5, 9, 5, 0));
        list.add(new PlaceableBlock(Blocks.SPRUCE_STAIRS, 2, 9, 5, 1));
        list.add(new PlaceableBlock(Blocks.PLANKS, 1, 9, 5, 2));
        list.add(new PlaceableBlock(Blocks.SPRUCE_STAIRS, 5, 9, 5, 3));
        list.add(new PlaceableBlock(Blocks.PLANKS, 1, 9, 5, 4));
        list.add(new PlaceableBlock(Blocks.SPRUCE_STAIRS, 3, 9, 5, 5));
        list.add(new PlaceableBlock(Blocks.WOODEN_SLAB, 5, 9, 5, 6));
        list.add(new PlaceableBlock(Blocks.DARK_OAK_STAIRS, 2, 10, 5, 1));
        list.add(new PlaceableBlock(Blocks.DARK_OAK_STAIRS, 7, 10, 5, 2));
        list.add(new PlaceableBlock(Blocks.DARK_OAK_STAIRS, 6, 10, 5, 4));
        list.add(new PlaceableBlock(Blocks.DARK_OAK_STAIRS, 3, 10, 5, 5));
        list.add(new PlaceableBlock(Blocks.WOODEN_SLAB, 13, 12, 5, 3));
        list.add(new PlaceableBlock(Blocks.OAK_FENCE, 0, 0, 6, 3));
        list.add(new PlaceableBlock(Blocks.DARK_OAK_STAIRS, 2, 2, 6, 2));
        list.add(new PlaceableBlock(Blocks.DARK_OAK_STAIRS, 4, 2, 6, 3));
        list.add(new PlaceableBlock(Blocks.DARK_OAK_STAIRS, 3, 2, 6, 4));
        list.add(new PlaceableBlock(Blocks.SPRUCE_STAIRS, 2, 3, 6, 2));
        list.add(new PlaceableBlock(Blocks.PLANKS, 1, 3, 6, 3));
        list.add(new PlaceableBlock(Blocks.SPRUCE_STAIRS, 3, 3, 6, 4));
        list.add(new PlaceableBlock(Blocks.DARK_OAK_STAIRS, 2, 4, 6, 1));
        list.add(new PlaceableBlock(Blocks.DARK_OAK_STAIRS, 7, 4, 6, 2));
        list.add(new PlaceableBlock(Blocks.AIR, 0, 4, 6, 3));
        list.add(new PlaceableItemFrame(new ItemStack(Items.FISH, 1, 1), 0, EnumFacing.EAST, 4, 6, 3, LootStrings.FISHING_FRAME));
        list.add(new PlaceableBlock(Blocks.DARK_OAK_STAIRS, 6, 4, 6, 4));
        list.add(new PlaceableBlock(Blocks.DARK_OAK_STAIRS, 3, 4, 6, 5));
        list.add(new PlaceableBlock(Blocks.DARK_OAK_STAIRS, 2, 5, 6, 1));
        list.add(new PlaceableBlock(Blocks.DARK_OAK_STAIRS, 7, 5, 6, 2));
        list.add(new PlaceableBlock(Blocks.DARK_OAK_STAIRS, 6, 5, 6, 4));
        list.add(new PlaceableBlock(Blocks.DARK_OAK_STAIRS, 3, 5, 6, 5));
        list.add(new PlaceableBlock(Blocks.SPRUCE_STAIRS, 2, 6, 6, 2));
        list.add(new PlaceableBlock(Blocks.SPRUCE_STAIRS, 3, 6, 6, 4));
        list.add(new PlaceableBlock(Blocks.DARK_OAK_STAIRS, 2, 7, 6, 1));
        list.add(new PlaceableBlock(Blocks.DARK_OAK_STAIRS, 7, 7, 6, 2));
        list.add(new PlaceableBlock(Blocks.DARK_OAK_STAIRS, 6, 7, 6, 4));
        list.add(new PlaceableBlock(Blocks.DARK_OAK_STAIRS, 3, 7, 6, 5));
        list.add(new PlaceableBlock(Blocks.DARK_OAK_STAIRS, 2, 8, 6, 1));
        list.add(new PlaceableBlock(Blocks.DARK_OAK_STAIRS, 7, 8, 6, 2));
        list.add(new PlaceableDecorative(Blocks.LADDER, 4, 8, 6, 3));
        list.add(new PlaceableBlock(Blocks.DARK_OAK_STAIRS, 6, 8, 6, 4));
        list.add(new PlaceableBlock(Blocks.DARK_OAK_STAIRS, 3, 8, 6, 5));
        list.add(new PlaceableBlock(Blocks.SPRUCE_STAIRS, 2, 9, 6, 2));
        list.add(new PlaceableBlock(Blocks.PLANKS, 1, 9, 6, 3));
        list.add(new PlaceableBlock(Blocks.SPRUCE_STAIRS, 3, 9, 6, 4));
        list.add(new PlaceableBlock(Blocks.DARK_OAK_STAIRS, 2, 10, 6, 2));
        list.add(new PlaceableBlock(Blocks.DARK_OAK_STAIRS, 5, 10, 6, 3));
        list.add(new PlaceableBlock(Blocks.DARK_OAK_STAIRS, 3, 10, 6, 4));
        list.add(new PlaceableBlock(Blocks.OAK_FENCE, 0, 12, 6, 3));
        list.add(new PlaceableBlock(Blocks.OAK_FENCE, 0, 0, 7, 3));
        list.add(new PlaceableBlock(Blocks.WOODEN_SLAB, 13, 1, 7, 3));
        list.add(new PlaceableBlock(Blocks.WOODEN_SLAB, 5, 2, 7, 3));
        list.add(new PlaceableBlock(Blocks.WOODEN_SLAB, 1, 3, 7, 3));
        list.add(new PlaceableBlock(Blocks.WOODEN_SLAB, 5, 4, 7, 2));
        list.add(new PlaceableBlock(Blocks.WOODEN_SLAB, 13, 4, 7, 3));
        list.add(new PlaceableBlock(Blocks.WOODEN_SLAB, 5, 4, 7, 4));
        list.add(new PlaceableBlock(Blocks.WOODEN_SLAB, 5, 5, 7, 2));
        list.add(new PlaceableBlock(Blocks.WOODEN_SLAB, 13, 5, 7, 3));
        list.add(new PlaceableBlock(Blocks.WOODEN_SLAB, 5, 5, 7, 4));
        list.add(new PlaceableBlock(Blocks.WOODEN_SLAB, 1, 6, 7, 3));
        list.add(new PlaceableBlock(Blocks.WOODEN_SLAB, 5, 7, 7, 2));
        list.add(new PlaceableBlock(Blocks.WOODEN_SLAB, 13, 7, 7, 3));
        list.add(new PlaceableBlock(Blocks.WOODEN_SLAB, 5, 7, 7, 4));
        list.add(new PlaceableBlock(Blocks.WOODEN_SLAB, 5, 8, 7, 2));
        list.add(new PlaceableBlock(Blocks.WOODEN_SLAB, 13, 8, 7, 3));
        list.add(new PlaceableBlock(Blocks.WOODEN_SLAB, 5, 8, 7, 4));
        list.add(new PlaceableBlock(Blocks.WOODEN_SLAB, 1, 9, 7, 3));
        list.add(new PlaceableBlock(Blocks.WOODEN_SLAB, 5, 10, 7, 3));
        list.add(new PlaceableBlock(Blocks.WOODEN_SLAB, 13, 11, 7, 3));
        list.add(new PlaceableBlock(Blocks.OAK_FENCE, 0, 12, 7, 3));
        list.add(new PlaceableBlock(Blocks.WOODEN_SLAB, 5, 0, 8, 3));
        list.add(new PlaceableBlock(Blocks.WOODEN_SLAB, 5, 12, 8, 3));
        return this;
    }
}