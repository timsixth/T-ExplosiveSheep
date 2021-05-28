package me.explosivesheep.main;

public class ConfigFile {

    public String PERMISSION_MESSAGE = "";
    public String ENABLE_SHEEP_MESSAGE = "";
    public String DISABLE_SHEEP_MESSGAE = "";
    public String SHEEP_NAME = "";
    public String PERMISSION = "";

    public ConfigFile() {
        PERMISSION_MESSAGE = ChatUtil.chatColor(Main.getMain().getConfig().getString("messages.nopermission"));
        ENABLE_SHEEP_MESSAGE = ChatUtil.chatColor(Main.getMain().getConfig().getString("messages.enablesheep"));
        SHEEP_NAME = ChatUtil.chatColor(Main.getMain().getConfig().getString("messages.sheepname"));
        DISABLE_SHEEP_MESSGAE = ChatUtil.chatColor(Main.getMain().getConfig().getString("messages.disablesheep"));
        PERMISSION = Main.getMain().getConfig().getString("permission");
    }
}
