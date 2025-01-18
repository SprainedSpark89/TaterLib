/**
 * Copyright (c) 2024 Dylan Sperrer - dylan@sperrer.ca
 * The project is Licensed under <a href="https://github.com/p0t4t0sandwich/TaterLib/blob/dev/LICENSE">GPL-3</a>
 * The API is Licensed under <a href="https://github.com/p0t4t0sandwich/TaterLib/blob/dev/LICENSE-API">MIT</a>
 */


import dev.neuralnexus.taterapi.TaterAPIProvider;
import dev.neuralnexus.taterapi.resource.ResourceKey;
import dev.neuralnexus.taterapi.world.Location;
import dev.neuralnexus.taterlib.b1_7_3.bukkit.world.BukkitLocation;
import dev.neuralnexus.taterlib.b1_7_3.bukkit.world.BukkitWorld;

import org.bukkit.craftbukkit.entity.CraftEntity;

import java.util.Optional;
import java.util.UUID;

/** Bukkit implementation of {@link Entity}. */
public class BukkitEntity implements dev.neuralnexus.taterapi.entity.Entity {
    private final BaseEntity entity;

    /**
     * Constructor.
     *
     * @param entity The Bukkit entity.
     */
    public BukkitEntity(BaseEntity entity) {
        this.entity = entity;
    }

    /**
     * Gets the Bukkit entity.
     *
     * @return The Bukkit entity.
     */
    public BaseEntity entity() {
        return entity;
    }

    @Override
    public UUID uuid() {
        return null;
    }

    @Override
    public int entityId() {
        return entity.getId();
    }

    @Override
    public void remove() {
        entity.destroy();
    }

    @Override
    public ResourceKey type() {
        return ResourceKey.of(
                "minecraft", OEnumMobType.b(((CraftEntity) entity).getHandle()).toLowerCase());
    }

    @Override
    public void sendMessage(String message) {}

    @Override
    public Optional<String> customName() {
        return Optional.of("minecraft.entity");
    }

    @Override
    public void setCustomName(String name) {
        //        entity.setCustomName(name);
    }

    @Override
    public Location location() {
    	Location location = null;
    	location.setX(entity.getX());
    	location.setY(entity.getY());
    	location.setZ(entity.getZ());
        return new BukkitLocation(location);
    }

    @Override
    public ResourceKey biome() {
        return ResourceKey.of(entity.getLocation().getBlock().getBiome().name());
    }

    @Override
    public void teleport(Location location) {
        entity.teleportTo(location.x(), location.y(), location.z(), location.yaw(), location.pitch());
    }

    @Override
    public boolean hasPermission(int permissionLevel) {
        return false;
    }

    @Override
    public boolean hasPermission(String permission) {
        return TaterAPIProvider.hasPermission(this, permission);
    }
}
