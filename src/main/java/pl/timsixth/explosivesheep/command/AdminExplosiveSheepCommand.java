package pl.timsixth.explosivesheep.command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import pl.timsixth.explosivesheep.config.ConfigFile;

public class AdminExplosiveSheepCommand implements CommandExecutor {

    private final ConfigFile configFile;

    public AdminExplosiveSheepCommand(ConfigFile configFile) {
        this.configFile = configFile;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!sender.hasPermission(configFile.PERMISSION)){
            sender.sendMessage(configFile.PERMISSION_MESSAGE);
            return true;
        }
        if (args.length == 0) {
            sender.sendMessage(configFile.CORRECT_USE_ADMIN_COMMAND);
        } else if (args.length == 1) {
            if (args[0].equalsIgnoreCase("reload")) {
                configFile.reloadConfig();
                sender.sendMessage(configFile.FILES_RELOADED);
            }
        } else {
            sender.sendMessage(configFile.CORRECT_USE_ADMIN_COMMAND);
        }
        return false;
    }
}
