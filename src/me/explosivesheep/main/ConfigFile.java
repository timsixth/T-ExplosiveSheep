package me.explosivesheep.main;

public class ConfigFile {

    public final String PERMISSION_MESSAGE;
    public final String ENABLE_SHEEP_MESSAGE;
    public final String DISABLE_SHEEP_MESSAGE;
    public final String SHEEP_NAME;
    public final String PERMISSION;

    public ConfigFile() {
        PERMISSION_MESSAGE = ChatUtil.chatColor(Main.getMain().getConfig().getString("messages.nopermission"));
        ENABLE_SHEEP_MESSAGE = ChatUtil.chatColor(Main.getMain().getConfig().getString("messages.enablesheep"));
        SHEEP_NAME = ChatUtil.chatColor(Main.getMain().getConfig().getString("messages.sheepname"));
        DISABLE_SHEEP_MESSAGE = ChatUtil.chatColor(Main.getMain().getConfig().getString("messages.disablesheep"));
        PERMISSION = Main.getMain().getConfig().getString("permission");
    }
}
