package tiberianeclipse.recipes;

import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import tiberianeclipse.item.ModItems;

public class ModRecipes{
    public static void init(){
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.ripariusShard), ModItems.ripariusCluster);
    }


}
