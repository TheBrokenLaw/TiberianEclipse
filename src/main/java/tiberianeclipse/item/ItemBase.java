package tiberianeclipse.item;

import net.minecraft.block.Block;
import tiberianeclipse.Main;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import tiberianeclipse.util.IModelProvider;

import javax.annotation.Nullable;
import java.util.Map;

public class ItemBase extends Item implements IModelProvider{

    protected String name;
    protected int meta;
    public ItemBase(String name, int meta) {
        this.name = name;
        this.meta=meta;
        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(Main.creativeTab);
    }
    @Override
    public void registerItemModel(Item item, int meta) {
        Main.proxy.registerItemRenderer(item, 0, name);
    }

    @Override
    public ItemBase setCreativeTab(CreativeTabs tab) {
        super.setCreativeTab(tab);
        return this;
    }
}