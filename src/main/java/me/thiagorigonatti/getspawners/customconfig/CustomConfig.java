package me.thiagorigonatti.getspawners.customconfig;


import me.thiagorigonatti.getspawners.core.GetSpawners;
import org.bukkit.block.CreatureSpawner;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.time.ZoneId;
import java.util.Date;
import java.util.Objects;
import java.util.TimeZone;

public class CustomConfig {
    public static GetSpawners getSpawners = GetSpawners.getPlugin(GetSpawners.class);
    private static FileConfiguration config;
    private static FileConfiguration enSpawners;
    private static FileConfiguration enMessages;
    private static FileConfiguration enMobs;
    private static FileConfiguration ptbrMessages;
    private static FileConfiguration ptbrSpawners;
    private static FileConfiguration ptbrMobs;
    private static final Path getSpawnersFolder = Paths.get(getSpawners.getDataFolder().getPath());
    private static final Path localizationFolder = Paths.get(getSpawners.getDataFolder().getPath(), "localization");
    private static final Path messagesFolder = Paths.get(getSpawners.getDataFolder().getPath(), "localization", "messages");
    private static final Path spawnersFolder = Paths.get(getSpawners.getDataFolder().getPath(), "localization", "spawners");
    private static final Path mobsFolder = Paths.get(getSpawners.getDataFolder().getPath(), "localization", "mobs");
    private static final File configFile = new File(getSpawners.getDataFolder(), "config.yml");
    private static final File enMessageFile = new File(messagesFolder.toFile(), "messages_en.yml");
    private static final File enMobsFile = new File(mobsFolder.toFile(), "mobs_en.yml");
    private static final File ptbrMessageFile = new File(messagesFolder.toFile(), "messages_ptbr.yml");
    private static final File enSpawnersFile = new File(spawnersFolder.toFile(), "spawners_en.yml");
    private static final File ptbrSpawnersFile = new File(spawnersFolder.toFile(), "spawners_ptbr.yml");
    private static final File ptbrMobsFile = new File(mobsFolder.toFile(), "mobs_ptbr.yml");
    private static final File logsFile = new File(getSpawnersFolder.toFile(), "logs.txt");


    public static void onCreateFolderAndFiles() throws IOException {
        if (Files.notExists(getSpawnersFolder)) {
            Files.createDirectory(getSpawnersFolder);
        }

        if (Files.notExists(localizationFolder)) {
            Files.createDirectory(localizationFolder);
        }
        if (Files.notExists(messagesFolder)) {
            Files.createDirectory(messagesFolder);
        }
        if (Files.notExists(spawnersFolder)) {
            Files.createDirectory(spawnersFolder);
        }
        if (Files.notExists(mobsFolder)) {
            Files.createDirectory(mobsFolder);
        }
        if (Files.notExists(configFile.toPath())) {
            Files.createFile(configFile.toPath());
            configContent();
        }
        if (Files.notExists(enMessageFile.toPath())) {
            Files.createFile(enMessageFile.toPath());
            EnglishContent.writeEnMessagesContent(enMessageFile.toPath());
        }
        if (Files.notExists(enSpawnersFile.toPath())) {
            Files.createFile(enSpawnersFile.toPath());
            EnglishContent.writeEnSpawnersContent(enSpawnersFile.toPath());
        }
        if (Files.notExists(enMobsFile.toPath())) {
            Files.createFile(enMobsFile.toPath());
            EnglishContent.writeEnMobsContent(enMobsFile.toPath());
        }
        if (Files.notExists(ptbrMobsFile.toPath())) {
            Files.createFile(ptbrMobsFile.toPath());
            BrazilianPortugueseContent.writePtbrMobsContent(ptbrMobsFile.toPath());
        }
        if (Files.notExists(ptbrMessageFile.toPath())) {
            Files.createFile(ptbrMessageFile.toPath());
            BrazilianPortugueseContent.writePtbrMessagesContent(ptbrMessageFile.toPath());
        }
        if (Files.notExists(ptbrSpawnersFile.toPath())) {
            Files.createFile(ptbrSpawnersFile.toPath());
            BrazilianPortugueseContent.writePtbrSpawnersContent(ptbrSpawnersFile.toPath());
        }

        if (Files.notExists(logsFile.toPath())) {
            Files.createFile(logsFile.toPath());
        }

    }

    public static FileConfiguration getConfig() {
        return config;
    }

    public static FileConfiguration getMessages() {
        if (Objects.requireNonNull(getConfig().getString("Language")).equals("en")) {
            return enMessages;
        } else if (Objects.requireNonNull(getConfig().getString("Language")).equals("pt_BR")) {
            return ptbrMessages;
        }
        return enMessages;
    }

