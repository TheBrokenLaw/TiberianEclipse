package tiberianeclipse.item.tools;

import net.minecraft.item.ItemStack;
import tiberianeclipse.item.ItemBase;

public class TibHammer extends ItemBase {
    public TibHammer(){
        super("tibHammer", 0);
        this.setMaxStackSize(1);

    }
    @Override
    public boolean hasContainerItem(){
        return true;
    }
    @Override
    public ItemStack getContainerItem(ItemStack itemStack){
        return itemStack;
    }

    public boolean doesContainerItemLeaveCraftingGrid(ItemStack par1itemstack){
        return false;
    }
}
