package eu.wolfpack.schwarzmarkthaendler.listener;

import eu.wolfpack.schwarzmarkthaendler.Schwarzmarkthaendler;
import eu.wolfpack.schwarzmarkthaendler.utils.ItemBuilder;
import eu.wolfpack.schwarzmarkthaendler.utils.PlayQuests;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;

import java.util.Map;

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
                Inventory inv = ChoseQuestOreShop.getInv();
                for (int i = 0; i < ChoseQuestOreShop.getSize()-1; i++) {
                    inv.setItem(i, PLACEHOLDER.getItem());
                }

                PlayQuests playQuest = Schwarzmarkthaendler.getPlayQuestsMap().get(event.getWhoClicked().getUniqueId());

                ItemBuilder itemq1 = new ItemBuilder(Material.valueOf(playQuest.getPq1().getMaterial()));
                ItemBuilder itemq2 = new ItemBuilder(Material.valueOf(playQuest.getPq2().getMaterial()));
                ItemBuilder itemq3 = new ItemBuilder(Material.valueOf(playQuest.getPq3().getMaterial()));

                if(playQuest.getPq1().isEnabled()){
                    //itemq1.addEnchantments(Map.of(Enchantment.DURABILITY, 1));
                }

                if(playQuest.getPq2().isEnabled()){
                    //itemq2.addEnchantments(Map.of(Enchantment.DURABILITY, 1));
                }

                if(playQuest.getPq3().isEnabled()){
                    //itemq3.addEnchantments(Map.of(Enchantment.DURABILITY, 1));
                }

                inv.setItem(0, itemq1.build());
                inv.setItem(8, itemq1.build());

                inv.setItem(9, itemq2.build());
                inv.setItem(17, itemq2.build());

                inv.setItem(18, itemq3.build());
                inv.setItem(26, itemq3.build());

                float quest1persentage = (playQuest.getPq1().getMin() * 100) / playQuest.getPq1().getMax();
                float quest2persentage = (playQuest.getPq2().getMin() * 100) / playQuest.getPq2().getMax();
                float quest3persentage = (playQuest.getPq3().getMin() * 100) / playQuest.getPq3().getMax();

                if(20 < quest1persentage){
                    inv.setItem(2, COMPLETE_20.getItem());
                }else{
                    inv.setItem(2, INCOMPLETE_20.getItem());
                }
                if(40 < quest1persentage){
                    inv.setItem(3, COMPLETE_40.getItem());
                }else{
                    inv.setItem(3, INCOMPLETE_40.getItem());
                }
                if(60 < quest1persentage){
                    inv.setItem(4, COMPLETE_60.getItem());
                }else{
                    inv.setItem(4, INCOMPLETE_60.getItem());
                }
                if(80 < quest1persentage){
                    inv.setItem(5, COMPLETE_80.getItem());
                }else{
                    inv.setItem(5, INCOMPLETE_80.getItem());
                }
                if(100 == quest1persentage){
                    inv.setItem(6, COMPLETE_100.getItem());
                }else{
                    inv.setItem(6, INCOMPLETE_100.getItem());
                }

                if(20 < quest2persentage){
                    inv.setItem(11, COMPLETE_20.getItem());
                }else{
                    inv.setItem(11, INCOMPLETE_20.getItem());
                }
                if(40 < quest2persentage){
                    inv.setItem(12, COMPLETE_40.getItem());
                }else{
                    inv.setItem(12, INCOMPLETE_40.getItem());
                }
                if(60 < quest2persentage){
                    inv.setItem(13, COMPLETE_60.getItem());
                }else{
                    inv.setItem(13, INCOMPLETE_60.getItem());
                }
                if(80 < quest2persentage){
                    inv.setItem(14, COMPLETE_80.getItem());
                }else{
                    inv.setItem(14, INCOMPLETE_80.getItem());
                }
                if(100 == quest2persentage){
                    inv.setItem(15, COMPLETE_100.getItem());
                }else{
                    inv.setItem(15, INCOMPLETE_100.getItem());
                }

                if(20 < quest3persentage){
                    inv.setItem(20, COMPLETE_20.getItem());
                }else{
                    inv.setItem(20, INCOMPLETE_20.getItem());
                }
                if(40 < quest3persentage){
                    inv.setItem(21, COMPLETE_40.getItem());
                }else{
                    inv.setItem(21, INCOMPLETE_40.getItem());
                }
                if(60 < quest3persentage){
                    inv.setItem(22, COMPLETE_60.getItem());
                }else{
                    inv.setItem(22, INCOMPLETE_60.getItem());
                }
                if(80 < quest3persentage){
                    inv.setItem(23, COMPLETE_80.getItem());
                }else{
                    inv.setItem(23, INCOMPLETE_80.getItem());
                }
                if(100 == quest3persentage){
                    inv.setItem(24, COMPLETE_100.getItem());
                }else{
                    inv.setItem(24, INCOMPLETE_100.getItem());
                }

                event.getWhoClicked().openInventory(inv);
            } else if (event.getCurrentItem().equals(BACK.getItem())) {
                event.setCancelled(true);
                event.getInventory().close();
            }else{
                event.setCancelled(true);
            }

        }

    }
}
