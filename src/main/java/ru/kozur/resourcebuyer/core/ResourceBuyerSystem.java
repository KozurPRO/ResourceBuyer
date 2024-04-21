package ru.kozur.resourcebuyer.core;

import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import ru.kozur.resourcebuyer.ResourceBuyer;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class ResourceBuyerSystem {
    public static Inventory buyerInventory = Bukkit.createInventory(null, 54, ChatColor.LIGHT_PURPLE + "Скупщик Ресурсов");
    public static Map<Player,Integer> schedulers = new HashMap<>();
    public static void openMenu(Player player) {
        player.openInventory(buyerInventory);
        int id = Bukkit.getScheduler().scheduleSyncRepeatingTask(ResourceBuyer.getInstance(), () -> {
            System.out.println("update");
        }, 0L, 20L);
        schedulers.put(player,id);
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

        ItemStack limeDye = new ItemStack(Material.LIME_DYE);
        ItemMeta limeDyeMeta = limeDye.getItemMeta();

        limeDyeMeta.setDisplayName("                                  ");
        limeDyeMeta.setLore(Collections.singletonList(ChatColor.WHITE + " Нажмите чтобы сдать все предметы и получить 0 монет."));
        limeDyeMeta.setLocalizedName("sell");

        limeDye.setItemMeta(limeDyeMeta);

        buyerInventory.setItem(53,limeDye);
        for (int i = 45; i < 54; i++) {
            if (i == 53) return;


            buyerInventory.setItem(i,blueGlass);
        }
    }
}
