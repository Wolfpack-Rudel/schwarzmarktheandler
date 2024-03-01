package eu.wolfpack.schwarzmarkthaendler.commands;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.*;
import eu.wolfpack.schwarzmarkthaendler.Schwarzmarkthaendler;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import static eu.wolfpack.schwarzmarkthaendler.villager.customVillager.SCHWARZMARKTHANDLER;

@CommandAlias("tphtp|teleporthandler")
@Description("Teleportiere den Handler zu einer Ausgewählten Position aus der Config")
@CommandPermission("schwarzmarkthaendler.tp")
public class tpHandlerToPosition extends BaseCommand {

    @Default
    @CommandCompletion("@tppoints")
    public void onTphtp(Player player, String pos){
        if(Schwarzmarkthaendler.getInstance().getConfig().getConfigurationSection("locations").getKeys(false).contains(pos)){
            player.sendMessage("Erfolgreich");
            SCHWARZMARKTHANDLER.tp(
                    Bukkit.getWorld(Schwarzmarkthaendler.getInstance().getConfig().getString("locations." + pos + ".world")),
                    Schwarzmarkthaendler.getInstance().getConfig().getDouble("locations." + pos + ".x"),
                    Schwarzmarkthaendler.getInstance().getConfig().getDouble("locations." + pos + ".y"),
                    Schwarzmarkthaendler.getInstance().getConfig().getDouble("locations." + pos + ".z"),
                    (float) Schwarzmarkthaendler.getInstance().getConfig().getDouble("locations." + pos + ".yaw"),
                    (float) Schwarzmarkthaendler.getInstance().getConfig().getDouble("locations." + pos + ".pitch")
            );
            return;
        }
        player.sendMessage("FEHLER!");
    }

}
