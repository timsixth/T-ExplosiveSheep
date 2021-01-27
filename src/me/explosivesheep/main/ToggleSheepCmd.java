package me.explosivesheep.main;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class ToggleSheepCmd implements CommandExecutor {

	ConfigFile cfg = new ConfigFile();

	@Override
	public boolean onCommand(CommandSender sender, Command arg1, String arg2, String[] args) {
		if (!sender.hasPermission(cfg.getPermission())) {
			sender.sendMessage(cfg.getPermissionMessage());
			return true;
		}
	if (args.length == 0) {
		sender.sendMessage(ChatColor.RED + "Correct use /togglesheep on|off");
		return true;
		}
		if (args[0].equalsIgnoreCase("off")) {
			if (Main.getPlugin(Main.class).getConfig().getBoolean("explozsivesheep") == true) {
				Main.getPlugin(Main.class).getConfig().set("explozsivesheep", Boolean.valueOf(false));
				Main.getPlugin(Main.class).saveConfig();
				sender.sendMessage(cfg.getDisableSheepMessage());
			} else {
				sender.sendMessage(ChatColor.DARK_RED + "Explosive sheep is already disable");
			}
		}
		if (args[0].equalsIgnoreCase("on")) {
			if (Main.getPlugin(Main.class).getConfig().getBoolean("explozsivesheep") == false) {
				Main.getPlugin(Main.class).getConfig().set("explozsivesheep", Boolean.valueOf(true));
				Main.getPlugin(Main.class).saveConfig();
				sender.sendMessage(cfg.getEnableSheepMessage());
			}
		}

		return false;
	}

}
