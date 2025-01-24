/**
 * Copyright (c) 2024 Dylan Sperrer - dylan@sperrer.ca
 * The project is Licensed under <a href="https://github.com/p0t4t0sandwich/TaterLib/blob/dev/LICENSE">GPL-3</a>
 * The API is Licensed under <a href="https://github.com/p0t4t0sandwich/TaterLib/blob/dev/LICENSE-API">MIT</a>
 */


import dev.neuralnexus.taterapi.entity.Entity;
import dev.neuralnexus.taterapi.event.entity.EntityEvent;

/** Bukkit implementation of {@link EntityEvent}. */
public class BukkitEntityEvent {
	public PluginLoader.DamageType damageType;
	public BaseEntity attacker;
	public BaseEntity defender;
	public int amount;
	public boolean canceled;
    protected BaseEntity event;

    BukkitEntityEvent(BaseEntity event) {
        this.event = event;
    }
    
    BukkitEntityEvent() {
    	
    }
    
    BukkitEntityEvent(PluginLoader.DamageType type, BaseEntity attacker, BaseEntity defender, int amount) {
    	damageType = type;
        this.attacker = attacker;
        this.defender = defender;
        this.amount = amount;
        canceled = false;
        event = null;
    }
    
    public BaseEntity entity() {
        return event;
    }
}
