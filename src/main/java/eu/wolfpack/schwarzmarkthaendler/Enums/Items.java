package eu.wolfpack.schwarzmarkthaendler.Enums;

import eu.wolfpack.schwarzmarkthaendler.utils.ItemBuilder;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import static org.bukkit.Material.LIGHT_GRAY_STAINED_GLASS_PANE;

public enum Items {
    PLACEHOLDER(LIGHT_GRAY_STAINED_GLASS_PANE, " ", " ", " ");


    private Material material;
    private String name;
    private String[] lore;

    Items(Material material, String name, String... lore) {
        this.material = material;
        this.name = name;
        this.lore = lore;
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

    public ItemStack getItem(){
        return new ItemBuilder(this.material).setDisplayname(this.name).setLore(this.lore).build();
    }

    public ItemBuilder getItemBuilder(){
        return new ItemBuilder(this.material).setDisplayname(this.name).setLore(this.lore);
    }
}
