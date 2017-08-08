package tiberianeclipse.block;

import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.client.model.IModel;
import net.minecraftforge.client.model.ModelLoaderRegistry;
import net.minecraftforge.client.model.b3d.B3DLoader;
import net.minecraftforge.common.EnumPlantType;
import net.minecraftforge.common.IPlantable;
import net.minecraftforge.common.property.IExtendedBlockState;
import tiberianeclipse.Main;
import tiberianeclipse.util.IModelProvider;

import javax.annotation.Nullable;
import java.io.IOException;
import java.util.Random;


public class TiberiumGrowth extends BlockBase implements IGrowable {
    protected static final AxisAlignedBB TIB_AABB = new AxisAlignedBB(0.30000001192092896D, 0.0D, 0.30000001192092896D, 0.699999988079071D, 0.2D, 0.699999988079071D);
    public int meta;
    public int hardness;
    public int resistance;
    public float lightLevel;
    public Item seed;
    public Item crop;
    public String name;
    public boolean whatthefuck;
    public static final PropertyInteger AGE = PropertyInteger.create("age", 0, 7);
    public BlockPos pos;
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
        this.pos=pos;

    }

    protected PropertyInteger getAgeProperty() {
        return AGE;
    }

    public int getMaxAge() {
        return 7;
    }

    public IBlockState withAge(int age) {
        return this.getDefaultState().withProperty(this.getAgeProperty(), age);
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
    public boolean isOpaqueCube(IBlockState state)
    {
        return false;
    }

    public boolean isFullCube(IBlockState state)
    {
        return false;
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
            int age=getAge(state);
           if (rand.nextInt((10)-age) == 0) {
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

            for (int k = 0; k < 16; ++k) {
                if (worldIn.isAirBlock(blockpos1)&&worldIn.getBlockState(pos.down())==ModBlocks.tiberiumGround.getDefaultState()) {
                    pos = blockpos1;
                }

                blockpos1 = pos.add(rand.nextInt(3) - 1, rand.nextInt(2) - rand.nextInt(2), rand.nextInt(3) - 1);
            }

            if ((worldIn.isAirBlock(blockpos1)&&worldIn.getBlockState(pos.down())==ModBlocks.tiberiumGround.getDefaultState())) {
                worldIn.setBlockState(blockpos1, this.getDefaultState(), 2);
            }
        }
       super.updateTick(worldIn, pos, state, rand);

       if (worldIn.getLightFromNeighbors(pos.up()) >= 9)
       {
           int i = this.getAge(state);

           if (i < this.getMaxAge())
           {
               float f = getGrowthChance(this, worldIn, pos);

               if(net.minecraftforge.common.ForgeHooks.onCropsGrowPre(worldIn, pos, state, rand.nextInt((int)(25.0F / f) + 1) == 0))
               {
                   worldIn.setBlockState(pos, this.withAge(i + 1), 2);
                   net.minecraftforge.common.ForgeHooks.onCropsGrowPost(worldIn, pos, state, worldIn.getBlockState(pos));
               }
           }
       }

    }
    protected static float getGrowthChance(Block blockIn, World worldIn, BlockPos pos) {
        float f = 2.0F;
        BlockPos blockpos1 = pos.north();
        BlockPos blockpos2 = pos.south();
        BlockPos blockpos3 = pos.west();
        BlockPos blockpos4 = pos.east();
        boolean flag = blockIn == worldIn.getBlockState(blockpos3).getBlock() || blockIn == worldIn.getBlockState(blockpos4).getBlock();
        boolean flag1 = blockIn == worldIn.getBlockState(blockpos1).getBlock() || blockIn == worldIn.getBlockState(blockpos2).getBlock();

        if (flag && flag1) {
            f /= 2.0F;
        } else {
            boolean flag2 = blockIn == worldIn.getBlockState(blockpos3.north()).getBlock() || blockIn == worldIn.getBlockState(blockpos4.north()).getBlock() || blockIn == worldIn.getBlockState(blockpos4.south()).getBlock() || blockIn == worldIn.getBlockState(blockpos3.south()).getBlock();

            if (flag2) {
                f /= 2.0F;
            }
        }

        return f;
    }
    public boolean canBlockStay(World worldIn, BlockPos pos, IBlockState state)
    {
        if (state.getBlock() == this) //Forge: This function is called during world gen and placement, before this block is set, so if we are not 'here' then assume it's the pre-check.
        {
            return this.canSustainBush(worldIn.getBlockState(pos.down()));
        }
        return this.canSustainBush(worldIn.getBlockState(pos.down()));
    }
    protected boolean canSustainBush(IBlockState state) {
        return state.getBlock() == Blocks.SAND
                || state.getBlock() == Blocks.GRASS
                || state.getBlock() == Blocks.STONE
                || state.getBlock() == Blocks.DIRT
                || state.getBlock() == Blocks.FARMLAND
                || state.getBlock()==ModBlocks.tiberiumGround
                || state.getBlock() == Blocks.SANDSTONE;
    }


    protected Item getSeed() {
        return seed;
    }

    protected Item getCrop() {
        return crop;
    }
    public boolean isMaxAge(IBlockState state)
    {
        return ((Integer)state.getValue(this.getAgeProperty())).intValue() >= this.getMaxAge();
    }
    @Nullable
    public Item getItemDropped(IBlockState state, Random rand, int fortune)
    {
        return this.isMaxAge(state) ? this.getCrop() : this.getSeed();
    }
    public boolean canGrow(World worldIn, BlockPos pos, IBlockState state, boolean isClient)
    {
        return !this.isMaxAge(state);
    }

    public boolean canUseBonemeal(World worldIn, Random rand, BlockPos pos, IBlockState state) {
        return true;
    }
    @Override
    public java.util.List<ItemStack> getDrops(net.minecraft.world.IBlockAccess world, BlockPos pos, IBlockState state, int fortune)
    {
        java.util.List<ItemStack> ret = super.getDrops(world, pos, state, fortune);
        int age = getAge(state);
        Random rand = world instanceof World ? ((World)world).rand : new Random();

        if (age >= getMaxAge())
        {
            int k = 3 + fortune;

            for (int i = 0; i < 3 + fortune; ++i)
            {
                if (rand.nextInt(2 * getMaxAge()) <= age)
                {
                    ret.add(new ItemStack(this.getSeed(), 1, 0));
                }
            }
        }
        return ret;
    }

    }






