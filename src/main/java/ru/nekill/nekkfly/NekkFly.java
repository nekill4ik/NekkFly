package ru.nekill.nekkfly;

import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerEvent;
import org.bukkit.plugin.java.JavaPlugin;
import ru.nekill.nekkfly.commands.FlyCommand;
import ru.nekill.nekkfly.commands.ReloadCommand;

import java.awt.*;

public final class NekkFly extends JavaPlugin {

    @Override
    public void onEnable() {

        saveDefaultConfig();
        reloadConfig();
        Config.load(getConfig());

        getLogger().info(Color.GREEN + "[NekkFly]" + " §aВключение");

        getCommand("nekkfly").setExecutor(new ReloadCommand(this));
        getCommand("fly").setExecutor(new FlyCommand());

        getServer().getPluginManager().registerEvents(new FlyListener(), this);
    }

    @Override
    public void onDisable() {
        getLogger().info(Color.RED + "[NekkFly]" + " §4Выключение");
    }
}
