package eu.wolfpack.schwarzmarkthaendler.Inventory;

import eu.wolfpack.schwarzmarkthaendler.utils.ItemBuilder;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import static org.bukkit.Bukkit.createInventory;

public class choseQuestOreShop {

    public void openInv(Player player){
        
        Inventory inv = createInventory(null, 9, "Schwarzmarkthandler");

        inv.setItem(2, new ItemBuilder(Material.DIAMOND).setDisplayname("Quest").build());
        inv.setItem(6, new ItemBuilder(Material.EMERALD).setDisplayname("Shop").build());

        player.openInventory(inv);

    }

}
