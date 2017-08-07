package tiberianeclipse.item.tools;

import net.minecraft.item.Item;
import net.minecraftforge.common.util.EnumHelper;
import tiberianeclipse.item.ItemBase;

public class BaseTool{
    public static Item.ToolMaterial refinedTibMaterial= EnumHelper.addToolMaterial("RefTib", 2,650,10,4,10);
    public static Item.ToolMaterial riparius= EnumHelper.addToolMaterial("Riparius", 2,250,12,6,8);
    public static Item.ToolMaterial vinifera= EnumHelper.addToolMaterial("Vinifera", 3,250,14,4,12);
    public static Item.ToolMaterial cruentus= EnumHelper.addToolMaterial("Cruentus", 4,250,16,4,16);
    public static Item.ToolMaterial arborea= EnumHelper.addToolMaterial("Arborea", 15,250,18,4,24);


}
