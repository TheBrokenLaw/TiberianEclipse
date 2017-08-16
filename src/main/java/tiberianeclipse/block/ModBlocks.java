package tiberianeclipse.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.fml.common.registry.GameRegistry;
import tiberianeclipse.ClientProxy;
import tiberianeclipse.block.counter.BlockCounter;
import tiberianeclipse.block.pedestal.BlockPedestal;
import tiberianeclipse.block.tibcrystals.*;
import tiberianeclipse.item.ModItems;
import tiberianeclipse.machine.BlockGrinder;
import tiberianeclipse.tileentities.BaseTileEntity;
import tiberianeclipse.tileentities.TibProcessor;
import tiberianeclipse.util.IModelProvider;

public class ModBlocks extends ClientProxy {
    public static BlockOre rockRiparius;
    public static BlockOre rockVinifera;
    public static BlockOre rockCruentus;
    public static BlockOre rockArborea;
   // public static TiberiumGrowth greenTibBush;
    public static BlockBase refinedTiberiumBlock;
    public static RipariusCrystal ripariusPod;
    public static BlockBase podTest;
    public static BlockBase tiberiumGround;
    public static TiberiumGrowth viniferaPod;
    public static TiberiumGrowth cruentusPod;
    public static TiberiumGrowth arboreaPod;
    //public static BlockTibPod tibPodTest;
    public static BlockTestDrops testDrops;
    public static BlockGrass fieldGrass;
    public static TibProcessor tibProcessor;
    public static MutatedLog tibMutLog;
    public static BlockGrinder blockGrinder;
    //public static BlockProcessor blockProcessor;
    public static RipariusTree ripariusTree;


    public static BlockCounter counter;
    public static BlockPedestal pedestal;
    public static void init(){
    /*  rockRiparius = register(new BlockOre("rockRiparius", Material.ROCK, ModItems.ripariusShard, 0,4,6,3,3,0.5f));
        rockVinifera = register(new BlockOre("rockVinifera",Material.ROCK, ModItems.viniferaShard, 0,4,6,4,4,0.35f));
        rockCruentus = register(new BlockOre("rockCruentus",Material.ROCK, ModItems.cruentusShard,0,4,6,5,5, 0.25f));
        rockArborea = register(new BlockOre("RockArborea",Material.ROCK, ModItems.arboreaShard,0,4,6,6,6,0.10f));
        greenTibBush = register(new TiberiumGrowth("greenTibBush",Material.ROCK, ModItems.ripariusShard, 0,1,3, 6,1,3, 0.25f, true));
     */ refinedTiberiumBlock = register(new BlockBase(Material.ROCK,"refinedTiberiumBlock", "pickaxe", 5));
        viniferaPod= register(new ViniferaCrystal("viniferaPod",Material.ROCK,ModItems.viniferaShard,0,3,6,1,1,.45f,true));
        cruentusPod= register(new CruentusCrystal("cruentusPod",Material.ROCK,ModItems.cruentusShard,0,3,6,1,1,.45f,true));
        arboreaPod= register(new ArboreaCrystal("arboreaPod",Material.ROCK,ModItems.arboreaShard,0,3,6,1,1,.45f,true));
        ripariusPod =register (new RipariusCrystal("ripariusPod",Material.ROCK,ModItems.ripariusShard, 0, 3,6,1,3,0.5f,true));
     // podTest= register (new BlockBase(Material.GLASS, "podTest"));
        tiberiumGround=register(new BlockGround(Material.GRASS, "groundTiberium",2,4));
    //    tibPodTest=register(new BlockTibPod("tibPodTest",Material.ROCK, ModItems.ripariusShard, 0,3,6,1,5,.5f,true));
    //    testDrops=register(new BlockTestDrops("TestDropper",Material.ROCK, ModItems.ripariusShard, 0,3,6));
        fieldGrass=register(new BlockGrass(Material.GRASS,"fieldGrass"));
        tibProcessor=register(new TibProcessor());
        tibMutLog=register(new MutatedLog("tibMutLog"));
//        blockGrinder=register(new BlockGrinder());
    //    blockProcessor=register(new BlockProcessor());
    //    counter=register(new BlockCounter());
    //    pedestal=register(new BlockPedestal("pedestal", Material.ROCK));
        ripariusTree=register(new RipariusTree());
    }
    private static <T extends Block> T register(T block, ItemBlock itemBlock){
        GameRegistry.register(block);

        if (itemBlock != null) {
            GameRegistry.register(itemBlock);

            if (block instanceof IModelProvider) {
                ((IModelProvider) block).registerItemModel(itemBlock, 0);
            }
            if (block instanceof BaseTileEntity) {
                GameRegistry.registerTileEntity(((BaseTileEntity<?>)block).getTileEntityClass(), block.getRegistryName().toString());
            }

            return block;


        }
        return block;
    }
    private static <T extends Block> T register(T block){
        ItemBlock itemBlock=new ItemBlock(block);
        itemBlock.setRegistryName(block.getRegistryName());
        return register(block, itemBlock);
    }
}

