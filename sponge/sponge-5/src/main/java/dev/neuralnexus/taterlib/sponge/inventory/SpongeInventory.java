package dev.neuralnexus.taterlib.sponge.inventory;

import dev.neuralnexus.taterlib.inventory.Inventory;
import dev.neuralnexus.taterlib.inventory.ItemStack;

import java.util.HashMap;
import java.util.Map;

/** Abstracts a Sponge inventory to an AbstractInventory. */
public class SpongeInventory implements Inventory {
    private final org.spongepowered.api.item.inventory.Inventory inventory;

    /**
     * Constructor.
     *
     * @param inventory The Sponge inventory.
     */
    public SpongeInventory(org.spongepowered.api.item.inventory.Inventory inventory) {
        this.inventory = inventory;
    }

    /** {@inheritDoc} */
    @Override
    public int size() {
        return inventory.capacity();
    }

    /** {@inheritDoc} */
    @Override
    public ItemStack item(int slot) {
        if (!inventory.peek(slot).isPresent()) {
            return null;
        }
        return new SpongeItemStack(inventory.peek(slot).get());
    }

    /** {@inheritDoc} */
    @Override
    public void setItem(int slot, ItemStack item) {
        if (inventory.peek(slot).isPresent()) {
            inventory
                    .peek(slot)
                    .get()
                    .setRawData(((SpongeItemStack) item).itemStack().toContainer());
        } else {
            inventory.set(((SpongeItemStack) item).itemStack());
        }
    }

    /** {@inheritDoc} */
    @Override
    public void addItem(ItemStack item) {
        inventory.offer(((SpongeItemStack) item).itemStack());
    }

    /** {@inheritDoc} */
    @Override
    public void removeItem(ItemStack item) {
        if (inventory.contains(((SpongeItemStack) item).itemStack())) {
            for (int i = 0; i < size(); i++) {
                if (item(i).equals(item)) {
                    setItem(i, null);
                    break;
                }
            }
        }
    }

    /** {@inheritDoc} */
    @Override
    public ItemStack[] contents() {
        ItemStack[] contents = new ItemStack[size()];
        for (int i = 0; i < size(); i++) {
            contents[i] = item(i);
        }
        return contents;
    }

    /** {@inheritDoc} */
    @Override
    public void setContents(ItemStack[] items) {
        for (int i = 0; i < size(); i++) {
            setItem(i, items[i]);
        }
    }

    /** {@inheritDoc} */
    @Override
    public ItemStack[] storageContents() {
        ItemStack[] contents = new ItemStack[size()];
        for (int i = 0; i < size(); i++) {
            contents[i] = item(i);
        }

        return contents;
    }

    /** {@inheritDoc} */
    @Override
    public void setStorageContents(ItemStack[] items) {
        for (int i = 0; i < size(); i++) {
            setItem(i, items[i]);
        }
    }

    /** {@inheritDoc} */
    @Override
    public boolean contains(ItemStack item) {
        return inventory.contains(((SpongeItemStack) item).itemStack());
    }

    /** {@inheritDoc} */
    @Override
    public boolean contains(String type) {
        for (ItemStack item : contents()) {
            if (item.type().equals(type)) {
                return true;
            }
        }
        return false;
    }

    /** {@inheritDoc} */
    @Override
    public boolean containsAtLeast(ItemStack item, int amount) {
        int total = 0;
        for (int i = 0; i < size(); i++) {
            if (item(i).type().equals(item.type())) {
                total += item(i).count();
            }
        }
        return total >= amount;
    }

    /** {@inheritDoc} */
    @Override
    public boolean containsAtLeast(String type, int amount) {
        int total = 0;
        for (int i = 0; i < size(); i++) {
            if (item(i).type().equals(type)) {
                total += item(i).count();
            }
        }
        return total >= amount;
    }

    /** {@inheritDoc} */
    @Override
    public Map<Integer, ItemStack> all(ItemStack item) {
        Map<Integer, ItemStack> map = new HashMap<>();
        for (int i = 0; i < size(); i++) {
            if (item(i).type().equals(item.type())) {
                map.put(i, item(i));
            }
        }
        return map;
    }

    /** {@inheritDoc} */
    @Override
    public int first(ItemStack item) {
        for (int i = 0; i < size(); i++) {
            if (item(i).type().equals(item.type())) {
                return i;
            }
        }
        return -1;
    }

    /** {@inheritDoc} */
    @Override
    public int first(String type) {
        for (int i = 0; i < size(); i++) {
            if (item(i).type().equals(type)) {
                return i;
            }
        }
        return -1;
    }

    /** {@inheritDoc} */
    @Override
    public int firstEmpty() {
        for (int i = 0; i < size(); i++) {
            if (item(i).type().equals("minecraft:air")) {
                return i;
            }
        }
        return -1;
    }

    /** {@inheritDoc} */
    @Override
    public void remove(ItemStack item) {
        for (int i = 0; i < size(); i++) {
            if (item(i).type().equals(item.type())) {
                if (inventory.peek(i).isPresent()) {
                    inventory.peek(i).get().setQuantity(0);
                }
            }
        }
    }

    /** {@inheritDoc} */
    @Override
    public void remove(String type) {
        for (int i = 0; i < size(); i++) {
            if (item(i).type().equals(type)) {
                if (inventory.peek(i).isPresent()) {
                    inventory.peek(i).get().setQuantity(0);
                }
            }
        }
    }

    /** {@inheritDoc} */
    @Override
    public void clear() {
        inventory.clear();
    }

    /** {@inheritDoc} */
    @Override
    public void clear(int slot) {
        if (inventory.peek(slot).isPresent()) {
            inventory.peek(slot).get().setQuantity(0);
        }
    }
}
