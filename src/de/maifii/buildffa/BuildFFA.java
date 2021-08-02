package de.maifii.buildffa;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

public class BuildFFA extends JavaPlugin {

    private File file = new File("plugins//LobbySystem//locations.yml");
    private YamlConfiguration location = YamlConfiguration.loadConfiguration(this.file);


    public static String Prefix;
    private static BuildFFA instance;


    @Override
    public void onEnable() {
        instance = this;

        this.loadConfig();
    }

    private void loadConfig() {
        this.saveDefaultConfig();
        this.reloadConfig();
    }


    @Override
    public void onDisable() {

    }


    public static BuildFFA getInstance() {
        return instance;
    }

    @Override
    public File getFile() {
        return file;
    }

    public YamlConfiguration getLocation() {
        return location;
    }
}
