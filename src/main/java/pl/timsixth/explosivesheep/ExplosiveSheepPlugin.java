package pl.timsixth.explosivesheep;

import pl.timsixth.explosivesheep.command.AdminExplosiveSheepCommand;
import pl.timsixth.explosivesheep.command.SpawnSheepCommand;
import pl.timsixth.explosivesheep.command.ToggleSheepCommand;
import pl.timsixth.explosivesheep.config.ConfigFile;
import pl.timsixth.explosivesheep.listener.FeedSheepTNTListener;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import pl.timsixth.explosivesheep.tabcompleter.AdminExplosiveSheepCommandTabCompleter;
import pl.timsixth.explosivesheep.tabcompleter.ToggleSheepCommandTabCompleter;
import pl.timsixth.explosivesheep.version.VersionChecker;

public final class ExplosiveSheepPlugin extends JavaPlugin {

    private ConfigFile configFile;

    @Override
    public void onEnable() {
        configFile = new ConfigFile(this);
        Bukkit.getPluginManager().registerEvents(new FeedSheepTNTListener(configFile, this), this);
        registerCommands();
        registerTabCompleters();
        this.getConfig().options().copyDefaults(true);
        saveConfig();

        new VersionChecker(this).checkVersion();
    }

    private void registerTabCompleters() {
        getCommand("togglesheep").setTabCompleter(new ToggleSheepCommandTabCompleter());
        getCommand("explosivesheep").setTabCompleter(new AdminExplosiveSheepCommandTabCompleter());
    }

    private void registerCommands() {
        getCommand("explosivesheep").setExecutor(new AdminExplosiveSheepCommand(configFile));
        getCommand("togglesheep").setExecutor(new ToggleSheepCommand(configFile, this));
        getCommand("spawnsheep").setExecutor(new SpawnSheepCommand(configFile, this));
    }
}
