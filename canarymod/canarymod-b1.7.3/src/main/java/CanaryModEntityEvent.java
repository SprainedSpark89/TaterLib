/**
 * Copyright (c) 2024 Dylan Sperrer - dylan@sperrer.ca
 * The project is Licensed under <a href="https://github.com/p0t4t0sandwich/TaterLib/blob/dev/LICENSE">GPL-3</a>
 * The API is Licensed under <a href="https://github.com/p0t4t0sandwich/TaterLib/blob/dev/LICENSE-API">MIT</a>
 */


import dev.neuralnexus.taterapi.event.entity.EntityEvent;

/** CanaryMod implementation of {@link EntityEvent}. */
public class CanaryModEntityEvent {
	public PluginLoader.DamageType damageType;
	public BaseEntity attacker;
	public BaseEntity defender;
	public int amount;
	public boolean canceled;
    protected BaseEntity event;

    CanaryModEntityEvent(BaseEntity event) {
        this.event = event;
    }
    
    CanaryModEntityEvent() {
    	
    }
    
    CanaryModEntityEvent(PluginLoader.DamageType type, BaseEntity attacker, BaseEntity defender, int amount) {
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
