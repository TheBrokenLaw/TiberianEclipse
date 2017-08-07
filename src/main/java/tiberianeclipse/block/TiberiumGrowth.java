package tiberianeclipse.block;

import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.client.model.IModel;
import net.minecraftforge.client.model.ModelLoaderRegistry;
import net.minecraftforge.client.model.b3d.B3DLoader;
import net.minecraftforge.common.property.IExtendedBlockState;
import tiberianeclipse.Main;
import tiberianeclipse.util.IModelProvider;

import java.io.IOException;
import java.util.Random;


public class TiberiumGrowth extends BlockBase implements IGrowable {
    protected static final AxisAlignedBB TIB_AABB = new AxisAlignedBB(0.30000001192092896D, 0.0D, 0.30000001192092896D, 0.699999988079071D, 0.4000000059604645D, 0.699999988079071D);
    public int meta;
    public int hardness;
    public int resistance;
    public float lightLevel;
    public Item seed;
    public Item crop;
    public String name;
    public boolean whatthefuck;
    public static final PropertyInteger AGE = PropertyInteger.create("age", 0, 7);

    public TiberiumGrowth(Material material, String name, int meta, Item seed, Item crop, int hardness, int resistance, float lightLevel, boolean whatthefuck) {
        super(material, name);
        setUnlocalizedName(name);

        this.seed = seed;
        this.crop = crop;
        this.meta = meta;
        this.hardness = hardness;
        this.resistance = resistance;
        this.setDefaultState(this.blockState.getBaseState().withProperty(AGE, Integer.valueOf(0)));
        this.setTickRandomly(true);
        this.setHardness(hardness);
        this.setResistance(resistance);
        this.setLightLevel(lightLevel);
        this.setSoundType(SoundType.GLASS);
        this.disableStats();
        this.whatthefuck = whatthefuck;
        this.setTickRandomly(true);
    }

    protected PropertyInteger getAgeProperty() {
        return AGE;
    }

    public int getMaxAge() {
        return 7;
    }

    public IBlockState withAge(int age) {
        return this.getDefaultState().withProperty(this.getAgeProperty(), Integer.valueOf(age));
    }

    protected int getAge(IBlockState state) {
        return ((Integer) state.getValue(this.getAgeProperty())).intValue();
    }

    public void grow(World worldIn, BlockPos pos, IBlockState state) {
        int i = this.getAge(state) + this.getBonemealAgeIncrease(worldIn);
        int j = this.getMaxAge();

        if (i > j) {
            i = j;
        }

        worldIn.setBlockState(pos, this.withAge(i), 2);
    }

    protected int getBonemealAgeIncrease(World worldIn) {
        return MathHelper.getRandomIntegerInRange(worldIn.rand, 2, 5);
    }

    public void grow(World worldIn, Random rand, BlockPos pos, IBlockState state) {
    }

    public IBlockState getStateFromMeta(int meta) {
        return this.withAge(meta);
    }

    public int getMetaFromState(IBlockState state) {
        return this.getAge(state);
    }

    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, new IProperty[]{AGE});
    }


    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
        return TIB_AABB;
    }

    public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand) {
        if (rand.nextInt(10) == 0) {
            int i = 5;
            int j = 4;

            for (BlockPos blockpos : BlockPos.getAllInBoxMutable(pos.add(-4, -1, -4), pos.add(4, 1, 4))) {
                if (worldIn.getBlockState(blockpos).getBlock() == this) {
                    --i;

                    if (i <= 0) {
                        return;
                    }
                }
            }

            BlockPos blockpos1 = pos.add(rand.nextInt(3) - 1, rand.nextInt(2) - rand.nextInt(2), rand.nextInt(3) - 1);

            for (int k = 0; k < 4; ++k) {
                if (worldIn.isAirBlock(blockpos1)) {
                    pos = blockpos1;
                }

                blockpos1 = pos.add(rand.nextInt(3) - 1, rand.nextInt(2) - rand.nextInt(2), rand.nextInt(3) - 1);
            }

            if ((worldIn.isAirBlock(blockpos1))) {
                worldIn.setBlockState(blockpos1, this.getDefaultState(), 2);
            }
        }
    }


    protected boolean canSustainBush(IBlockState state) {
        return state.getBlock() == Blocks.SAND
                || state.getBlock() == Blocks.GRASS
                || state.getBlock() == Blocks.STONE
                || state.getBlock() == Blocks.DIRT
                || state.getBlock() == Blocks.FARMLAND
                || state.getBlock() == Blocks.SANDSTONE;
    }


    protected Item getSeed() {
        return seed;
    }

    protected Item getCrop() {
        return crop;
    }


    public boolean canGrow(World worldIn, BlockPos pos, IBlockState state, boolean isClient) {
        return true;
    }

    @Override
    public boolean canUseBonemeal(World worldIn, Random rand, BlockPos pos, IBlockState state) {
        return true;
    }
}





