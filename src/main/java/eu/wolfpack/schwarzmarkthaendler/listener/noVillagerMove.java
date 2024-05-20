package eu.wolfpack.schwarzmarkthaendler.listener;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Villager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerFishEvent;
import org.bukkit.event.vehicle.VehicleEnterEvent;

public class noVillagerMove implements Listener {


    //NoFishing
    @EventHandler(ignoreCancelled = true)
    public void onPlayerFish(PlayerFishEvent event) {

        Player player = event.getPlayer();
        if(!(event.getCaught() instanceof Villager)) return;
        if(!event.getCaught().getName().equals("Schwarzmarkthändler")) return;

        event.setCancelled(true);

    }

    //NoSittingInVehicle


    @EventHandler(ignoreCancelled = true)
    public void onVehicleEnter(VehicleEnterEvent event) {
        Entity villager = event.getEntered();
        if(!(villager instanceof Villager) && !villager.getName().equals("Schwarzmarkthändler")) return;

        event.setCancelled(true);

    }
}
