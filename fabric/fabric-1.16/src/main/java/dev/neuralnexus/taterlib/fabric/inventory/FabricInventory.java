package dev.neuralnexus.taterlib.fabric.inventory;

import dev.neuralnexus.taterlib.inventory.Inventory;
import dev.neuralnexus.taterlib.inventory.ItemStack;

import java.util.HashMap;
import java.util.Map;

/** Abstracts a Fabric inventory to an AbstractInventory. */
public class FabricInventory implements Inventory {
    private final net.minecraft.inventory.Inventory inventory;

    /**
     * Constructor.
     *
     * @param inventory The Fabric inventory.
     */
    public FabricInventory(net.minecraft.inventory.Inventory inventory) {
        this.inventory = inventory;
    }

    /** {@inheritDoc} */
    @Override
    public int size() {
        return inventory.size();
    }

    /** {@inheritDoc} */
    @Override
    public ItemStack item(int slot) {
        return new FabricItemStack(inventory.getStack(slot));
    }

    /** {@inheritDoc} */
    @Override
    public void setItem(int slot, ItemStack item) {
        inventory.setStack(slot, ((FabricItemStack) item).itemStack());
    }

    /** {@inheritDoc} */
    @Override
    public void addItem(ItemStack item) {
        for (int i = 0; i < size(); i++) {
            if (item(i).type().equals("minecraft:air")) {
                setItem(i, item);
                break;
            }
        }
    }

    /** {@inheritDoc} */
    @Override
    public void removeItem(ItemStack item) {
        for (int i = 0; i < size(); i++) {
            String itemName = item(i).type();
            if (itemName.equals(item.type())) {
                inventory.removeStack(i);
            }
        }
    }

    /** {@inheritDoc} */
    @Override
    public ItemStack[] contents() {
        int size = size();
        ItemStack[] contents = new ItemStack[size];
        for (int i = 0; i < size; i++) {
            contents[i] = item(i);
        }

        return contents;
    }

    /** {@inheritDoc} */
    @Override
    public void setContents(ItemStack[] item) {
        for (int i = 0; i < size(); i++) {
            setItem(i, item[i]);
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
    public void setStorageContents(ItemStack[] item) {
        for (int i = 0; i < size(); i++) {
            setItem(i, item[i]);
        }
    }

    /** {@inheritDoc} */
    @Override
    public boolean contains(ItemStack item) {
        for (int i = 0; i < size(); i++) {
            if (item(i).type().equals(item.type())) {
                return true;
            }
        }
        return false;
    }

    /** {@inheritDoc} */
    @Override
    public boolean contains(String type) {
        for (int i = 0; i < size(); i++) {
            if (item(i).type().equals(type)) {
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
    public boolean containsAtLeast(String type, int count) {
        int total = 0;
        for (int i = 0; i < size(); i++) {
            if (item(i).type().equals(type)) {
                total += item(i).count();
            }
        }
        return total >= count;
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
                inventory.removeStack(i);
            }
        }
    }

    /** {@inheritDoc} */
    @Override
    public void remove(String type) {
        for (int i = 0; i < size(); i++) {
            if (item(i).type().equals(type)) {
                inventory.removeStack(i);
            }
        }
    }

    /** {@inheritDoc} */
    @Override
    public void clear() {
        for (int i = 0; i < size(); i++) {
            inventory.removeStack(i);
        }
    }

    /** {@inheritDoc} */
    @Override
    public void clear(int slot) {
        inventory.removeStack(slot);
    }
}
