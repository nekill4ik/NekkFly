package ru.nekill.nekkfly;

import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;

public class FlyListener implements Listener {

    @EventHandler(priority = EventPriority.LOW)
    private void on(PlayerMoveEvent event) {
        if (event.getPlayer().getGameMode() == GameMode.SURVIVAL) {
            if (event.getPlayer().isFlying()) {
                if ((event.getPlayer().getInventory().getChestplate() == null || event.getPlayer().getInventory().getChestplate().getType() != Material.ELYTRA)) {
                    event.getPlayer().sendMessage(Config.noelytra);
                    event.getPlayer().setAllowFlight(false);
                    event.getPlayer().setFlying(false);
                }
            }
        }
    }
}