package pl.timsixth.explosivesheep.util;

import org.bukkit.ChatColor;

public final class ChatUtil {
    private ChatUtil() {
    }

    public static String chatColor(String text) {
        return ChatColor.translateAlternateColorCodes('&', text);
    }
}
