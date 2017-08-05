package tiberianeclipse.block;

import net.minecraft.block.material.Material;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import tiberianeclipse.Main;
import tiberianeclipse.util.IModelProvider;

public class BlockBase extends Block implements IModelProvider{
    protected String name;
    public BlockBase(Material material, String name){
        super(material);
        this.name=name;
        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(Main.creativeTab);
    }
    @Override
    public void registerItemModel(Item item){
        Main.proxy.registerItemRenderer(item, 0, name);
    }
    @Override
    public BlockBase setCreativeTab(CreativeTabs tab){
        super.setCreativeTab(tab);
        return this;
    }
}
