package eu.wolfpack.schwarzmarkthaendler.Enums;

import eu.wolfpack.schwarzmarkthaendler.utils.ItemBuilder;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import static org.bukkit.Material.*;

public enum Items {
    PLACEHOLDER(LIGHT_GRAY_STAINED_GLASS_PANE,  ChatColor.translateAlternateColorCodes('&', "&l "), 10100, " ", " "),
    SHOP(ORANGE_CONCRETE, ChatColor.translateAlternateColorCodes('&', "&b&lShop"), 10101),
    QUEST(YELLOW_CONCRETE, ChatColor.translateAlternateColorCodes('&', "&b&lQuests"), 10102),
    BACK(PAPER, ChatColor.translateAlternateColorCodes('&', "&c&lZurück"), 10003),
    COMPLETE_20(LIME_STAINED_GLASS_PANE, "20%", 10110),
    COMPLETE_40(LIME_STAINED_GLASS_PANE, "40%", 10111),
    COMPLETE_60(LIME_STAINED_GLASS_PANE, "60%", 10112),
    COMPLETE_80(LIME_STAINED_GLASS_PANE, "80%", 10113),
    COMPLETE_100(LIME_STAINED_GLASS_PANE, "100%", 10114),
    INCOMPLETE_20(RED_STAINED_GLASS_PANE, "20%", 10120),
    INCOMPLETE_40(RED_STAINED_GLASS_PANE, "40%", 10121),
    INCOMPLETE_60(RED_STAINED_GLASS_PANE, "60%", 10122),
    INCOMPLETE_80(RED_STAINED_GLASS_PANE, "80%", 10123),
    INCOMPLETE_100(RED_STAINED_GLASS_PANE, "100%", 10124),
    ENABLED(LIME_DYE, "Aktiviert", 10103),
    DISABLED(GRAY_DYE, "Deaktiviert", 10104)

    ;


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
