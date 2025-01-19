/**
 * Copyright (c) 2024 Dylan Sperrer - dylan@sperrer.ca
 * The project is Licensed under <a href="https://github.com/p0t4t0sandwich/TaterLib/blob/dev/LICENSE">GPL-3</a>
 * The API is Licensed under <a href="https://github.com/p0t4t0sandwich/TaterLib/blob/dev/LICENSE-API">MIT</a>
 */


import dev.neuralnexus.taterapi.event.entity.EntitySpawnEvent;
import dev.neuralnexus.taterapi.world.Location;
import dev.neuralnexus.taterlib.b1_7_3.bukkit.event.entity.BukkitEntityEvent;

/** Bukkit implementation of {@link EntitySpawnEvent}. */
public class BukkitEntitySpawnEvent extends BukkitEntityEvent implements EntitySpawnEvent {
    private final Mob event;
    boolean stop = false;

    public BukkitEntitySpawnEvent(Mob event) {
        //super(event);
        this.event = event;
    }

    @Override
    public boolean cancelled() {
        return stop;
    }

    @Override
    public void setCancelled(boolean cancelled) {
        stop = (cancelled);
    }

    @Override
    public Location location() {
        return new BukkitLocation(event.getX(), event.getY(), event.getX(), event.getPitch(), event.getRotation());
    }
}
