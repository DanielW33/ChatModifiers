package me.MuchDan.ChatModifiers.Commands;

import me.MuchDan.ChatModifiers.ChatModifiers;
import me.MuchDan.ChatModifiers.Util.DefaultCommands;
import me.MuchDan.ChatModifiers.Util.IO;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class AdminCommands extends DefaultCommands implements CommandExecutor {
    private ChatModifiers plugin;

    public AdminCommands(ChatModifiers plugin){
        this.plugin = plugin;
    }
    @Override
    public boolean onCommand(CommandSender Sender, Command Cmd, String label, String[] args){
        Player player = (Player) Sender;
        IO Configuration = plugin.getConfiguration();

        if(player.hasPermission(Configuration.getConfig().getString("AdminCommandsPermission"))){
            if(args.length == 0){
                AdminCommandList(player);
                return false;
            }
            if(args[0].equalsIgnoreCase("Reload")){
                plugin.getGradientList().reloadConfig();
                plugin.getConfiguration().reloadConfig();
                player.sendMessage(ChatColor.AQUA + "Successfully reloaded Configuration.yml and GradientList.yml!");
            }
            else{
                Sender.sendMessage(ChatColor.RED + "Invalid command, Please reference below.");
                AdminCommandList(player);
            }
        }
        else{
            CommandList(player);
        }
        return true;
    }
}
