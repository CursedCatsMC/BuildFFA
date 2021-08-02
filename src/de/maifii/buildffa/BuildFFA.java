package de.maifii.buildffa;

import de.maifii.buildffa.commands.BuildCommand;
import de.maifii.buildffa.commands.SetCommand;
import de.maifii.buildffa.listeners.*;
import de.maifii.buildffa.utils.FileUtils;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

public class BuildFFA extends JavaPlugin {

    private File file = new File("plugins//LobbySystem//locations.yml");
    private YamlConfiguration location = YamlConfiguration.loadConfiguration(this.file);
    private HashMap<Player, Player> lastDamager = new HashMap();

    private static ArrayList<Player> buildMode;

    public static String Prefix;
    public static String noPermission;
    public static String buildOn;
    public static String buildOff;
    public static String falscheEingabe;
    public static String locationSet;

    private static BuildFFA instance;


    @Override
    public void onEnable() {
        instance = this;
        buildMode = new ArrayList<Player>();

        FileUtils.setStandardConfig();
        FileUtils.readConfig();

        this.register();
        this.loadConfig();
    }

    private void register() {
        PluginManager pluginManager = Bukkit.getPluginManager();
        pluginManager.registerEvents(new BlockBreakListener(), this);
        pluginManager.registerEvents(new BlockPlaceListener(), this);
        pluginManager.registerEvents(new FoodLevelChangeListener(), this);
        pluginManager.registerEvents(new WeatherChanngeListener(), this);
        pluginManager.registerEvents(new EntityDamageListener(), this);
        pluginManager.registerEvents(new EntityDamageByEntityListener(), this);
        pluginManager.registerEvents(new PlayerMoveListener(), this);

        getCommand("build").setExecutor(new BuildCommand());
        getCommand("set").setExecutor(new SetCommand());
    }

    private void loadConfig() {
        this.saveDefaultConfig();
        this.reloadConfig();
    }


    @Override
    public void onDisable() {

    }




    //getters
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

    public static ArrayList<Player> getBuildMode() {
        return buildMode;
    }

    public HashMap<Player, Player> getLastDamager() {
        return lastDamager;
    }
}
