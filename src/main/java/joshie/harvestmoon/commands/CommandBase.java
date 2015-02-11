package joshie.harvestmoon.commands;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.command.ICommand;
import net.minecraft.command.ICommandSender;

public abstract class CommandBase implements ICommand {
    @Override
    public int compareTo(Object o) {
        return 0;
    }

    @Override
    public List getCommandAliases() {
        return null;
    }

    @Override
    public boolean canCommandSenderUseCommand(ICommandSender sender) {
        return true;
    }

    @Override
    public List addTabCompletionOptions(ICommandSender sender, String[] parameters) {
        ArrayList<String> string = new ArrayList();
        for(int i = 0; i < Byte.MAX_VALUE; i++) {
            string.add("" + i);
        }

        return string;
    }

    @Override
    public boolean isUsernameIndex(String[] parameter, int p_82358_2_) {
        return false;
    }
}
