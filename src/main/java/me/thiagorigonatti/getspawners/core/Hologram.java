package me.thiagorigonatti.getspawners.core;

import me.thiagorigonatti.getspawners.customconfig.CustomConfig;
import org.bukkit.entity.Entity;
import org.bukkit.event.block.BlockBreakEvent;

import java.util.List;

public class Hologram extends DropSpawners {

    public static void setCustomName(BlockBreakEvent event) {
        List<Entity> entities = event.getBlock().getWorld().getEntities();
        for (Entity entity : entities) {
            if (entity.getLocation().subtract(0.5, 0, 0.5).toString().equals(event.getBlock().getLocation().toString())) {
                String spawnedType = CustomConfig.getSpawners().getString("Spawner_Name." + firstCapitalWord(DropSpawners.spawnedType));
                String amount = Integer.toString(creatureSpawner.getMinSpawnDelay() - 201);
                String displayName = spawnedType + " " + amount + "X";
                entity.setCustomName(color(displayName));
                if (isParticleAndSound) {
                    Particles.showParticles(Integer.parseInt(amount) + 1, creatureSpawner.getBlock(), event.getPlayer());
                }
            }
        }
    }

    public static void remove(BlockBreakEvent event) {
        List<Entity> entities = event.getBlock().getWorld().getEntities();
        for (Entity entity : entities) {
            if (entity.getLocation().subtract(0.5, 0, 0.5).toString().equals(event.getBlock().getLocation().toString())) {
                entity.remove();
            }
        }
        if (isParticleAndSound) {
            Particles.showParticles(2, creatureSpawner.getBlock(), event.getPlayer());
        }
    }
}
