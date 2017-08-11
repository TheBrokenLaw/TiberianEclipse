package tiberianeclipse.block;

import com.google.common.base.Predicate;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.*;
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
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import tiberianeclipse.Main;
import tiberianeclipse.util.IModelProvider;

import javax.annotation.Nullable;
import java.io.IOException;
import java.util.Random;


public class TiberiumGrowth extends BlockOre implements IGrowable {

  //  public static final PropertyDirection FACING = PropertyDirection.create("facing", new Predicate<EnumFacing>()
 //   {public boolean apply(@Nullable EnumFacing p_apply_1_)
  //      {
   //         return p_apply_1_ != EnumFacing.DOWN;
   //     }});
    protected static final AxisAlignedBB TIB_AABB = new AxisAlignedBB(0.25D, 0.0D, 0.256D, 0.75D, 0.5D, 0.75D);
    public int meta;
    public float hardness;
    public float resistance;
    public float lightLevel;
    public Item drop;
    public int leastQuantity;
    public int mostQuantity;
    public String name;
    public Material material;
    public boolean whatthefuck;
    public int meta2;
    public static final PropertyInteger AGE = PropertyInteger.create("age", 0, 7);
    public BlockPos pos;
    public TiberiumGrowth(String name,Material material, Item drop, int meta, int leastQuantity, int mostQuantity, float hardness, float resistance, float lightLevel, boolean whatthefuck) {
        super(name, material, drop, meta, leastQuantity, mostQuantity, lightLevel, hardness, resistance);
        setUnlocalizedName(name);
        this.material=material;
        this.setHarvestLevel("pickaxe",0);
        this.drop = drop;
        this.leastQuantity = leastQuantity;
        this.mostQuantity=mostQuantity;
        this.meta = meta;
        this.meta2=meta2;
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
   //     this.setDefaultState(this.blockState.getBaseState().withProperty(FACING, EnumFacing.UP));
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
    @Override
    public boolean isOpaqueCube(IBlockState state)
    {
        return false;
    }
    @SideOnly(Side.CLIENT)
    public BlockRenderLayer getBlockLayer()
    {
        return BlockRenderLayer.TRANSLUCENT;
    }
    public boolean isFullCube(IBlockState state)
    {
        return false;
    }
    protected int getBonemealAgeIncrease(World worldIn) {
        return MathHelper.getRandomIntegerInRange(worldIn.rand, 2, 5);
    }

    public void grow(World worldIn, Random rand, BlockPos pos, IBlockState state) {
        int i = this.getAge(state) + this.getBonemealAgeIncrease(worldIn);
        int j = this.getMaxAge();

        if (i > j) {
            i = j;
        }

        worldIn.setBlockState(pos, this.withAge(i), 2);
    }

    public IBlockState getStateFromMeta(int meta) {
        return this.withAge(meta);
    }

    public int getMetaFromState(IBlockState state)
    {
        return this.getAge(state);
    }

    protected BlockStateContainer createBlockState()
    {

        return new BlockStateContainer(this, new IProperty[]{AGE});//, FACING});
    }


    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
        return TIB_AABB;
    }

