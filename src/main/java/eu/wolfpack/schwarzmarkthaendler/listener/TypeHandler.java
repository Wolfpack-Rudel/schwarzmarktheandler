package eu.wolfpack.schwarzmarkthaendler.listener;

import eu.wolfpack.schwarzmarkthaendler.Schwarzmarkthaendler;
import eu.wolfpack.schwarzmarkthaendler.type.*;
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

        Map<UUID, PlayerQuest> playerQuest;
        playerQuest = Schwarzmarkthaendler.getPlayerQuest();

        if(!(playerQuest.containsKey(event.getPlayer().getUniqueId()))){

            playerQuest.put(
                    event.getPlayer().getUniqueId(),
                    new PlayerQuest(
                            "q1",
                            "BREAK",
                            10,
                            25,
                            "DIRT",
                            0,
                            true
                    )
            );

            Schwarzmarkthaendler.setPlayerQuest(playerQuest);
        }

    }

    @EventHandler(ignoreCancelled = true)
    public void onBlockBreak(BlockBreakEvent event) {

        new breakBlock().Handler(event.getPlayer(), event.getBlock().getType());

    }

    @EventHandler(ignoreCancelled = true)
    public void onBlockPlace(BlockPlaceEvent event) {

        new buildBlock().Handler(event.getPlayer(), event.getBlock().getType());

    }

    @EventHandler(ignoreCancelled = true)
    public void onCraftItem(CraftItemEvent event) {

        new craftItem().Handler((Player) event.getView().getPlayer(), event.getRecipe().getResult().getType());

    }

    @EventHandler(ignoreCancelled = true)
    public void onEntityDeath(EntityDeathEvent event) {

        if(event.getEntity().getKiller() == null) return;
        new killEntity().Handler(event.getEntity().getKiller(), event.getEntityType());

    }

    @EventHandler(ignoreCancelled = true)
    public void onPlayerInteract(PlayerInteractEvent event) {

        new useItem().Handler(event.getPlayer(), event.getMaterial());

    }

    @EventHandler(ignoreCancelled = true)
    public void onPlayerItemConsume(PlayerItemConsumeEvent event) {

        new consumeItem().Handler(event.getPlayer(), event.getItem().getType());

    }
}
