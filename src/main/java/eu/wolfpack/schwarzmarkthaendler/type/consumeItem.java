package eu.wolfpack.schwarzmarkthaendler.type;

import eu.wolfpack.schwarzmarkthaendler.Schwarzmarkthaendler;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;

public class consumeItem {

    public void Handler(Player player, Material material){

        if(Schwarzmarkthaendler.getPlayerQuest().get(player.getUniqueId()) == null) return;
        if(!Schwarzmarkthaendler.getPlayerQuest().get(player.getUniqueId()).getType().equals("CONSUME")) return;
        if(!Schwarzmarkthaendler.getPlayerQuest().get(player.getUniqueId()).getMaterial().equals(material.toString())) return;
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

        Schwarzmarkthaendler.getPlayerPoints().put(
                player.getUniqueId(),
                Schwarzmarkthaendler.getPlayerPoints().get(player.getUniqueId()) +
                        Schwarzmarkthaendler.getPlayerQuest().get(player.getUniqueId()).getPoints());

        Schwarzmarkthaendler.getPlayerQuest().get(player.getUniqueId()).setEnabled(false);

        player.sendMessage("CONSUME");


    }
}
