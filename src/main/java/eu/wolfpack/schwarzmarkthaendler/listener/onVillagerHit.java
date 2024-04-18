package eu.wolfpack.schwarzmarkthaendler.listener;

import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

import static eu.wolfpack.schwarzmarkthaendler.Enums.Inventorys.ChoseQuestOreShop;

public class onVillagerHit implements Listener {

    @EventHandler(ignoreCancelled = true)
    public void onEntityDamageByEntity(EntityDamageByEntityEvent event) {


        if(!(event.getDamager() instanceof Player)) return;
        if(!event.getEntityType().equals(EntityType.VILLAGER)) return;

        if(!event.getEntity().getScoreboardTags().contains("customVillager-Schwarzmarkthändler")) return;

        event.getDamager().sendMessage("Schwarzmarkthändler - Hit - ObenInfEvent");

        ((Player) event.getDamager()).openInventory(ChoseQuestOreShop.getInv());
        event.setCancelled(true);

    }
}
