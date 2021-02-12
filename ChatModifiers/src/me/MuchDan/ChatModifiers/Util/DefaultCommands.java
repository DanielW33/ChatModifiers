package me.MuchDan.ChatModifiers.Util;

import me.MuchDan.ChatModifiers.ChatModifiers;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class DefaultCommands {
    public void CommandList(Player Sender){
        Sender.sendMessage(ChatColor.YELLOW + "========== ChatModifiers ==========");
        Sender.sendMessage(ChatColor.YELLOW + "/setChat Color {set of Colors}");
        Sender.sendMessage(ChatColor.YELLOW + "/setChat Click 'Command on Click' ex. /spawn");
        Sender.sendMessage(ChatColor.YELLOW + "/setChat Hover 'Your Message here'");
        Sender.sendMessage(ChatColor.YELLOW + "Be sure to exclude any {} or '' when executing the commands.");
    }
    public void AdminCommandList(Player Sender){
        Sender.sendMessage(ChatColor.YELLOW + "========== ChatModifiers Admin ==========");
        Sender.sendMessage(ChatColor.YELLOW + "/ChatModifiers reload" + ChatColor.WHITE + " will reload all config files" );
    }
}
