package me.MuchDan.ChatModifiers.Events;

import me.MuchDan.ChatModifiers.ChatModifiers;
import me.MuchDan.ChatModifiers.Util.IO;
import net.luckperms.api.LuckPerms;
import net.luckperms.api.LuckPermsProvider;
import net.luckperms.api.model.user.User;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.chat.hover.content.Text;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

public class OnPlayerChatEvent implements Listener {
    private ChatModifiers plugin;

    public OnPlayerChatEvent(ChatModifiers plugin){
        this.plugin = plugin;
    }

    @EventHandler
    public void PlayerChatEvent(AsyncPlayerChatEvent Event){
        if(!Event.isCancelled()) {
            Player player = Event.getPlayer();

            String UUID = player.getUniqueId().toString();
            LuckPerms luckPerms = LuckPermsProvider.get();
            User user = luckPerms.getUserManager().getUser(player.getUniqueId());

            String Prefix = user.getCachedData().getMetaData().getPrefix() == null ? "" : user.getCachedData().getMetaData().getPrefix() + " ";
            String Suffix = user.getCachedData().getMetaData().getSuffix() == null ? "" : " " + user.getCachedData().getMetaData().getSuffix();

            String RealName = player.getName();
            String DisplayName = player.getDisplayName();
            String StartMessage = Event.getMessage();

            Event.setMessage(ChatColor.translateAlternateColorCodes('&', Event.getMessage()));
            PackedMessage(UUID, StartMessage, DisplayName, Prefix, Suffix, RealName, Event);
        }
    }
    private TextComponent ApplyGradiant(AsyncPlayerChatEvent Event, String StartMessage) {
        IO GradientData = plugin.getGradientData();
        String Gradient = GradientData.getConfig().getString(Event.getPlayer().getUniqueId().toString() + ".Gradient");
        TextComponent Message;
        if(GradientData.getConfig().contains(Event.getPlayer().getUniqueId().toString() + ".Reversed")){
            Message = Reversed(StartMessage, Gradient);
        }
        else{
            Message = Forward(StartMessage, Gradient);
        }
        return Message;
    }
    private TextComponent Forward(String StartMessage, String Gradient){
        List<TextComponent> Msg = new ArrayList<>();
        int GradientLength = ChatModifiers.Colors.getGradientMap().get(Gradient).size();
        int Count = StartMessage.length() > GradientLength ? StartMessage.length() / GradientLength : 1;
        int pos = 0;
        int j = 0;

        List<String> GradientList = ChatModifiers.Colors.getGradientMap().get(Gradient);
        for(int i = 0; i < StartMessage.length(); i++){
            if(j == Count){
                if(pos != ChatModifiers.Colors.getGradientMap().get(Gradient).size() - 1) {
                    pos++;
                }
                j = 0;
            }
            if(StartMessage.charAt(i) == ' '){
                Msg.add(new TextComponent(" "));
            }
            else {
                j++;
                Msg.add(new TextComponent(String.valueOf(StartMessage.charAt(i))));
                Msg.get(i).setColor(net.md_5.bungee.api.ChatColor.of(GradientList.get(pos)));
            }
        }
        TextComponent FinalMessage = new TextComponent();
        for (TextComponent textComponent : Msg) {
            FinalMessage.addExtra(textComponent);
        }
        Msg.clear();
        return FinalMessage;
    }
    public TextComponent Reversed(String StartMessage, String Gradient){
        List<TextComponent> Msg = new ArrayList<>();
        int GradientLength = ChatModifiers.Colors.getGradientMap().get(Gradient).size();
        int Count = StartMessage.length() > GradientLength ? StartMessage.length() / GradientLength : 1;
        int pos = ChatModifiers.Colors.getGradientMap().get(Gradient).size() - 1;
        int j = 0;

        List<String> GradientList = ChatModifiers.Colors.getGradientMap().get(Gradient);

        for(int i = 0; i < StartMessage.length(); i++){
            if(j == Count){
                if(pos != 0){
                    pos --;
                }
                j = 0;
            }
            if(StartMessage.charAt(i) == ' '){
                Msg.add(new TextComponent(" "));
            }
            else{
                j++;
                Msg.add(new TextComponent(String.valueOf(StartMessage.charAt(i))));
                Msg.get(i).setColor(net.md_5.bungee.api.ChatColor.of(GradientList.get(pos)));
            }
        }
        TextComponent FinalMessage = new TextComponent();
        for(TextComponent textComponent : Msg){
            FinalMessage.addExtra(textComponent);
        }
        Msg.clear();
        return FinalMessage;
    }
    private void regularMessage(AsyncPlayerChatEvent Event, String Prefix, String Suffix){
        Event.setFormat(Prefix +  "%1$s" + Suffix  + ": " + "%2$s");

    }
    private void PackedMessage(String UUID, String StartMessage, String DisplayName, String Prefix, String Suffix, String RealName, AsyncPlayerChatEvent Event){
        IO ColorData = plugin.getColorData();
        IO HoverData = plugin.getHoverData();
        IO ClickData = plugin.getClickData();
        IO GradientData = plugin.getGradientData();

        boolean hasColor = ColorData.getConfig().contains(UUID);
        boolean hasHover = HoverData.getConfig().contains(UUID);
        boolean hasClick = ClickData.getConfig().contains(UUID);
        boolean hasGradient = GradientData.getConfig().contains(UUID);

        if(!hasColor && !hasHover && !hasClick && !hasGradient){
            regularMessage(Event, Prefix, Suffix);
        }
        else {
            Event.setCancelled(true);
            TextComponent Message = new TextComponent("");

            if (hasGradient) {
                StartMessage = ChatColor.stripColor(StartMessage);
                Message = ApplyGradiant(Event, StartMessage);
            }
            else if (hasColor) {
                StartMessage = ChatColor.stripColor(StartMessage);
                StartMessage = HandleColors(UUID, StartMessage);
                StartMessage = ChatColor.translateAlternateColorCodes('&', StartMessage);
                Message.addExtra(StartMessage);
            }
            if (hasHover) {
                HandleHover(UUID, Message);
            }
            if (hasClick) {
                HandleClick(UUID, Message);
            }

            TextComponent Name = new TextComponent(DisplayName);
            TextComponent TPrefix = new TextComponent(Prefix);
            TextComponent TSuffix = new TextComponent(Suffix);
            //Name.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new Text(RealName)));

            TextComponent Final = new TextComponent();
            Final.addExtra(TPrefix);
            Final.addExtra(Name);
            Final.addExtra(TSuffix);
            Final.addExtra(": ");
            Final.addExtra(Message);

            plugin.getServer().getLogger().log(Level.INFO, DisplayName + ": " + StartMessage);
            Event.getRecipients().forEach(Players -> Players.spigot().sendMessage(Final));

        }
    }

