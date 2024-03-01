package eu.wolfpack.schwarzmarkthaendler.type;

import eu.wolfpack.schwarzmarkthaendler.Schwarzmarkthaendler;
import org.bukkit.Material;
import org.bukkit.entity.Player;

public class buildBlock {

    public void Handler(Player player, Material material){

        if(!Schwarzmarkthaendler.getPlayerQuest().get(player.getUniqueId()).getType().equals("BUILD")) return;
        if(!Schwarzmarkthaendler.getPlayerQuest().get(player.getUniqueId()).getMaterial().equals(material.toString())) return;

        Schwarzmarkthaendler.getPlayerQuest().get(player.getUniqueId()).setMax(
                Schwarzmarkthaendler.getPlayerQuest().get(player.getUniqueId()).getMax() + 1
        );

        player.sendMessage("BUILD");


    }

}
