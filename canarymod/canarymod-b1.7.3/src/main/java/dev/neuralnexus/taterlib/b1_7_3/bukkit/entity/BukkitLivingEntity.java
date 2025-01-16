/**
 * Copyright (c) 2024 Dylan Sperrer - dylan@sperrer.ca
 * The project is Licensed under <a href="https://github.com/p0t4t0sandwich/TaterLib/blob/dev/LICENSE">GPL-3</a>
 * The API is Licensed under <a href="https://github.com/p0t4t0sandwich/TaterLib/blob/dev/LICENSE-API">MIT</a>
 */
package dev.neuralnexus.taterlib.b1_7_3.bukkit.entity;

import dev.neuralnexus.taterapi.entity.Entity;
import dev.neuralnexus.taterapi.entity.LivingEntity;
import dev.neuralnexus.taterapi.exceptions.VersionFeatureNotSupportedException;

/** Bukkit implementation of {@link LivingEntity}. */
public class BukkitLivingEntity extends BukkitEntity implements LivingEntity {
    private final org.bukkit.entity.LivingEntity entity;

    /**
     * Constructor.
     *
     * @param entity The Bukkit entity.
     */
    public BukkitLivingEntity(org.bukkit.entity.LivingEntity entity) {
        super(entity);
        this.entity = entity;
    }

    @Override
    public void damage(double amount) {
        entity.damage((int) amount);
    }

    @Override
    public void damage(double amount, Entity source) {
        entity.damage((int) amount, ((BukkitEntity) source).entity());
    }

    @Override
    public double health() {
        return entity.getHealth();
    }

    @Override
    public void setHealth(double health) {
        entity.setHealth((int) health);
    }

    @Override
    public double absorptionAmount() {
        throw new VersionFeatureNotSupportedException();
    }

    @Override
    public void setAbsorptionAmount(double amount) {
        throw new VersionFeatureNotSupportedException();
    }

    @Override
    public double maxHealth() {
        // TODO: Check if there's a workaround for b1.7.3
        throw new VersionFeatureNotSupportedException();
    }

    @Override
    public void setMaxHealth(double health) {
        // TODO: Check if there's a workaround for b1.7.3
        throw new VersionFeatureNotSupportedException();
    }
}
