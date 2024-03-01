package eu.wolfpack.schwarzmarkthaendler.listener;

import org.bukkit.Bukkit;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;

public class onVillagerTrade implements Listener {

    @EventHandler(ignoreCancelled = true)
    public void onPlayerInteractEntity(PlayerInteractEntityEvent event) {

        if(!event.getRightClicked().getType().equals(EntityType.VILLAGER)) return;
        if(!event.getRightClicked().getScoreboardTags().contains("customVillager-Schwarzmarkthändler")) return;

        event.getPlayer().sendMessage("Schwarzmarkthändler - Interact - ObenInfEvent");

        event.setCancelled(true);

    }
}