    public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand) {

            if (rand.nextInt(5) == 0)
            {
                int i = 50;
                int j = 4;

                for (BlockPos blockpos : BlockPos.getAllInBoxMutable(pos.add(-4, -1, -4), pos.add(4, 1, 4)))
                {
                    if (worldIn.getBlockState(blockpos).getBlock() == this)
                    {
                        --i;

                        if (i <= 0)
                        {
                            return;
                        }
                    }
                }

                BlockPos blockpos1 = pos.add(rand.nextInt(3) - 1, rand.nextInt(2) - rand.nextInt(2), rand.nextInt(3) - 1);

                for (int k = 0; k < 4; ++k)
                {
                    if (worldIn.isAirBlock(blockpos1) && this.canBlockStay(worldIn, blockpos1, this.getDefaultState()))
                    {
                        pos = blockpos1;
                    }

                    blockpos1 = pos.add(rand.nextInt(3) - 1, rand.nextInt(2) - rand.nextInt(2), rand.nextInt(3) - 1);
                }

                if (worldIn.isAirBlock(blockpos1) && this.canBlockStay(worldIn, blockpos1, this.getDefaultState()))
                {
                    worldIn.setBlockState(blockpos1, this.getDefaultState(), 2);
                }
            }
            for (BlockPos blockpos2 : BlockPos.getAllInBoxMutable(pos.add(rand.nextInt(2), -1, rand.nextInt(2)), pos.add(rand.nextInt(2), 1, rand.nextInt(2)))) {
                BlockPos blockPos = pos.down();
                if (worldIn.getBlockState(blockPos) != ModBlocks.fieldGrass.getDefaultState() && worldIn.getBlockState(blockPos)==Blocks.GRASS
                        ||worldIn.getBlockState(blockPos) != ModBlocks.fieldGrass.getDefaultState() && worldIn.getBlockState(blockPos)==Blocks.STONE||
                        worldIn.getBlockState(blockPos) != ModBlocks.fieldGrass.getDefaultState() && worldIn.getBlockState(blockPos)==Blocks.DIRT) {
                    worldIn.setBlockState(blockPos, ModBlocks.fieldGrass.getDefaultState());

                }
                if(worldIn.getBlockState(pos.up())==Blocks.LOG.getDefaultState()&&worldIn.getBlockState(pos.up())!=ModBlocks.tibMutLog.getDefaultState()||worldIn.getBlockState(pos.up())==Blocks.LOG2.getDefaultState()&&worldIn.getBlockState(blockpos2)!=ModBlocks.tibMutLog.getDefaultState()){
                    worldIn.setBlockState(pos.up(),ModBlocks.tibMutLog.getDefaultState());
                }
            }
/*        int age=getAge(state);
           if (rand.nextInt(5) == 0) {
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
                if (worldIn.isAirBlock(blockpos1)&&worldIn.getBlockState(pos.down())==ModBlocks.tiberiumGround.getDefaultState()||worldIn.isAirBlock(blockpos1)&&worldIn.getBlockState(pos.down())==ModBlocks.fieldGrass.getDefaultState()) {
                    pos = blockpos1;
                }

                blockpos1 = pos.add(rand.nextInt(3) - 1, rand.nextInt(2) - rand.nextInt(2), rand.nextInt(3) - 1);
            }

          if ((worldIn.isAirBlock(blockpos1)&&worldIn.getBlockState(pos.down())==ModBlocks.tiberiumGround.getDefaultState()||worldIn.isAirBlock(blockpos1)&&worldIn.getBlockState(pos.down())==ModBlocks.fieldGrass.getDefaultState())) {
               worldIn.setBlockState(blockpos1, this.getDefaultState(), 2);
           }
        }

  */
                super.updateTick(worldIn, pos, state, rand);

                if (worldIn.getLightFromNeighbors(pos.up()) >= 2) {
                    int k = this.getAge(state);

                    if (k < this.getMaxAge()) {
                        float f = getGrowthChance(this, worldIn, pos);

                        if (net.minecraftforge.common.ForgeHooks.onCropsGrowPre(worldIn, pos, state, rand.nextInt((int) (25.0F / f) + 1) == 0)) {
                            worldIn.setBlockState(pos, this.withAge(k + 1), 2);
                            net.minecraftforge.common.ForgeHooks.onCropsGrowPost(worldIn, pos, state, worldIn.getBlockState(pos));
                        }
                    }
                }
    }


   /* public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand)
    {
        if (!worldIn.isRemote)
       {



                   for (int i = 0; i < 4; ++i)
                    {
                        BlockPos blockpos = pos.add(rand.nextInt(3) - 1, rand.nextInt(5)-4, rand.nextInt(3) - 1);

                        if (blockpos.getY() >= 0 && blockpos.getY() < 256 && !worldIn.isBlockLoaded(blockpos.down())&&worldIn.getBlockState(pos.down())==ModBlocks.tiberiumGround.getDefaultState())
                        {
                          return;
                       }

                       IBlockState iblockstate = worldIn.getBlockState(blockpos.up());
                        IBlockState iblockstate1 = worldIn.getBlockState(blockpos);

                             if ((worldIn.isAirBlock(blockpos)&&worldIn.getBlockState(pos.down())==ModBlocks.tiberiumGround.getDefaultState())) {
                                  worldIn.setBlockState(blockpos, this.getDefaultState(), 2);
                              }
                       }
                  }
*///       }

    protected static float getGrowthChance(Block blockIn, World worldIn, BlockPos pos) {
        float f = 4.0F;
        return f;


    }
    public Block.EnumOffsetType getOffsetType()
    {
        return Block.EnumOffsetType.XZ;
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
        return state.getBlock()==ModBlocks.tiberiumGround
                ||state.getBlock()==ModBlocks.fieldGrass
                ||state.getBlock()==Blocks.GRASS
                ||state.getBlock()==Blocks.DIRT
                ||state.getBlock()==Blocks.STONE
                ||state.getBlock()==Blocks.SAND;
    }


    public boolean isMaxAge(IBlockState state)
    {
        return ((Integer)state.getValue(this.getAgeProperty())).intValue() >= this.getMaxAge();
    }

    public boolean canGrow(World worldIn, BlockPos pos, IBlockState state, boolean isClient)
    {
        return !this.isMaxAge(state);
    }

    public boolean canUseBonemeal(World worldIn, Random rand, BlockPos pos, IBlockState state) {
        return true;
    }


    @Override
    public Item getItemDropped(IBlockState blockstate, Random random, int fortune) {
        return this.drop;
    }

    @Override
    public int damageDropped(IBlockState blockstate) {
        return this.meta;
    }

    @Override
    public int quantityDropped(IBlockState blockstate, int fortune, Random random) {
        if (this.leastQuantity >= this.mostQuantity)
            return this.leastQuantity;
        return this.leastQuantity + random.nextInt(this.mostQuantity - this.leastQuantity + fortune + 1);
  /*  }
    private boolean canPlaceOn(World worldIn, BlockPos pos)
    {
        IBlockState state = worldIn.getBlockState(pos);
        if (state.isSideSolid(worldIn, pos, EnumFacing.UP))
        {
            return true;
        }
        else
        {
            return state.getBlock().canPlaceTorchOnTop(state, worldIn, pos);
        }
    }

    public boolean canPlaceBlockAt(World worldIn, BlockPos pos)
    {
        for (EnumFacing enumfacing : FACING.getAllowedValues())
        {
            if (this.canPlaceAt(worldIn, pos, enumfacing))
            {
                return true;
            }
        }

        return false;
    }

    private boolean canPlaceAt(World worldIn, BlockPos pos, EnumFacing facing)
    {
        BlockPos blockpos = pos.offset(facing.getOpposite());
        boolean flag = facing.getAxis().isHorizontal();
        return flag && worldIn.isSideSolid(blockpos, facing, true) || facing.equals(EnumFacing.UP) && this.canPlaceOn(worldIn, blockpos);
    }
    public IBlockState onBlockPlaced(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer)
    {
        if (this.canPlaceAt(worldIn, pos, facing))
        {
            return this.getDefaultState().withProperty(FACING, facing);
        }
        else
        {
            for (EnumFacing enumfacing : EnumFacing.Plane.HORIZONTAL)
            {
                if (worldIn.isSideSolid(pos.offset(enumfacing.getOpposite()), enumfacing, true))
                {
                    return this.getDefaultState().withProperty(FACING, enumfacing);
                }
            }

            return this.getDefaultState();
        }
    }

    /**
     * Called after the block is set in the Chunk data, but before the Tile Entity is set
     */
  //  public void onBlockAdded(World worldIn, BlockPos pos, IBlockState state)
   // {
  //      this.checkForDrop(worldIn, pos, state);
  //  }
 //  protected boolean checkForDrop(World worldIn, BlockPos pos, IBlockState state)
  //  {
    /*    if (state.getBlock() == this && this.canPlaceAt(worldIn, pos, (EnumFacing)state.getValue(FACING)))
      */ // {
     //       return true;
    //    }
    //    else
   //     {
    //        if (worldIn.getBlockState(pos).getBlock() == this)
   //         {
   //             this.dropBlockAsItem(worldIn, pos, state, 0);
  //              worldIn.setBlockToAir(pos);
 //           }

   //         return false;
   //     }
   // }
  //  public IBlockState getStateFromMeta2(int meta2)
   // {
     //   IBlockState iblockstate = this.getDefaultState();

    //   switch (meta2)
      //  {
         //   case 1:
          //      iblockstate = iblockstate.withProperty(FACING, EnumFacing.EAST);
         //       break;
        //    case 2:
         //       iblockstate = iblockstate.withProperty(FACING, EnumFacing.WEST);
        //        break;
         //   case 3:
         //       iblockstate = iblockstate.withProperty(FACING, EnumFacing.SOUTH);
        //        break;
       //     case 4:
       //         iblockstate = iblockstate.withProperty(FACING, EnumFacing.NORTH);
       //         break;
      //      case 5:
      //      default:
     //           iblockstate = iblockstate.withProperty(FACING, EnumFacing.UP);
      //  }

   //     return iblockstate;
   // }
   // public int getMetaFromState(IBlockState state2)
   // {
     //   int i = 0;

     //   switch ((EnumFacing)state2.getValue(FACING))
     //   {
     //       case EAST:
     //           i = i | 1;
     //           break;
     //       case WEST:
      //          i = i | 2;
      //          break;
       //     case SOUTH:
       //         i = i | 3;
       //         break;
       //     case NORTH:
       //         i = i | 4;
      //          break;
       //     case DOWN:
       //     case UP:
      //      default:
      //          i = i | 5;
     //   }

   //     return i;
   // }
  // public IBlockState withRotation(IBlockState state2, Rotation rot)
  //  {
  //      return state2.withProperty(FACING, rot.rotate((EnumFacing)state2.getValue(FACING)));
  //  }
  //  public IBlockState withMirror(IBlockState state2, Mirror mirrorIn)
    //{
  //      return state2.withRotation(mirrorIn.toRotation((EnumFacing)state2.getValue(FACING)));
    }

}







