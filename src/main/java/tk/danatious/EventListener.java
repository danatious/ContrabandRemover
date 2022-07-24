package tk.danatious;
import org.bukkit.Material;
import org.bukkit.entity.Item;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockDispenseArmorEvent;
import org.bukkit.event.block.BlockDispenseEvent;
import org.bukkit.event.block.BlockDropItemEvent;
import org.bukkit.event.entity.EntityPickupItemEvent;
import org.bukkit.event.inventory.*;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;

import java.util.List;

public class EventListener implements Listener {

    @EventHandler
    public void chestOpenEvent(InventoryOpenEvent e) {
        e.getInventory().removeItem(BlacklistManager.getBlacklistArray());
    }

    @EventHandler
    public void chestCloseEvent(InventoryCloseEvent e) {
        e.getInventory().removeItem(BlacklistManager.getBlacklistArray());
    }

    @EventHandler
    public void hopperPickupEvent(InventoryPickupItemEvent e) {
        if (BlacklistManager.blacklistContains(e.getItem().getItemStack())) {
            e.setCancelled(true);
        }
    }

    @EventHandler
    public void entityPickupEvent(EntityPickupItemEvent e) {
        if (BlacklistManager.blacklistContains(e.getItem().getItemStack())) {
            e.setCancelled(true);
        }
    }

    @EventHandler
    public void dispenserEquipEvent(BlockDispenseArmorEvent e) {
        if (BlacklistManager.blacklistContains(e.getItem())) {
            e.setCancelled(true);
        }
    }

    @EventHandler
    public void dispenserDropEvent(BlockDispenseEvent e) {
        if (BlacklistManager.blacklistContains(e.getItem())) {
            e.setCancelled(true);
        }
    }

    @EventHandler
    public void inventoryClickEvent(InventoryClickEvent e) {
        try {
            e.getClickedInventory().removeItem(BlacklistManager.getBlacklistArray());
        } catch (Exception exception) {
            e.setCancelled(true);
        }
    }

    @EventHandler
    public void blockDropEvent(BlockDropItemEvent e) {
        List<Item> items = e.getItems();
        for(int i = 0; i < items.size(); i++) {
            for(int j = 0; j < BlacklistManager.BLACKLIST.size(); j++) {
                if (items.get(i).getItemStack().isSimilar(BlacklistManager.BLACKLIST.get(j))) {
                    e.setCancelled(true);
                }
            }
        }
    }

    @EventHandler
    public void craftItemEvent(PrepareItemCraftEvent e) {
        for(int i = 0; i < BlacklistManager.BLACKLIST.size(); i++) {
            try {
                if (e.getRecipe().getResult().isSimilar(BlacklistManager.BLACKLIST.get(i))) {
                    e.getInventory().setResult(new ItemStack(Material.AIR));
                }
            } catch (Exception exception) {
                break;
            }
        }
    }

    @EventHandler
    public void upgradeItemEvent(PrepareSmithingEvent e) {
        for(int i = 0; i < BlacklistManager.BLACKLIST.size(); i++) {
            try {
                if (e.getResult().isSimilar(BlacklistManager.BLACKLIST.get(i))) {
                    e.setResult(new ItemStack(Material.AIR));
                }
            } catch (Exception exception) {
                break;
            }
        }
    }

}
