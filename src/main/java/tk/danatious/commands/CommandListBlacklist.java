package tk.danatious.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import tk.danatious.BlacklistManager;

public class CommandListBlacklist implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        sender.sendMessage(BlacklistManager.BLACKLIST.toString());

        return true;
    }

}
