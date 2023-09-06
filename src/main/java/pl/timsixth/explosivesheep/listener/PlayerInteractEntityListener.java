package pl.timsixth.explosivesheep.listener;

import org.bukkit.DyeColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.entity.Sheep;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import pl.timsixth.explosivesheep.ExplosiveSheepPlugin;
import pl.timsixth.explosivesheep.config.ConfigFile;
import pl.timsixth.explosivesheep.task.ExplodeSheepTask;

public class PlayerInteractEntityListener implements Listener {

    private final ConfigFile configFile;
    private final ExplosiveSheepPlugin explosiveSheepPlugin;

    public PlayerInteractEntityListener(ConfigFile configFile, ExplosiveSheepPlugin explosiveSheepPlugin) {
        this.configFile = configFile;
        this.explosiveSheepPlugin = explosiveSheepPlugin;
    }

    @EventHandler
    public void onFeed(PlayerInteractEntityEvent event) {
        if (event.getRightClicked() instanceof Sheep) {
            Player player = event.getPlayer();

            if (event.getHand() != EquipmentSlot.HAND) return;

            if (player.getInventory().getItemInMainHand().getType() == Material.TNT) {
                if (explosiveSheepPlugin.getConfig().getBoolean("explozsivesheep")) {
                    player.getInventory().removeItem(new ItemStack(Material.TNT, 1));
                    Sheep sheep = (Sheep) event.getRightClicked();
                    sheep.setColor(DyeColor.RED);
                    sheep.setCustomName(configFile.SHEEP_NAME);
                    sheep.setCustomNameVisible(true);
                    new ExplodeSheepTask(sheep).runTaskLater(explosiveSheepPlugin, 100);
                } else {
                    player.sendMessage(configFile.DISABLE_SHEEP_MESSAGE);
                }
            }
        }
    }
}
