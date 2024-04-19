package eu.wolfpack.schwarzmarkthaendler.listener;

import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.Inventory;

import static eu.wolfpack.schwarzmarkthaendler.Enums.Inventorys.ChoseQuestOreShop;
import static eu.wolfpack.schwarzmarkthaendler.Enums.Items.*;

public class onVillagerHit implements Listener {

    @EventHandler(ignoreCancelled = true)
    public void onEntityDamageByEntity(EntityDamageByEntityEvent event) {


        if(!(event.getDamager() instanceof Player)) return;
        if(!event.getEntityType().equals(EntityType.VILLAGER)) return;

        if(!event.getEntity().getScoreboardTags().contains("customVillager-Schwarzmarkthändler")) return;

        event.getDamager().sendMessage("Schwarzmarkthändler - Hit - ObenInfEvent");

        Inventory inv = ChoseQuestOreShop.getInv();
        for (int i = 0; i < ChoseQuestOreShop.getSize()-1; i++) {
            inv.setItem(i, PLACEHOLDER.getItem());
        }

        inv.setItem(11, QUEST.getItem());
        inv.setItem(15, SHOP.getItem());
        inv.setItem(26, BACK.getItem());


        ((Player) event.getDamager()).openInventory(inv);
        event.setCancelled(true);

    }
}
