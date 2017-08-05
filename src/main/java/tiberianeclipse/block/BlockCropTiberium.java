package tiberianeclipse.block;

import net.minecraft.block.BlockCrops;
import net.minecraft.item.Item;
import tiberianeclipse.Main;
import tiberianeclipse.item.ModItems;

public class BlockCropTiberium extends BlockCrops {
    public BlockCropTiberium(){
        setUnlocalizedName("greenTibBush");
        setRegistryName("greenTibBush");
        setCreativeTab(Main.creativeTab);

    }
    @Override
    protected Item getSeed(){
        return ModItems.ripariusShard;
    }
    @Override
    protected Item getCrop() {
        return ModItems.ripariusShard;
    }
}
