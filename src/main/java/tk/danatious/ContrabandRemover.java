package tk.danatious;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;
import tk.danatious.commands.CommandAddBlacklist;
import tk.danatious.commands.CommandClearBlacklist;
import tk.danatious.commands.CommandListBlacklist;
import tk.danatious.commands.CommandRemoveBlacklist;

import java.util.ArrayList;

public final class ContrabandRemover extends JavaPlugin {

    public static FileConfiguration config;

    @Override
    public void onEnable() {
        config = this.getConfig();

        config.addDefault("blacklist", new ArrayList<ItemStack>());
        config.options().copyDefaults(true);
        saveConfig();

        getServer().getPluginManager().registerEvents(new EventListener(), this);
        this.getCommand("bladd").setExecutor(new CommandAddBlacklist());
        this.getCommand("blremove").setExecutor(new CommandRemoveBlacklist());
        this.getCommand("blclear").setExecutor(new CommandClearBlacklist());
        this.getCommand("bllist").setExecutor(new CommandListBlacklist());

        Purger purger = new Purger();
    }

    @Override
    public void onDisable() {

    }
}