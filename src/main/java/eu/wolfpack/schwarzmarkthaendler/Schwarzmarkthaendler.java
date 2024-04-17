package eu.wolfpack.schwarzmarkthaendler;

import co.aikar.commands.BukkitCommandCompletionContext;
import co.aikar.commands.CommandCompletions;
import co.aikar.commands.PaperCommandManager;
import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import eu.wolfpack.schwarzmarkthaendler.commands.*;
import eu.wolfpack.schwarzmarkthaendler.listener.TypeHandler;
import eu.wolfpack.schwarzmarkthaendler.listener.onVillagerHit;
import eu.wolfpack.schwarzmarkthaendler.listener.onVillagerTrade;
import eu.wolfpack.schwarzmarkthaendler.utils.PlayerQuest;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.configuration.file.YamlConfigurationOptions;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.*;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.util.*;

import static eu.wolfpack.schwarzmarkthaendler.villager.customVillager.SCHWARZMARKTHANDLER;

public final class Schwarzmarkthaendler extends JavaPlugin {

    public static Schwarzmarkthaendler getInstance() {
        return instance;
    }
    private static Schwarzmarkthaendler instance;
    private static File dataFile;
    private static Map<UUID, Integer> playerPoints = new HashMap<UUID, Integer>();
    private static Map<UUID, PlayerQuest> playerQuest = new HashMap<UUID, PlayerQuest>();

    @Override
    public void onEnable() {
        // Plugin startup logic

        PaperCommandManager cmdManager = new PaperCommandManager(this);
        CommandCompletions<BukkitCommandCompletionContext> cmdCompletion = cmdManager.getCommandCompletions();

        instance = this;
        saveResource("config.yml", false);

        //Startup LOG
        getLogger().info("========================");
        getLogger().info("   Schwarzmarkthandler");

        dataFile = new File(getDataFolder(), "playerPoints.yml");
        loadPlayerPoints();

        getLogger().info(" ");
        getLogger().info("Lade Locations...");
        getLogger().info(Objects.requireNonNull(getConfig().getConfigurationSection("locations")).getKeys(false).toString());
        getLogger().info("Locations geladen");
        getLogger().info(" ");
        getLogger().info("Lade Quests");
        getLogger().info(Objects.requireNonNull(getConfig().getConfigurationSection("quests")).getKeys(false).toString());

        getLogger().info("Quests geladen");
        getLogger().info(" ");
        getLogger().info("Lade Commands");

        //CommandManager

        cmdCompletion.registerAsyncCompletion("tppoints", c -> {
            CommandSender player = c.getSender();
            if(!(player instanceof Player)) return null;
            return Objects.requireNonNull(getConfig().getConfigurationSection("locations")).getKeys(false);
        });
        cmdCompletion.registerAsyncCompletion("questslist", c -> {
            CommandSender player = c.getSender();
            if(!(player instanceof Player)) return null;
            return Objects.requireNonNull(getConfig().getConfigurationSection("quests")).getKeys(false);
        });

        getLogger().info("CommandCompletion Done");

        cmdManager.registerCommand(new tpHandlerToPosition());
        cmdManager.registerCommand(new findVil());
        cmdManager.registerCommand(new getQuestInfo());
        cmdManager.registerCommand(new managePlayerPoints());
        cmdManager.registerCommand(new setPlayerQuest());

        cmdManager.enableUnstableAPI("help");

        getLogger().info("Commands geladen");

        //PAPI: https://wiki.placeholderapi.com/developers/using-placeholderapi/#__tabbed_4_2

        if (Bukkit.getPluginManager().getPlugin("PlaceholderAPI") == null) {
            /*
             * We inform about the fact that PlaceholderAPI isn't installed and then
             * disable this plugin to prevent issues.
             */
            getLogger().severe("Could not find PlaceholderAPI! This plugin is required.");
            Bukkit.getPluginManager().disablePlugin(this);
        }

        getLogger().info(" ");
        getLogger().info("        Startup");
        getLogger().info("========================");

        String random = "locations." + Objects.requireNonNull(getConfig().getConfigurationSection("locations")).getKeys(false).toArray()[(int)( Math.random() * Objects.requireNonNull(getConfig().getConfigurationSection("locations")).getKeys(false).size())];
        Location loc = new Location(
                Bukkit.getWorld(Objects.requireNonNull(Objects.requireNonNull(getConfig().getConfigurationSection(random)).getString("world"))),
                Objects.requireNonNull(getConfig().getConfigurationSection(random)).getDouble("x"),
                Objects.requireNonNull(getConfig().getConfigurationSection(random)).getDouble("y"),
                Objects.requireNonNull(getConfig().getConfigurationSection(random)).getDouble("z"),
                Objects.requireNonNull(getConfig().getConfigurationSection(random)).getInt("yaw"),
                Objects.requireNonNull(getConfig().getConfigurationSection(random)).getInt("pitch")
                );

        SCHWARZMARKTHANDLER.spawn(loc);

        //EventManager
        getServer().getPluginManager().registerEvents(new onVillagerHit(), this);
        getServer().getPluginManager().registerEvents(new onVillagerTrade(), this);
        getServer().getPluginManager().registerEvents(new TypeHandler(), this);

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic

        savePlayerPoints();
        SCHWARZMARKTHANDLER.killAll();
    }

    public static Map<UUID, Integer> getPlayerPoints() {
        return playerPoints;
    }

    public static void setPlayerPoints(Map<UUID, Integer> playerPoints) {
        Schwarzmarkthaendler.playerPoints = playerPoints;
    }

    public static void savePlayerPoints() {
        try (Writer writer = new FileWriter(dataFile)) {
            Gson gson = new Gson();
            gson.toJson(playerPoints, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void loadPlayerPoints() {
        if (dataFile.exists()) {
            try (Reader reader = new FileReader(dataFile)) {
                Gson gson = new Gson();
                Type type = new TypeToken<Map<UUID, Integer>>() {}.getType();
                playerPoints = gson.fromJson(reader, type);
            } catch (IOException e) {
                e.printStackTrace();
                playerPoints = new HashMap<>();
            }
        }
    }

    public static Map<UUID, PlayerQuest> getPlayerQuest() {
        return playerQuest;
    }

    public static void setPlayerQuest(Map<UUID, PlayerQuest> playerQuest) {
        Schwarzmarkthaendler.playerQuest = playerQuest;
    }
}
