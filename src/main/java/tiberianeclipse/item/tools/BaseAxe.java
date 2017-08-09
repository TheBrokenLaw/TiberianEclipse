package tiberianeclipse.item.tools;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemAxe;
import tiberianeclipse.Main;
import tiberianeclipse.util.IModelProvider;

public class BaseAxe extends AxeFix implements IModelProvider {
    private String name;

    public BaseAxe(ToolMaterial material, String name) {
        super(material);
        this.setUnlocalizedName(name);
        this.setRegistryName(name);
        this.name = name;
    }

    public void registerItemModel(Item item, int meta) {
        Main.proxy.registerItemRenderer(this, 0, name);
    }

    @Override
    public BaseAxe setCreativeTab(CreativeTabs tab) {
        super.setCreativeTab(Main.creativeTab);
        return this;
    }
}
