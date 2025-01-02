/**
 * Copyright (c) 2024 Dylan Sperrer - dylan@sperrer.ca
 * The project is Licensed under <a href="https://github.com/p0t4t0sandwich/TaterLib/blob/dev/LICENSE">GPL-3</a>
 * The API is Licensed under <a href="https://github.com/p0t4t0sandwich/TaterLib/blob/dev/LICENSE-API">MIT</a>
 */
package dev.neuralnexus.taterlib.v1_7_10.fabric.entity;

import dev.neuralnexus.taterapi.TaterAPIProvider;
import dev.neuralnexus.taterapi.entity.Entity;
import dev.neuralnexus.taterapi.exceptions.VersionFeatureNotSupportedException;
import dev.neuralnexus.taterapi.resource.ResourceKey;
import dev.neuralnexus.taterapi.server.Server;
import dev.neuralnexus.taterapi.world.Location;
import dev.neuralnexus.taterlib.v1_7_10.fabric.world.FabricLocation;
import dev.neuralnexus.taterlib.v1_7_10.fabric.world.FabricServerWorld;

import net.minecraft.server.world.ServerWorld;

import java.util.Optional;
import java.util.UUID;

/** Fabric implementation of {@link Entity}. */
public class FabricEntity implements Entity {
    private final net.minecraft.entity.Entity entity;

    /**
     * Constructor.
     *
     * @param entity The Fabric entity.
     */
    public FabricEntity(net.minecraft.entity.Entity entity) {
        this.entity = entity;
    }

    /**
     * Gets the Fabric entity.
     *
     * @return The Fabric entity.
     */
    public net.minecraft.entity.Entity entity() {
        return entity;
    }

    @Override
    public UUID uuid() {
        return entity.getUuid();
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
        return ResourceKey.of(entity.getTranslationKey().split("entity\\.")[1].replace(".", ":"));
    }

    @Override
    public Optional<String> customName() {
        if (entity.getName() == null) return Optional.empty();
        return Optional.of(entity.getName().asFormattedString());
    }

    @Override
    public void setCustomName(String name) {
        // TODO: Implement
        // NAME TAGS SUPPORT
        //        entity.setCustomName(name);
        throw new VersionFeatureNotSupportedException();
    }

    @Override
    public Location location() {
        return new FabricLocation(entity);
    }

    @Override
    public ResourceKey biome() {
        return ResourceKey.of(entity.world.getBiome((int) entity.x, (int) entity.z).name);
    }

    @Override
    public void teleport(Location location) {
        if (!location.world().dimension().equals(dimension())) {
            Optional<ServerWorld> serverLevel =
                    ((Server) ((ServerWorld) entity.world).getServer())
                            .world(location.world().dimension())
                            .map(FabricServerWorld.class::cast)
                            .map(FabricServerWorld::world);
            if (!serverLevel.isPresent()) return;
            entity.teleportToDimension(serverLevel.get().dimension.dimensionType);
        }
        entity.updatePosition(location.x(), location.y(), location.z());
    }

    @Override
    public void sendMessage(String message) {}

    @Override
    public boolean hasPermission(int permissionLevel) {
        return false;
    }

    @Override
    public boolean hasPermission(String permission) {
        return TaterAPIProvider.hasPermission(this, permission);
    }
}
