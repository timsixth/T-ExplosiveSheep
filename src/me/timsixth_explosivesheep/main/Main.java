package me.timsixth_explosivesheep.main;

import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        ConfigFile cfg = new ConfigFile();
        Bukkit.getPluginManager().registerEvents(new FeedSheepTNTListener(cfg), this);
        getCommand("togglesheep").setExecutor(new ToggleSheepCommand(cfg));
        this.getConfig().options().copyDefaults(true);
        saveConfig();
    }

    public static Plugin getMain() {
        return Main.getPlugin(Main.class);
    }

}
