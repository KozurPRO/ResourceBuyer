package ru.kozur.resourcebuyer;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import ru.kozur.resourcebuyer.core.ResourceBuyerSystem;

public class BukkitListener implements Listener {

    @EventHandler
    private void on(InventoryClickEvent event) {

        if (event.getClickedInventory() != null && event.getClickedInventory().equals(ResourceBuyerSystem.buyerInventory)) {
            Player player = (Player) event.getWhoClicked();
            if (event.getClickedInventory().getItem(event.getSlot()) != null) {
                ItemStack clickedItem = event.getClickedInventory().getItem(event.getSlot());
                if (clickedItem.getItemMeta() == null) return;
                String clickedItemLoc = clickedItem.getItemMeta().getLocalizedName();
                if (clickedItemLoc.equals("blue glass")) {
                    event.setCancelled(true);
                }
            }
        }
    }
}
