package tiberianeclipse.item.tools;

import net.minecraft.item.ItemSword;

public class ItemModSword extends ItemSword {
    public ItemModSword(String name, ToolMaterial material) {
        super(material);
        this.setUnlocalizedName(name);
    }

}