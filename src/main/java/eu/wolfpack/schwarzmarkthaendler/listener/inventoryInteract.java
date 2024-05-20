package eu.wolfpack.schwarzmarkthaendler.listener;

import eu.wolfpack.schwarzmarkthaendler.Schwarzmarkthaendler;
import eu.wolfpack.schwarzmarkthaendler.utils.ItemBuilder;
import eu.wolfpack.schwarzmarkthaendler.utils.PlayQuests;
import eu.wolfpack.schwarzmarkthaendler.utils.PlayerQuest;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;


import java.util.Map;
import java.util.Objects;
import java.util.UUID;

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
                Inventory inv = QuestMenu.getInv();
                for (int i = 0; i < QuestMenu.getSize()-1; i++) {
                    inv.setItem(i, PLACEHOLDER.getItem());
                }

                PlayQuests playQuest = Schwarzmarkthaendler.getPlayQuestsMap().get(event.getWhoClicked().getUniqueId());

                ItemBuilder itemq1;
                ItemBuilder itemq2;
                ItemBuilder itemq3;
                ItemBuilder statusq1;
                ItemBuilder statusq2;
                ItemBuilder statusq3;

                if(playQuest.getPq1().getType().equals("KILL")){
                    itemq1 = new ItemBuilder(Material.valueOf(playQuest.getPq1().getMaterial() + "_SPAWN_EGG"));
                }else{
                    itemq1 = new ItemBuilder(Material.valueOf(playQuest.getPq1().getMaterial()));
                }

                if(playQuest.getPq2().getType().equals("KILL")){
                    itemq2 = new ItemBuilder(Material.valueOf(playQuest.getPq2().getMaterial() + "_SPAWN_EGG"));
                }else{
                    itemq2 = new ItemBuilder(Material.valueOf(playQuest.getPq2().getMaterial()));
                }

                if(playQuest.getPq3().getType().equals("KILL")){
                    itemq3 = new ItemBuilder(Material.valueOf(playQuest.getPq3().getMaterial() + "_SPAWN_EGG"));
                }else{
                    itemq3 = new ItemBuilder(Material.valueOf(playQuest.getPq3().getMaterial()));
                }

                if(playQuest.getPq1().isEnabled()){
                    statusq1 = ENABLED.getItemBuilder();
                }else{
                    statusq1 = DISABLED.getItemBuilder();
                }

                if(playQuest.getPq2().isEnabled()){
                    statusq2 = ENABLED.getItemBuilder();
                }else{
                    statusq2 = DISABLED.getItemBuilder();
                }

                if(playQuest.getPq3().isEnabled()){
                    statusq3 = ENABLED.getItemBuilder();
                }else{
                    statusq3 = DISABLED.getItemBuilder();
                }

                inv.setItem(0, itemq1.build());
                inv.setItem(1, statusq1.build());

                inv.setItem(9, itemq2.build());
                inv.setItem(10, statusq2.build());

                inv.setItem(18, itemq3.build());
                inv.setItem(19, statusq3.build());

                int quest1persentage = playQuest.getPq1().getMax();
                if(playQuest.getPq1().getMax()!=0) quest1persentage = (playQuest.getPq1().getMax() * 100) / playQuest.getPq1().getMin();
                int quest2persentage= playQuest.getPq2().getMax();
                if(playQuest.getPq2().getMax()!=0) quest2persentage = (playQuest.getPq2().getMax() * 100) / playQuest.getPq2().getMin();
                int quest3persentage= playQuest.getPq3().getMax();
                if(playQuest.getPq3().getMax()!=0) quest3persentage = (playQuest.getPq3().getMax() * 100) / playQuest.getPq3().getMin();

                if(20 < quest1persentage){
                    inv.setItem(3, COMPLETE_20.getItem());
                }else{
                    inv.setItem(3, INCOMPLETE_20.getItem());
                }
                if(40 < quest1persentage){
                    inv.setItem(4, COMPLETE_40.getItem());
                }else{
                    inv.setItem(4, INCOMPLETE_40.getItem());
                }
                if(60 < quest1persentage){
                    inv.setItem(5, COMPLETE_60.getItem());
                }else{
                    inv.setItem(5, INCOMPLETE_60.getItem());
                }
                if(80 < quest1persentage){
                    inv.setItem(6, COMPLETE_80.getItem());
                }else{
                    inv.setItem(6, INCOMPLETE_80.getItem());
                }
                if(100 == quest1persentage){
                    inv.setItem(7, COMPLETE_100.getItem());
                }else{
                    inv.setItem(7, INCOMPLETE_100.getItem());
                }

                if(20 < quest2persentage){
                    inv.setItem(12, COMPLETE_20.getItem());
                }else{
                    inv.setItem(12, INCOMPLETE_20.getItem());
                }
                if(40 < quest2persentage){
                    inv.setItem(13, COMPLETE_40.getItem());
                }else{
                    inv.setItem(13, INCOMPLETE_40.getItem());
                }
                if(60 < quest2persentage){
                    inv.setItem(14, COMPLETE_60.getItem());
                }else{
                    inv.setItem(14, INCOMPLETE_60.getItem());
                }
                if(80 < quest2persentage){
                    inv.setItem(15, COMPLETE_80.getItem());
                }else{
                    inv.setItem(15, INCOMPLETE_80.getItem());
                }
                if(100 == quest2persentage){
                    inv.setItem(16, COMPLETE_100.getItem());
                }else{
                    inv.setItem(16, INCOMPLETE_100.getItem());
                }

                if(20 < quest3persentage){
                    inv.setItem(21, COMPLETE_20.getItem());
                }else{
                    inv.setItem(21, INCOMPLETE_20.getItem());
                }
                if(40 < quest3persentage){
                    inv.setItem(22, COMPLETE_40.getItem());
                }else{
                    inv.setItem(22, INCOMPLETE_40.getItem());
                }
                if(60 < quest3persentage){
                    inv.setItem(23, COMPLETE_60.getItem());
                }else{
                    inv.setItem(23, INCOMPLETE_60.getItem());
                }
                if(80 < quest3persentage){
                    inv.setItem(24, COMPLETE_80.getItem());
                }else{
                    inv.setItem(24, INCOMPLETE_80.getItem());
                }
                if(100 == quest3persentage){
                    inv.setItem(25, COMPLETE_100.getItem());
                }else{
                    inv.setItem(25, INCOMPLETE_100.getItem());
                }

                event.getWhoClicked().openInventory(inv);
            } else if (event.getCurrentItem().equals(BACK.getItem())) {
                event.setCancelled(true);
                event.getInventory().close();
            }else{
                event.setCancelled(true);
            }

        }

        if((event.getInventory().getSize() == QuestMenu.getSize()) && (event.getView().getTitle().equals(QuestMenu.getTitle()))){

            event.setCancelled(true);

            if(Objects.equals(event.getCurrentItem(), DISABLED.getItem())){

                if(event.getSlot() == 1){

                    Map<UUID, PlayerQuest> playerQuest = Schwarzmarkthaendler.getPlayerQuest();
                    PlayerQuest quest = playerQuest.get(event.getWhoClicked().getUniqueId());

                    PlayerQuest sq2 = Schwarzmarkthaendler.getPlayQuestsMap().get(UUID.nameUUIDFromBytes("MASTER".getBytes())).getPq2();
                    PlayerQuest sq3 = Schwarzmarkthaendler.getPlayQuestsMap().get(UUID.nameUUIDFromBytes("MASTER".getBytes())).getPq3();
                    PlayerQuest sq1 = Schwarzmarkthaendler.getPlayQuestsMap().get(UUID.nameUUIDFromBytes("MASTER".getBytes())).getPq1();

                    if(quest.getQuestName().equals(sq1.getQuestName())){
                        quest.setEnabled(false);
                        playerQuest.replace(event.getWhoClicked().getUniqueId(), quest);
                        quest = Schwarzmarkthaendler.getPlayQuestsMap().get(event.getWhoClicked().getUniqueId()).getPq1();
                        if(quest.getMin() == quest.getMax()) return;
                        quest.setEnabled(true);

                        playerQuest.replace(event.getWhoClicked().getUniqueId(), quest);
                        Schwarzmarkthaendler.setPlayerQuest(playerQuest);

                        event.getInventory().setItem(1, ENABLED.getItem());

                        return;
                    }

                    if(quest.getQuestName().equals(sq2.getQuestName())){
                        quest.setEnabled(false);
                        playerQuest.replace(event.getWhoClicked().getUniqueId(), quest);
                        quest = Schwarzmarkthaendler.getPlayQuestsMap().get(event.getWhoClicked().getUniqueId()).getPq1();
                        if(quest.getMin() == quest.getMax()) return;
                        quest.setEnabled(true);

                        playerQuest.replace(event.getWhoClicked().getUniqueId(), quest);
                        Schwarzmarkthaendler.setPlayerQuest(playerQuest);

                        event.getInventory().setItem(1, ENABLED.getItem());
                        event.getInventory().setItem(10, DISABLED.getItem());

                        return;
                    }

                    if(quest.getQuestName().equals(sq3.getQuestName())){
                        quest.setEnabled(false);
                        playerQuest.replace(event.getWhoClicked().getUniqueId(), quest);
                        quest = Schwarzmarkthaendler.getPlayQuestsMap().get(event.getWhoClicked().getUniqueId()).getPq1();
                        if(quest.getMin() == quest.getMax()) return;
                        quest.setEnabled(true);

                        playerQuest.replace(event.getWhoClicked().getUniqueId(), quest);
                        Schwarzmarkthaendler.setPlayerQuest(playerQuest);

                        event.getInventory().setItem(1, ENABLED.getItem());
                        event.getInventory().setItem(19, DISABLED.getItem());
                    }
                }

                if(event.getSlot() == 10){

                    Map<UUID, PlayerQuest> playerQuest = Schwarzmarkthaendler.getPlayerQuest();
                    PlayerQuest quest = playerQuest.get(event.getWhoClicked().getUniqueId());

                    PlayerQuest sq1 = Schwarzmarkthaendler.getPlayQuestsMap().get(UUID.nameUUIDFromBytes("MASTER".getBytes())).getPq1();
                    PlayerQuest sq3 = Schwarzmarkthaendler.getPlayQuestsMap().get(UUID.nameUUIDFromBytes("MASTER".getBytes())).getPq3();
                    PlayerQuest sq2 = Schwarzmarkthaendler.getPlayQuestsMap().get(UUID.nameUUIDFromBytes("MASTER".getBytes())).getPq2();

                    if(quest.getQuestName().equals(sq2.getQuestName())){
                        quest.setEnabled(false);
                        playerQuest.replace(event.getWhoClicked().getUniqueId(), quest);
                        quest = Schwarzmarkthaendler.getPlayQuestsMap().get(event.getWhoClicked().getUniqueId()).getPq2();
                        if(quest.getMin() == quest.getMax()) return;
                        quest.setEnabled(true);

                        playerQuest.replace(event.getWhoClicked().getUniqueId(), quest);
                        Schwarzmarkthaendler.setPlayerQuest(playerQuest);

                        event.getInventory().setItem(10, ENABLED.getItem());

                        return;
                    }


                    if(quest.getQuestName().equals(sq1.getQuestName())){
                        quest.setEnabled(false);
                        playerQuest.replace(event.getWhoClicked().getUniqueId(), quest);
                        quest = Schwarzmarkthaendler.getPlayQuestsMap().get(event.getWhoClicked().getUniqueId()).getPq2();
                        if(quest.getMin() == quest.getMax()) return;
                        quest.setEnabled(true);

                        playerQuest.replace(event.getWhoClicked().getUniqueId(), quest);
                        Schwarzmarkthaendler.setPlayerQuest(playerQuest);

                        event.getInventory().setItem(10, ENABLED.getItem());
                        event.getInventory().setItem(1, DISABLED.getItem());

                        return;
                    }

                    if(quest.getQuestName().equals(sq3.getQuestName())){
                        quest.setEnabled(false);
                        playerQuest.replace(event.getWhoClicked().getUniqueId(), quest);
                        quest = Schwarzmarkthaendler.getPlayQuestsMap().get(event.getWhoClicked().getUniqueId()).getPq2();
                        if(quest.getMin() == quest.getMax()) return;
                        quest.setEnabled(true);

                        playerQuest.replace(event.getWhoClicked().getUniqueId(), quest);
                        Schwarzmarkthaendler.setPlayerQuest(playerQuest);

                        event.getInventory().setItem(10, ENABLED.getItem());
                        event.getInventory().setItem(19, DISABLED.getItem());
                    }
                }

                if(event.getSlot() == 19){

                    Map<UUID, PlayerQuest> playerQuest = Schwarzmarkthaendler.getPlayerQuest();
                    PlayerQuest quest = playerQuest.get(event.getWhoClicked().getUniqueId());

                    PlayerQuest sq1 = Schwarzmarkthaendler.getPlayQuestsMap().get(UUID.nameUUIDFromBytes("MASTER".getBytes())).getPq1();
                    PlayerQuest sq2 = Schwarzmarkthaendler.getPlayQuestsMap().get(UUID.nameUUIDFromBytes("MASTER".getBytes())).getPq2();
                    PlayerQuest sq3 = Schwarzmarkthaendler.getPlayQuestsMap().get(UUID.nameUUIDFromBytes("MASTER".getBytes())).getPq3();

                    if(quest.getQuestName().equals(sq3.getQuestName())){
                        quest.setEnabled(false);
                        playerQuest.replace(event.getWhoClicked().getUniqueId(), quest);
                        quest = Schwarzmarkthaendler.getPlayQuestsMap().get(event.getWhoClicked().getUniqueId()).getPq3();
                        if(quest.getMin() == quest.getMax()) return;
                        quest.setEnabled(true);

                        playerQuest.replace(event.getWhoClicked().getUniqueId(), quest);
                        Schwarzmarkthaendler.setPlayerQuest(playerQuest);

                        event.getInventory().setItem(19, ENABLED.getItem());

                        return;
                    }

                    if(quest.getQuestName().equals(sq2.getQuestName())){
                        quest.setEnabled(false);
                        playerQuest.replace(event.getWhoClicked().getUniqueId(), quest);
                        quest = Schwarzmarkthaendler.getPlayQuestsMap().get(event.getWhoClicked().getUniqueId()).getPq3();
                        if(quest.getMin() == quest.getMax()) return;
                        quest.setEnabled(true);

                        playerQuest.replace(event.getWhoClicked().getUniqueId(), quest);
                        Schwarzmarkthaendler.setPlayerQuest(playerQuest);

                        event.getInventory().setItem(19, ENABLED.getItem());
                        event.getInventory().setItem(10, DISABLED.getItem());

                        return;
                    }

                    if(quest.getQuestName().equals(sq1.getQuestName())){
                        quest.setEnabled(false);
                        playerQuest.replace(event.getWhoClicked().getUniqueId(), quest);
                        quest = Schwarzmarkthaendler.getPlayQuestsMap().get(event.getWhoClicked().getUniqueId()).getPq3();
                        if(quest.getMin() == quest.getMax()) return;
                        quest.setEnabled(true);

                        playerQuest.replace(event.getWhoClicked().getUniqueId(), quest);
                        Schwarzmarkthaendler.setPlayerQuest(playerQuest);

                        event.getInventory().setItem(19, ENABLED.getItem());
                        event.getInventory().setItem(1, DISABLED.getItem());
                    }
                }

            }

            if(Objects.equals(event.getCurrentItem(), ENABLED.getItem())){

                Map<UUID, PlayerQuest> playerQuest = Schwarzmarkthaendler.getPlayerQuest();
                PlayerQuest quest = playerQuest.get(event.getWhoClicked().getUniqueId());

                if(event.getSlot() == 1){
                    quest.setEnabled(false);
                    playerQuest.replace(event.getWhoClicked().getUniqueId(), quest);


                    event.getInventory().setItem(1, DISABLED.getItem());
                }

                if(event.getSlot() == 10){
                    quest.setEnabled(false);
                    playerQuest.replace(event.getWhoClicked().getUniqueId(), quest);


                    event.getInventory().setItem(10, DISABLED.getItem());
                }

                if(event.getSlot() == 19){
                    quest.setEnabled(false);
                    playerQuest.replace(event.getWhoClicked().getUniqueId(), quest);


                    event.getInventory().setItem(19, DISABLED.getItem());
                }

                Schwarzmarkthaendler.setPlayerQuest(playerQuest);

            }
        }
    }
}
