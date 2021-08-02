package de.maifii.buildffa.utils;

import de.maifii.buildffa.BuildFFA;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;

import java.io.IOException;

public class LocationUtils {

    public void teleport(String name, Player spieler) {
        World world = Bukkit.getWorld(BuildFFA.getInstance().getLocation().getString(String.valueOf(name) + ".World"));
        double x = BuildFFA.getInstance().getLocation().getDouble(name + ".X");
        double y = BuildFFA.getInstance().getLocation().getDouble(name + ".Y");
        double z = BuildFFA.getInstance().getLocation().getDouble(name + ".Z");
        float yaw = (float)BuildFFA.getInstance().getLocation().getDouble(name + ".Yaw");
        float pitch = (float)BuildFFA.getInstance().getLocation().getDouble(name + ".Pitch");
        Location location = new Location(world, x, y, z, yaw, pitch);
        spieler.teleport(location);
    }

    //LOCATIONS
    public void setLocationn(String name, Player spieler) {
        BuildFFA.getInstance().getLocation().set(name + ".World", spieler.getWorld().getName());
        BuildFFA.getInstance().getLocation().set(name + ".X", spieler.getLocation().getX());
        BuildFFA.getInstance().getLocation().set(name + ".Y",spieler.getLocation().getY());
        BuildFFA.getInstance().getLocation().set(name + ".Z", spieler.getLocation().getZ());
        BuildFFA.getInstance().getLocation().set(name + ".Yaw", Float.valueOf(spieler.getLocation().getYaw()));
        BuildFFA.getInstance().getLocation().set(name + ".Pitch", Float.valueOf(spieler.getLocation().getPitch()));
        try {
            BuildFFA.getInstance().getLocation().save(BuildFFA.getInstance().getFile());
            spieler.sendMessage(BuildFFA.Prefix + "DU hast die Location §e" + name + " §7gesetzt.");
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    //HÖHEN
    public void setHeight(String name, Player spieler) {
        BuildFFA.getInstance().getLocation().set(name + ".Y", spieler.getLocation().getY());
        try {BuildFFA.getInstance().getLocation().save(BuildFFA.getInstance().getFile());
            spieler.sendMessage(BuildFFA.Prefix + "Du hast die Location §e" +  name + "§7 gesetzt");
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}


