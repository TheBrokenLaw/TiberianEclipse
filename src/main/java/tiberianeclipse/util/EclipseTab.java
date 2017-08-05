package tiberianeclipse.util;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import tiberianeclipse.Main;
import tiberianeclipse.item.ModItems;

public class EclipseTab extends CreativeTabs{
    public EclipseTab(){
        super(Main.modId);
        setBackgroundImageName("item_search.png");
    }

    @Override
    public Item getTabIconItem() {
        return ModItems.ripariusShard;
    }
    @Override
    public boolean hasSearchBar(){
        return true;
    }
}
