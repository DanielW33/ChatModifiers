package me.MuchDan.ChatModifiers.Commands;

import me.MuchDan.ChatModifiers.ChatModifiers;
import me.MuchDan.ChatModifiers.Util.DefaultCommands;
import me.MuchDan.ChatModifiers.Util.IO;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.util.StringUtil;


import java.util.ArrayList;
import java.util.List;

public class setChatCommand extends DefaultCommands implements CommandExecutor {
    private ChatModifiers plugin = null;

    public setChatCommand(ChatModifiers plugin){
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender Sender, Command cmd, String label, String[] args){

        if(label.equalsIgnoreCase("setChat") && Sender instanceof Player){
            if(args.length == 0 || args.length == 1){
                CommandList((Player) Sender);
                return true;
            }
            Player player = (Player) Sender;
            String Message;
            IO Configuration = plugin.getConfiguration();

            if(args[0].equalsIgnoreCase("Color")){
                Message = setColor(player, args) ?
                        Configuration.getConfig().getString("ColorAllow") : Configuration.getConfig().getString("ColorDeny");
            }
            else if(args[0].equalsIgnoreCase("Gradient")){
                Message = setGradient(player, args) ?
                        Configuration.getConfig().getString("GradientAllow") : Configuration.getConfig().getString("GradientDeny");
            }
            else if(args[0].equalsIgnoreCase("Click")){
                Message = setClick(player, args) ?
                        Configuration.getConfig().getString("ClickAllow") : Configuration.getConfig().getString("ClickDeny");

            }
            else if(args[0].equalsIgnoreCase("Hover")){
                Message = setHover(player, args) ?
                        Configuration.getConfig().getString("HoverAllow") : Configuration.getConfig().getString("HoverDeny");
            }
            else{
                Message = Configuration.getConfig().getString("InvalidPara");
            }

            player.sendMessage(Translate(Message));
            return true;
        }

        return false;
    }
    private String Translate(String Message){
        return ChatColor.translateAlternateColorCodes('&', Message);
    }

    private void setLimitlessMessage(IO file, String UUID, String[] args){
        String Message = "";
        boolean set = true;

        for(int i = 1; i < args.length; i++) {
            if (args[i].equalsIgnoreCase("None")) {
                set = false;
                break;
            } else {
                Message = Message + args[i] + " ";
            }
        }
        if (set) {
            file.getConfig().set(UUID, ChatColor.translateAlternateColorCodes('&',Message));
        }
        else{
            file.getConfig().set(UUID, null);
        }
        file.saveConfig();
    }

    private boolean setHover(Player player , String[] args){
        IO Configuration = plugin.getConfiguration();
        IO HoverData = plugin.getHoverData();
        String Permission = Configuration.getConfig().getString("HoverPermission");

        if(player.hasPermission(Permission)){
            setLimitlessMessage(HoverData, player.getUniqueId().toString(), args);
            return true;
        }
       return false;
    }
    private boolean setGradient(Player player, String[] args) {
        IO Configuration = plugin.getConfiguration();
        String Permission = Configuration.getConfig().getString("GradientPermission");

        if (player.hasPermission(Permission)) {
            if (args[1].equalsIgnoreCase("None")) {
                removeGradient(player);
            }
            else if (ChatModifiers.Colors.getGradientMap().containsKey(args[1])) {
                ApplyGraident(player, args);
            }
            else {
                player.sendMessage(ChatColor.YELLOW + "Hey! The gradient you selected doesn't exist ;( sorry.\nSetting your gradient to None");
                removeGradient(player);
            }
            return true;
        }
        return false;
    }
    private  void ApplyGraident(Player player, String[] args){
        IO GradientData = plugin.getGradientData();
        GradientData.getConfig().set(player.getUniqueId().toString() + ".Gradient", args[1]);
        if(args.length == 3 && args[2].equalsIgnoreCase("Reversed")){
            GradientData.getConfig().set(player.getUniqueId().toString() + ".Reversed", true);
        }
        else if(args.length == 2 && GradientData.getConfig().contains(player.getUniqueId().toString() + ".Reversed")){
            GradientData.getConfig().set(player.getUniqueId().toString() + ".Reversed", null);
        }
        GradientData.saveConfig();
    }
    private void removeGradient(Player player){
        IO GradientData = plugin.getGradientData();
        GradientData.getConfig().set(player.getUniqueId().toString() + ".Reversed", null);
        GradientData.getConfig().set(player.getUniqueId().toString() + ".Gradient", null);
        GradientData.getConfig().set(player.getUniqueId().toString(), null);
        GradientData.saveConfig();
    }
    private boolean setColor(Player player, String[] args){
        IO Configuration = plugin.getConfiguration();
        IO ColorData = plugin.getColorData();
        String Permission = Configuration.getConfig().getString("ColorPermission");

        if(player.hasPermission(Permission)){
            List<String> Colors = new ArrayList<>();

            for(int i = 1; i < args.length; i++){
                String Arg = args[i].toUpperCase();
                StringUtil.copyPartialMatches(Arg, ChatModifiers.Colors.getColorsAsList(), Colors);
            }

            if(Colors.contains("None")){
                ColorData.getConfig().set(player.getUniqueId().toString(), null);
            }
            else{
                ColorData.getConfig().set(player.getUniqueId().toString(), Colors);
            }
            ColorData.saveConfig();
            player.sendMessage(ChatColor.RED + "Warning: when having colors set, normal alternate color codes will not work in chat.");
            return true;
        }
        return false;
    }

    private boolean setClick(Player player, String[] args){
        IO Configuration = plugin.getConfiguration();
        IO ClickData = plugin.getClickData();
        String Permission = Configuration.getConfig().getString("ClickPermission");

        if(player.hasPermission(Permission)){
            setLimitlessMessage(ClickData, player.getUniqueId().toString(), args);
            return true;
        }
        return false;
    }
}
