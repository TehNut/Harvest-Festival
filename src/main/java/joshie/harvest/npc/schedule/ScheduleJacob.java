package joshie.harvest.npc.schedule;

import joshie.harvest.api.buildings.BuildingLocation;
import joshie.harvest.api.calendar.Season;
import joshie.harvest.api.calendar.Weekday;
import joshie.harvest.api.npc.INPC;
import joshie.harvest.api.npc.ISchedule;
import net.minecraft.entity.EntityLiving;
import net.minecraft.world.World;

import static joshie.harvest.api.npc.INPC.Location.HOME;
import static joshie.harvest.npc.schedule.ScheduleLocations.GODDESSFRONT;
import static joshie.harvest.npc.schedule.ScheduleLocations.POND;

public class ScheduleJacob implements ISchedule {
    @Override
    public BuildingLocation getTarget(World world, EntityLiving entity, INPC npc, Season season, Weekday weekday, long time) {
        if (time >= 5000L && time <= 9000L) return POND;
        else if (time >= 9000L && time <= 11000L) return GODDESSFRONT;
        else return npc.getLocation(HOME);
    }
}
