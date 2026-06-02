package ru.nekill.nekkfly.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;
import ru.nekill.nekkfly.Config;
import ru.nekill.nekkfly.NekkFly;

public class ReloadCommand implements CommandExecutor {
    private final NekkFly plugin;

    public ReloadCommand(NekkFly plugin) {
        this.plugin = plugin;
    }
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command,
                             @NotNull String label, @NotNull String[] args) {
        if (args.length == 0 || !args[0].equalsIgnoreCase("reload")) {
            sender.sendMessage("§eUsage: /nekkfly reload");
            return true;
        }

        if (!sender.hasPermission("nekkfly.admin")) {
            sender.sendMessage("§cno perm.");
            return true;
        }

        plugin.reloadConfig();
        Config.load(plugin.getConfig());
        sender.sendMessage("§aConfig reloaded!");
        return true;
    }
}

