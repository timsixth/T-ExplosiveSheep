package pl.timsixth.explosivesheep.command;

import org.bukkit.Bukkit;
import org.bukkit.DyeColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Sheep;
import pl.timsixth.explosivesheep.ExplosiveSheepPlugin;
import pl.timsixth.explosivesheep.config.ConfigFile;
import pl.timsixth.explosivesheep.task.ExplodeSheepTask;

public class SpawnSheepCommand implements CommandExecutor {

    private final ConfigFile configFile;
    private final ExplosiveSheepPlugin explosiveSheepPlugin;

    public SpawnSheepCommand(ConfigFile configFile, ExplosiveSheepPlugin explosiveSheepPlugin) {
        this.configFile = configFile;
        this.explosiveSheepPlugin = explosiveSheepPlugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            Bukkit.getLogger().info(configFile.ONLY_PLAYERS);
            return true;
        }

        if (!sender.hasPermission(configFile.PERMISSION)) {
            sender.sendMessage(configFile.PERMISSION_MESSAGE);
            return true;
        }

        Player player = (Player) sender;
        Sheep sheep = (Sheep) player.getWorld().spawnEntity(player.getLocation(), EntityType.SHEEP);
        sheep.setCustomName(configFile.SHEEP_NAME);
        sheep.setColor(DyeColor.RED);
        sheep.setCustomNameVisible(true);
        new ExplodeSheepTask(sheep).runTaskLater(explosiveSheepPlugin, 100);
        player.sendMessage(configFile.SPAWNED_SHEEP);
        return false;
    }
}
