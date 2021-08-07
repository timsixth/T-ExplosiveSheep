package me.explosivesheep.main;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class ToggleSheepCommand implements CommandExecutor {

	private final ConfigFile cfg;

	public ToggleSheepCommand(ConfigFile cfg) {
		this.cfg = cfg;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command arg1, String arg2, String[] args) {
		if (!sender.hasPermission(cfg.PERMISSION)) {
			sender.sendMessage(cfg.PERMISSION_MESSAGE);
			return true;
		}
	if (args.length == 0) {
		sender.sendMessage(ChatColor.RED + "Correct use /togglesheep on|off");
		return true;
		}
		if (args[0].equalsIgnoreCase("off")) {
			if (Main.getMain().getConfig().getBoolean("explozsivesheep")) {
				Main.getMain().getConfig().set("explozsivesheep", Boolean.FALSE);
				Main.getMain().saveConfig();
				sender.sendMessage(cfg.DISABLE_SHEEP_MESSAGE);
			} else {
				sender.sendMessage(ChatColor.DARK_RED + "Explosive sheep is already disable");
			}
		}
		if (args[0].equalsIgnoreCase("on")) {
			if (!Main.getMain().getConfig().getBoolean("explozsivesheep")) {
				Main.getMain().getConfig().set("explozsivesheep", Boolean.TRUE);
				Main.getMain().saveConfig();
				sender.sendMessage(cfg.ENABLE_SHEEP_MESSAGE);
			}
		}
		return false;
	}

}
