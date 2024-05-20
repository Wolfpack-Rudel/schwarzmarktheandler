package eu.wolfpack.schwarzmarkthaendler.commands;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.CommandAlias;
import co.aikar.commands.annotation.CommandPermission;
import co.aikar.commands.annotation.Default;
import co.aikar.commands.annotation.Description;
import co.aikar.commands.bukkit.contexts.OnlinePlayer;
import eu.wolfpack.schwarzmarkthaendler.Schwarzmarkthaendler;
import eu.wolfpack.schwarzmarkthaendler.utils.PlayerQuest;
import org.bukkit.entity.Player;

import java.util.Map;
import java.util.UUID;

@CommandAlias("spq|setPlayerQuest")
@Description("Lege die laufende Quest eines Spielers fest")
@CommandPermission("schwarzmarkthaendler.spq")
public class setPlayerQuest extends BaseCommand {

    @Default
    public void onSh(Player player, OnlinePlayer target, String questName, String type, int min, int points, String material, int max, boolean enabled){


        Map<UUID, PlayerQuest> playerQuest;
        playerQuest = Schwarzmarkthaendler.getPlayerQuest();

            playerQuest.replace(
                    target.getPlayer().getUniqueId(),
                    new PlayerQuest(
                            questName,
                            null,
                            type,
                            min,
                            points,
                            material,
                            max,
                            enabled
                    )
            );

            Schwarzmarkthaendler.setPlayerQuest(playerQuest);

        player.sendMessage("Updated!");

    }

}
