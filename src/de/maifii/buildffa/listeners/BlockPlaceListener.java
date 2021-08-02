package de.maifii.buildffa.listeners;

import de.maifii.buildffa.BuildFFA;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

public class BlockPlaceListener implements Listener {

    @EventHandler
    public void onBlockPlace(BlockPlaceEvent event) {
        Player spieler = event.getPlayer();
        //LOCATION FÜR PLAZIERTEN BLOCK ERSTELLEN
        Location location = event.getBlockPlaced().getLocation();
        //WENN SPIELER NICHT IN BUILDMODE IST
        if(!BuildFFA.getBuildMode().contains(spieler)) {
            //WENN DIE BLOCK LOCATION GRÖßER ODER GLEICH IST WIE SPAWNHEIGHT
            if(location.getY() >= BuildFFA.getInstance().getLocation().getDouble("Spawnheight.Y")) {
                event.setCancelled(true);
                //WENN SPIELER BEDINGUNG ERFÜLLT
            } else {
                if(event.getBlock().getType() == Material.SANDSTONE) {
                    Bukkit.getScheduler().scheduleSyncRepeatingTask(BuildFFA.getInstance(), new Runnable() {
                        int blocktime = 4;

                        @Override
                        public void run() {
                            if(blocktime == 3) {
                                location.getBlock().setType(Material.RED_SANDSTONE);
                            }
                            if(blocktime == 2) {
                                location.getBlock().setType(Material.REDSTONE_BLOCK);
                            }
                            if(blocktime == 0) {
                                location.getBlock().setType(Material.AIR);
                            }
                            --blocktime;
                        }
                    }, 0L, 45L);
                }
                if(event.getBlock().getType() == Material.LADDER) {
                    Bukkit.getScheduler().scheduleSyncRepeatingTask(BuildFFA.getInstance(), new Runnable() {
                        int blocktime = 4;

                        @Override
                        public void run() {
                            if(blocktime == 0) {
                                location.getBlock().setType(Material.AIR);
                            }
                            --blocktime;
                        }
                    },0L, 40L);
                }
            }
        }
    }
}
