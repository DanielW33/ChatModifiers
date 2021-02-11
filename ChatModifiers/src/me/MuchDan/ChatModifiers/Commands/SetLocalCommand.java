package me.MuchDan.ChatModifiers.Commands;

import me.MuchDan.ChatModifiers.ChatModifiers;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SetLocalCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender Sender, Command cmd, String label, String[] args){
        if(label.equalsIgnoreCase("Local")){
            if(!(Sender instanceof Player)){
                Sender.sendMessage("You can not enter local chat from console!");
                return false;
            }
            Player player = (Player) Sender;

            if (ChatModifiers.local.contains(player)) {
                ChatModifiers.local.remove(player);
                player.sendMessage(ChatColor.GREEN + "You are now chatting in global chat!");
            }


        }

        return false;
    }
}
