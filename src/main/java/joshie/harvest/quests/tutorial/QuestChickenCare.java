package joshie.harvest.quests.tutorial;

import joshie.harvest.animals.HFAnimals;
import joshie.harvest.animals.entity.EntityHarvestChicken;
import joshie.harvest.animals.item.ItemAnimalTool.Tool;
import joshie.harvest.api.core.ISizeable.Size;
import joshie.harvest.api.npc.INPC;
import joshie.harvest.api.quests.HFQuest;
import joshie.harvest.api.quests.Quest;
import joshie.harvest.api.quests.QuestQuestion;
import joshie.harvest.buildings.HFBuildings;
import joshie.harvest.core.helpers.InventoryHelper;
import joshie.harvest.npc.HFNPCs;
import joshie.harvest.quests.Quests;
import joshie.harvest.quests.TutorialSelection;
import joshie.harvest.town.TownHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;

import javax.annotation.Nullable;
import java.util.Set;

import static joshie.harvest.animals.block.BlockTray.Tray.FEEDER_EMPTY;
import static joshie.harvest.animals.block.BlockTray.Tray.NEST_EMPTY;
import static joshie.harvest.animals.item.ItemAnimalTool.Tool.CHICKEN_FEED;
import static joshie.harvest.core.helpers.InventoryHelper.ITEM_STACK;
import static joshie.harvest.npc.HFNPCs.GODDESS;
import static joshie.harvest.npc.HFNPCs.POULTRY;

@HFQuest("tutorial.chicken")
public class QuestChickenCare extends QuestQuestion {
    private static final int INTRO = 0;
    private static final int THROW = 1;
    private static final int ACTION1 = 2;
    private static final int ACTION2 = 3;
    private static final int EGG = 4;
    private static final int FINAL = 5;
    private boolean hasThrown;
    private boolean hasFed;

    public QuestChickenCare() {
        super(new TutorialSelection("chicken"));
        setNPCs(GODDESS, POULTRY);
    }

    @Override
    public boolean canStartQuest(Set<Quest> active, Set<Quest> finished) {
        return finished.contains(Quests.TUTORIAL_CROPS);
    }

    @Override
    public void onEntityInteract(EntityPlayer player, @Nullable ItemStack held, EnumHand hand, Entity target) {
        if (!hasFed && (quest_stage == ACTION1 || quest_stage == ACTION2)) {
            if (target instanceof EntityChicken) {
                if (held != null) {
                    if (InventoryHelper.ITEM_STACK.matches(held, HFAnimals.TOOLS.getStackFromEnum(Tool.CHICKEN_FEED))) {
                        hasFed = true;
                    }

                    increaseStage(player);
                }
            }
        }
    }

    @Override
    public void onRightClickBlock(EntityPlayer player, BlockPos pos, EnumFacing face) {
        if (!hasThrown && (quest_stage == ACTION1 || quest_stage == ACTION2)) {
            for (Entity entity: player.getPassengers()) {
                if (entity instanceof EntityHarvestChicken) {
                    hasThrown = true; //You have now thrown!
                    increaseStage(player);
                }
            }
        }
    }

    @Override
    public Selection getSelection(EntityPlayer player, INPC npc) {
        return npc == POULTRY && quest_stage <= 0 ? selection : null;
    }

