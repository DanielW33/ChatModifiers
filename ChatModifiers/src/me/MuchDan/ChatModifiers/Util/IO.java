package me.MuchDan.ChatModifiers.Util;

import me.MuchDan.ChatModifiers.ChatModifiers;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.logging.Level;

public class IO {
    private ChatModifiers plugin;
    private FileConfiguration dataConfig = null;
    private File configFile = null;
    private String FilePath;

    public IO(ChatModifiers plugin, String FilePath) {
        this.plugin = plugin;
        this.FilePath = FilePath;
        saveDefaultConfig();
    }

    public void reloadConfig() {
        if (this.configFile == null) {
            this.configFile = new File(this.plugin.getDataFolder(), FilePath);
        }
        this.dataConfig = YamlConfiguration.loadConfiguration(this.configFile);

        InputStream defaultStream = this.plugin.getResource(FilePath);
        if (defaultStream != null) {
            YamlConfiguration defaultConfig = YamlConfiguration.loadConfiguration(new InputStreamReader(defaultStream));
            this.dataConfig.setDefaults((defaultConfig));
        }
    }

    public FileConfiguration getConfig() {
        if (this.dataConfig == null) {
            reloadConfig();
        }
        return this.dataConfig;
    }

    public void saveConfig() {
        if (this.dataConfig == null || this.configFile == null) {
            return;
        }
        try {
            this.getConfig().save(this.configFile);
        } catch (IOException e) {
            plugin.getLogger().log(Level.SEVERE, "Failed to save data config.", e);
            e.printStackTrace();
        }
    }

    public void saveDefaultConfig() {
        if (this.configFile == null) {
            this.configFile = new File(this.plugin.getDataFolder(), FilePath);
        }

        if (!this.configFile.exists()) {
            this.plugin.saveResource(FilePath, false);
        }
    }
}