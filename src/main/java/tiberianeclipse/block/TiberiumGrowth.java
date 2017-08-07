package tiberianeclipse.block;

import net.minecraft.block.BlockCrops;
import net.minecraft.block.IGrowable;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.SoundType;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.client.model.IModel;
import net.minecraftforge.client.model.ModelLoaderRegistry;
import net.minecraftforge.client.model.b3d.B3DLoader;
import net.minecraftforge.common.property.IExtendedBlockState;
import tiberianeclipse.Main;
import tiberianeclipse.util.IModelProvider;

import java.io.IOException;


public class TiberiumGrowth extends BlockCrops implements IGrowable {
    public int meta;
    public int hardness;
    public int resistance;
    public float lightLevel;
    public Item seed;
    public Item crop;
    public String name;
    public boolean whatthefuck;

    public TiberiumGrowth(String name, int meta, Item seed, Item crop, int hardness, int resistance, float lightLevel, boolean whatthefuck) {
        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(Main.creativeTab);
        this.seed = seed;
        this.crop = crop;
        this.meta = meta;
        this.hardness = hardness;
        this.resistance = resistance;
        this.setDefaultState(this.blockState.getBaseState().withProperty(this.getAgeProperty(), Integer.valueOf(0)));
        this.setTickRandomly(true);
        this.setHardness(hardness);
        this.setResistance(resistance);
        this.setLightLevel(lightLevel);
        this.setSoundType(SoundType.GLASS);
        this.disableStats();
        this.whatthefuck = whatthefuck;
    }

    @Override
    protected boolean canSustainBush(IBlockState state) {
        return state.getBlock() == Blocks.SAND
                || state.getBlock() == Blocks.GRASS
                || state.getBlock() == Blocks.STONE
                || state.getBlock() == Blocks.DIRT
                || state.getBlock() == Blocks.FARMLAND
                || state.getBlock() == Blocks.SANDSTONE;
    }

    @Override
    protected Item getSeed() {
        return seed;
    }

    protected Item getCrop() {
        return crop;
    }


}