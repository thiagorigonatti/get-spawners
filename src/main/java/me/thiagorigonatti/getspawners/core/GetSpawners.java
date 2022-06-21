package me.thiagorigonatti.getspawners.core;

import me.thiagorigonatti.getspawners.commands.Commands;
import me.thiagorigonatti.getspawners.customconfig.CustomConfig;
import me.thiagorigonatti.getspawners.customconfig.Messages;
import me.thiagorigonatti.getspawners.nms.UpdateSpawners_1_13_R1;
import me.thiagorigonatti.getspawners.nms.UpdateSpawners_1_13_R2;
import me.thiagorigonatti.getspawners.nms.UpdateSpawners_1_14_R1;
import me.thiagorigonatti.getspawners.nms.UpdateSpawners_1_15_R1;
import me.thiagorigonatti.getspawners.nms.UpdateSpawners_1_16_R1;
import me.thiagorigonatti.getspawners.nms.UpdateSpawners_1_16_R2;
import me.thiagorigonatti.getspawners.nms.UpdateSpawners_1_16_R3;
import me.thiagorigonatti.getspawners.nms.UpdateSpawners_1_17_R1;
import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.IOException;

public class GetSpawners extends JavaPlugin {
    public static Morphable morphable;
    private static Plugin plugin;

    public Morphable getMorphable() {
        return morphable;
    }

    public static Plugin getPlugin() {
        return plugin;
    }

    public void onEnable() {
        plugin = this;
        new CheckLatest().getGSVersion();
        this.loadConfig();
        switch (Messages.bukkitVersion) {
            case "1.13":
                morphable = new UpdateSpawners_1_13_R1();
                break;
            case "1.13.1":
            case "1.13.2":
                morphable = new UpdateSpawners_1_13_R2();
                break;
            case "1.14":
            case "1.14.1":
            case "1.14.2":
            case "1.14.3":
            case "1.14.4":
                morphable = new UpdateSpawners_1_14_R1();
                break;
            case "1.15":
            case "1.15.1":
            case "1.15.2":
                morphable = new UpdateSpawners_1_15_R1();
                break;
            case "1.16":
            case "1.16.1":
                morphable = new UpdateSpawners_1_16_R1();
                break;
            case "1.16.2":
            case "1.16.3":
                morphable = new UpdateSpawners_1_16_R2();
                break;
            case "1.16.4":
            case "1.16.5":
                morphable = new UpdateSpawners_1_16_R3();
                break;
            case "1.17":
            case "1.17.1":
                morphable = new UpdateSpawners_1_17_R1();
                break;
            case "1.18":
            case "1.18.1":
            case "1.18.2":
            case "1.19":
            case "1.19.1":
            case "1.19.2":
            case "1.19.3":
            case "1.19.4":
                morphable = new UpdateSpawners();
        }
        Listener[] listeners = {
                new DropSpawners(), new PlaceSpawners(), new SpawnerStack(), new ChangeSpawners(),
                new DroppedExp(), new CustomMobName(), new CheckLatest(), new Debug(), new ExplodeHologram()
        };

        for (Listener listener : listeners) {
            getServer().getPluginManager().registerEvents(listener, this);
        }

        getCommand("gs").setExecutor(new Commands());
        Bukkit.getConsoleSender().sendMessage(Messages.PREFIX + " " + Messages.ENABLED);
        Bukkit.getConsoleSender().sendMessage(ConsoleInfo.showCompatiblesStatus(Messages.PREFIX, CheckLatest.versionMessage));
    }

    public void loadConfig() {
        try {
            CustomConfig.onCreateFolderAndFiles();
            CustomConfig.loadReload();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}