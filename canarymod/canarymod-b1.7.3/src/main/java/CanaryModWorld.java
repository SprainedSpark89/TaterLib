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

/** CanaryMod implementation of {@link World}. */
public class CanaryModWorld implements dev.neuralnexus.taterapi.world.World {
    private final World world;

    /**
     * Creates a new world.
     *
     * @param world The CanaryMod world.
     */
    public CanaryModWorld(World world) {
        this.world = world;
    }

    /**
     * Gets the CanaryMod world.
     *
     * @return The CanaryMod world.
     */
    public World world() {
        return world;
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
    public List players() {
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
                .map(CanaryModEntity::new)
                .filter(e -> e.location().x() >= pos1.x() && e.location().x() <= pos2.x())
                .filter(predicate)
                .collect(Collectors.toList());
    }

    @Override
    public List<Entity> entities(Entity entity, double radius, Predicate<Entity> predicate) {
        return world.getEntityList().stream()
                .map(CanaryModEntity::new)
                .filter(e -> e.location().distance(entity.location()) <= radius)
                .filter(predicate)
                .collect(Collectors.toList());
    }
}