    public static FileConfiguration getSpawners() {
        if (Objects.requireNonNull(getConfig().getString("Language")).equals("en")) {
            return enSpawners;
        } else if (Objects.requireNonNull(getConfig().getString("Language")).equals("pt_BR")) {
            return ptbrSpawners;
        }
        return enSpawners;
    }

    public static FileConfiguration getMobs() {
        if (Objects.requireNonNull(getConfig().getString("Language")).equals("en")) {
            return enMobs;
        } else if (Objects.requireNonNull(getConfig().getString("Language")).equals("pt_BR")) {
            return ptbrMobs;
        }
        return enMobs;
    }

    public static void loadReload() {


        config = YamlConfiguration.loadConfiguration(configFile);
        enMessages = YamlConfiguration.loadConfiguration(enMessageFile);
        enSpawners = YamlConfiguration.loadConfiguration(enSpawnersFile);
        enMobs = YamlConfiguration.loadConfiguration(enMobsFile);
        ptbrMobs = YamlConfiguration.loadConfiguration(ptbrMobsFile);
        ptbrMessages = YamlConfiguration.loadConfiguration(ptbrMessageFile);
        ptbrSpawners = YamlConfiguration.loadConfiguration(ptbrSpawnersFile);

        Messages.reloadConfig();
    }


