package eu.wolfpack.schwarzmarkthaendler.listener;

import eu.wolfpack.schwarzmarkthaendler.Schwarzmarkthaendler;
import eu.wolfpack.schwarzmarkthaendler.type.*;
import eu.wolfpack.schwarzmarkthaendler.utils.PlayQuests;
import eu.wolfpack.schwarzmarkthaendler.utils.PlayerQuest;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.inventory.CraftItemEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.event.player.PlayerJoinEvent;

import java.util.Map;
import java.util.UUID;

public class TypeHandler implements Listener {

    @EventHandler(ignoreCancelled = true)
    public void onPlayerJoin(PlayerJoinEvent event) {

        Map<UUID, PlayQuests> playQuest;
        playQuest = Schwarzmarkthaendler.getPlayQuestsMap();

        if(!(playQuest.containsKey(event.getPlayer().getUniqueId()))){

            PlayQuests quests = new PlayQuests(null, null, null);
            quests.setPq1(
                    new PlayerQuest(
                            playQuest.get(UUID.nameUUIDFromBytes("MASTER".getBytes())).getPq1().getQuestName(),
                            playQuest.get(UUID.nameUUIDFromBytes("MASTER".getBytes())).getPq1().getDescription(),
                            playQuest.get(UUID.nameUUIDFromBytes("MASTER".getBytes())).getPq1().getType(),
                            playQuest.get(UUID.nameUUIDFromBytes("MASTER".getBytes())).getPq1().getMin(),
                            playQuest.get(UUID.nameUUIDFromBytes("MASTER".getBytes())).getPq1().getPoints(),
                            playQuest.get(UUID.nameUUIDFromBytes("MASTER".getBytes())).getPq1().getMaterial(),
                            playQuest.get(UUID.nameUUIDFromBytes("MASTER".getBytes())).getPq1().getMax(),
                            playQuest.get(UUID.nameUUIDFromBytes("MASTER".getBytes())).getPq1().isEnabled()
                    )
            );
            quests.setPq2(new PlayerQuest(
                    playQuest.get(UUID.nameUUIDFromBytes("MASTER".getBytes())).getPq2().getQuestName(),
                    playQuest.get(UUID.nameUUIDFromBytes("MASTER".getBytes())).getPq2().getDescription(),
                    playQuest.get(UUID.nameUUIDFromBytes("MASTER".getBytes())).getPq2().getType(),
                    playQuest.get(UUID.nameUUIDFromBytes("MASTER".getBytes())).getPq2().getMin(),
                    playQuest.get(UUID.nameUUIDFromBytes("MASTER".getBytes())).getPq2().getPoints(),
                    playQuest.get(UUID.nameUUIDFromBytes("MASTER".getBytes())).getPq2().getMaterial(),
                    playQuest.get(UUID.nameUUIDFromBytes("MASTER".getBytes())).getPq2().getMax(),
                    playQuest.get(UUID.nameUUIDFromBytes("MASTER".getBytes())).getPq2().isEnabled()
            ));
            quests.setPq3(new PlayerQuest(
                    playQuest.get(UUID.nameUUIDFromBytes("MASTER".getBytes())).getPq3().getQuestName(),
                    playQuest.get(UUID.nameUUIDFromBytes("MASTER".getBytes())).getPq3().getDescription(),
                    playQuest.get(UUID.nameUUIDFromBytes("MASTER".getBytes())).getPq3().getType(),
                    playQuest.get(UUID.nameUUIDFromBytes("MASTER".getBytes())).getPq3().getMin(),
                    playQuest.get(UUID.nameUUIDFromBytes("MASTER".getBytes())).getPq3().getPoints(),
                    playQuest.get(UUID.nameUUIDFromBytes("MASTER".getBytes())).getPq3().getMaterial(),
                    playQuest.get(UUID.nameUUIDFromBytes("MASTER".getBytes())).getPq3().getMax(),
                    playQuest.get(UUID.nameUUIDFromBytes("MASTER".getBytes())).getPq3().isEnabled()
            ));

            playQuest.put(event.getPlayer().getUniqueId(), quests);
            Schwarzmarkthaendler.setPlayQuests(playQuest);
        }

    }

    //BREAK Type

    @EventHandler(ignoreCancelled = true)
    public void onBlockBreak(BlockBreakEvent event) {

        new breakBlock().Handler(event.getPlayer(), event.getBlock().getType());

    }

    //BUILD Type

    @EventHandler(ignoreCancelled = true)
    public void onBlockPlace(BlockPlaceEvent event) {

        new buildBlock().Handler(event.getPlayer(), event.getBlock().getType());

    }

    //CRAFT Type

    @EventHandler(ignoreCancelled = true)
    public void onCraftItem(CraftItemEvent event) {

        new craftItem().Handler((Player) event.getView().getPlayer(), event.getRecipe().getResult().getType());

    }

    //KILL TYPE

    @EventHandler(ignoreCancelled = true)
    public void onEntityDeath(EntityDeathEvent event) {

        if(event.getEntity().getKiller() == null) return;
        new killEntity().Handler(event.getEntity().getKiller(), event.getEntityType());

    }

    //USEITEM TYPE

    @EventHandler(ignoreCancelled = true)
    public void onPlayerInteract(PlayerInteractEvent event) {

        new useItem().Handler(event.getPlayer(), event.getMaterial());

    }

    //CONSUME TYPE

    @EventHandler(ignoreCancelled = true)
    public void onPlayerItemConsume(PlayerItemConsumeEvent event) {

        new consumeItem().Handler(event.getPlayer(), event.getItem().getType());

    }
}
