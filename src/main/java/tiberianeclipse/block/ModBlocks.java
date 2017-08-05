package tiberianeclipse.block;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fml.common.registry.GameRegistry;
import tiberianeclipse.util.IModelProvider;

public class ModBlocks {
    public static BlockOre oreTiberium;
    public static void init(){
        oreTiberium = register(new BlockOre("oreTiberium").setCreativeTab(CreativeTabs.MATERIALS));

    }
    private static <T extends Block> T register(T block, ItemBlock itemBlock){
        GameRegistry.register(block);
        GameRegistry.register(itemBlock);
        if (block instanceof IModelProvider){
            ((IModelProvider)block).registerItemModel(itemBlock);
        }
        return block;
    }
    private static <T extends Block> T register(T block){
        ItemBlock itemBlock=new ItemBlock(block);
        itemBlock.setRegistryName(block.getRegistryName());
        return register(block, itemBlock);
    }
}
