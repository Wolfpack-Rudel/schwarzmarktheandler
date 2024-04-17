package eu.wolfpack.schwarzmarkthaendler.listener;

import eu.wolfpack.schwarzmarkthaendler.Inventory.choseQuestOreShop;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class onVillagerHit implements Listener {

    @EventHandler(ignoreCancelled = true)
    public void onEntityDamageByEntity(EntityDamageByEntityEvent event) {


        if(!(event.getDamager() instanceof Player)) return;
        if(!event.getEntityType().equals(EntityType.VILLAGER)) return;

        if(!event.getEntity().getScoreboardTags().contains("customVillager-Schwarzmarkthändler")) return;

        event.getDamager().sendMessage("Schwarzmarkthändler - Hit - ObenInfEvent");

        new choseQuestOreShop().openInv((Player) event.getDamager());

        //((Player) event.getDamager()).openInventory();
        event.setCancelled(true);

    }
}
