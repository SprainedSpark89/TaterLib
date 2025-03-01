/**
 * Copyright (c) 2024 Dylan Sperrer - dylan@sperrer.ca
 * The project is Licensed under <a href="https://github.com/p0t4t0sandwich/TaterLib/blob/dev/LICENSE">GPL-3</a>
 * The API is Licensed under <a href="https://github.com/p0t4t0sandwich/TaterLib/blob/dev/LICENSE-API">MIT</a>
 */
/*
package dev.neuralnexus.taterlib.b1_7_3.CanaryMod.event.player;

import dev.neuralnexus.taterapi.entity.player.Player;
import dev.neuralnexus.taterapi.event.player.PlayerDeathEvent;
import dev.neuralnexus.taterlib.b1_7_3.CanaryMod.event.entity.CanaryModEntityDeathEvent;

import org.CanaryMod.event.entity.EntityDeathEvent;

import CanaryModPlayer;

/** CanaryMod implementation of {@link PlayerDeathEvent}. */
/*
public class CanaryModPlayerDeathEvent extends CanaryModEntityDeathEvent implements PlayerDeathEvent {
    private final EntityDeathEvent event;
    private String deathMessage = "";

    public CanaryModPlayerDeathEvent(EntityDeathEvent event) {
        super(event);
        this.event = event;
    }

    @Override
    public Player player() {
        return new CanaryModPlayer((org.CanaryMod.entity.Player) event.getEntity());
    }

    @Override
    public String deathMessage() {
        if (!deathMessage.isEmpty()) {
            return deathMessage;
        }
        return player().name() + " died";
    }

    @Override
    public void setDeathMessage(String deathMessage) {
        this.deathMessage = deathMessage;
    }

    @Override
    public boolean keepInventory() {
        return false;
    }

    @Override
    public void setKeepInventory(boolean keepInventory) {}
}
*/