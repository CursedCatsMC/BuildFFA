package de.maifii.buildffa.commands;

import de.maifii.buildffa.BuildFFA;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class BuildCommand implements CommandExecutor {


    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        Player spieler = (Player) sender;
        if(sender instanceof Player) {
            if(spieler.hasPermission("cursedcats.admin")) {
                if(args.length == 0){
                    if(BuildFFA.getBuildMode().contains(spieler)) {
                        spieler.sendMessage(BuildFFA.Prefix + BuildFFA.buildOff);
                        BuildFFA.getBuildMode().remove(spieler);
                    }
                    else {
                        spieler.sendMessage(BuildFFA.Prefix + BuildFFA.buildOn);
                        BuildFFA.getBuildMode().add(spieler);
                    }
                }
                else
                    spieler.sendMessage(BuildFFA.Prefix + BuildFFA.falscheEingabe + "build");
            }
            else
                spieler.sendMessage(BuildFFA.Prefix + BuildFFA.noPermission);
        }
        return false;
    }
}
