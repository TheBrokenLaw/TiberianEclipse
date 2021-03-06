package tiberianeclipse.recipes;

import com.sun.corba.se.spi.ior.ObjectKey;
import net.minecraft.init.Blocks;
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
        GameRegistry.addShapelessRecipe(new ItemStack(ModBlocks.refinedTiberiumBlock, 1),new Object[]{new ItemStack(ModItems.refinedTiberium,3),new ItemStack(ModItems.refinedTiberium,3),new ItemStack(ModItems.refinedTiberium,3),new ItemStack(ModItems.refinedTiberium,3)});
        //Refining Tiberium Varieties
        GameRegistry.addSmelting(ModItems.ripariusShard, new ItemStack(ModItems.refinedTiberium), 0.7f);
        GameRegistry.addSmelting(ModItems.viniferaShard, new ItemStack(ModItems.refinedTiberium, 2), 0.8f);
        GameRegistry.addSmelting(ModItems.cruentusShard, new ItemStack(ModItems.refinedTiberium, 4), 0.9f);
        GameRegistry.addSmelting(ModItems.arboreaShard, new ItemStack(ModItems.refinedTiberium, 8), 1.0f);
        GameRegistry.addSmelting(ModItems.ripariusCluster, new ItemStack(ModItems.refinedTiberium, 3), 2.1f);
        GameRegistry.addSmelting(ModItems.viniferaCluster, new ItemStack(ModItems.refinedTiberium, 6), 2.4f);
        GameRegistry.addSmelting(ModItems.cruentusCluster, new ItemStack(ModItems.refinedTiberium, 12), 2.7f);
        GameRegistry.addSmelting(ModItems.arboreaCluster, new ItemStack(ModItems.refinedTiberium, 24), 3.4f);
        GameRegistry.addSmelting(ModItems.ripVinCluster, new ItemStack(ModItems.refinedTiberium, 4), 2.2f);
        GameRegistry.addSmelting(ModItems.vinRipCluster, new ItemStack(ModItems.refinedTiberium, 5), 2.3f);
        GameRegistry.addSmelting(ModItems.vinCruCluster, new ItemStack(ModItems.refinedTiberium,8), 2.5f);
        GameRegistry.addSmelting(ModItems.cruVinCluster, new ItemStack(ModItems.refinedTiberium,10), 2.6f);
        GameRegistry.addSmelting(ModItems.cruArborCluster, new ItemStack(ModItems.refinedTiberium, 16), 2.9f);
        GameRegistry.addSmelting(ModItems.arborCruCluster, new ItemStack(ModItems.refinedTiberium, 20), 3.0f);
        GameRegistry.addSmelting(ModItems.ripDustedIron, new ItemStack(Items.IRON_INGOT,2),.02f);
        GameRegistry.addSmelting(ModItems.ripDustedGold, new ItemStack(Items.GOLD_INGOT,2),.04f);
        GameRegistry.addSmelting(ModItems.vinDustedIron, new ItemStack(Items.IRON_INGOT,4),.02f);
        GameRegistry.addSmelting(ModItems.vinDustedGold, new ItemStack(Items.GOLD_INGOT,4),.04f);
        GameRegistry.addSmelting(ModItems.cruDustedIron, new ItemStack(Items.IRON_INGOT,8),.02f);
        GameRegistry.addSmelting(ModItems.cruDustedGold, new ItemStack(Items.GOLD_INGOT,8),.04f);
        GameRegistry.addSmelting(ModItems.arbDustedIron, new ItemStack(Items.IRON_INGOT,16),.02f);
        GameRegistry.addSmelting(ModItems.arbDustedGold, new ItemStack(Items.GOLD_INGOT,16),.04f);
        //Tools
        GameRegistry.addRecipe(new ItemStack(ModItems.tibHammer),new Object[]{" BR"," RB","R  ",'R', ModItems.refinedTibRod, 'B', ModItems.refinedTiberium});
            //Swords
        GameRegistry.addRecipe(new ItemStack(ModItems.ripariusBlade), new Object[] {" S ", " S ", " B ", 'S', ModItems.ripariusCluster, 'B', ModItems.refinedTiberium});
        GameRegistry.addRecipe(new ItemStack(ModItems.viniferaBlade),new Object[]{" S ", " S ", " B ", 'S', ModItems.viniferaCluster, 'B', ModItems.refinedTiberium});
        GameRegistry.addRecipe(new ItemStack(ModItems.cruentusBlade),new Object[]{" S ", " S ", " B ", 'S', ModItems.cruentusCluster, 'B', ModItems.refinedTiberium});
        GameRegistry.addRecipe(new ItemStack(ModItems.arboreaBlade), new Object[]{" S ", " S ", " B ", 'S', ModItems.arboreaCluster, 'B', ModItems.refinedTiberium});
            //Picks

            //Shovels
            //Axes
        //Misc
        GameRegistry.addShapedRecipe(new ItemStack(ModBlocks.tibProcessor),new Object[]{"CBC","BFB","CBC",'C', Blocks.COBBLESTONE,'F',Blocks.FURNACE,'B',ModBlocks.refinedTiberiumBlock});
        GameRegistry.addShapedRecipe(new ItemStack(ModItems.refinedTibRod), new Object[]{"  R"," R ","R  ", 'R', ModItems.refinedTiberium});
        GameRegistry.addShapedRecipe(new ItemStack(ModItems.refTibSword), new Object[]{" R "," R "," B ", 'R', ModItems.refinedTiberium,'B',ModItems.refinedTibRod});
        GameRegistry.addShapedRecipe(new ItemStack(ModItems.refTibPick), new Object[]{"RRR"," B "," B ", 'R', ModItems.refinedTiberium,'B',ModItems.refinedTibRod});
        GameRegistry.addShapedRecipe(new ItemStack(ModItems.refTibAxe), new Object[]{"RR ","RB "," B ", 'R', ModItems.refinedTiberium,'B',ModItems.refinedTibRod});
        GameRegistry.addShapedRecipe(new ItemStack(ModItems.basicChest), new Object[]{"R R","RBR","RRR", 'R', ModItems.refinedTiberium,'B',Items.IRON_INGOT});
        GameRegistry.addShapedRecipe(new ItemStack(ModItems.basicFeet), new Object[]{"R R","R R","   ", 'R', ModItems.refinedTiberium});
        GameRegistry.addShapedRecipe(new ItemStack(ModItems.basicHelm), new Object[]{"RBR","R R","   ", 'R', ModItems.refinedTiberium,'B',Items.IRON_INGOT});
        GameRegistry.addShapedRecipe(new ItemStack(ModItems.basicLegs), new Object[]{"RBR","R R","R R", 'R', ModItems.refinedTiberium,'B',Items.IRON_INGOT});
        GameRegistry.addShapedRecipe(new ItemStack(ModItems.refTibShovel), new Object[]{" R "," B "," B ", 'R', ModItems.refinedTiberium,'B',ModItems.refinedTibRod});
        GameRegistry.addShapedRecipe(new ItemStack(ModItems.crushedRiparius, 1), new Object[] {" H "," S "," B ",'H', ModItems.tibHammer.setContainerItem(ModItems.tibHammer),'S', ModItems.ripariusShard, 'B', ModItems.refinedTiberium});
        GameRegistry.addShapedRecipe(new ItemStack(ModItems.crushedVinifera, 1), new Object[] {" H "," S "," B ",'H', ModItems.tibHammer.setContainerItem(ModItems.tibHammer),'S', ModItems.viniferaShard, 'B', ModItems.refinedTiberium});
        GameRegistry.addShapedRecipe(new ItemStack(ModItems.crushedCruentus, 1), new Object[] {" H "," S "," B ",'H', ModItems.tibHammer.setContainerItem(ModItems.tibHammer),'S', ModItems.cruentusShard, 'B', ModItems.refinedTiberium});
        GameRegistry.addShapedRecipe(new ItemStack(ModItems.crushedArborea, 1), new Object[] {" H "," S "," B ",'H', ModItems.tibHammer.setContainerItem(ModItems.tibHammer),'S', ModItems.arboreaShard, 'B', ModItems.refinedTiberium});
        GameRegistry.addShapedRecipe(new ItemStack(ModItems.ripDustedIron,1),new Object[]{" D ","DID"," D ",'D',ModItems.crushedRiparius,'I',Items.IRON_INGOT});
        GameRegistry.addShapedRecipe(new ItemStack(ModItems.ripDustedGold,1),new Object[]{"DDD","DID","DDD",'D',ModItems.crushedRiparius,'I',Items.GOLD_INGOT});
        GameRegistry.addShapedRecipe(new ItemStack(ModItems.vinDustedIron,1),new Object[]{" D ","DID"," D ",'D',ModItems.crushedVinifera,'I',Items.IRON_INGOT});
        GameRegistry.addShapedRecipe(new ItemStack(ModItems.vinDustedGold,1),new Object[]{"DDD","DID","DDD",'D',ModItems.crushedVinifera,'I',Items.GOLD_INGOT});
        GameRegistry.addShapedRecipe(new ItemStack(ModItems.cruDustedIron,1),new Object[]{" D ","DID"," D ",'D',ModItems.crushedCruentus,'I',Items.IRON_INGOT});
        GameRegistry.addShapedRecipe(new ItemStack(ModItems.cruDustedGold,1),new Object[]{"DDD","DID","DDD",'D',ModItems.crushedCruentus,'I',Items.GOLD_INGOT});
        GameRegistry.addShapedRecipe(new ItemStack(ModItems.arbDustedIron,1),new Object[]{" D ","DID"," D ",'D',ModItems.crushedArborea,'I',Items.IRON_INGOT});
        GameRegistry.addShapedRecipe(new ItemStack(ModItems.arbDustedGold,1),new Object[]{"DDD","DID","DDD",'D',ModItems.crushedArborea,'I',Items.GOLD_INGOT});
    }


}
