/**
 * Copyright (c) 2024 Dylan Sperrer - dylan@sperrer.ca
 * The project is Licensed under <a href="https://github.com/p0t4t0sandwich/TaterLib/blob/dev/LICENSE">GPL-3</a>
 * The API is Licensed under <a href="https://github.com/p0t4t0sandwich/TaterLib/blob/dev/LICENSE-API">MIT</a>
 */


import dev.neuralnexus.taterapi.event.entity.EntityDamageEvent;
import dev.neuralnexus.taterapi.event.entity.EntityEvent;
import dev.neuralnexus.taterlib.b1_7_3.bukkit.event.entity.BukkitEntityEvent;

/** Bukkit implementation of {@link EntityDamageEvent}. */
public class BukkitEntityDamageEvent extends BukkitEntityEvent implements EntityDamageEvent  {
	public PluginLoader.DamageType damageType;
	public BaseEntity attacker;
	public BaseEntity defender;
	public int amount;
	public boolean canceled;

    public BukkitEntityDamageEvent(PluginLoader.DamageType type, BaseEntity attacker, BaseEntity defender, int amount) {
        damageType = type;
        this.attacker = attacker;
        this.defender = defender;
        this.amount = amount;
        canceled = false;
        event = null;
    }

    public boolean cancelled() {
        return canceled;
    }

    public void setCancelled(boolean cancelled) {
    	canceled = cancelled;
    }

    public String cause() {
        return damageType.name();
    }

    public double damage() {
        // Method is ambiguous, time to reflect!
        return amount;
    }
}
