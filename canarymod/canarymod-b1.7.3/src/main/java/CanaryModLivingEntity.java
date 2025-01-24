/**
 * Copyright (c) 2024 Dylan Sperrer - dylan@sperrer.ca
 * The project is Licensed under <a href="https://github.com/p0t4t0sandwich/TaterLib/blob/dev/LICENSE">GPL-3</a>
 * The API is Licensed under <a href="https://github.com/p0t4t0sandwich/TaterLib/blob/dev/LICENSE-API">MIT</a>
 */


import dev.neuralnexus.taterapi.entity.Entity;
import dev.neuralnexus.taterapi.exceptions.VersionFeatureNotSupportedException;

/** CanaryMod implementation of {@link LivingEntity}. */
public class CanaryModLivingEntity extends CanaryModEntity implements dev.neuralnexus.taterapi.entity.LivingEntity {
    private final LivingEntity entity;

    /**
     * Constructor.
     *
     * @param entity The CanaryMod entity.
     */
    public CanaryModLivingEntity(LivingEntity entity) {
        super(entity);
        this.entity = entity;
    }

    @Override
    public void damage(double amount) {
        entity.increaseHealth((int) -amount);
    }

    @Override
    public void damage(double amount, Entity source) {
    	entity.increaseHealth((int) -amount);
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
