package tiberianeclipse.item;

import tiberianeclipse.Main;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import tiberianeclipse.util.IModelProvider;

public class ItemBase extends Item implements IModelProvider{

    protected String name;

    public ItemBase(String name) {
        this.name = name;
        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(Main.creativeTab);
    }
    @Override
    public void registerItemModel(Item item) {
        Main.proxy.registerItemRenderer(item, 0, name);
    }

    @Override
    public ItemBase setCreativeTab(CreativeTabs tab) {
        super.setCreativeTab(tab);
        return this;
    }

}