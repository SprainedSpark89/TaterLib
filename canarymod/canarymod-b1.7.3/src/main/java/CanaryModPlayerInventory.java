/**
 * Copyright (c) 2024 Dylan Sperrer - dylan@sperrer.ca
 * The project is Licensed under <a href="https://github.com/p0t4t0sandwich/TaterLib/blob/dev/LICENSE">GPL-3</a>
 * The API is Licensed under <a href="https://github.com/p0t4t0sandwich/TaterLib/blob/dev/LICENSE-API">MIT</a>
 */


import dev.neuralnexus.taterapi.exceptions.VersionFeatureNotSupportedException;
import dev.neuralnexus.taterapi.item.inventory.ItemStack;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/** CanaryMod implementation of {@link PlayerInventory}. */
public class CanaryModPlayerInventory extends CanaryModInventory {
    public final PlayerInventory playerInventory;

    /**
     * Constructor.
     *
     * @param playerInventory The CanaryMod player inventory.
     */
    public CanaryModPlayerInventory(PlayerInventory playerInventory) {
        super(playerInventory);
        this.playerInventory = playerInventory;
    }

    
    public List<ItemStack> armor() {
        return Arrays.stream(playerInventory.getContents())
                .map(CanaryModItemStack::new)
                .collect(Collectors.toList());
    }

    public void setArmor(List<Item> armor) {
        playerInventory.setContents(
                (Item[]) armor.toArray());
    }

    
    public ItemStack offhand() {
        throw new VersionFeatureNotSupportedException();
    }

    
    public void setOffhand(ItemStack offhand) {
        throw new VersionFeatureNotSupportedException();
    }

    
    public int selectedSlot() {
        return playerInventory.getPlayer().getItemInHand();
    }
}
