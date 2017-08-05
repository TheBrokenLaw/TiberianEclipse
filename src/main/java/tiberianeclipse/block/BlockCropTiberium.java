package tiberianeclipse.block;

import net.minecraft.block.BlockCrops;
import net.minecraft.item.Item;
import tiberianeclipse.item.ModItems;

public class BlockCropTiberium extends BlockCrops {
    public BlockCropTiberium(){
        setUnlocalizedName("greenTibBush");
        setRegistryName("greenTibBush");

    }
    @Override
    protected Item getSeed(){
        return ModItems.greenShard;
    }
    @Override protected Item getCrop() {
        return ModItems.greenShard;
    }
}
