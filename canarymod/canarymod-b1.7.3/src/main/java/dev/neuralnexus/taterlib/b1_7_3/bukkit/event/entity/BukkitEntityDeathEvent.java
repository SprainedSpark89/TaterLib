/*
/**
 * Copyright (c) 2024 Dylan Sperrer - dylan@sperrer.ca
 * The project is Licensed under <a href="https://github.com/p0t4t0sandwich/TaterLib/blob/dev/LICENSE">GPL-3</a>
 * The API is Licensed under <a href="https://github.com/p0t4t0sandwich/TaterLib/blob/dev/LICENSE-API">MIT</a>
 */
/*
package dev.neuralnexus.taterlib.b1_7_3.CanaryMod.event.entity;

import dev.neuralnexus.taterapi.event.entity.EntityDeathEvent;
import dev.neuralnexus.taterapi.item.inventory.ItemStack;
import dev.neuralnexus.taterlib.b1_7_3.CanaryMod.item.inventory.CanaryModItemStack;

import java.util.List;
import java.util.stream.Collectors;

import CanaryModEntityEvent;

/** CanaryMod implementation of {@link EntityDeathEvent}. */
/*
public class CanaryModEntityDeathEvent extends CanaryModEntityEvent implements EntityDeathEvent {
    private final org.CanaryMod.event.entity.EntityDeathEvent event;

    public CanaryModEntityDeathEvent(org.CanaryMod.event.entity.EntityDeathEvent event) {
        super(event);
        this.event = event;
    }

    @Override
    public List<ItemStack> drops() {
        return event.getDrops().stream().map(CanaryModItemStack::new).collect(Collectors.toList());
    }

    @Override
    public void setDrops(List<ItemStack> drops) {
        event.getDrops().clear();
        List<org.CanaryMod.inventory.ItemStack> eventDrops = event.getDrops();
        drops.forEach(item -> eventDrops.add(((CanaryModItemStack) item).itemStack()));
    }

    @Override
    public void clearDrops() {
        event.getDrops().clear();
    }

    @Override
    public int droppedExp() {
        return 0;
    }

    @Override
    public void setDroppedExp(int exp) {}
}
*/
