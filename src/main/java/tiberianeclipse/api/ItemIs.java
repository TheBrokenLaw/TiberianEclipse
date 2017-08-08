package tiberianeclipse.api;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import javax.annotation.Nonnull;
import java.util.Optional;

public interface ItemIs extends WhatIs {
    @Nonnull
    String identifier();
    Optional<Item> maybeItem();
    Optional<ItemStack> maybeStack(int stackSize );
    boolean isEnabled();
}
