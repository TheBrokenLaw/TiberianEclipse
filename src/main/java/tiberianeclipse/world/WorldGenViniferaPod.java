package tiberianeclipse.world;

import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;
import tiberianeclipse.block.ModBlocks;

import java.util.Random;

public class WorldGenViniferaPod extends WorldGenerator {
    private final IBlockState viniferaPodState;
    protected void setBlockAndAge(Random random, World world, BlockPos pos, IBlockState stateNew)
    {
        if (!world.getBlockState(pos).isOpaqueCube())
        {
            world.setBlockState(pos, stateNew, 2);
        }
    }

    {
        this.viniferaPodState = ModBlocks.viniferaPod.getDefaultState();
    }

    public boolean generate(World worldIn, Random rand, BlockPos position)
    {

        for (IBlockState iblockstate = worldIn.getBlockState(position); (iblockstate.getBlock().isAir(iblockstate, worldIn, position) || iblockstate.getBlock().isLeaves(iblockstate, worldIn, position)) && position.getY() > 0; iblockstate = worldIn.getBlockState(position))
        {
            position = position.down();
        }

        for (int i = 0; i < 128; ++i)

        {
            BlockPos blockpos = position.add(rand.nextInt(8) - rand.nextInt(8), rand.nextInt(4) - rand.nextInt(4), rand.nextInt(8) - rand.nextInt(8));

            if (worldIn.isAirBlock(blockpos) && ModBlocks.viniferaPod.canBlockStay(worldIn, blockpos, this.viniferaPodState))
            {
                this.setBlockAndAge(rand, worldIn, blockpos, this.viniferaPodState.withProperty(ModBlocks.viniferaPod.AGE, this.randomAge(rand)));
            }
        }

        return true;
    }

    int randomAge(Random random)
    {
        return random.nextInt(7);
    }
   // public boolean generate(World worldIn, Random rand, BlockPos pos)
   // {

// we randomly pick between a bush with a cookie and a bush without a cookie

   //     Block block = ModBlocks.viniferaPod;
   //     int y = 1 + getGroundFromAbove(worldIn, pos.getX(), pos.getZ());
        // debug:
        // System.out.println("Y-value of ground is " + y + " at (" + pos.getX() + ", " + pos.getZ() + ")");
        // the Y we passed earlier will be used here as the minimum spawn height allowed
    //    if(y >= pos.getY())
    //    {
     //       BlockPos bushPos = new BlockPos(pos.getX(), y, pos.getZ());
            // we know it's on top of grass or dirt, but what is here already?
     //       Block toReplace = worldIn.getBlockState(bushPos).getBlock();
            // only place bush if it is air or plant
     //       if(toReplace == Blocks.AIR )//<--
                    //|| toReplace == ModBlocks.viniferaPod||toReplace==Blocks.GRASS || toReplace== Blocks.RED_FLOWER||toReplace==Blocks.YELLOW_FLOWER)<--
      //      {
                // set the block to a bush
                // use 2 as the flag to prevent update -- you don't have to include that parameter
      //          worldIn.setBlockState(bushPos, ModBlocks.viniferaPod.getDefaultState());
                // debug:
                // System.out.println("placed a cookie bush!");
      //      }   // else System.out.println("Sadly, this block is occupied by " + toReplace.getUnlocalizedName());
       // }
      //  return false;
  //  }

    // find a grass or dirt block to place the bush on
  //  public static int getGroundFromAbove(World world, int x, int z)
   // {
     //   int y = 255;
     //   boolean foundGround = false;
     //   while(!foundGround && y-- >= 0)
     //   {
     //       Block blockAt = world.getBlockState(new BlockPos(x,y,z)).getBlock();
            // "ground" for our bush is grass or dirt
     //       foundGround = blockAt == ModBlocks.tiberiumGround;
     //   }

    //    return y;
   // }
}
