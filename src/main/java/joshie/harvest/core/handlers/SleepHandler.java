package joshie.harvest.core.handlers;

import joshie.harvest.core.HFCore;
import joshie.harvest.core.util.HFEvents;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayer.SleepResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.event.entity.player.PlayerSleepInBedEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.util.List;

@HFEvents
public class SleepHandler {
    public static boolean register() { return HFCore.SLEEP_ANYTIME; }

    @SubscribeEvent
    public void onPlayerSleep(PlayerSleepInBedEvent event) {
        event.setResult(trySleep(event.getEntityPlayer(), event.getPos()));
    }

    private SleepResult trySleep(EntityPlayer player, BlockPos bedLocation) {
        if (!player.worldObj.isRemote) {
            if (player.isPlayerSleeping() || !player.isEntityAlive()) {
                return EntityPlayer.SleepResult.OTHER_PROBLEM;
            }

            if (!player.worldObj.provider.isSurfaceWorld()) {
                return EntityPlayer.SleepResult.NOT_POSSIBLE_HERE;
            }

            if (Math.abs(player.posX - (double) bedLocation.getX()) > 3.0D || Math.abs(player.posY - (double) bedLocation.getY()) > 2.0D || Math.abs(player.posZ - (double) bedLocation.getZ()) > 3.0D) {
                return EntityPlayer.SleepResult.TOO_FAR_AWAY;
            }

            List<EntityMob> list = player.worldObj.getEntitiesWithinAABB(EntityMob.class, new AxisAlignedBB((double) bedLocation.getX() - 8.0D, (double) bedLocation.getY() - 5.0D, (double) bedLocation.getZ() - 8.0D, (double) bedLocation.getX() + 8.0D, (double) bedLocation.getY() + 5.0D, (double) bedLocation.getZ() + 8.0D));

            if (!list.isEmpty()) {
                return EntityPlayer.SleepResult.NOT_SAFE;
            }
        }

        if (player.isRiding()) {
            player.dismountRidingEntity();
        }

        setSize(player, 0.2F, 0.2F);

        IBlockState state = null;
        if (player.worldObj.isBlockLoaded(bedLocation)) state = player.worldObj.getBlockState(bedLocation);
        if (state != null && state.getBlock().isBed(state, player.worldObj, bedLocation, player)) {
            EnumFacing enumfacing = state.getBlock().getBedDirection(state, player.worldObj, bedLocation);
            float f = 0.5F;
            float f1 = 0.5F;

            switch (enumfacing) {
                case SOUTH:
                    f1 = 0.9F;
                    break;
                case NORTH:
                    f1 = 0.1F;
                    break;
                case WEST:
                    f = 0.1F;
                    break;
                case EAST:
                    f = 0.9F;
            }

            player.setRenderOffsetForSleep(enumfacing);
            player.setPosition((double) ((float) bedLocation.getX() + f), (double) ((float) bedLocation.getY() + 0.6875F), (double) ((float) bedLocation.getZ() + f1));
        } else {
            player.setPosition((double) ((float) bedLocation.getX() + 0.5F), (double) ((float) bedLocation.getY() + 0.6875F), (double) ((float) bedLocation.getZ() + 0.5F));
        }

        player.sleeping = true;
        player.sleepTimer = 0;
        player.playerLocation = bedLocation;
        player.motionX = 0.0D;
        player.motionY = 0.0D;
        player.motionZ = 0.0D;

        if (!player.worldObj.isRemote) {
            player.worldObj.updateAllPlayersSleepingFlag();
        }

        return EntityPlayer.SleepResult.OK;
    }

    private void setSize(EntityPlayer player, float width, float height) {
        if (width != player.width || height != player.height) {
            float f = player.width;
            player.width = width;
            player.height = height;
            AxisAlignedBB axisalignedbb = player.getEntityBoundingBox();
            player.setEntityBoundingBox(new AxisAlignedBB(axisalignedbb.minX, axisalignedbb.minY, axisalignedbb.minZ, axisalignedbb.minX + (double) player.width, axisalignedbb.minY + (double) player.height, axisalignedbb.minZ + (double) player.width));

            if (player.width > f && !player.firstUpdate && !player.worldObj.isRemote) {
                player.moveEntity((double) (f - player.width), 0.0D, (double) (f - player.width));
            }
        }
    }
}
