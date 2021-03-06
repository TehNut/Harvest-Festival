package joshie.harvest.animals.tile;

import joshie.harvest.api.HFApi;
import joshie.harvest.api.animals.IAnimalTracked;
import joshie.harvest.core.base.tile.TileFillable;
import joshie.harvest.core.helpers.EntityHelper;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.item.ItemStack;

import static joshie.harvest.api.animals.AnimalFoodType.SEED;

public class TileFeeder extends TileFillable {
    @Override
    public boolean onActivated(ItemStack held) {
        if (HFApi.animals.canEat(held, SEED)) {
            boolean processed = false;
            for (int i = 0; i < 10 && held.stackSize > 0; i++) {
                if (held.stackSize >= 1) {
                    if (hasRoomAndFill()) {
                        held.splitStack(1);
                        processed = true;
                    } else break;
                }
            }

            return processed;
        }

        return false;
    }

    private boolean hasRoomAndFill() {
        if (fillAmount < 10) {
            setFilled(getFillAmount() + 1);
            return true;
        }

        return false;
    }

    private boolean hasFoodAndFeed() {
        if (fillAmount > 0) {
            setFilled(getFillAmount() - 1);
            return true;
        }

        return false;
    }

    @Override
    public void newDay(Phase phase) {
        for (EntityAnimal animal : EntityHelper.getEntities(EntityAnimal.class, getWorld(), getPos(), 32D, 5D)) {
            if (animal instanceof IAnimalTracked) { //Feed all the local animals
                IAnimalTracked tracked = ((IAnimalTracked) animal);
                if (tracked.getData().isHungry() && HFApi.animals.canAnimalEatFoodType(tracked, SEED) && hasFoodAndFeed()) {
                    tracked.getData().feed(null);
                }
            }
        }
    }
}