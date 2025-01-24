/**
 * Copyright (c) 2024 Dylan Sperrer - dylan@sperrer.ca
 * The project is Licensed under <a href="https://github.com/p0t4t0sandwich/TaterLib/blob/dev/LICENSE">GPL-3</a>
 * The API is Licensed under <a href="https://github.com/p0t4t0sandwich/TaterLib/blob/dev/LICENSE-API">MIT</a>
 */

import dev.neuralnexus.taterapi.resource.ResourceKey;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/** CanaryMod implementation of {@link Inventory}. */
public class CanaryModInventory implements dev.neuralnexus.taterapi.item.inventory.Inventory {
    private final Inventory inventory;

    /**
     * Constructor.
     *
     * @param inventory The CanaryMod inventory.
     */
    public CanaryModInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    @Override
    public int size() {
        return inventory.getContentsSize();
    }

    @Override
    public dev.neuralnexus.taterapi.item.inventory.ItemStack get(int slot) {
        return inventory.getItemFromId(slot) == null
                ? null
                : new CanaryModItemStack(inventory.getItemFromId(slot));
    }

    @Override
    public void set(int slot, dev.neuralnexus.taterapi.item.inventory.ItemStack item) {
        inventory.setSlot(((CanaryModItemStack) item).itemStack(), slot);
    }

    @Override
    public void add(dev.neuralnexus.taterapi.item.inventory.ItemStack item) {
        inventory.addItem(((CanaryModItemStack) item).itemStack());
    }

    @Override
    public List<dev.neuralnexus.taterapi.item.inventory.ItemStack> contents() {
        return Arrays.stream(inventory.getContents())
                .map(item -> item == null ? null : new CanaryModItemStack(item))
                .collect(Collectors.toList());
    }

    @Override
    public void setContents(List<dev.neuralnexus.taterapi.item.inventory.ItemStack> items) {
        inventory.setContents(
                items.stream()
                        .map(item -> item == null ? null : ((CanaryModItemStack) item).itemStack())
                        .toArray(Item[]::new));
    }

    @Override
    public void remove(ResourceKey type) {
        
    }

    @Override
    public void clear(int slot) {
        inventory.removeItem(slot);
    }
}
