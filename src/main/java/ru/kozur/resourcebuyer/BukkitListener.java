package ru.kozur.resourcebuyer;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.inventory.ItemStack;

import static ru.kozur.resourcebuyer.core.ResourceBuyerSystem.inventory;
import static ru.kozur.resourcebuyer.core.ResourceBuyerSystem.schedulers;

public class BukkitListener implements Listener {

    @EventHandler
    private void on(InventoryClickEvent event) {
        Player player = (Player) event.getWhoClicked();
        if (inventory.containsKey(player)) {
            if (event.getClickedInventory() != null && event.getClickedInventory().equals(inventory.get(player))) {

                if (event.getClickedInventory().getItem(event.getSlot()) != null) {
                    ItemStack clickedItem = event.getClickedInventory().getItem(event.getSlot());
                    if (clickedItem.getItemMeta() == null) return;

                    String clickedItemLoc = clickedItem.getItemMeta().getLocalizedName();

                    if (clickedItemLoc.equals("blue glass")) {
                        event.setCancelled(true);
                    }

                    if (clickedItemLoc.equals("sell")) {
                        event.setCancelled(true);
                    }

                }
            }
        }
    }

    @EventHandler
    private void on(InventoryCloseEvent event) {
        /*
         * Checking inventory, and getting task id and remove from list
         */
        Player player = (Player) event.getPlayer();
        if (inventory.containsKey(player)) {
            if (event.getInventory().equals(inventory.get(player))) {
                if (schedulers.containsKey(player)) {
                    Bukkit.getScheduler().cancelTask(schedulers.get(player));
                }
            }
        }
    }
}
