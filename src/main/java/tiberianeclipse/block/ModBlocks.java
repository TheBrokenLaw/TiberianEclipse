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
    public static TiberiumGrowth tiberiumPod;
    public static BlockBase podTest;
    public static BlockBase tiberiumGround;
    public static void init(){
        rockRiparius = register(new BlockOre("rockRiparius", ModItems.ripariusShard, 1,4,6,0.5f));
        rockVinifera = register(new BlockOre("rockVinifera", ModItems.viniferaShard, 2,4,6,0.35f));
        rockCruentus = register(new BlockOre("rockCruentus", ModItems.cruentusShard,3,4,6, 0.25f));
        rockArborea = register(new BlockOre("RockArborea", ModItems.arboreaShard,4,4,6,0.10f));
        greenTibBush = register(new TiberiumGrowth(Material.GLASS,"greenTibBush", 0,ModItems.ripariusShard, ModItems.ripariusShard,3, 6, 0.25f, true));
        refinedTiberiumBlock = register(new BlockBase(Material.ROCK, "refinedTiberiumBlock"));
        tiberiumPod= register (new TiberiumGrowth(Material.GLASS,"tiberiumPod",0,ModItems.ripariusShard, ModItems.ripariusShard, 3,6,.25f,true));
        podTest= register (new BlockBase(Material.GLASS, "podTest"));
        tiberiumGround=register(new BlockBase(Material.GRASS, "groundTiberium"));
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

