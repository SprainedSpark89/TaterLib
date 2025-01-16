/**
 * Copyright (c) 2024 Dylan Sperrer - dylan@sperrer.ca
 * The project is Licensed under <a href="https://github.com/p0t4t0sandwich/TaterLib/blob/dev/LICENSE">GPL-3</a>
 * The API is Licensed under <a href="https://github.com/p0t4t0sandwich/TaterLib/blob/dev/LICENSE-API">MIT</a>
 */
package dev.neuralnexus.taterlib.b1_7_3.bukkit.entity;

import dev.neuralnexus.taterapi.TaterAPIProvider;
import dev.neuralnexus.taterapi.entity.Entity;
import dev.neuralnexus.taterapi.resource.ResourceKey;
import dev.neuralnexus.taterapi.world.Location;
import dev.neuralnexus.taterlib.b1_7_3.bukkit.world.BukkitLocation;
import dev.neuralnexus.taterlib.b1_7_3.bukkit.world.BukkitWorld;

import net.minecraft.server.EntityTypes;

import org.bukkit.craftbukkit.entity.CraftEntity;

import java.util.Optional;
import java.util.UUID;

/** Bukkit implementation of {@link Entity}. */
public class BukkitEntity implements Entity {
    private final org.bukkit.entity.Entity entity;

    /**
     * Constructor.
     *
     * @param entity The Bukkit entity.
     */
    public BukkitEntity(org.bukkit.entity.Entity entity) {
        this.entity = entity;
    }

    /**
     * Gets the Bukkit entity.
     *
     * @return The Bukkit entity.
     */
    public org.bukkit.entity.Entity entity() {
        return entity;
    }

    @Override
    public UUID uuid() {
        return entity.getUniqueId();
    }

    @Override
    public int entityId() {
        return entity.getEntityId();
    }

    @Override
    public void remove() {
        entity.remove();
    }

    @Override
    public ResourceKey type() {
        return ResourceKey.of(
                "minecraft", EntityTypes.b(((CraftEntity) entity).getHandle()).toLowerCase());
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
        return new BukkitLocation(entity.getLocation());
    }

    @Override
    public ResourceKey biome() {
        return ResourceKey.of(entity.getLocation().getBlock().getBiome().name());
    }

    @Override
    public void teleport(Location location) {
        entity.teleport(
                new org.bukkit.Location(
                        ((BukkitWorld) location.world()).world(),
                        location.x(),
                        location.y(),
                        location.z()));
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
