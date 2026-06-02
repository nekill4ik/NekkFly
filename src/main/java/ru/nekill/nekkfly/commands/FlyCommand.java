package ru.nekill.nekkfly.commands;

import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import ru.nekill.nekkfly.Config;

import static org.bukkit.Bukkit.getPlayer;

public class FlyCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String s, @NotNull String[] args) {
        if (!(sender instanceof Player p)) {
            sender.sendMessage("♫ " + "§c Только для игроков");
            return true;
        }

        if ((p.getInventory().getChestplate() == null || p.getInventory().getChestplate().getType() != Material.ELYTRA)) {
            sender.sendMessage(Config.dontHaveElytra);
            p.setAllowFlight(false);
            return true;
        } else
        if (p.isFlying()) {
            p.setFlying(false);
            sender.sendMessage(Config.flydisable);
            p.setAllowFlight(false);
            return true;
        } else
            p.setAllowFlight(true);
            p.setFlying(true);
            sender.sendMessage(Config.flyenable);

            return true;
    }
}
