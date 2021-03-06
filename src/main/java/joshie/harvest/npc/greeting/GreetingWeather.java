package joshie.harvest.npc.greeting;

import joshie.harvest.api.npc.IGreeting;
import joshie.harvest.api.npc.INPC;
import joshie.harvest.calendar.CalendarClient;
import joshie.harvest.core.handlers.HFTrackers;
import joshie.harvest.core.util.Text;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.Locale;

public class GreetingWeather implements IGreeting {
    @SuppressWarnings("deprecation")
    @SideOnly(Side.CLIENT)
    public String getLocalizedText(EntityPlayer player, EntityAgeable entity, INPC npc) {
        String weather = HFTrackers.<CalendarClient>getCalendar(player.worldObj).getTomorrowsWeather().name().toLowerCase(Locale.ENGLISH);
        return Text.getRandomSpeech(npc, "harvestfestival.npc.goddess.weather." + weather, 32);
    }
}
