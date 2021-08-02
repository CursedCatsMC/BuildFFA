package de.maifii.buildffa.utils;

import de.maifii.buildffa.BuildFFA;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;

public class FileUtils {

    //FILLE ERSTELLEN
    public static File getConfigFille() {
        return new File("plugins/BuildFFA", "config.yml");
    }


    public static FileConfiguration getConfigFileConfiguration() {
        return YamlConfiguration.loadConfiguration(getConfigFille());
    }

    //STANDARD WERTE SETZEN z.B Nachrichten
    public static void setStandardConfig() {
        FileConfiguration cfg = getConfigFileConfiguration();
        cfg.options().copyDefaults(true);
        cfg.addDefault("Prefix", "&8&l»&7» &9BuildFFA &7| ");
        try {
            cfg.save(getConfigFille());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //STANDARD WERTE NUN EINEN STRING ZUWEISEN
    public static void readConfig() {
        FileConfiguration cfg = getConfigFileConfiguration();
        BuildFFA.Prefix = ChatColor.translateAlternateColorCodes('&', cfg.getString("Prefix"));
    }

}