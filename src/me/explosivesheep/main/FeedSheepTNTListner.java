package me.explosivesheep.main;

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

public class FeedSheepTNTListner implements Listener {

	private final ConfigFile cfg;

	public FeedSheepTNTListner(ConfigFile configFile) {
		this.cfg = configFile;
	}

	@EventHandler
	public void onFeed(PlayerInteractAtEntityEvent e) {
		if (e.getRightClicked() instanceof Sheep) {
			Player player = e.getPlayer();
			if (player.getItemInHand().getType() == Material.TNT){
			if (Main.getMain().getConfig().getBoolean("explozsivesheep")) {
					e.getRightClicked().remove();
					e.getPlayer().getInventory().removeItem(new ItemStack(Material.TNT, 1));
					Sheep sheep = (Sheep) e.getRightClicked().getLocation().getWorld()
							.spawnEntity(e.getRightClicked().getLocation(), EntityType.SHEEP);
					sheep.setColor(DyeColor.RED);
					sheep.setCustomName(cfg.SHEEP_NAME);
					sheep.setCustomNameVisible(true);
					new BukkitRunnable() {

						@Override
						public void run() {
							sheep.remove();
							sheep.getLocation().getWorld().spawnEntity(sheep.getLocation(), EntityType.PRIMED_TNT);
						}
					}.runTaskLater(Main.getMain(), 100);
				}else {
				e.getPlayer().sendMessage(cfg.DISABLE_SHEEP_MESSGAE);
			}
			}
		}

	}
}
