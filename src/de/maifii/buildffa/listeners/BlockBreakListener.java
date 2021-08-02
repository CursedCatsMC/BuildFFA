package de.maifii.buildffa.listeners;

import de.maifii.buildffa.BuildFFA;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class BlockBreakListener implements Listener {

    @EventHandler
    public void onBlockBreak(BlockBreakEvent event) {
        Player spieler = event.getPlayer();
        if(!BuildFFA.getBuildMode().contains(spieler))
        event.setCancelled(true);
    }
}
