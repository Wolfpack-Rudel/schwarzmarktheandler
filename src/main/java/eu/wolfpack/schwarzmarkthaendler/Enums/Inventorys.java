package eu.wolfpack.schwarzmarkthaendler.Enums;

import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.jetbrains.annotations.NotNull;

import static org.bukkit.Bukkit.createInventory;

public enum Inventorys {

    ChoseQuestOreShop(null, 9, "Chose"),
    QuestMenu(null, 9, "Quest"),
    ShopMenu(null, 9, "Shop");

    private final InventoryHolder owner;
    private final int size;
    private final @NotNull String title;

    Inventorys(InventoryHolder owner, int size, @NotNull String title) {
        this.owner = owner;
        this.size = size;
        this.title = title;
    }

    public InventoryHolder getOwner() {
        return owner;
    }

    public int getSize() {
        return size;
    }

    public String getTitle() {
        return title;
    }

    public Inventory getInv(){
        return createInventory(this.owner, this.size, this.title);
    }
}
