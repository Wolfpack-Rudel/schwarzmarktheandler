package eu.wolfpack.schwarzmarkthaendler.type;

import eu.wolfpack.schwarzmarkthaendler.Schwarzmarkthaendler;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;

public class breakBlock {

    public void Handler(Player player, Material material){

        if(!Schwarzmarkthaendler.getPlayerQuest().get(player.getUniqueId()).getType().equals("BREAK")) return;
        if(!Schwarzmarkthaendler.getPlayerQuest().get(player.getUniqueId()).getMaterial().equals(material.toString())) return;

        Schwarzmarkthaendler.getPlayerQuest().get(player.getUniqueId()).setMax(
                Schwarzmarkthaendler.getPlayerQuest().get(player.getUniqueId()).getMax() + 1
        );

        if(Schwarzmarkthaendler.getPlayerQuest().get(player.getUniqueId()).getMax() != Schwarzmarkthaendler.getPlayerQuest().get(player.getUniqueId()).getMin()) return;

        player.playSound(player.getLocation(), Sound.BLOCK_NOTE_BLOCK_CHIME, 100, 1);



        player.sendMessage("BREAK");


    }

}
