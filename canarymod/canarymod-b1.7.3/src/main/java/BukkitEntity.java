/**
 * Copyright (c) 2024 Dylan Sperrer - dylan@sperrer.ca
 * The project is Licensed under <a href="https://github.com/p0t4t0sandwich/TaterLib/blob/dev/LICENSE">GPL-3</a>
 * The API is Licensed under <a href="https://github.com/p0t4t0sandwich/TaterLib/blob/dev/LICENSE-API">MIT</a>
 */


import dev.neuralnexus.taterapi.TaterAPIProvider;
import dev.neuralnexus.taterapi.resource.ResourceKey;
import dev.neuralnexus.taterapi.world.Location;

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
                "minecraft", OEntityList.b(entity.getEntity()).toLowerCase());
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
    	//taken from a1.2.6.1 recreation i made
    	//double temp = this.mc.theWorld.func_4075_a().getTemperatures(this.mc.theWorld.func_4075_a().temperature, (int)this.mc.thePlayer.posX, (int)this.mc.thePlayer.posZ, 1, 1)[0];
        //double humidity = this.mc.theWorld.func_4075_a().getHumidities(this.mc.theWorld.func_4075_a().temperature, (int)this.mc.thePlayer.posX, (int)this.mc.thePlayer.posZ, 1, 1)[0];
    	double temp = entity.getWorld().getWorld().a().a(entity.getWorld().getWorld().a().a, (int)entity.getX(), (int)entity.getZ(), 1, 1)[0];
    	double hum = (entity.getWorld().getWorld().a().a(entity.getWorld().getWorld().a().b, (int)entity.getX(), (int)entity.getZ(), 1, 1)[0]) * temp;
        return ResourceKey.of(OBiomeGenBase.a(temp, hum).n);
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
