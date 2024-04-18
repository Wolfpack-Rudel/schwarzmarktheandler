package eu.wolfpack.schwarzmarkthaendler.Enums;

import eu.wolfpack.schwarzmarkthaendler.utils.ItemBuilder;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import static org.bukkit.Material.*;

public enum Items {
    PLACEHOLDER(GRAY_STAINED_GLASS_PANE,  ChatColor.translateAlternateColorCodes('&', "&l "), 10100, " ", " "),
    SHOP(ORANGE_CONCRETE, ChatColor.translateAlternateColorCodes('&', "&b&lShop"), 10101),
    QUEST(YELLOW_CONCRETE, ChatColor.translateAlternateColorCodes('&', "&b&lQuests"), 10102),
    BACK(PAPER, ChatColor.translateAlternateColorCodes('&', "&c&lZurück"), 10003);


    private Material material;
    private String name;
    private String[] lore;
    private int identifyer;

    Items(Material material, String name, int identifyer, String... lore) {
        this.material = material;
        this.name = name;
        this.lore = lore;
        this.identifyer = identifyer;
    }

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String[] getLore() {
        return lore;
    }

    public void setLore(String[] lore) {
        this.lore = lore;
    }

    public int getIdentifyer() {
        return identifyer;
    }

    public void setIdentifyer(int identifyer) {
        this.identifyer = identifyer;
    }

    public ItemStack getItem(){
        return new ItemBuilder(this.material).setDisplayname(this.name).setLore(this.lore).setCustomModelData(this.identifyer).build();
    }

    public ItemBuilder getItemBuilder(){
        return new ItemBuilder(this.material).setDisplayname(this.name).setLore(this.lore).setCustomModelData(this.identifyer);
    }
}
