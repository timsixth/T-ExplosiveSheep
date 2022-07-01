package me.timsixth.explosivesheep;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class ToggleSheepCommand implements CommandExecutor {

    private final ConfigFile configFile;
    private final Main main;

    public ToggleSheepCommand(ConfigFile configFile, Main main) {
        this.configFile = configFile;
        this.main = main;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command arg1, String arg2, String[] args) {
        if (!sender.hasPermission(configFile.PERMISSION)) {
            sender.sendMessage(configFile.PERMISSION_MESSAGE);
            return true;
        }
        if (args.length == 0) {
            sender.sendMessage(configFile.CORRECT_USE_MESSAGE);
            return true;
        }
        if (args[0].equalsIgnoreCase("off")) {
            if (main.getConfig().getBoolean("explozsivesheep")) {
                switchExplosiveSheep(sender,Boolean.FALSE,configFile.DISABLE_SHEEP_MESSAGE);
            } else {
                sender.sendMessage(configFile.SHEEP_IS_DISABLED_MESSAGE);
            }
        }
        if (args[0].equalsIgnoreCase("on")) {
            if (!main.getConfig().getBoolean("explozsivesheep")) {
                switchExplosiveSheep(sender,Boolean.TRUE,configFile.ENABLE_SHEEP_MESSAGE);
            }
        }
        return false;
    }

    private void switchExplosiveSheep(CommandSender sender,Boolean arg,String message) {
        main.getConfig().set("explozsivesheep", arg);
        main.saveConfig();
        sender.sendMessage(message);
    }

}
