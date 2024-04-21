package eu.wolfpack.schwarzmarkthaendler.commands;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.*;
import co.aikar.commands.bukkit.contexts.OnlinePlayer;
import eu.wolfpack.schwarzmarkthaendler.Schwarzmarkthaendler;
import org.bukkit.entity.Player;

import java.util.Map;
import java.util.UUID;

@CommandAlias("mpp|managePlayerPoints")
@Description("Verwalte die Punkte eines Nutzers")
@CommandPermission("schwarzmarkthaendler.mpp")
public class managePlayerPoints extends BaseCommand {

    @Subcommand("add|a")
    public void mMPa(Player player, OnlinePlayer target, Integer p){

        Map<UUID, Integer> playerPoints;

        playerPoints = Schwarzmarkthaendler.getPlayerPoints();

        if(playerPoints.containsKey(target.player.getUniqueId())){
            playerPoints.replace(target.player.getUniqueId(), playerPoints.get(target.player.getUniqueId()) + p);
        }else{
            playerPoints.put(target.player.getUniqueId(), p);
        }

        Schwarzmarkthaendler.setPlayerPoints(
                playerPoints
        );
        player.sendMessage("DONE!");

    }

    @Subcommand("set|s")
    public void mMPs(Player player, OnlinePlayer target, Integer p){
        Map<UUID, Integer> playerPoints;

        playerPoints = Schwarzmarkthaendler.getPlayerPoints();

        if(playerPoints.containsKey(target.player.getUniqueId())){
            playerPoints.replace(target.player.getUniqueId(), p);
        }else{
            playerPoints.put(target.player.getUniqueId(), p);
        }

        Schwarzmarkthaendler.setPlayerPoints(
                playerPoints
        );
        player.sendMessage("DONE!");
    }

    @Subcommand("remove|r")
    public void mMPr(Player player, OnlinePlayer target, Integer p){
        Map<UUID, Integer> playerPoints;

        playerPoints = Schwarzmarkthaendler.getPlayerPoints();

        if(playerPoints.containsKey(target.player.getUniqueId())){
            playerPoints.replace(target.player.getUniqueId(), playerPoints.get(target.player.getUniqueId()) - p);
        }else{
            player.sendMessage("Spieler hat keine Punkte!");
            return;
        }

        Schwarzmarkthaendler.setPlayerPoints(
                playerPoints
        );
        player.sendMessage("DONE!");
    }

    @Subcommand("get|g")
    public void mMPr(Player player, OnlinePlayer target){

        Map<UUID, Integer> playerPoints;

        playerPoints = Schwarzmarkthaendler.getPlayerPoints();

        if(!playerPoints.containsKey(target.player.getUniqueId())) {
            player.sendMessage("Spieler hat keine Punkte!");
            return;
        }

        player.sendMessage("Punkte: " + playerPoints.get(target.player.getUniqueId()).toString());

    }

}
