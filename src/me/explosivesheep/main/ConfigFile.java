package me.explosivesheep.main;

import org.bukkit.ChatColor;

public class ConfigFile {

	public String getPermissionMessage() {
		return ChatColor.translateAlternateColorCodes('&',
				Main.getMain().getConfig().getString("nopermission"));
	}

	public String getEnableSheepMessage() {
		return ChatColor.translateAlternateColorCodes('&',
				Main.getMain().getConfig().getString("enablesheep"));
	}

	public String getSheepNameMessage() {
		return ChatColor.translateAlternateColorCodes('&', Main.getMain().getConfig().getString("sheepname"));
	}

	public String getPermission() {
		return Main.getMain().getConfig().getString("permission");
	}

	public String getDisableSheepMessage() {
		return ChatColor.translateAlternateColorCodes('&',
				Main.getMain().getConfig().getString("disablesheep"));
	}


}
