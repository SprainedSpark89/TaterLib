/**
 * Copyright (c) 2024 Dylan Sperrer - dylan@sperrer.ca
 * The project is Licensed under <a href="https://github.com/p0t4t0sandwich/TaterLib/blob/dev/LICENSE">GPL-3</a>
 * The API is Licensed under <a href="https://github.com/p0t4t0sandwich/TaterLib/blob/dev/LICENSE-API">MIT</a>
 */


import dev.neuralnexus.taterapi.exceptions.VersionFeatureNotSupportedException;
import dev.neuralnexus.taterapi.resource.ResourceKey;

import java.util.List;
import java.util.Optional;

/** Abstracts a CanaryMod item stack to an AbstractItemStack. */
public class CanaryModItemStack implements dev.neuralnexus.taterapi.item.inventory.ItemStack {
    private final Item itemStack;

    /**
     * Constructor.
     *
     * @param itemStack The CanaryMod item stack.
     */
    public CanaryModItemStack(Item itemStack) {
        this.itemStack =
                itemStack == null ? new Item(Item.Type.Air) : itemStack;
    }

    /**
     * Getter for the CanaryMod item stack.
     *
     * @return The CanaryMod item stack.
     */
    public Item itemStack() {
        return itemStack;
    }

    @Override
    public ResourceKey type() {
        return ResourceKey.of("minecraft", itemStack.getType().name().toLowerCase());
    }

    @Override
    public int count() {
        return itemStack.getAmount();
    }

    @Override
    public void setCount(int count) {
        itemStack.setAmount(count);
    }

    @Override
    public dev.neuralnexus.taterapi.item.inventory.ItemStack clone() {
        return new CanaryModItemStack(itemStack);
    }

    @Override
    public boolean hasDisplayName() {
        throw new VersionFeatureNotSupportedException();
    }

    @Override
    public Optional<String> displayName() {
        throw new VersionFeatureNotSupportedException();
    }

    @Override
    public void setDisplayName(String name) {
        throw new VersionFeatureNotSupportedException();
    }

    @Override
    public boolean hasLore() {
        throw new VersionFeatureNotSupportedException();
    }

    @Override
    public List<String> lore() {
        throw new VersionFeatureNotSupportedException();
    }

    @Override
    public void setLore(List<String> lore) {
        throw new VersionFeatureNotSupportedException();
    }

    @Override
    public boolean hasEnchants() {
        throw new VersionFeatureNotSupportedException();
    }

    @Override
    public boolean unbreakable() {
        // TODO: Planned internal module covering this functionality
        throw new VersionFeatureNotSupportedException();
    }

    @Override
    public void setUnbreakable(boolean unbreakable) {
        // TODO: Planned internal module covering this functionality
        throw new VersionFeatureNotSupportedException();
    }
}
