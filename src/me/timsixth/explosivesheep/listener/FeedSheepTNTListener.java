package me.timsixth.explosivesheep.listener;

import me.timsixth.explosivesheep.ExplosiveSheepPlugin;
import me.timsixth.explosivesheep.config.ConfigFile;
import org.bukkit.DyeColor;
import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Sheep;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractAtEntityEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

public class FeedSheepTNTListener implements Listener {

    private final ConfigFile configFile;
    private final ExplosiveSheepPlugin explosiveSheepPlugin;

    public FeedSheepTNTListener(ConfigFile configFile, ExplosiveSheepPlugin explosiveSheepPlugin) {
        this.configFile = configFile;
        this.explosiveSheepPlugin = explosiveSheepPlugin;
    }

    @EventHandler
    public void onFeed(PlayerInteractAtEntityEvent event) {
        if (event.getRightClicked() instanceof Sheep) {
            Player player = event.getPlayer();
            if (player.getItemInHand().getType() == Material.TNT) {
                if (explosiveSheepPlugin.getConfig().getBoolean("explozsivesheep")) {
                    player.getInventory().removeItem(new ItemStack(Material.TNT, 1));
                    Sheep sheep = (Sheep) event.getRightClicked();
                    sheep.setColor(DyeColor.RED);
                    sheep.setCustomName(configFile.SHEEP_NAME);
                    sheep.setCustomNameVisible(true);
                    new BukkitRunnable() {

                        @Override
                        public void run() {
                            sheep.remove();
                            sheep.getLocation().getWorld().spawnEntity(sheep.getLocation(), EntityType.PRIMED_TNT);
                        }
                    }.runTaskLater(explosiveSheepPlugin, 100);
                } else {
                    player.sendMessage(configFile.DISABLE_SHEEP_MESSAGE);
				}
            }
        }
    }
}
