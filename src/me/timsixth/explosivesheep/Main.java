package me.timsixth.explosivesheep;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        ConfigFile configFile = new ConfigFile(this);
        Bukkit.getPluginManager().registerEvents(new FeedSheepTNTListener(configFile, this), this);
        getCommand("togglesheep").setExecutor(new ToggleSheepCommand(configFile, this));
        this.getConfig().options().copyDefaults(true);
        saveConfig();
    }
}
