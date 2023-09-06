package pl.timsixth.explosivesheep;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import pl.timsixth.explosivesheep.bstats.Metrics;
import pl.timsixth.explosivesheep.command.AdminExplosiveSheepCommand;
import pl.timsixth.explosivesheep.command.SpawnSheepCommand;
import pl.timsixth.explosivesheep.command.ToggleSheepCommand;
import pl.timsixth.explosivesheep.config.ConfigFile;
import pl.timsixth.explosivesheep.listener.PlayerInteractEntityListener;
import pl.timsixth.explosivesheep.tabcompleter.AdminExplosiveSheepCommandTabCompleter;
import pl.timsixth.explosivesheep.tabcompleter.ToggleSheepCommandTabCompleter;
import pl.timsixth.explosivesheep.version.VersionChecker;

public final class ExplosiveSheepPlugin extends JavaPlugin {

    private ConfigFile configFile;

    @Override
    public void onEnable() {
        this.getConfig().options().copyDefaults(true);
        saveConfig();

        configFile = new ConfigFile(this);

        Bukkit.getPluginManager().registerEvents(new PlayerInteractEntityListener(configFile, this), this);

        registerCommands();
        registerTabCompleters();

        new Metrics(this, 19741);

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
