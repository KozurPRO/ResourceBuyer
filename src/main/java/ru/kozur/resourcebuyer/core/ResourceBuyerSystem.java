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
    public static Map<Player, Inventory> inventory = new HashMap<>();
    public static Map<Player, Integer> schedulers = new HashMap<>();

    public static void openMenu(Player player) {
        if (!inventory.containsKey(player)) {
            inventory.put(player, Bukkit.createInventory(null, 54, ChatColor.LIGHT_PURPLE + "Скупщик Ресурсов"));
            initializeItems(player);
        }
        if (inventory.containsKey(player)) {
            player.openInventory(inventory.get(player));
            updateInventory(player,inventory.get(player));
        }
    }

    public static void initializeItems(Player player) {
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

        if (inventory.containsKey(player)) {
            inventory.get(player).setItem(53, limeDye);
            for (int i = 45; i < 54; i++) {
                if (i == 53) return;


                inventory.get(player).setItem(i, blueGlass);
            }
        }
    }


    public static void updateInventory(Player player, Inventory inventory) {
        int id = Bukkit.getScheduler().scheduleSyncRepeatingTask(ResourceBuyer.getInstance(), () -> {
            /*
             * Logic for inventory and update money what u will get
             */
            System.out.println("update");
        }, 0L, 20L);

        schedulers.put(player, id);
    }
}
