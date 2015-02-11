package joshie.harvestmoon.commands;

import static joshie.harvestmoon.HarvestMoon.handler;
import joshie.harvestmoon.network.PacketHandler;
import joshie.harvestmoon.network.PacketSetCalendar;
import net.minecraft.command.ICommandSender;

public class CommandDay extends CommandBase {
    @Override
    public String getCommandName() {
        return "day";
    }

    @Override
    public String getCommandUsage(ICommandSender sender) {
        return "/day <day>";
    }

    @Override
    public void processCommand(ICommandSender sender, String[] parameters) {
        if (parameters == null || parameters.length != 1) return;
        try {
            PacketHandler.sendToServer(new PacketSetCalendar(handler.getClient().getCalendar().getDate().setDay(Integer.parseInt(parameters[0]))));
        } catch (NumberFormatException e) {}
    }
}
