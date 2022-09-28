package pl.timsixth.explosivesheep;

import pl.timsixth.explosivesheep.command.ToggleSheepCommand;
import pl.timsixth.explosivesheep.config.ConfigFile;
import pl.timsixth.explosivesheep.listener.FeedSheepTNTListener;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import pl.timsixth.explosivesheep.tabcompleter.ToggleSheepCommandTabCompleter;

public final class ExplosiveSheepPlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        ConfigFile configFile = new ConfigFile(this);
        Bukkit.getPluginManager().registerEvents(new FeedSheepTNTListener(configFile, this), this);
        getCommand("togglesheep").setExecutor(new ToggleSheepCommand(configFile, this));
        getCommand("togglesheep").setTabCompleter(new ToggleSheepCommandTabCompleter());
        this.getConfig().options().copyDefaults(true);
        saveConfig();
    }
}