    @Override
    public String getLocalizedScript(EntityPlayer player, EntityLiving entity, INPC npc) {
        if (npc == HFNPCs.GODDESS) {
            if (player.worldObj.rand.nextFloat() < 0.15F) {
                if (TownHelper.getClosestTownToEntity(entity).hasBuilding(HFBuildings.POULTRY_FARM)) {
                    //If the barn exists the goddess will tell the player to go and talk to ashlee
                    return getLocalized("reminder.talk");
                }

                //Goddess reminds the player that you should go and build a poultry farm
                //So that you can get further chickens
                return getLocalized("reminder.poultry");
            } else return null;
        } else if (npc == HFNPCs.POULTRY) {
            if (isCompletedEarly) {
                return getLocalized("completed");
            } else if (quest_stage == INTRO) {
            /*Ashlee explains she has a chicken she would like to give you
            She then proceeds to ask if you know how to care for chickens */
                return getLocalized("start");
            } else if (quest_stage == THROW) {
            /*Now that Ashlee knows that you do not how to take care of chicken she starts off on a rant
            She explains that in order to care four chickens, you must feed them
            She tells you that you can feed them by hand, or place chicken feed in a feeding tray
            And they will feed themselves, She also tells you that they need to be loved,
            She explains the best way for a chicken to feel loved is when you pick it up
            You can do this by right clicking it, and to put it down, right click the ground
            She explains you can also make it love you when feed it by hand
            She explains that doing this will make the chicken like you more, and in doing so
            She asks the player to go feed by hand, and throw the chicken (giving the player feed) */
                return getLocalized("throw");
            } else if (quest_stage == ACTION1 || quest_stage == ACTION2) {
            /*Ashlee Reminds you to go pick up and throw a chicken, as well as feed one chicken feed
            She allow informs the player that if they ran out of feed, she will happily trade for more
            She also explains that she will trade a vanilla egg for a chicken if yours happens to die
            If the player gives them seeds */
                return getLocalized("reminder.throw");
            } else if (quest_stage == EGG) {
            /*Ashlee congratulates you on performing the task, she then goes on to say that
            Over time the chicken will eventually produce bigger and better eggs that you can sell for more money
            She also explains that for chickens to lay eggs they need a nesting box
            Chickens will lay their eggs in here and you can then collect them and ship them off
            Ashlee now asks the player to return when they have one egg from the special chickens */
                return getLocalized("egg");
            } else if (quest_stage == FINAL) {
                /*Ashlee thanks the player for their time and gives them a reward of a large egg
                She explains this is a valuable egg from the best of chickens, you'll have to take care
                Of yours properly if you wish to look after it. She also heard that yulif had a spare cow
                And that you should go talk to him if you want it */
                if (InventoryHelper.getHandItemIsIn(player, ITEM_STACK, HFAnimals.EGG.getStack(Size.SMALL)) != null) {
                    return getLocalized("complete");
                }

            /*Ashlee reminds you that she wants an egg from one of the special chickens
            She also tells that if you lost the nest, bring her a hay bale */
                return getLocalized("reminder.egg");
            }
        }

        return null;
    }

    @Override
    public void onChatClosed(EntityPlayer player, EntityLiving entity, INPC npc) {
        if (isCompletedEarly) {
            complete(player);
            rewardEntity(player, "harvestfestival.chicken");
            rewardItem(player, new ItemStack(HFAnimals.TOOLS, 64, CHICKEN_FEED.ordinal()));
            rewardItem(player, HFAnimals.TRAY.getStackFromEnum(NEST_EMPTY));
            rewardItem(player, HFAnimals.EGG.getStack(Size.LARGE));
        } else if (quest_stage == THROW) {
            increaseStage(player);
            rewardEntity(player, "harvestfestival.chicken");
            rewardItem(player, new ItemStack(HFAnimals.TOOLS, 16, CHICKEN_FEED.ordinal()));
        } else if (quest_stage == EGG) {
            increaseStage(player);
            rewardItem(player, HFAnimals.TRAY.getStackFromEnum(NEST_EMPTY));
        } else if (quest_stage == FINAL) {
            if (InventoryHelper.getHandItemIsIn(player, ITEM_STACK, HFAnimals.EGG.getStack(Size.SMALL)) != null) {
                complete(player);
                rewardItem(player, HFAnimals.EGG.getStack(Size.LARGE));
            }
        }
    }

    @Override
    public void onQuestCompleted(EntityPlayer player) {
        rewardItem(player, HFAnimals.EGG.getStackOfSize(Size.LARGE, 3));
        rewardItem(player, HFAnimals.TRAY.getStackFromEnum(FEEDER_EMPTY));
    }

    @Override
    public void readFromNBT(NBTTagCompound nbt) {
        super.readFromNBT(nbt);
        hasThrown = nbt.getBoolean("HasThrown");
        hasFed = nbt.getBoolean("HasFed");
    }

    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound nbt) {
        super.writeToNBT(nbt);
        nbt.setBoolean("HasThrown", hasThrown);
        nbt.setBoolean("HasFed", hasFed);
        return nbt;
    }
}