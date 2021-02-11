package me.MuchDan.ChatModifiers.Util;

import java.util.*;

public class ColorMap {
    private Map<String, String> ColorChart = null;
    private Map<String, List<String>> GradientMap = null;

    public ColorMap(){
        InitColorMap();
        InitGradiantMap();
    }

    private void InitGradiantMap(){
        GradientMap = new HashMap<>();
        GreyBlue();
        Black();
        Brown();
        OrangeRed();
        YellowOrange();
        OrangeYellow();
        Sunset();
        Grass();
        LightGreen();
        GreenBlue();
        Green();
        BlueGreen();
        LightBlue();
        Blue();
        BluePurple();
        Purple();
        LightPurple();
        Pink();
        Red();
    }
    public List<String> getGradientsAsList(){
        String[] Gradients = {"GreyBlue", "Black", "Brown", "OrangeRed", "YellowOrange", "OrangeYellow", "SunSet", "Grass", "LightGreen", "GreenBlue", "Green"
        , "BlueGreen", "LightBlue", "Blue", "BluePurple", "Purple", "LightPurple", "Pink", "Red", "None"};
        return Arrays.asList(Gradients);
    }
    private void GreyBlue(){
        String[] Hex = {"#263238", "#37474F","#455A64", "#546E7A", "#607D8B", "#78909C", "#90A4AE", "#B0BEC5", "#CFD8DC", "#ECEFF1"};
        List<String> GreyBlueGradiant = Arrays.asList(Hex);
        GradientMap.put("GreyBlue", GreyBlueGradiant);
    }
    private void Black(){
        String[] Hex = {"#212121","#424242","#616161","#757575","#9E9E9E","#BDBDBD","#E0E0E0","#EEEEEE","#F5F5F5","#FAFAFA"};
        List<String> BlackGradiant = Arrays.asList(Hex);
        GradientMap.put("Black", BlackGradiant);
    }
    private void Brown(){
        String[] Hex = {"#3E2723","#4E342E","#5D4037","#6D4C41","#795548","#8D6E63","#A1887F","#BCAAA4", "#D7CCC8","#EFEBE9"};
        List<String> BrownGradiant = Arrays.asList(Hex);
        GradientMap.put("Brown", BrownGradiant);
    }
    private void OrangeRed(){
        String[] Hex = {"#BF360C","#D84315","#E64A19","#F4511E","#FF5722","#FF7043","#FF8A65","#FFAB91","#FFCCBC", "#FBE9E7"};
        List<String> BrownGradiant = Arrays.asList(Hex);
        GradientMap.put("OrangeRed", BrownGradiant);
    }
    private void OrangeYellow(){
        String[] Hex = {"#E65100","#EF6C00","#F57C00","#FB8C00","#FF9800","#FFA726","#FFB74D","#FFCC80","#FFE0B2", "#FFF3E0"};
        List<String> OrangeYellow = Arrays.asList(Hex);
        GradientMap.put("OrangeYellow", OrangeYellow);
    }
    private void Sunset(){
        String[] Hex = {"#FF6F00","#FF8F00","#FFA000","#FFB300","#FFC107","#FFCA28","#FFD54F","#FFE082","#FFECB3", "#FFF8E1"};
        List<String> SunSet = Arrays.asList(Hex);
        GradientMap.put("SunSet", SunSet);
    }
    private void YellowOrange(){
        String[] Hex = {"#F57F17","#F9A825","#FBC02D","#FDD835","#FFEB3B","#FFEE58","#FFF176","#FFF59D","#FFF9C4", "#FFFDE7"};
        List<String> YellowOrange = Arrays.asList(Hex);
        GradientMap.put("YellowOrange", YellowOrange);
    }
    private void Grass(){
        String[] Hex = {"#827717","#9E9D24","#AFB42B","#C0CA33","#CDDC39","#D4E157","#DCE775","#E6EE9C","#F0F4C3", "#F9FBE7"};
        List<String> Grass = Arrays.asList(Hex);
        GradientMap.put("Grass", Grass);
    }
    private void LightGreen(){
        String[] Hex = {"#33691E","#558B2F","#689F38","#7CB342","#8BC34A","#9CCC65","#AED581", "#C5E1A5","#DCEDC8","#F1F8E9"};
        List<String> LightGreen = Arrays.asList(Hex);
        GradientMap.put("LightGreen", LightGreen);
    }
    private void Green(){
        String[] Hex = {"#1B5E20","#2E7D32","#388E3C","#43A047","#4CAF50","#66BB6A","#81C784","#A5D6A7","#C8E6C9", "#E8F5E9"};
        List<String> Green = Arrays.asList(Hex);
        GradientMap.put("Green", Green);
    }
    private void GreenBlue(){
        String[] Hex = {"#004D40","#00695C","#00796B","#00897B","#009688","#26A69A","#4DB6AC", "#80CBC4","#B2DFDB","#E0F2F1"};
        List<String> GreenBlue = Arrays.asList(Hex);
        GradientMap.put("GreenBlue", GreenBlue);
    }
    private void BlueGreen(){
        String[] Hex = {"#006064","#00838F","#0097A7","#00ACC1","#00BCD4","#26C6DA","#4DD0E1","#80DEEA", "#B2EBF2","#E0F7FA"};
        List<String> BlueGreen = Arrays.asList(Hex);
        GradientMap.put("BlueGreen", BlueGreen);
    }
    private void LightBlue(){
        String[] Hex = {"#01579B","#0277BD","#0288D1","#039BE5","#03A9F4","#29B6F6","#4FC3F7","#81D4FA", "#B3E5FC","#E1F5FE"};
        List<String> LightBlue = Arrays.asList(Hex);
        GradientMap.put("LightBlue", LightBlue);
    }
    private void Blue(){
        String[] Hex = {"#0D47A1","#1565C0","#1976D2","#1E88E5","#2196F3","#42A5F5","#64B5F6","#90CAF9", "#BBDEFB","#E3F2FD"};
        List<String> Blue = Arrays.asList(Hex);
        GradientMap.put("Blue", Blue);
    }
    private void BluePurple(){
        String[] Hex = {"#1A237E","#283593","#303F9F","#3949AB","#3F51B5","#5C6BC0","#7986CB","#9FA8DA","#C5CAE9", "#E8EAF6"};
        List<String> BluePurple = Arrays.asList(Hex);
        GradientMap.put("BluePurple", BluePurple);
    }
    private void Purple(){
        String[] Hex = {"#311B92","#4527A0","#512DA8","#5E35B1","#673AB7","#7E57C2","#9575CD","#B39DDB","#D1C4E9", "#EDE7F6"};
        List<String> Purple = Arrays.asList(Hex);
        GradientMap.put("Purple", Purple);
    }
    private void LightPurple(){
        String[] Hex = {"#4A148C","#6A1B9A","#7B1FA2","#8E24AA","#9C27B0","#AB47BC","#BA68C8","#CE93D8", "#E1BEE7","#F3E5F5"};
        List<String> lightPurple = Arrays.asList(Hex);
        GradientMap.put("LightPurple", lightPurple);
    }
    private void Pink(){
        String[] Hex = {"#880E4F","#AD1457","#C2185B","#D81B60","#E91E63","#EC407A","#F06292","#F48FB1","#F8BBD0", "#FCE4EC"};
        List<String> Pink = Arrays.asList(Hex);
        GradientMap.put("Pink", Pink);
    }
    private void Red(){
        String[] Hex = {"#B71C1C","#C62828","#D32F2F","#E53935","#F44336","#EF5350","#E57373","#EF9A9A","#FFCDD2", "#FFEBEE"};
        List<String> Red = Arrays.asList(Hex);
        GradientMap.put("Red", Red);
    }
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
/*
    private void GreyBlue(){
        String[] Hex = {"&x&2&6&3&2&3&8", "&x&3&7&4&7&4&F","&x&4&5&5&A&6&4", "&x&5&4&6&E&7&A", "&x&6&0&7&D&8&B", "&x&7&8&9&0&9&C", "&x&9&0&A&4&A&E",
                "&x&B&0&B&E&C&5", "&x&C&F&D&8&D&C", "&x&E&C&E&F&F&1"};
        List<String> GreyBlueGradiant = Arrays.asList(Hex);
        GradientMap.put("GreyBlue", GreyBlueGradiant);
    }
    private void Black(){
        String[] Hex = {"&x&2&1&2&1&2&1","&x&4&2&4&2&4&2","&x&6&1&6&1&6&1","&x&7&5&7&5&7&5","&x&9&E&9&E&9&E","&x&B&D&B&D&B&D","&x&E&0&E&0&E&0","&x&E&E&E&E&E&E","&x&F&5&F&5&F&5"
                ,"&x&F&A&F&A&F&A"};
        List<String> BlackGradiant = Arrays.asList(Hex);
        GradientMap.put("Black", BlackGradiant);
    }
    private void Brown(){
        String[] Hex = {"&x&3&E&2&7&2&3","&x&4&E&3&4&2&E","&x&5&D&4&0&3&7","&x&6&D&4&C&4&1","&x&7&9&5&5&4&8","&x&8&D&6&E&6&3","&x&A&1&8&8&7&F","&x&B&C&A&A&A&4",
                "&x&D&7&C&C&C&8","&x&E&F&E&B&E&9"};
        List<String> BrownGradiant = Arrays.asList(Hex);
        GradientMap.put("Brown", BrownGradiant);
    }
    private void OrangeRed(){
        String[] Hex = {"&x&B&F&3&6&0&C","&x&D&8&4&3&1&5","&x&E&6&4&A&1&9","&x&F&4&5&1&1&E","&x&F&F&5&7&2&2","&x&F&F&7&0&4&3","&x&F&F&8&A&6&5","&x&F&F&A&B&9&1","&x&F&F&C&C&B&C",
                "&x&F&B&E&9&E&7"};
        List<String> BrownGradiant = Arrays.asList(Hex);
        GradientMap.put("OrangeRed", BrownGradiant);
    }
    private void OrangeYellow(){
        String[] Hex = {"&x&E&6&5&1&0&0","&x&E&F&6&C&0&0","&x&F&5&7&C&0&0","&x&F&B&8&C&0&0","&x&F&F&9&8&0&0","&x&F&F&A&7&2&6","&x&F&F&B&7&4&D","&x&F&F&C&C&8&0","&x&F&F&E&0&B&2",
                "&x&F&F&F&3&E&0"};
        List<String> OrangeYellow = Arrays.asList(Hex);
        GradientMap.put("OrangeYellow", OrangeYellow);
    }
    private void Sunset(){
        String[] Hex = {"&x&F&F&6&F&0&0","&x&F&F&8&F&0&0","&x&F&F&A&0&0&0","&x&F&F&B&3&0&0","&x&F&F&C&1&0&7","&x&F&F&C&A&2&8","&x&F&F&D&5&4&F","&x&F&F&E&0&8&2","&x&F&F&E&C&B&3",
                "&x&F&F&F&8&E&1"};
        List<String> SunSet = Arrays.asList(Hex);
        GradientMap.put("SunSet", SunSet);
    }
    private void YellowOrange(){
        String[] Hex = {"&x&F&5&7&F&1&7","&x&F&9&A&8&2&5","&x&F&B&C&0&2&D","&x&F&D&D&8&3&5","&x&F&F&E&B&3&B","&x&F&F&E&E&5&8","&x&F&F&F&1&7&6","&x&F&F&F&5&9&D","&x&F&F&F&9&C&4",
                "&x&F&F&F&D&E&7"};
        List<String> YellowOrange = Arrays.asList(Hex);
        GradientMap.put("YellowOrange", YellowOrange);
    }
    private void Grass(){
        String[] Hex = {"&x&8&2&7&7&1&7","&x&9&E&9&D&2&4","&x&A&F&B&4&2&B","&x&C&0&C&A&3&3","&x&C&D&D&C&3&9","&x&D&4&E&1&5&7","&x&D&C&E&7&7&5","&x&E&6&E&E&9&C","&x&F&0&F&4&C&3",
                "&x&F&9&F&B&E&7"};
        List<String> Grass = Arrays.asList(Hex);
        GradientMap.put("Grass", Grass);
    }
    private void LightGreen(){
        String[] Hex = {"&x&3&3&6&9&1&E","&x&5&5&8&B&2&F","&x&6&8&9&F&3&8","&x&7&C&B&3&4&2","&x&8&B&C&3&4&A","&x&9&C&C&C&6&5","&x&A&E&D&5&8&1",
                "&x&C&5&E&1&A&5","&x&D&C&E&D&C&8","&x&F&1&F&8&E&9"};
        List<String> LightGreen = Arrays.asList(Hex);
        GradientMap.put("LightGreen", LightGreen);
    }
    private void Green(){
        String[] Hex = {"&x&1&B&5&E&2&0","&x&2&E&7&D&3&2","&x&3&8&8&E&3&C","&x&4&3&A&0&4&7","&x&4&C&A&F&5&0","&x&6&6&B&B&6&A","&x&8&1&C&7&8&4","&x&A&5&D&6&A&7","&x&C&8&E&6&C&9",
                "&x&E&8&F&5&E&9"};
        List<String> Green = Arrays.asList(Hex);
        GradientMap.put("Green", Green);
    }
    private void GreenBlue(){
        String[] Hex = {"&x&0&0&4&D&4&0","&x&0&0&6&9&5&C","&x&0&0&7&9&6&B","&x&0&0&8&9&7&B","&x&0&0&9&6&8&8","&x&2&6&A&6&9&A","&x&4&D&B&6&A&C",
                "&x&8&0&C&B&C&4","&x&B&2&D&F&D&B","&x&E&0&F&2&F&1"};
        List<String> GreenBlue = Arrays.asList(Hex);
        GradientMap.put("GreenBlue", GreenBlue);
    }
    private void BlueGreen(){
        String[] Hex = {"&x&0&0&6&0&6&4","&x&0&0&8&3&8&F","&x&0&0&9&7&A&7","&x&0&0&A&C&C&1","&x&0&0&B&C&D&4","&x&2&6&C&6&D&A","&x&4&D&D&0&E&1","&x&8&0&D&E&E&A",
                "&x&B&2&E&B&F&2","&x&E&0&F&7&F&A"};
        List<String> BlueGreen = Arrays.asList(Hex);
        GradientMap.put("BlueGreen", BlueGreen);
    }
    private void LightBlue(){
        String[] Hex = {"&x&0&1&5&7&9&B","&x&0&2&7&7&B&D","&x&0&2&8&8&D&1","&x&0&3&9&B&E&5","&x&0&3&A&9&F&4","&x&2&9&B&6&F&6","&x&4&F&C&3&F&7","&x&8&1&D&4&F&A",
                "&x&B&3&E&5&F&C","&x&E&1&F&5&F&E"};
        List<String> LightBlue = Arrays.asList(Hex);
        GradientMap.put("LightBlue", LightBlue);
    }
    private void Blue(){
        String[] Hex = {"&x&0&D&4&7&A&1","&x&1&5&6&5&C&0","&x&1&9&7&6&D&2","&x&1&E&8&8&E&5","&x&2&1&9&6&F&3","&x&4&2&A&5&F&5","&x&6&4&B&5&F&6","&x&9&0&C&A&F&9",
                "&x&B&B&D&E&F&B","&x&E&3&F&2&F&D"};
        List<String> Blue = Arrays.asList(Hex);
        GradientMap.put("Blue", Blue);
    }
    private void BluePurple(){
        String[] Hex = {"&x&1&A&2&3&7&E","&x&2&8&3&5&9&3","&x&3&0&3&F&9&F","&x&3&9&4&9&A&B","&x&3&F&5&1&B&5","&x&5&C&6&B&C&0","&x&7&9&8&6&C&B","&x&9&F&A&8&D&A","&x&C&5&C&A&E&9",
                "&x&E&8&E&A&F&6"};
        List<String> BluePurple = Arrays.asList(Hex);
        GradientMap.put("BluePurple", BluePurple);
    }
    private void Purple(){
        String[] Hex = {"&x&3&1&1&B&9&2","&x&4&5&2&7&A&0","&x&5&1&2&D&A&8","&x&5&E&3&5&B&1","&x&6&7&3&A&B&7","&x&7&E&5&7&C&2","&x&9&5&7&5&C&D","&x&B&3&9&D&D&B","&x&D&1&C&4&E&9",
                "&x&E&D&E&7&F&6"};
        List<String> Purple = Arrays.asList(Hex);
        GradientMap.put("Purple", Purple);
    }
    private void LightPurple(){
        String[] Hex = {"&x&4&A&1&4&8&C","&x&6&A&1&B&9&A","&x&7&B&1&F&A&2","&x&8&E&2&4&A&A","&x&9&C&2&7&B&0","&x&A&B&4&7&B&C","&x&B&A&6&8&C&8","&x&C&E&9&3&D&8",
                "&x&E&1&B&E&E&7","&x&F&3&E&5&F&5"};
        List<String> lightPurple = Arrays.asList(Hex);
        GradientMap.put("LightPurple", lightPurple);
    }
    private void Pink(){
        String[] Hex = {"&x&8&8&0&E&4&F","&x&A&D&1&4&5&7","&x&C&2&1&8&5&B","&x&D&8&1&B&6&0","&x&E&9&1&E&6&3","&x&E&C&4&0&7&A","&x&F&0&6&2&9&2","&x&F&4&8&F&B&1","&x&F&8&B&B&D&0",
                "&x&F&C&E&4&E&C"};
        List<String> Pink = Arrays.asList(Hex);
        GradientMap.put("Pink", Pink);
    }
    private void Red(){
        String[] Hex = {"&x&B&7&1&C&1&C","&x&C&6&2&8&2&8","&x&D&3&2&F&2&F","&x&E&5&3&9&3&5","&x&F&4&4&3&3&6","&x&E&F&5&3&5&0","&x&E&5&7&3&7&3","&x&E&F&9&A&9&A","&x&F&F&C&D&D&2",
                "&x&F&F&E&B&E&E"};
        List<String> Red = Arrays.asList(Hex);
        GradientMap.put("Red", Red);
    }
 */
