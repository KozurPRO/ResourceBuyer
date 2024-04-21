package ru.kozur.resourcebuyer;

import org.bukkit.plugin.java.JavaPlugin;
import ru.kozur.resourcebuyer.command.BuyerOpen;
import ru.kozur.resourcebuyer.core.ResourceBuyerSystem;

public final class ResourceBuyer extends JavaPlugin {
    public static ResourceBuyer instance;
    @Override
    public void onEnable() {
        instance = this;
        getCommand("buyer").setExecutor(new BuyerOpen());
        getServer().getPluginManager().registerEvents(new BukkitListener(),this);
        ResourceBuyerSystem.initializeItems();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
