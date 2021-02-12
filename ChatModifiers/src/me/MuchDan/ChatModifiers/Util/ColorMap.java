package me.MuchDan.ChatModifiers.Util;

import me.MuchDan.ChatModifiers.ChatModifiers;

import java.util.*;

public class ColorMap {
    private ChatModifiers plugin;
    private Map<String, String> ColorChart = null;
    private Map<String, List<String>> GradientMap = null;

    public ColorMap(ChatModifiers plugin){
        this.plugin = plugin;
        InitColorMap();
        InitGradiantMap();
    }
    ///////////////////////////////
    private void InitGradiantMap(){
        GradientMap = new HashMap<>();
        IO GradientList = plugin.getGradientList();
        GradientList.getConfig().getKeys(true).forEach(vals -> GradientMap.put(vals.replace("Gradients.", ""), GradientList.getConfig().getStringList(vals)));
    }
    public List<String> getGradientsAsList(){
        List<String> Gradients = new ArrayList<>();
        Gradients.addAll(GradientMap.keySet());
        return Gradients;
    }
    /////////////////////////////////////
    public void InitColorMap(){
        ColorChart = new HashMap<>();
        ColorChart.put("Black", "&0");
        ColorChart.put("Dark_Blue", "&1");
        ColorChart.put("Dark_Green", "&2");
        ColorChart.put("Dark_Aqua", "&3");
        ColorChart.put("Dark_Red", "&4");
        ColorChart.put("Dark_Purple", "&5");
        ColorChart.put("Gold", "&6");
        ColorChart.put("Gray", "&7");
        ColorChart.put("Dark_Gray", "&8");
        ColorChart.put("Blue", "&9");
        ColorChart.put("Green", "&a");
        ColorChart.put("Aqua", "&b");
        ColorChart.put("Red", "&c");
        ColorChart.put("Light_Purple", "&d");
        ColorChart.put("Yellow", "&e");
        ColorChart.put("White", "&f");
        ColorChart.put("Random", "&k");
        ColorChart.put("Bold", "&l");
        ColorChart.put("CrossedOut", "&m");
        ColorChart.put("Underlined", "&n");
        ColorChart.put("Italic", "&o");
    }
    public List<String> getColorsAsList(){
        List<String> Colors = new ArrayList<>();
        String[] ColorArray = {"Black", "Dark_Blue", "Dark_Green", "Dark_Aqua", "Dark_Red", "Dark_Purple", "Gold", "Gray", "Dark_Gray", "Blue", "Green", "Aqua", "Red", "Light_Purple"
        , "Yellow", "White", "Random", "Bold", "CrossedOut", "Underlined", "Italic", "None"};
        Colors.addAll(Arrays.asList(ColorArray));
        return Colors;
    }
    public Map<String, String> getColorChart(){
        return ColorChart;
    }
    public Map<String, List<String>> getGradientMap() {
        return GradientMap;
    }
}
