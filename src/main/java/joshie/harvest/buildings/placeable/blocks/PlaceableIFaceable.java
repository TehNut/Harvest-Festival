package joshie.harvest.buildings.placeable.blocks;

import joshie.harvest.core.util.Direction;
import joshie.harvest.core.util.IFaceable;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class PlaceableIFaceable extends PlaceableBlock {
    private EnumFacing facing;
    private ResourceLocation chestType;

    @Override
    public boolean canPlace(ConstructionStage stage) {
        return stage == ConstructionStage.DECORATE;
    }

    @Override
    public void postPlace(World world, BlockPos pos, Direction direction) {
        TileEntity tile = world.getTileEntity(pos);
        if (tile instanceof IFaceable) {
            EnumFacing orientation = direction.getRotation().rotate(direction.getMirror().mirror(this.facing));
            ((IFaceable) tile).setFacing(orientation);
            //PacketHandler.sendAround(new PacketSyncOrientation(world.provider.getDimension(), pos, orientation), tile);
        }
    }
}