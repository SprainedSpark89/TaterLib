/**
 * Copyright (c) 2024 Dylan Sperrer - dylan@sperrer.ca
 * The project is Licensed under <a href="https://github.com/p0t4t0sandwich/TaterLib/blob/dev/LICENSE">GPL-3</a>
 * The API is Licensed under <a href="https://github.com/p0t4t0sandwich/TaterLib/blob/dev/LICENSE-API">MIT</a>
 */


import dev.neuralnexus.taterapi.entity.Entity;

import dev.neuralnexus.taterapi.resource.ResourceKey;
import dev.neuralnexus.taterapi.world.Location;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/** Bukkit implementation of {@link World}. */
public class BukkitWorld implements dev.neuralnexus.taterapi.world.World {
    private final World world;

    /**
     * Creates a new world.
     *
     * @param world The Bukkit world.
     */
    public BukkitWorld(World world) {
        this.world = world;
    }

    /**
     * Gets the Bukkit world.
     *
     * @return The Bukkit world.
     */
    public World world() {
        return world;
    }

    @Override
    public List<Player> players() {
    	List<Player> players = new ArrayList<Player>();
    	for(LivingEntity entity : world.getLivingEntityList()) {
    		if(entity instanceof Player) {
    			players.add((Player)entity);
    		}
    	}
        return players;
    }

    @Override
    public ResourceKey dimension() {
        return ResourceKey.of(world.getType().name());
    }

    @Override
    public List<Entity> entities(
            Entity entity, Location pos1, Location pos2, Predicate<Entity> predicate) {
        return world.getEntityList().stream()
                .map(BukkitEntity::new)
                .filter(e -> e.location().x() >= pos1.x() && e.location().x() <= pos2.x())
                .filter(predicate)
                .collect(Collectors.toList());
    }

    @Override
    public List<Entity> entities(Entity entity, double radius, Predicate<Entity> predicate) {
        return world.getEntityList().stream()
                .map(BukkitEntity::new)
                .filter(e -> e.location().distance(entity.location()) <= radius)
                .filter(predicate)
                .collect(Collectors.toList());
    }
}
