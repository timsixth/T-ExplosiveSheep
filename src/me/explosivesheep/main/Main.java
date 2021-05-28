package me.explosivesheep.main;

import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {


    @Override
    public void onEnable() {
        if (this.getDescription().getAuthors().contains("timsixth (Idea by RokeR)") && this.getDescription().getName().contains("T-ExplosiveSheep")) {
            getLogger().info("Plugin enabled!");
            ConfigFile cfg = new ConfigFile();
            Bukkit.getPluginManager().registerEvents(new FeedSheepTNTListner(cfg), this);
            getCommand("togglesheep").setExecutor(new ToggleSheepCmd(cfg));
            this.getConfig().options().copyDefaults(true);
            saveConfig();
        } else {
            this.getPluginLoader().disablePlugin(this);
            System.out.println("You are not author this plugin");
        }

    }

    public static Plugin getMain() {
        return Main.getPlugin(Main.class);
    }

}
