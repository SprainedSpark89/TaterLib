/**
 * Copyright (c) 2024 Dylan Sperrer - dylan@sperrer.ca
 * The project is Licensed under <a href="https://github.com/p0t4t0sandwich/TaterLib/blob/dev/LICENSE">GPL-3</a>
 * The API is Licensed under <a href="https://github.com/p0t4t0sandwich/TaterLib/blob/dev/LICENSE-API">MIT</a>
 */
package dev.neuralnexus.taterlib.v1_7_10.forge.entity;

import dev.neuralnexus.taterapi.TaterAPIProvider;
import dev.neuralnexus.taterapi.entity.Entity;
import dev.neuralnexus.taterapi.exceptions.VersionFeatureNotSupportedException;
import dev.neuralnexus.taterapi.resource.ResourceKey;
import dev.neuralnexus.taterapi.server.Server;
import dev.neuralnexus.taterapi.world.Location;
import dev.neuralnexus.taterlib.v1_7_10.forge.world.ForgeLocation;
import dev.neuralnexus.taterlib.v1_7_10.forge.world.ForgeServerWorld;

import net.minecraft.world.WorldServer;

import java.util.Optional;
import java.util.UUID;

/** Forge implementation of {@link Entity}. */
public class ForgeEntity implements Entity {
    private final net.minecraft.entity.Entity entity;

    /**
     * Constructor.
     *
     * @param entity The Forge entity.
     */
    public ForgeEntity(net.minecraft.entity.Entity entity) {
        this.entity = entity;
    }

    /**
     * Gets the Forge entity.
     *
     * @return The Forge entity.
     */
    public net.minecraft.entity.Entity entity() {
        return entity;
    }

    @Override
    public UUID uuid() {
        return entity.getUniqueID();
    }

    @Override
    public int entityId() {
        return entity.getEntityId();
    }

    @Override
    public void remove() {
        entity.setDead();
    }

    @Override
    public ResourceKey type() {
        // TODO: Find entity registry
        return ResourceKey.of(
                entity.getCommandSenderName().split("entity\\.")[1].replace(".", ":"));
    }

    @Override
    public Optional<String> customName() {
        if (entity.getFormattedCommandSenderName() == null) return Optional.empty();
        return Optional.of(entity.getFormattedCommandSenderName().getFormattedText());
    }

    @Override
    public void setCustomName(String name) {
        // TODO: Implement NAME TAGS SUPPORT
        throw new VersionFeatureNotSupportedException();
    }

    @Override
    public Location location() {
        return new ForgeLocation(entity);
    }

    @Override
    public ResourceKey biome() {
        // TODO: Find biome registry
        return ResourceKey.of(
                entity.worldObj.provider.getBiomeGenForCoords((int) entity.posX, (int) entity.posZ)
                        .biomeName);
    }

    @Override
    public void teleport(Location location) {
        if (!location.world().dimension().equals(dimension())) {
            Optional<WorldServer> serverLevel =
                    ((Server) ((WorldServer) entity.worldObj).func_73046_m())
                            .world(location.world().dimension())
                            .map(ForgeServerWorld.class::cast)
                            .map(ForgeServerWorld::world);
            if (!serverLevel.isPresent()) return;
            entity.travelToDimension(serverLevel.get().provider.dimensionId);
        }
        entity.setPosition(location.x(), location.y(), location.z());
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