    public static void spawnerMiningData(Player player, CreatureSpawner creatureSpawner) {

        TimeZone.setDefault(TimeZone.getTimeZone(ZoneId.of(Messages.zoneId)));
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(Messages.datePattern);
        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat(Messages.timePattern);

        Date date = new Date();
        String dateTime = simpleDateFormat.format(date.getTime());
        String dateTime2 = simpleDateFormat2.format(date.getTime());
        String uuid = player.getUniqueId().toString();
        String world = player.getWorld().getName();
        String playerName = player.getName();
        String locationX = Integer.toString(creatureSpawner.getBlock().getLocation().getBlockX());
        String locationY = Integer.toString(creatureSpawner.getBlock().getLocation().getBlockY());
        String locationZ = Integer.toString(creatureSpawner.getBlock().getLocation().getBlockZ());
        String spawnedType = creatureSpawner.getSpawnedType().name();

        try {

            FileWriter writer = new FileWriter(logsFile, true);
            writer.write(Messages.logOutput
                    .replaceAll("%player_name%", playerName)
                    .replaceAll("%player_uuid%", uuid)
                    .replaceAll("%spawned_type%", spawnedType)
                    .replaceAll("%world_name%", world)
                    .replaceAll("%x%", locationX)
                    .replaceAll("%y%", locationY)
                    .replaceAll("%z%", locationZ)
                    .replaceAll("%date%", dateTime)
                    .replaceAll("%time%", dateTime2
                            + System.getProperty("line.separator")));

            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private static void configContent() {
        try {
            Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(configFile), StandardCharsets.UTF_8));
            writer.write("# Select zone, date & time format to write data in logs.txt file always a player mine an original spawner; you can also change/translate the output message\n" +
                    "Log:\n" +
                    "  Enabled: true\n" +
                    "  ZoneId: 'America/Chicago' #https://docs.oracle.com/middleware/12212/wcs/tag-ref/MISC/TimeZones.html\n" +
                    "  DatePattern: 'MM-dd-yyyy'\n" +
                    "  TimePattern: 'HH:mm:ss z'\n" +
                    "  Output: '%player_name% (%player_uuid%) mined a(n) %spawned_type% spawner in (%world_name%: %x% %y% %z%) at: %date% %time%'\n" +
                    "\n" +
                    "# If enabled is set as true, it will allow to mine spawners with or without enchantments, just any netherite pickaxe\n" +
                    "# If silk_touch_required is set as true, you'll mine only if your netherite pick have been enchanted with silk touch\n" +
                    "Netherite_Pickaxe:\n" +
                    "  Enabled: true\n" +
                    "  Silk_Touch_Required: true\n" +
                    "\n" +
                    "\n" +
                    "# If enabled is set as true, it will allow to mine spawners with or without enchantments, just any diamond pickaxe\n" +
                    "# If silk_touch_required is set as true, you'll mine only if your diamond pick have been enchanted with silk touch\n" +
                    "Diamond_Pickaxe:\n" +
                    "  Enabled: true\n" +
                    "  Silk_Touch_Required: true\n" +
                    "\n" +
                    "\n" +
                    "# Iron pickaxe option true, means it will allow to mine spawners with or without enchantmentes, just any iron pickaxe\n" +
                    "# If silk_touch_required true, you'll mine only if your iron pick have been enchanted with silk touch\n" +
                    "# If enabled option is set to false, silk_touch_required will be irrelevant\n" +
                    "Iron_Pickaxe:\n" +
                    "  Enabled: false\n" +
                    "  Silk_Touch_Required: false\n" +
                    "\n" +
                    "# Select particle and sound to show/play always a spawner is put above another one (stacked)\n" +
                    "Particles:\n" +
                    "  Enabled: true\n" +
                    "  Particle_And_Sound:\n" +
                    "  #https://hub.spigotmc.org/javadocs/spigot/org/bukkit/Particle.html\n" +
                    "  #https://hub.spigotmc.org/javadocs/spigot/org/bukkit/Sound.html\n" +
                    "    - VILLAGER_HAPPY, AMBIENT_CAVE        #2 \n" +
                    "    - FLAME, AMBIENT_CAVE                 #3\n" +
                    "    - FIREWORKS_SPARK, AMBIENT_CAVE       #4\n" +
                    "    - CRIT_MAGIC, AMBIENT_CAVE            #5\n" +
                    "    - CLOUD, AMBIENT_CAVE                 #6\n" +
                    "    - END_ROD, AMBIENT_CAVE               #7\n" +
                    "    - SPELL, AMBIENT_CAVE                 #8\n" +
                    "    - PORTAL, AMBIENT_CAVE                #9\n" +
                    "    - TOTEM, AMBIENT_CAVE                 #10\n" +
                    "    - DRAGON_BREATH, AMBIENT_CAVE         #11\n" +
                    "    - SNOWBALL, AMBIENT_CAVE              #12\n" +
                    "    - LAVA, AMBIENT_CAVE                  #13\n" +
                    "    - HEART, AMBIENT_CAVE                 #14\n" +
                    "    - VILLAGER_ANGRY, AMBIENT_CAVE        #15\n" +
                    "\n" +
                    "\n" +
                    "# The option to allow mob spawners change\n" +
                    "# By right clicking spawner with a spawn egg in main hand to change it, is the default as natively\n" +
                    "# Using this option you can turn it off, if wanted\n" +
                    "Allow_SpawnEgg_Change:\n" +
                    "  Enabled: true\n" +
                    "\n" +
                    "\n" +
                    "# Prevent spawner change while player is invisible by SuperVanish plugin\n" +
                    "SuperVanish_Prevent_SpawnEgg_Change:\n" +
                    "  Enabled: true\n" +
                    "\n" +
                    "\n" +
                    "# Enables, disables custom names for mobs which was spawned by a not original spawner (placed by a player spawner)\n" +
                    "Custom_Name_For_gsMobs:\n" +
                    "  Enabled: false\n" +
                    "\n" +
                    "\n" +
                    "# Set custom name visible true to always see the name above mob head, otherwise only if aiming the mob\n" +
                    "Always_Visible_Name:\n" +
                    "  Enabled: true\n" +
                    "\n" +
                    "\n" +
                    "# Exp gained from mobs which have been spawned from a not original spawner, (placed by a player spawner) will get an operation by these values\n" +
                    "# Killing a gs mob, you'll get the default exp amount, calculated by the operations below\n" +
                    "Dropped_Exp_From_gsMobs:\n" +
                    "  Enabled: false\n" +
                    "# Set multiply to 0 by disable exp\n" +
                    "  Multiply: 1\n" +
                    "# Divide value equals 0 will receive 1\n" +
                    "  Divide: 0 #1\n" +
                    "  Subtract: 0\n" +
                    "  Add: 0\n" +
                    "\n" +
                    "\n" +
                    "# Experience gained from an original mob which have been spawned from an original vanilla spawner, it will get an operation by these values\n" +
                    "# If enabled is set to true, killing a mob, you'll get the default exp amount, calculated by the operations below\n" +
                    "Dropped_Exp_From_Vanilla_Mobs:\n" +
                    "  Enabled: false\n" +
                    "# Set multiply to 0 by disable exp\n" +
                    "  Multiply: 1\n" +
                    "# Divide value equals 0 will receive 1\n" +
                    "  Divide: 0 #1\n" +
                    "  Subtract: 0\n" +
                    "  Add: 0\n" +
                    "\n" +
                    "\n" +
                    "# Set plugin messages and names language; availables languages: 'en', 'pt_BR'\n" +
                    "Language: en");
            writer.flush();
            writer.close();
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }
}