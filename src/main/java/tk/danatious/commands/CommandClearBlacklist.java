package tk.danatious.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.inventory.ItemStack;
import tk.danatious.BlacklistManager;

import java.util.ArrayList;

public class CommandClearBlacklist implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        BlacklistManager.BLACKLIST = new ArrayList<ItemStack>();

        return true;
    }

}
