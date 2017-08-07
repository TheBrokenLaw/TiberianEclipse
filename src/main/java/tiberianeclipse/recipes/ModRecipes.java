package tiberianeclipse.recipes;

import com.sun.corba.se.spi.ior.ObjectKey;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import tiberianeclipse.block.ModBlocks;
import tiberianeclipse.item.ModItems;

public class ModRecipes{
    public static void init(){
        //Shards from clusters
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.ripariusShard, 3), ModItems.ripariusCluster);
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.viniferaShard, 3), ModItems.viniferaCluster);
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.cruentusShard, 3), ModItems.cruentusCluster);
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.arboreaShard, 3), ModItems.arboreaCluster);
        //Clusters from shards
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.ripariusCluster, 1), new Object[] {new ItemStack(ModItems.ripariusShard, 1), new ItemStack(ModItems.ripariusShard, 1), new ItemStack(ModItems.ripariusShard, 1)});
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.viniferaCluster, 1), new Object[] {new ItemStack(ModItems.viniferaShard, 1), new ItemStack(ModItems.viniferaShard, 1), new ItemStack(ModItems.viniferaShard, 1)});
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.cruentusCluster, 1), new Object[] {new ItemStack(ModItems.cruentusShard, 1), new ItemStack(ModItems.cruentusShard, 1), new ItemStack(ModItems.cruentusShard, 1)});
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.arboreaCluster, 1), new Object[] {new ItemStack(ModItems.arboreaShard, 1), new ItemStack(ModItems.arboreaShard, 1), new ItemStack(ModItems.arboreaShard, 1)});
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.ripVinCluster, 1), new Object[] {new ItemStack(ModItems.ripariusShard, 1), new ItemStack(ModItems.ripariusShard, 1), new ItemStack(ModItems.viniferaShard, 1)});
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.vinRipCluster, 1), new Object[] {new ItemStack(ModItems.viniferaShard, 1), new ItemStack(ModItems.viniferaShard, 1), new ItemStack(ModItems.ripariusShard, 1)});
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.vinCruCluster, 1), new Object[] {new ItemStack(ModItems.viniferaShard, 1), new ItemStack(ModItems.viniferaShard, 1), new ItemStack(ModItems.cruentusShard, 1)});
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.cruVinCluster, 1), new Object[] {new ItemStack(ModItems.cruentusShard, 1), new ItemStack(ModItems.cruentusShard, 1), new ItemStack(ModItems.viniferaShard, 1)});
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.cruArborCluster, 1), new Object[] {new ItemStack(ModItems.cruentusShard, 1), new ItemStack(ModItems.cruentusShard, 1), new ItemStack(ModItems.arboreaShard, 1)});
        GameRegistry.addShapelessRecipe(new ItemStack(ModItems.arborCruCluster, 1), new Object[] {new ItemStack(ModItems.arboreaShard, 1), new ItemStack(ModItems.arboreaShard, 1), new ItemStack(ModItems.cruentusShard, 1)});
        //Blocks
        //#DOES NOT WORK GameRegistry.addShapelessRecipe(new ItemStack(ModBlocks.refinedTiberiumBlock, 4),ModItems.refinedTiberium, 4);
        //Refining Tiberium Varieties
        GameRegistry.addSmelting(ModItems.ripariusShard, new ItemStack(ModItems.refinedTiberium), 0.7f);
        GameRegistry.addSmelting(ModItems.viniferaShard, new ItemStack(ModItems.refinedTiberium, 2), 0.8f);
        GameRegistry.addSmelting(ModItems.cruentusShard, new ItemStack(ModItems.refinedTiberium, 4), 0.9f);
        GameRegistry.addSmelting(ModItems.arboreaShard, new ItemStack(ModItems.refinedTiberium, 8), 1.0f);
        GameRegistry.addSmelting(ModItems.ripariusCluster, new ItemStack(ModItems.refinedTiberium, 4), 2.1f);
        GameRegistry.addSmelting(ModItems.viniferaCluster, new ItemStack(ModItems.refinedTiberium, 8), 2.4f);
        GameRegistry.addSmelting(ModItems.cruentusCluster, new ItemStack(ModItems.refinedTiberium, 16), 2.7f);
        GameRegistry.addSmelting(ModItems.arboreaCluster, new ItemStack(ModItems.refinedTiberium, 24), 3.4f);
        GameRegistry.addSmelting(ModItems.ripVinCluster, new ItemStack(ModItems.refinedTiberium, 5), 2.2f);
        GameRegistry.addSmelting(ModItems.vinRipCluster, new ItemStack(ModItems.refinedTiberium, 7), 2.3f);
        GameRegistry.addSmelting(ModItems.vinCruCluster, new ItemStack(ModItems.refinedTiberium,10), 2.5f);
        GameRegistry.addSmelting(ModItems.cruVinCluster, new ItemStack(ModItems.refinedTiberium,14), 2.6f);
        GameRegistry.addSmelting(ModItems.cruArborCluster, new ItemStack(ModItems.refinedTiberium, 18), 2.9f);
        GameRegistry.addSmelting(ModItems.arborCruCluster, new ItemStack(ModItems.refinedTiberium, 22), 3.0f);
        //Tools
            //Swords
        GameRegistry.addRecipe(new ItemStack(ModItems.ripariusBlade), new Object[] {" S ", " S ", " B ", 'S', ModItems.ripariusCluster, 'B', ModItems.refinedTiberium});
        GameRegistry.addRecipe(new ItemStack(ModItems.viniferaBlade),new Object[]{" S ", " S ", " B ", 'S', ModItems.viniferaCluster, 'B', ModItems.refinedTiberium});
        GameRegistry.addRecipe(new ItemStack(ModItems.cruentusBlade),new Object[]{" S ", " S ", " B ", 'S', ModItems.cruentusCluster, 'B', ModItems.refinedTiberium});
        GameRegistry.addRecipe(new ItemStack(ModItems.arboreaBlade), new Object[]{" S ", " S ", " B ", 'S', ModItems.arboreaCluster, 'B', ModItems.refinedTiberium});
    }


}
