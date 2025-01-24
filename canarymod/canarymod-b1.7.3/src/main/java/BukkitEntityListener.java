/**
 * Copyright (c) 2024 Dylan Sperrer - dylan@sperrer.ca
 * The project is Licensed under <a href="https://github.com/p0t4t0sandwich/TaterLib/blob/dev/LICENSE">GPL-3</a>
 * The API is Licensed under <a href="https://github.com/p0t4t0sandwich/TaterLib/blob/dev/LICENSE-API">MIT</a>
 */


import dev.neuralnexus.taterapi.event.api.EntityEvents;
import dev.neuralnexus.taterapi.event.api.PlayerEvents;
/** Listens for entity events. */
public class BukkitEntityListener extends PluginListener {
    /**
     * Called when an entity is damaged.
     *
     * @param event The event.
     */
	
	public boolean onDamage(PluginLoader.DamageType type, BaseEntity attacker, BaseEntity defender, int amount) {
		EntityEvents.DAMAGE.invoke(new BukkitEntityDamageEvent(type, attacker, defender, amount));
		return false;
    }

    //    /**
    //     * Called when an entity is damaged by an entity.
    //     * @param event The event.
    //     */
    //    @EventHandler
    //    public void onEntityDamageByEntity(EntityDamageByEntityEvent event) {
    //        EntityListener.onEntityDamageByEntity(new
    // BukkitEntityDamageEvent.DamageByEntity(event));
    //    }
    //
    //    /**
    //     * Called when an entity is damaged by a block.
    //     * @param event The event.
    //     */
    //    @EventHandler
    //    public void onEntityDamageByBlock(EntityDamageByBlockEvent event) {
    //        EntityListener.onEntityDamageByBlock(new
    // BukkitEntityDamageEvent.DamageByBlock(event));
    //    }

    /**
     * Called when an entity dies.
     *
     * @param event The event.
     */
    /*@Override
    public void onEntityDeath(EntityDeathEvent event) {
        EntityEvents.DEATH.invoke(new BukkitEntityDeathEvent(event));

        // Check if the entity is a player
        if (event.getEntity() instanceof Player) {
            PlayerEvents.DEATH.invoke(new BukkitPlayerDeathEvent(event));
        }
    }*/

    /**
     * Called when an entity spawns.
     *
     * @param event The event.
     */
    public boolean onMobSpawn(Mob mob) {
    	EntityEvents.SPAWN.invoke(new BukkitEntitySpawnEvent(mob));
        return false;
    }
}
