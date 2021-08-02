package de.maifii.buildffa.commands;

import de.maifii.buildffa.BuildFFA;
import de.maifii.buildffa.utils.LocationUtils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SetCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        LocationUtils locations = new LocationUtils();

        Player spieler = (Player) sender;
        if(sender instanceof Player) {
            if(spieler.hasPermission("cursedcats.inhaber")) {
                if(args.length == 1) {
                    if(args[0].equalsIgnoreCase("Spawn")) {
                        locations.setLocationn("Spawn", spieler);
                    }
                    else if(args[0].equalsIgnoreCase("Spawnheight")) {
                        locations.setHeight("Spawnheight", spieler);
                    }
                    else if(args[0].equalsIgnoreCase("Deathheight")) {
                        locations.setHeight("Deathheight", spieler);
                    }
                    else
                        spieler.sendMessage(BuildFFA.Prefix + BuildFFA.falscheEingabe + "set [Spawn, Spawnheight, Deathheigt]");
                }
                else
                    spieler.sendMessage(BuildFFA.Prefix + BuildFFA.falscheEingabe + "set [Spawn, Spawnheight, Deathheigt]");
            }
            else
                spieler.sendMessage(BuildFFA.Prefix + BuildFFA.noPermission);
        }
        return false;
    }
}
