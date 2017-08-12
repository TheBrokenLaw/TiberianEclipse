package tiberianeclipse.item;

import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import tiberianeclipse.Main;

public class ModArmor extends ItemArmor {
    private String name;
    public ModArmor(String name,ArmorMaterial material, EntityEquipmentSlot slot){
        super(material, 0, slot);
        setRegistryName(name);
        setUnlocalizedName(name);
        this.name=name;
        setCreativeTab(Main.creativeTab);
    }


    public void registerItemModel(Item item, int meta) {
        Main.proxy.registerItemRenderer(item, 0, name);
    }
    }

