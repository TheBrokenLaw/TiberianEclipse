package tiberianeclipse.block;

import com.sun.deploy.util.SessionState;
import net.minecraft.block.Block;
import net.minecraft.block.BlockDirt;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import net.minecraft.block.Block;
import net.minecraft.block.BlockLilyPad;
import net.minecraft.world.World;
import net.minecraftforge.common.EnumPlantType;
import net.minecraftforge.common.IPlantable;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class SpreadTest extends BlockBase implements IPlantable{
    protected static final AxisAlignedBB SPREAD_AABB = new AxisAlignedBB(0.30000001192092896D, 0.0D, 0.30000001192092896D, 0.699999988079071D, 0.4000000059604645D, 0.699999988079071D);

    public static final PropertyInteger AGE = PropertyInteger.create("age", 0, 7);
        public Material material;
        public String name;
        public SpreadTest(Material material, String name){
            super(material, name);
            this.material=material;

            this.name=name;
            this.setTickRandomly(true);
        }
        protected PropertyInteger getAgeProperty()
        {
            return AGE;
        }

        public int getMaxAge()
        {
            return 7;
        }

        protected int getAge(IBlockState state)
        {
            return ((Integer)state.getValue(this.getAgeProperty())).intValue();
        }

        public IBlockState withAge(int age)
        {
            return this.getDefaultState().withProperty(this.getAgeProperty(), Integer.valueOf(age));
        }

        public boolean isMaxAge(IBlockState state)
        {
            return ((Integer)state.getValue(this.getAgeProperty())).intValue() >= this.getMaxAge();
        }
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos)
    {
        return SPREAD_AABB;
    }

        public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand)
        {
            super.updateTick(worldIn, pos, state, rand);

            if (worldIn.getLightFromNeighbors(pos.up()) >= 0)
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
                    if (worldIn.isAirBlock(blockpos1) && this.canBlockStay(worldIn, blockpos1, this.getDefaultState())) {
                        pos = blockpos1;
                    }

                    blockpos1 = pos.add(rand.nextInt(3) - 1, rand.nextInt(2) - rand.nextInt(2), rand.nextInt(3) - 1);
                }

                if ((worldIn.isAirBlock(blockpos1)) && this.canBlockStay(worldIn, blockpos1, this.getDefaultState())) {
                    worldIn.setBlockState(blockpos1, this.getDefaultState(), 2);
                }
            }

        }
        protected static float getGrowthChance(Block blockIn, World worldIn, BlockPos pos)
        {
            float f = 1.0F;
            BlockPos blockpos = pos.down();

            for (int i = -1; i <= 1; ++i)
            {
                for (int j = -1; j <= 1; ++j)
                {
                    float f1 = 0.0F;
                    IBlockState iblockstate = worldIn.getBlockState(blockpos.add(i, 0, j));


                        f1 = 1.0F;



                    if (i != 0 || j != 0)
                    {
                        f1 /= 4.0F;
                    }

                    f += f1;
                }
            }

            BlockPos blockpos1 = pos.north();
            BlockPos blockpos2 = pos.south();
            BlockPos blockpos3 = pos.west();
            BlockPos blockpos4 = pos.east();
            boolean flag = blockIn == worldIn.getBlockState(blockpos3).getBlock() || blockIn == worldIn.getBlockState(blockpos4).getBlock();
            boolean flag1 = blockIn == worldIn.getBlockState(blockpos1).getBlock() || blockIn == worldIn.getBlockState(blockpos2).getBlock();

            if (flag && flag1)
            {
                f /= 2.0F;
            }
            else
            {
                boolean flag2 = blockIn == worldIn.getBlockState(blockpos3.north()).getBlock() || blockIn == worldIn.getBlockState(blockpos4.north()).getBlock() || blockIn == worldIn.getBlockState(blockpos4.south()).getBlock() || blockIn == worldIn.getBlockState(blockpos3.south()).getBlock();

                if (flag2)
                {
                    f /= 2.0F;
                }
            }

            return f;
        }
    public boolean canBlockStay(World worldIn, BlockPos pos, IBlockState state) {
        IBlockState ground = worldIn.getBlockState(pos.down());
        return ground.getBlock().canSustainPlant(ground, worldIn, pos.down(), net.minecraft.util.EnumFacing.UP, this);
    }
    public boolean isOpaqueCube(IBlockState state)
    {
        return false;
    }

    public boolean isFullCube(IBlockState state)
    {
        return false;
    }
    protected boolean canSustainBush(IBlockState state) {
        return state.getBlock() == Blocks.SAND
                || state.getBlock() == Blocks.GRASS
                || state.getBlock() == Blocks.STONE
                || state.getBlock() == Blocks.DIRT
                || state.getBlock() == Blocks.FARMLAND
                || state.getBlock() == Blocks.SANDSTONE;
    }


    @SideOnly(Side.CLIENT)
    public IBlockState getStateFromMeta(int meta)
    {
        return this.withAge(meta);
    }

        public int getMetaFromState(IBlockState state)
        {
            return 0;
        }
        protected BlockStateContainer createBlockState()
        {
            return new BlockStateContainer(this, new IProperty[] {AGE});
        }

    @Override
    public net.minecraftforge.common.EnumPlantType getPlantType(net.minecraft.world.IBlockAccess world, BlockPos pos)
    {
        if (this == ModBlocks.spread)          return EnumPlantType.Plains;

        return net.minecraftforge.common.EnumPlantType.Plains;
    }

    @Override
    public IBlockState getPlant(net.minecraft.world.IBlockAccess world, BlockPos pos)
    {
        IBlockState state = world.getBlockState(pos);
        if (state.getBlock() != this) return getDefaultState();
        return state;
    }
    @SideOnly(Side.CLIENT)
    public BlockRenderLayer getBlockLayer()
    {
        return BlockRenderLayer.CUTOUT;
    }

}

