package ru.kozur.resourcebuyer.command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import ru.kozur.resourcebuyer.core.ResourceBuyerSystem;

public class BuyerOpen implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (!(sender instanceof Player player)) return false;
        if (args.length != 0) return false;

        ResourceBuyerSystem.openMenu(player);

        return true;
    }
}
