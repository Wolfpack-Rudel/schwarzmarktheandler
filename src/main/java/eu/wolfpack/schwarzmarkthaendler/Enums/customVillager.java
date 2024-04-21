package eu.wolfpack.schwarzmarkthaendler.Enums;

import com.destroystokyo.paper.profile.PlayerProfile;
import com.destroystokyo.paper.profile.ProfileProperty;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Villager;
import org.bukkit.inventory.EntityEquipment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.Bukkit;

import java.util.UUID;

public enum customVillager {
    SCHWARZMARKTHANDLER(
        "Schwarzmarkthändler",
            null,
            makeArmorSet(
                    null,
                    null,
                    null,
                    null
            )
    );

    private final String name;
    private final ItemStack mainItem;
    private final ItemStack[] armor;
    private LivingEntity ent;

    customVillager(String name, ItemStack mainItem, ItemStack[] armor) {
        this.name = name;
        this.mainItem = mainItem;
        this.armor = armor;
    }

    public void spawn(Location location){
        LivingEntity entity = (LivingEntity) location.getWorld().spawnEntity(location, EntityType.VILLAGER);
        entity.setCustomNameVisible(true);
        entity.setCustomName(color(name));
        entity.addScoreboardTag("customVillager-Schwarzmarkthändler");
        entity.setAI(false);
        entity.setSilent(true);
        entity.setInvulnerable(false);
        Villager villager = (Villager) entity;
        villager.setProfession(Villager.Profession.ARMORER);
        villager.setVillagerType(Villager.Type.JUNGLE);

        EntityEquipment inv = entity.getEquipment();
        if (armor != null) {
            inv.setArmorContents(armor);
        }

        // Skin 2b245841 generated on Aug 10, 2022 9:14:21 PM via MineSkin.org - https://minesk.in/2b2458410a224cca8798c56d7a9a6814
        PlayerProfile skin2b245841 = Bukkit.createProfile(UUID.fromString("dbf5f959-9b8a-4b88-947c-15b7c4a651ee"), "skin2b245841");
        skin2b245841.setProperty(new ProfileProperty("textures", "ewogICJ0aW1lc3RhbXAiIDogMTY2MDE1ODg2MTA1NSwKICAicHJvZmlsZUlkIiA6ICI0MjEwNTYxMWQxZjM0NzAyOTQ4NjE3OTYzMDY3NjY2NCIsCiAgInByb2ZpbGVOYW1lIiA6ICJUcmlraXRyYWthdGVsYXp6IiwKICAic2lnbmF0dXJlUmVxdWlyZWQiIDogdHJ1ZSwKICAidGV4dHVyZXMiIDogewogICAgIlNLSU4iIDogewogICAgICAidXJsIiA6ICJodHRwOi8vdGV4dHVyZXMubWluZWNyYWZ0Lm5ldC90ZXh0dXJlLzYyY2YyZmE5MzNlZWMxZjUzOGNiYjJmZTkwOWJmNTE5MTc0NzMyYWIwMjJmNzRiN2YzN2QyYTA3ZWMzMjZkYTUiCiAgICB9CiAgfQp9", "uI0wrJ74v/VJLOG61/sLiJvj0eyqyf8LXKi8k1Vx5pKMpmY8xCIKq2sB7hTnx4fGrXixo3Rglg1fopX7X2b6kckC8SLvO04ns3IpVj33ImanPG305jtMOzlaGKAFIazO+oUuJcp1GhEqQTCLCd4mVBgeEqMEuYsqmMNiZQ1G2lX0xThhXvzeIXMtrsPeK8Q21na2FUItP1FLY71c1uwYZ8NqoI4cKsR3xu4n/PXD/E4lb237qQtTaciBaN2SgBGGADo0YrdsUoLKCETm+HPwaFJVMRwVgENvXkyimGXFSNSHWJAzpqoOHm+OLncq3g5IDAnIwcj8BxGzB6P5HzRXOm7/KSV1VSxO3fQaNoXjEH80vCC75jfSzw3nVWy6uwwGj+qBzzBFoShmSpXSyTA4Nb3fs1NEgp32c4dn1EskWSB82ixf7C/QBYdjwD5y+cNNEf7h3IOnUyxHDfYtfDFDPTD8pCTeHat9oXTVHPZ0tnODtgrvFLElaCkn3xfqcCt3QitrQ7njBAEYhnz1BqDHywrrEo0WNqAxwGraSY4hhiIS+22Bv23bVk2Kc71TznnRtNM1TK4tNTAtiKmqBTOseLV4JoCVGTxHsLH8psjIuVFH8DeNYUmT4EFkWCRqHMc1ANgCPL51FMOiUbdMGSsNJhDeSHF8Yp0qOajn+C/FfLo="));

        inv.setHelmetDropChance(0f);
        inv.setChestplateDropChance(0f);
        inv.setLeggingsDropChance(0f);
        inv.setBootsDropChance(0f);
        inv.setItemInMainHand(mainItem);
        inv.setItemInMainHandDropChance(0f);
        this.ent = entity;


    }

    public void killAll(){
        this.ent.setHealth(0);
    }

    public void tp(World world, double x, double y, double z, float yaw, float pitch){
        this.ent.setHealth(0);
        spawn(new Location(world, x,y,z, yaw, pitch));
    }

    private static ItemStack[] makeArmorSet(ItemStack helmet, ItemStack chestplate, ItemStack leggings, ItemStack boots) {
        ItemStack[] armor = new ItemStack[4];
        armor[3] = helmet;
        armor[2] = chestplate;
        armor[1] = leggings;
        armor[0] = boots;
        return armor;
    }

    private static String color(String string) {
        return ChatColor.translateAlternateColorCodes('&', string);
    }

    public boolean living(){
        return !this.ent.isEmpty();
    }

    public Location getPos(){
        if(this.ent.isEmpty()) return null;
        return this.ent.getLocation();
    }
}
