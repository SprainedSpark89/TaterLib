/**
 * Copyright (c) 2024 Dylan Sperrer - dylan@sperrer.ca
 * The project is Licensed under <a href="https://github.com/p0t4t0sandwich/TaterLib/blob/dev/LICENSE">GPL-3</a>
 * The API is Licensed under <a href="https://github.com/p0t4t0sandwich/TaterLib/blob/dev/LICENSE-API">MIT</a>
 */

package dev.neuralnexus.taterlib.v1_7_10.fabric.event.entity;

import dev.neuralnexus.taterapi.event.entity.EntityDamageEvent;

import net.minecraft.entity.Entity;
import net.minecraft.entity.damage.DamageSource;

import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

/** Fabric implementation of {@link EntityDamageEvent}. */
public class FabricEntityDamageEvent extends FabricEntityEvent implements EntityDamageEvent {
    private final DamageSource damageSource;
    private final float damage;
    private final CallbackInfo ci;

    public FabricEntityDamageEvent(
            Entity entity, DamageSource damageSource, float damage, CallbackInfo ci) {
        super(entity);
        this.damageSource = damageSource;
        this.damage = damage;
        this.ci = ci;
    }

    /** {@inheritDoc} */
    @Override
    public boolean cancelled() {
        return ci.isCancelled();
    }

    /** {@inheritDoc} */
    @Override
    public void setCancelled(boolean cancelled) {
        if (cancelled) {
            ci.cancel();
        }
    }

    /** {@inheritDoc} */
    @Override
    public String cause() {
        return damageSource.getName();
    }

    /** {@inheritDoc} */
    @Override
    public double damage() {
        return damage;
    }
}
