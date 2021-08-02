package de.maifii.buildffa.listeners;

import de.maifii.buildffa.BuildFFA;
import de.maifii.buildffa.utils.InventoryUtils;
import de.maifii.buildffa.utils.LocationUtils;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoinListener implements Listener {

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player spieler = event.getPlayer();
        LocationUtils locations = new LocationUtils();
        InventoryUtils invs = new InventoryUtils();
        locations.teleport("Spawn", spieler);
        spieler.setMaxHealth(20.0);
        spieler.setHealth(20.0);
        invs.setInventory(spieler);
        invs.setEquipment(spieler);
        event.setJoinMessage(BuildFFA.Prefix + "Der Spieler §9" + spieler.getName() + " §7hat das Spiel betreten.");
    }
}
