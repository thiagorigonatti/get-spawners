package me.thiagorigonatti.getspawners.core;

import me.thiagorigonatti.getspawners.core.Morphable;
import org.bukkit.block.CreatureSpawner;
import org.bukkit.entity.EntityType;


public class UpdateSpawners implements Morphable {

    @Override
    public void update(org.bukkit.block.Block blockPlaced, String spawnedType, int spawnCount, int minSpawnDelay, int maxSpawnDelay, boolean isBreaking, boolean isChanging) {

        CreatureSpawner creatureSpawner = ((CreatureSpawner) blockPlaced.getState());
        creatureSpawner.setSpawnedType(EntityType.valueOf(spawnedType.toUpperCase()));

        if ( minSpawnDelay == 0) {
            creatureSpawner.setSpawnCount(1);
            creatureSpawner.setMinSpawnDelay(201);
        } else if (minSpawnDelay == 200) {
            creatureSpawner.setSpawnCount(2);
            creatureSpawner.setMinSpawnDelay(minSpawnDelay + 2);
            creatureSpawner.setMaxSpawnDelay(maxSpawnDelay - 40);
        } else if (isBreaking) {
            creatureSpawner.setSpawnCount(spawnCount - 1);
            creatureSpawner.setMinSpawnDelay(minSpawnDelay - 1);
            creatureSpawner.setMaxSpawnDelay(maxSpawnDelay + 40);
        } else if (isChanging) {
            creatureSpawner.setSpawnCount(spawnCount);
            creatureSpawner.setMinSpawnDelay(minSpawnDelay);
            creatureSpawner.setMaxSpawnDelay(maxSpawnDelay);
        } else {
            creatureSpawner.setSpawnCount(spawnCount + 1);
            creatureSpawner.setMinSpawnDelay(minSpawnDelay + 1);
            creatureSpawner.setMaxSpawnDelay(maxSpawnDelay - 40);
        }

        creatureSpawner.update();
    }
}