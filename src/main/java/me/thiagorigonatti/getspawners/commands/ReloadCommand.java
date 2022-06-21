package me.thiagorigonatti.getspawners.commands;

import me.thiagorigonatti.getspawners.core.*;
import me.thiagorigonatti.getspawners.customconfig.Messages;
import org.bukkit.command.CommandSender;
import org.bukkit.event.HandlerList;

public class ReloadCommand extends Messages {
    private static final GetSpawners getSpawners = GetSpawners.getPlugin(GetSpawners.class);

    void reload(CommandSender commandSender) {
        if (commandSender.hasPermission("getspawners.reload")) {
            HandlerList.unregisterAll(getSpawners);
            getSpawners.loadConfig();
            getSpawners.getServer().getPluginManager().registerEvents(new ChangeSpawners(), getSpawners);
            getSpawners.getServer().getPluginManager().registerEvents(new CheckLatest(), getSpawners);
            getSpawners.getServer().getPluginManager().registerEvents(new CustomMobName(), getSpawners);
            getSpawners.getServer().getPluginManager().registerEvents(new Debug(), getSpawners);
            getSpawners.getServer().getPluginManager().registerEvents(new DropSpawners(), getSpawners);
            getSpawners.getServer().getPluginManager().registerEvents(new DroppedExp(), getSpawners);
            getSpawners.getServer().getPluginManager().registerEvents(new ExplodeHologram(), getSpawners);
            getSpawners.getServer().getPluginManager().registerEvents(new PlaceSpawners(), getSpawners);
            getSpawners.getServer().getPluginManager().registerEvents(new SpawnerStack(), getSpawners);
            commandSender.sendMessage(PREFIX + " " + RELOADED);
        } else {
            commandSender.sendMessage(PREFIX + " " + NO_PERM);
        }
    }
}