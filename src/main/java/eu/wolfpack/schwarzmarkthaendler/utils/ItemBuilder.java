package eu.wolfpack.schwarzmarkthaendler.utils;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import java.util.Arrays;
import java.util.Map;

public class ItemBuilder {

    private ItemMeta itemMeta;
    private ItemStack itemStack;

    public ItemBuilder(Material mat){
        itemStack = new ItemStack(mat);
        itemMeta = itemStack.getItemMeta();
    }

    public ItemBuilder setDisplayname(String s){
        itemMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', s));
        return this;
    }
    public ItemBuilder setLocalizedName(String s){
        itemMeta.setLocalizedName(s);
        return this;
    }
    public ItemBuilder setLore(String... s){

        itemMeta.setLore(Arrays.asList(s));
        return this;
    }

    public ItemBuilder setSkullOwner(String name){
        SkullMeta meta = (SkullMeta) itemMeta;
        meta.setOwner(name);
        return this;
    }

    public ItemBuilder setUnbreakable(boolean s){
        itemMeta.setUnbreakable(s);
        return this;
    }
    public ItemBuilder addItemFlags(ItemFlag... s){
        itemMeta.addItemFlags(s);
        return this;
    }

    public ItemBuilder addEnchantments(Map<Enchantment, Integer> enchantments){
        itemStack.addEnchantments(enchantments);
        return this;
    }

    public ItemBuilder setCustomModelData(int i){
        itemMeta.setCustomModelData(i);
        return this;
    }

    @Override
    public String toString() {
        return "ItemBuilder{" +
                "itemMeta=" + itemMeta +
                ", itemStack=" + itemStack +
                '}';
    }
    public ItemStack build(){
        itemStack.setItemMeta(itemMeta);
        return itemStack;
    }
}