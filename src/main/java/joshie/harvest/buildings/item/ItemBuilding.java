package joshie.harvest.buildings.item;

import joshie.harvest.buildings.BuildingHelper;
import joshie.harvest.buildings.BuildingImpl;
import joshie.harvest.buildings.BuildingRegistry;
import joshie.harvest.buildings.HFBuildings;
import joshie.harvest.buildings.render.RenderKey;
import joshie.harvest.core.HFTab;
import joshie.harvest.core.base.item.ItemHFFML;
import joshie.harvest.core.helpers.ChatHelper;
import joshie.harvest.core.util.ICreativeSorted;
import joshie.harvest.core.util.Text;
import joshie.harvest.town.TownHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;

import static joshie.harvest.core.HFCore.DEBUG_MODE;

public class ItemBuilding extends ItemHFFML<ItemBuilding, BuildingImpl> implements ICreativeSorted {
    public ItemBuilding() {
        super(BuildingRegistry.REGISTRY, HFTab.TOWN);
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(ItemStack stack, World world, EntityPlayer player, EnumHand hand) {
        if (world.provider.getDimension() == 0) {
            RayTraceResult raytrace = BuildingHelper.rayTrace(player, 128, 0F);
            if (raytrace == null || raytrace.getBlockPos() == null) {
                return new ActionResult<>(EnumActionResult.PASS, stack);
            }

            BuildingImpl building = getObjectFromStack(stack);
            if (building != null && (DEBUG_MODE || building.canHaveMultiple() || !TownHelper.getClosestTownToEntity(player).hasBuilding(building.getRegistryName()))) {
                if(player.canPlayerEdit(raytrace.getBlockPos(), EnumFacing.DOWN, stack)) {
                    if (!world.isRemote) {
                        TownHelper.ensureTownExists(world, raytrace.getBlockPos()); //Force a town to exist near where you clicked
                    }

                    RenderKey key = BuildingHelper.getPositioning(stack, world, raytrace, building, player, true);
                    if (key != null) {
                        stack.splitStack(1);
                        return new ActionResult<>(building.generate(world, key.getPos(), key.getMirror(), key.getRotation()), stack);
                    }
                } else if (world.isRemote) ChatHelper.displayChat(TextFormatting.RED + Text.translate("town.failure") + " " + TextFormatting.WHITE + Text.translate("town.permission"));
            } else if (world.isRemote) ChatHelper.displayChat(TextFormatting.RED + Text.translate("town.failure") + " " + TextFormatting.WHITE + Text.translate("town.distance"));
        } else if (world.isRemote) ChatHelper.displayChat(TextFormatting.RED + Text.translate("town.failure") + " " + TextFormatting.WHITE + Text.translate("town.dimension"));
        return new ActionResult<>(EnumActionResult.PASS, stack);
    }

    @Override
    public BuildingImpl getNullValue() {
        return HFBuildings.null_building;
    }

    @Override
    public String getItemStackDisplayName(ItemStack stack) {
        return Text.format("harvestfestival.structures.spawn", getObjectFromStack(stack).getLocalisedName());
    }

    @Override
    public int getSortValue(ItemStack stack) {
        return 200;
    }
}
