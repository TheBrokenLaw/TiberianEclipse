package tiberianeclipse.item.tools;

import com.google.common.collect.Sets;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemSpade;
import net.minecraft.item.ItemSword;
import tiberianeclipse.Main;
import tiberianeclipse.util.IModelProvider;

import java.util.Set;

public class BaseShovel extends ItemSpade implements IModelProvider {
    private String name;
    public BaseShovel(ToolMaterial material, String name) {
        super(material);
        this.setUnlocalizedName(name);
        this.setRegistryName(name);
        this.name = name;

    }

    public void registerItemModel(Item item, int meta) {
        Main.proxy.registerItemRenderer(this, 0, name);
    }

    @Override
    public BaseShovel setCreativeTab(CreativeTabs tab) {
        super.setCreativeTab(Main.creativeTab);
        return this;
    }
}
