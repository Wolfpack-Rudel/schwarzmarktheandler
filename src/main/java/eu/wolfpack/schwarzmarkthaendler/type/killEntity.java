package eu.wolfpack.schwarzmarkthaendler.type;

import eu.wolfpack.schwarzmarkthaendler.Schwarzmarkthaendler;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

public class killEntity {

    public void Handler(Player player, EntityType type){

        if(!Schwarzmarkthaendler.getPlayerQuest().get(player.getUniqueId()).getType().equals("BREAK")) return;
        if(!Schwarzmarkthaendler.getPlayerQuest().get(player.getUniqueId()).getMaterial().equals(type.toString())) return;
        if(!Schwarzmarkthaendler.getPlayerQuest().get(player.getUniqueId()).isEnabled()) return;

        Schwarzmarkthaendler.getPlayerQuest().get(player.getUniqueId()).setMax(
                Schwarzmarkthaendler.getPlayerQuest().get(player.getUniqueId()).getMax() + 1
        );

        if(Schwarzmarkthaendler.getPlayerQuest().get(player.getUniqueId()).getMax() != Schwarzmarkthaendler.getPlayerQuest().get(player.getUniqueId()).getMin()) return;

        player.playSound(player.getLocation(), Sound.UI_TOAST_CHALLENGE_COMPLETE, 0.75F, 1.5F);

        player.sendTitle(
                "Quest Beendet",
                "Du hast erfolgreich deine Quest " + Schwarzmarkthaendler.getPlayerQuest().get(player.getUniqueId()).getQuestName() + " beendet.",
                1,
                100,
                60);

        player.sendMessage("BREAK");


    }

}
