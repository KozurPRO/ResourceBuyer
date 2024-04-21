package ru.kozur.resourcebuyer.core;

import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ResourceBuyerSystem {
    public static Inventory buyerInventory = Bukkit.createInventory(null, 54, ChatColor.LIGHT_PURPLE + "Скупщик Ресурсов");
    public static void openMenu(Player player) {
        player.openInventory(buyerInventory);
    }

    public static void initializeItems() {
        createBarier();
    }

    public static void createBarier() {
        /*
         * Create bariers
         */

        ItemStack blueGlass = new ItemStack(Material.BLUE_STAINED_GLASS);
        ItemMeta blueGlassMeta = blueGlass.getItemMeta();

        blueGlassMeta.setDisplayName(ChatColor.YELLOW + "Тут ничего нет :(");
        blueGlassMeta.setLocalizedName("blue glass");
        blueGlass.setItemMeta(blueGlassMeta);
        
        for (int i = 45; i < 54; i++) {
            if (i == 53) return;


            buyerInventory.setItem(i,blueGlass);
        }
    }
}
