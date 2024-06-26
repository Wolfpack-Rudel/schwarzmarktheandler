package eu.wolfpack.schwarzmarkthaendler.commands;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.*;
import org.bukkit.entity.Player;

import java.util.Objects;

import static eu.wolfpack.schwarzmarkthaendler.Enums.customVillager.SCHWARZMARKTHANDLER;

@CommandAlias("sh|schowhandler")
@Description("Lasse dir die Position des Handlers ausgeben")
@CommandPermission("schwarzmarkthaendler.sh")
public class findVil extends BaseCommand {

    @Default
    public void onSh(Player player){
        if(!SCHWARZMARKTHANDLER.living()){
            player.sendMessage("FEHLER!");
            return;
        }

        player.sendMessage("Position: " + Objects.requireNonNull(SCHWARZMARKTHANDLER.getPos()));

    }

}
