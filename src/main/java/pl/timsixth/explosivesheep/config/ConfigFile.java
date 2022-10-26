package pl.timsixth.explosivesheep.config;

import pl.timsixth.explosivesheep.ExplosiveSheepPlugin;
import pl.timsixth.explosivesheep.util.ChatUtil;

public class ConfigFile {

    public String PERMISSION_MESSAGE;
    public String ENABLE_SHEEP_MESSAGE;
    public String DISABLE_SHEEP_MESSAGE;
    public String CORRECT_USE_MESSAGE;
    public String SHEEP_IS_DISABLED_MESSAGE;
    public String SHEEP_NAME;
    public String PERMISSION;
    public String FILES_RELOADED;

    public String CORRECT_USE_ADMIN_COMMAND;
    private final ExplosiveSheepPlugin explosiveSheepPlugin;

    public ConfigFile(ExplosiveSheepPlugin explosiveSheepPlugin) {
        this.explosiveSheepPlugin = explosiveSheepPlugin;
        loadConfig();
    }

    private void loadConfig() {
        PERMISSION_MESSAGE = ChatUtil.chatColor(explosiveSheepPlugin.getConfig().getString("messages.nopermission"));
        ENABLE_SHEEP_MESSAGE = ChatUtil.chatColor(explosiveSheepPlugin.getConfig().getString("messages.enablesheep"));
        SHEEP_NAME = ChatUtil.chatColor(explosiveSheepPlugin.getConfig().getString("messages.sheepname"));
        DISABLE_SHEEP_MESSAGE = ChatUtil.chatColor(explosiveSheepPlugin.getConfig().getString("messages.disablesheep"));
        CORRECT_USE_MESSAGE = ChatUtil.chatColor(explosiveSheepPlugin.getConfig().getString("messages.correctuse"));
        SHEEP_IS_DISABLED_MESSAGE = ChatUtil.chatColor(explosiveSheepPlugin.getConfig().getString("messages.sheep_is_disabled"));
        FILES_RELOADED = ChatUtil.chatColor(explosiveSheepPlugin.getConfig().getString("messages.files_reloaded"));
        CORRECT_USE_ADMIN_COMMAND = ChatUtil.chatColor(explosiveSheepPlugin.getConfig().getString("messages.correct_use_admin_command"));
        PERMISSION = explosiveSheepPlugin.getConfig().getString("permission");
    }

    public void reloadConfig() {
        explosiveSheepPlugin.reloadConfig();
        loadConfig();
    }
}
