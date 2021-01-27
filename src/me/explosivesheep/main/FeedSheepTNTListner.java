package me.explosivesheep.main;

import org.bukkit.DyeColor;
import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Sheep;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractAtEntityEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

public class FeedSheepTNTListner implements Listener {

	ConfigFile cfg = new ConfigFile();

	@EventHandler
	public void onFeed(PlayerInteractAtEntityEvent e) {

		if (e.getRightClicked() instanceof Sheep) {
			if (Main.getPlugin(Main.class).getConfig().getBoolean("explozsivesheep") == true) {
				if (e.getPlayer().getItemInHand().getType() == Material.TNT) {
					e.getRightClicked().remove();
					e.getPlayer().getInventory().removeItem(new ItemStack[] { new ItemStack(Material.TNT, 1) });
					Sheep sheep = (Sheep) e.getRightClicked().getLocation().getWorld()
							.spawnEntity(e.getRightClicked().getLocation(), EntityType.SHEEP);
					sheep.setColor(DyeColor.RED);
					sheep.setCustomName(cfg.getSheepNameMessage());
					sheep.setCustomNameVisible(true);
					new BukkitRunnable() {

						@Override
						public void run() {
							sheep.remove();
							sheep.getLocation().getWorld().spawnEntity(sheep.getLocation(), EntityType.PRIMED_TNT);
						}
					}.runTaskLater(Main.getPlugin(Main.class), 100);
				}
			} else {
				e.getPlayer().sendMessage(cfg.getDisableSheepMessage());
			}
		}

	}
}
