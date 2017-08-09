package tiberianeclipse.item.tools;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemPickaxe;
import tiberianeclipse.Main;
import tiberianeclipse.util.IModelProvider;

public class BasePick extends ItemPickaxe implements IModelProvider {
    private String name;

    public BasePick(ToolMaterial material, String name) {
        super(material);
        this.setUnlocalizedName(name);
        this.setRegistryName(name);
        this.name = name;
    }

    public void registerItemModel(Item item, int meta) {
        Main.proxy.registerItemRenderer(this, 0, name);
    }

    @Override
    public BasePick setCreativeTab(CreativeTabs tab) {
        super.setCreativeTab(Main.creativeTab);
        return this;
    }
}
