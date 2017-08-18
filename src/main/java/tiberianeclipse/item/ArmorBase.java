package tiberianeclipse.item;

import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraftforge.common.util.EnumHelper;
import tiberianeclipse.Main;
import tiberianeclipse.util.IModelProvider;

public class ArmorBase extends ItemBase implements IModelProvider {
    public String name;

    public ArmorBase(String name) {
        super(name, 0);
        this.name = name;
    }

    public static ItemArmor.ArmorMaterial basic = EnumHelper.addArmorMaterial("BASIC", "tiberianeclipse:basicArmor", 60, new int[]{10, 12, 10, 8}, 8, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 0.0f);

    @Override
    public void registerItemModel(Item item, int meta) {
        Main.proxy.registerItemRenderer(item, 0, name);
    }
}
