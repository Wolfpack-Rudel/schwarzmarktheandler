package eu.wolfpack.schwarzmarkthaendler.listener;

import eu.wolfpack.schwarzmarkthaendler.Schwarzmarkthaendler;
import eu.wolfpack.schwarzmarkthaendler.type.*;
import eu.wolfpack.schwarzmarkthaendler.utils.PlayQuests;
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

    //Temporäres Quest Adden - muss entfernt werden nach Dev Arbeiten

    @EventHandler(ignoreCancelled = true)
    public void onPlayerJoin(PlayerJoinEvent event) {

        Map<UUID, PlayQuests> playQuest;
        playQuest = Schwarzmarkthaendler.getPlayQuestsMap();

        if(!(playQuest.containsKey(event.getPlayer().getUniqueId()))){

            playQuest.put(event.getPlayer().getUniqueId(), playQuest.get(UUID.nameUUIDFromBytes("MASTER".getBytes())));

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
