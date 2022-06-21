package me.thiagorigonatti.getspawners.core;

import me.thiagorigonatti.getspawners.customconfig.CustomConfig;
import org.bukkit.Location;
import org.bukkit.entity.ArmorStand;

public class EntitySpawn extends CustomConfig {
    public static void spawn(String stackedName, Location location) {

        location.getWorld().spawn(location.add(0.5, 0, 0.5), ArmorStand.class,
                consumerStand -> {
                    consumerStand.setCustomName(stackedName);
                    consumerStand.setCustomNameVisible(true);
                    consumerStand.setSmall(true);
                    consumerStand.setVisible(false);
                    consumerStand.setGravity(false);
                });

    }
}
