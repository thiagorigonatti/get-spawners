package me.thiagorigonatti.getspawners.core;

import org.bukkit.block.Block;

public interface Morphable {

    void update(Block blockPlaced, String spawnedType, int spawnCount, int minSpawnDelay, int maxSpawnDelay, boolean isBreaking, boolean isChanging);
}
