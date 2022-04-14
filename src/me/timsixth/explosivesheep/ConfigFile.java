package me.timsixth.explosivesheep;

public class ConfigFile {

    public final String PERMISSION_MESSAGE;
    public final String ENABLE_SHEEP_MESSAGE;
    public final String DISABLE_SHEEP_MESSAGE;
    public final String CORRECT_USE_MESSAGE;
    public final String SHEEP_IS_DISABLED_MESSAGE;
    public final String SHEEP_NAME;
    public final String PERMISSION;

    public ConfigFile(Main main) {
        PERMISSION_MESSAGE = ChatUtil.chatColor(main.getConfig().getString("messages.nopermission"));
        ENABLE_SHEEP_MESSAGE = ChatUtil.chatColor(main.getConfig().getString("messages.enablesheep"));
        SHEEP_NAME = ChatUtil.chatColor(main.getConfig().getString("messages.sheepname"));
        DISABLE_SHEEP_MESSAGE = ChatUtil.chatColor(main.getConfig().getString("messages.disablesheep"));
        CORRECT_USE_MESSAGE = ChatUtil.chatColor(main.getConfig().getString("messages.correctuse"));
        SHEEP_IS_DISABLED_MESSAGE = ChatUtil.chatColor(main.getConfig().getString("messages.sheep_is_disabled"));
        PERMISSION = main.getConfig().getString("permission");
    }
}
