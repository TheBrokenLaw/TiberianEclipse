package tiberianeclipse.util;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public interface StackSource {
    Item getItem();
    ItemStack stack(int i);

}
