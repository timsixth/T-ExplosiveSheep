package me.explosivesheep.main;

import org.bukkit.ChatColor;

public class ChatUtil {

    public static String chatColor(String text){
        return ChatColor.translateAlternateColorCodes('&',text);
    }
}
