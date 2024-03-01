package eu.wolfpack.schwarzmarkthaendler.commands;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.*;
import co.aikar.commands.bukkit.contexts.OnlinePlayer;
import eu.wolfpack.schwarzmarkthaendler.Schwarzmarkthaendler;
import org.bukkit.entity.Player;

@CommandAlias("gqi|getQuestInfo")
@Description("Lasse dir die Info zu einer Quest anzeigen")
@CommandPermission("schwarzmarkthaendler.qi")
public class getQuestInfo extends BaseCommand {

    @Subcommand("config|c")
    @CommandCompletion("@questslist")
    public void onQL(Player player, String quest){
        if(Schwarzmarkthaendler.getInstance().getConfig().getConfigurationSection("quests").getKeys(false).contains(quest)){
            player.sendMessage("Erfolgreich: " + Schwarzmarkthaendler.getInstance().getConfig().getConfigurationSection("quests." + quest).getKeys(false).toString());
            player.sendMessage("Name: " + Schwarzmarkthaendler.getInstance().getConfig().get("quests." + quest + ".name"));
            player.sendMessage("Description: " + Schwarzmarkthaendler.getInstance().getConfig().get("quests." + quest + ".description"));
            player.sendMessage("Type: " + Schwarzmarkthaendler.getInstance().getConfig().get("quests." + quest + ".type"));
            player.sendMessage("Min: " + Schwarzmarkthaendler.getInstance().getConfig().get("quests." + quest + ".min"));
            player.sendMessage("Points: " + Schwarzmarkthaendler.getInstance().getConfig().get("quests." + quest + ".points"));
            player.sendMessage("Material: " + Schwarzmarkthaendler.getInstance().getConfig().get("quests." + quest + ".material"));

            return;
        }
        player.sendMessage("FEHLER!");
    }

    @Subcommand("plugin|p")
    public void onQLP(Player player, OnlinePlayer target){
        player.sendMessage("Name: " + Schwarzmarkthaendler.getPlayerQuest().get(target.player.getUniqueId()).getQuestName());
        player.sendMessage("Type: " + Schwarzmarkthaendler.getPlayerQuest().get(target.player.getUniqueId()).getType());
        player.sendMessage("Min: " + Schwarzmarkthaendler.getPlayerQuest().get(target.player.getUniqueId()).getMin());
        player.sendMessage("Points: " + Schwarzmarkthaendler.getPlayerQuest().get(target.player.getUniqueId()).getPoints());
        player.sendMessage("Material: " + Schwarzmarkthaendler.getPlayerQuest().get(target.player.getUniqueId()).getMaterial());
        player.sendMessage("Bereits Abgebaut: " + Schwarzmarkthaendler.getPlayerQuest().get(target.player.getUniqueId()).getMax());

    }

}
