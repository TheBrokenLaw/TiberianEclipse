package tiberianeclipse.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.ItemBlock;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fml.common.registry.GameRegistry;
import tiberianeclipse.util.IModelProvider;

public class ModBlocks {
    public static BlockOre rockRiparius;
    public static BlockOre rockVinifera;
    public static BlockOre rockCruentus;
    public static BlockOre rockArborea;
    public static BlockCropTiberium greenTibBush;
    public static BlockBase refinedTiberiumBlock;
    public static void init(){
        rockRiparius = register(new BlockOre("rockRiparius"));
        rockVinifera = register(new BlockOre("rockVinifera"));
        rockCruentus = register(new BlockOre("rockCruentus"));
        rockArborea = register(new BlockOre("rockArborea"));
        greenTibBush = register(new BlockCropTiberium(), null);
        refinedTiberiumBlock = register(new BlockBase(Material.ROCK, "refinedTiberiumBlock"));
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
