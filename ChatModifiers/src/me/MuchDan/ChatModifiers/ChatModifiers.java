package me.MuchDan.ChatModifiers;

import me.MuchDan.ChatModifiers.Commands.setChatCommand;
import me.MuchDan.ChatModifiers.Commands.setChatTabCompleter;
import me.MuchDan.ChatModifiers.Events.OnPlayerChatEvent;
import me.MuchDan.ChatModifiers.Util.ColorMap;
import me.MuchDan.ChatModifiers.Util.IO;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;

public class ChatModifiers extends JavaPlugin {
    public static ColorMap Colors;
    public static List<Player> local;
    private IO HoverData = null;
    private IO ClickData = null;
    private IO ColorData = null;
    private IO Configuration = null;
    private IO GradientData = null;

    @Override
    public void onEnable(){
        init();

        this.getCommand("setChat").setExecutor(new setChatCommand(this));
        this.getCommand("ChatModifiers").setExecutor(new setChatCommand(this));
        this.getCommand("setChat").setTabCompleter(new setChatTabCompleter());

        this.getServer().getPluginManager().registerEvents(new OnPlayerChatEvent(this), this);
    }

    private void init(){
        HoverData = new IO(this, "Data/HoverData.yml");
        ClickData = new IO(this, "Data/ClickData.yml");
        ColorData = new IO(this, "Data/ColorData.yml");
        Configuration = new IO(this, "Configuration.yml");
        GradientData = new IO(this, "Data/GradientData.yml");

        HoverData.getConfig().options().copyDefaults(false);
        ClickData.getConfig().options().copyDefaults(false);
        ColorData.getConfig().options().copyDefaults(false);
        Configuration.getConfig().options().copyDefaults(false);
        GradientData.getConfig().options().copyDefaults(false);

        HoverData.saveDefaultConfig();
        ClickData.saveDefaultConfig();
        ColorData.saveDefaultConfig();
        Configuration.saveDefaultConfig();
        GradientData.saveDefaultConfig();

        Colors = new ColorMap();
        local = new ArrayList<>();
    }

    public IO getClickData() {
        return ClickData;
    }

    public IO getColorData() {
        return ColorData;
    }

    public IO getHoverData() {
        return HoverData;
    }

    public IO getConfiguration() {
        return Configuration;
    }

    public IO getGradientData(){
        return GradientData;
    }
}
