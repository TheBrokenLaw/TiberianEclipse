package tiberianeclipse.item.tools;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemSpade;
import net.minecraft.item.ItemSword;
import tiberianeclipse.Main;
import tiberianeclipse.util.IModelProvider;

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
