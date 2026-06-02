package ru.nekill.nekkfly;

import lombok.SneakyThrows;
import lombok.experimental.UtilityClass;
import org.bukkit.configuration.file.FileConfiguration;

@UtilityClass
public class Config {

    @SneakyThrows
    public static void load(FileConfiguration file) {

        dontHaveElytra = file.getString("dont-have-elytra", "§cYou don't have elytra on you!");
        flyenable = file.getString("fly-enable", "§aFly enable");
        flydisable = file.getString("fly-disable", "§cFly disable");
        noelytra = file.getString("no-elytra-on-flying", "§cYou can't fly without Elytra!");
        noPerm = file.getString("no-permissions", "§cno perm.");
        configReloaded = file.getString("config-reloaded", "§aConfig reloaded!");
    }

    public static String dontHaveElytra;
    public static String flyenable;
    public static String flydisable;
    public static String noelytra;
    public static String noPerm;
    public static String configReloaded;
}
