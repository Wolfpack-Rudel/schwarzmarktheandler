package eu.wolfpack.schwarzmarkthaendler.listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import static eu.wolfpack.schwarzmarkthaendler.Enums.Inventorys.*;
import static eu.wolfpack.schwarzmarkthaendler.Enums.Items.*;

public class inventoryInteract implements Listener {

    @EventHandler(ignoreCancelled = true)
    public void onInventoryInteract(InventoryClickEvent event) {

        if((event.getInventory().getSize() == ChoseQuestOreShop.getSize()) && (event.getView().getTitle().equals(ChoseQuestOreShop.getTitle()))){

            if(event.getCurrentItem() == null) return;

            if(event.getCurrentItem().equals(SHOP.getItem())){
                event.setCancelled(true);
                event.getWhoClicked().openInventory(ShopMenu.getInv());
            } else if (event.getCurrentItem().equals(QUEST.getItem())) {
                event.setCancelled(true);
                event.getWhoClicked().openInventory(QuestMenu.getInv());
            } else if (event.getCurrentItem().equals(BACK.getItem())) {
                event.setCancelled(true);
                event.getInventory().close();
            }else{
                event.setCancelled(true);
            }

        }

    }
}
