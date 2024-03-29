package pl.timsixth.explosivesheep.command;

import pl.timsixth.explosivesheep.ExplosiveSheepPlugin;
import pl.timsixth.explosivesheep.config.ConfigFile;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class ToggleSheepCommand implements CommandExecutor {

    private final ConfigFile configFile;
    private final ExplosiveSheepPlugin explosiveSheepPlugin;

    public ToggleSheepCommand(ConfigFile configFile, ExplosiveSheepPlugin explosiveSheepPlugin) {
        this.configFile = configFile;
        this.explosiveSheepPlugin = explosiveSheepPlugin;
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
            if (explosiveSheepPlugin.getConfig().getBoolean("explozsivesheep")) {
                switchExplosiveSheep(sender,Boolean.FALSE,configFile.DISABLE_SHEEP_MESSAGE);
            } else {
                sender.sendMessage(configFile.SHEEP_IS_DISABLED_MESSAGE);
            }
        }
        if (args[0].equalsIgnoreCase("on")) {
            if (!explosiveSheepPlugin.getConfig().getBoolean("explozsivesheep")) {
                switchExplosiveSheep(sender,Boolean.TRUE,configFile.ENABLE_SHEEP_MESSAGE);
            }
        }
        return false;
    }

    private void switchExplosiveSheep(CommandSender sender,Boolean arg,String message) {
        explosiveSheepPlugin.getConfig().set("explozsivesheep", arg);
        explosiveSheepPlugin.saveConfig();
        sender.sendMessage(message);
    }

}
