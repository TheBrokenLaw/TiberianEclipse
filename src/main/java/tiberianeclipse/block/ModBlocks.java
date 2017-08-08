package tiberianeclipse.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.client.renderer.block.statemap.StateMap;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.GameRegistry;
import tiberianeclipse.ClientProxy;
import tiberianeclipse.Main;
import tiberianeclipse.item.ModItems;
import tiberianeclipse.util.IModelProvider;

public class ModBlocks extends ClientProxy {
    public static BlockOre rockRiparius;
    public static BlockOre rockVinifera;
    public static BlockOre rockCruentus;
    public static BlockOre rockArborea;
    public static TiberiumGrowth greenTibBush;
    public static BlockBase refinedTiberiumBlock;
    public static TiberiumGrowth ripariusPod;
    public static BlockBase podTest;
    public static BlockBase tiberiumGround;
    public static TiberiumGrowth viniferaPod;
    public static TiberiumGrowth cruentusPod;
    public static TiberiumGrowth arboreaPod;
    public static void init(){
        rockRiparius = register(new BlockOre("rockRiparius", ModItems.ripariusShard, 1,4,6,3,3,0.5f));
        rockVinifera = register(new BlockOre("rockVinifera", ModItems.viniferaShard, 2,4,6,4,4,0.35f));
        rockCruentus = register(new BlockOre("rockCruentus", ModItems.cruentusShard,3,4,6,5,5, 0.25f));
        rockArborea = register(new BlockOre("RockArborea", ModItems.arboreaShard,4,4,6,6,6,0.10f));
        greenTibBush = register(new TiberiumGrowth("greenTibBush",Material.ROCK, ModItems.ripariusShard, 0,3, 6,1,3, 0.25f, true));
        refinedTiberiumBlock = register(new BlockBase(Material.ROCK, "refinedTiberiumBlock",2,6));
        viniferaPod= register(new TiberiumGrowth("viniferaPod",Material.ROCK,ModItems.viniferaShard,0,3,6,1,1,.45f,true));
        cruentusPod= register(new TiberiumGrowth("cruentusPod",Material.ROCK,ModItems.cruentusShard,0,3,6,1,1,.45f,true));
        arboreaPod= register(new TiberiumGrowth("arboreaPod",Material.ROCK,ModItems.arboreaShard,0,3,6,1,1,.45f,true));
        ripariusPod =register (new TiberiumGrowth("ripariusPod",Material.ROCK,ModItems.ripariusShard, 1, 3,6,1,3,0.5f,true));
        podTest= register (new BlockBase(Material.GLASS, "podTest",2,4));
        tiberiumGround=register(new BlockBase(Material.GRASS, "groundTiberium",2,4));
    }
    private static <T extends Block> T register(T block, ItemBlock itemBlock){
        GameRegistry.register(block);
        if (itemBlock != null) {
            GameRegistry.register(itemBlock);

            if (block instanceof IModelProvider) {
                ((IModelProvider) block).registerItemModel(itemBlock);
            }
        }
        return block;
    }
    private static <T extends Block> T register(T block){
        ItemBlock itemBlock=new ItemBlock(block);
        itemBlock.setRegistryName(block.getRegistryName());
        return register(block, itemBlock);
    }
}

