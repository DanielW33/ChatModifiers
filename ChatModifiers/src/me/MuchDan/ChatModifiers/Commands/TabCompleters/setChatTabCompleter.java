package me.MuchDan.ChatModifiers.Commands.TabCompleters;

import me.MuchDan.ChatModifiers.ChatModifiers;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.util.StringUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class setChatTabCompleter implements TabCompleter {

    @Override
    public List<String> onTabComplete(CommandSender Sender, Command cmd, String label, String[] args) {
        if(label.equalsIgnoreCase("setChat")){

            List<String> Para = new ArrayList<>();
            if(args.length == 1){
                List<String> Parameter = Arrays.asList(new String[]{"Color", "Gradient" ,"Hover", "Click"});
                StringUtil.copyPartialMatches(args[0], Parameter, Para);
                return Para;
            }
            else if(args.length >= 2 && args[0].equalsIgnoreCase("Color")){
                StringUtil.copyPartialMatches(args[args.length - 1], ChatModifiers.Colors.getColorsAsList(), Para);
                return Para;
            }
            else if(args.length == 2 && args[0].equalsIgnoreCase("Gradient")){
                StringUtil.copyPartialMatches(args[1], ChatModifiers.Colors.getGradientsAsList(), Para);
                return Para;
            }
            else if (args.length == 2 && args[0].equalsIgnoreCase("Hover")){
                List<String> Parameter = Arrays.asList(new String[]{"Your Hover Message", "None"});
                StringUtil.copyPartialMatches(args[1], Parameter, Para);
                return Para;
            }
            else if(args.length == 2 && args[0].equalsIgnoreCase("Click")){
                List<String> Parameter = Arrays.asList(new String[]{"Your Command that runs when clicked", "None"});
                StringUtil.copyPartialMatches(args[1], Parameter, Para);
                return Para;
            }
            else if(args.length == 3 && args[0].equalsIgnoreCase("Gradient")){
                Para.add("Reversed");
                return Para;
            }
        }
        return null;
    }
}
