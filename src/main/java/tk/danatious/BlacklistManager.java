package tk.danatious;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import java.util.ArrayList;

public class BlacklistManager {

    public static ArrayList<ItemStack> BLACKLIST = (ArrayList<ItemStack>) ContrabandRemover.config.get("blacklist");

    public static void addToBlacklist(String itemName) {
        Material material = Material.matchMaterial(itemName.toUpperCase());
        ItemStack prettifiedItemStack = new ItemStack(material,65536);

        BLACKLIST.add(prettifiedItemStack);
        ContrabandRemover.config.set("blacklist", BLACKLIST);
        ContrabandRemover.getPlugin(ContrabandRemover.class).saveConfig();
    }

    public static void removeFromBlacklist(String itemName) {
        Material material = Material.matchMaterial(itemName.toUpperCase());
        ItemStack prettifiedItemStack = new ItemStack(material,65536);

        for (int i = 0; i < BLACKLIST.size(); i++) {
            if (prettifiedItemStack.isSimilar(BLACKLIST.get(i))) {
                BLACKLIST.remove(i);
                break;
            }
        }
        ContrabandRemover.config.set("blacklist", BLACKLIST);
        ContrabandRemover.getPlugin(ContrabandRemover.class).saveConfig();
    }

    public static ItemStack[] getBlacklistArray() {
        ItemStack[] itemStacks = new ItemStack[ BlacklistManager.BLACKLIST.size() ];
        BlacklistManager.BLACKLIST.toArray(itemStacks);

        return itemStacks;
    }

    public static boolean blacklistContains(ItemStack prePrettified) {
        return BLACKLIST.contains(new ItemStack(prePrettified.getType(),65536));
    }

}