    private void HandleClick(String UUID, TextComponent msg){
        IO ClickData = plugin.getClickData();
        String ClickCommand = ClickData.getConfig().getString(UUID);
        msg.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, ClickCommand));
    }

    private void HandleHover(String UUID, TextComponent msg){
        IO HoverData = plugin.getHoverData();
        String HoverMessage = HoverData.getConfig().getString(UUID);
        msg.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new Text(HoverMessage)));
    }

    private String HandleColors(String UUID, String Message) {
        IO ColorData = plugin.getColorData();
        List<String> Colors = ColorData.getConfig().getStringList(UUID);

        String ConcatenatedMessage = "";
        String R = "", B = "", I = "", U = "", C = "";
        if (Colors.contains("Random")) {
            R = ChatModifiers.Colors.getColorChart().get("Random");
            Colors.remove("Random");
        }
        if (Colors.contains("Bold")) {
            B = ChatModifiers.Colors.getColorChart().get("Bold");
            Colors.remove("Bold");
        }
        if (Colors.contains("Italic")) {
            I = ChatModifiers.Colors.getColorChart().get("Italic");
            Colors.remove("Italic");
        }
        if (Colors.contains("Underlined")) {
            U = ChatModifiers.Colors.getColorChart().get("Underlined");
            Colors.remove("Underlined");
        }
        if (Colors.contains("CrossedOut")) {
            C = ChatModifiers.Colors.getColorChart().get("CrossedOut");
            Colors.remove("CrossedOut");
        }
        int Assigned = Colors.size();
        int Counter = 0;
        if(!Colors.isEmpty()) {
            for (int i = 0; i < Message.length(); i++) {
                if (Counter == Assigned) {
                    Counter = 0;
                }
                if(Message.charAt(i) == ' '){
                    ConcatenatedMessage = ConcatenatedMessage + " ";
                }
                else {
                    ConcatenatedMessage = ConcatenatedMessage + ChatModifiers.Colors.getColorChart().get(Colors.get(Counter)) + R + B + I + U + C + Message.charAt(i);
                    Counter = Counter + 1;
                }
            }
        }
        else {
            ConcatenatedMessage = ConcatenatedMessage + R + B + I + U + C + Message;
        }

        return ConcatenatedMessage;
    }

}
