package me.timsixth.explosivesheep.config;

import me.timsixth.explosivesheep.ExplosiveSheepPlugin;
import me.timsixth.explosivesheep.util.ChatUtil;

public class ConfigFile {

    public final String PERMISSION_MESSAGE;
    public final String ENABLE_SHEEP_MESSAGE;
    public final String DISABLE_SHEEP_MESSAGE;
    public final String CORRECT_USE_MESSAGE;
    public final String SHEEP_IS_DISABLED_MESSAGE;
    public final String SHEEP_NAME;
    public final String PERMISSION;

    public ConfigFile(ExplosiveSheepPlugin explosiveSheepPlugin) {
        PERMISSION_MESSAGE = ChatUtil.chatColor(explosiveSheepPlugin.getConfig().getString("messages.nopermission"));
        ENABLE_SHEEP_MESSAGE = ChatUtil.chatColor(explosiveSheepPlugin.getConfig().getString("messages.enablesheep"));
        SHEEP_NAME = ChatUtil.chatColor(explosiveSheepPlugin.getConfig().getString("messages.sheepname"));
        DISABLE_SHEEP_MESSAGE = ChatUtil.chatColor(explosiveSheepPlugin.getConfig().getString("messages.disablesheep"));
        CORRECT_USE_MESSAGE = ChatUtil.chatColor(explosiveSheepPlugin.getConfig().getString("messages.correctuse"));
        SHEEP_IS_DISABLED_MESSAGE = ChatUtil.chatColor(explosiveSheepPlugin.getConfig().getString("messages.sheep_is_disabled"));
        PERMISSION = explosiveSheepPlugin.getConfig().getString("permission");
    }
}
