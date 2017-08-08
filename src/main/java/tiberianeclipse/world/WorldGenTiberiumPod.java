package tiberianeclipse.world;

import net.minecraft.block.Block;
import net.minecraft.block.BlockBush;
import net.minecraft.block.BlockFlower;
import net.minecraft.block.BlockTallGrass;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;
import tiberianeclipse.api.MaterialIs;
import tiberianeclipse.block.ModBlocks;

import java.util.Random;

import static net.minecraft.block.material.Material.PLANTS;

public class WorldGenTiberiumPod extends WorldGenerator {
    private final IBlockState tiberiumPodState;


    {
        this.tiberiumPodState = ModBlocks.tiberiumPod.getDefaultState();
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

            if (worldIn.isAirBlock(blockpos) && ModBlocks.tiberiumPod.canBlockStay(worldIn, blockpos, this.tiberiumPodState))
            {
                worldIn.setBlockState(blockpos, this.tiberiumPodState);
            }
        }

        return true;
    }

   // public boolean generate(World worldIn, Random rand, BlockPos pos)
   // {

// we randomly pick between a bush with a cookie and a bush without a cookie

   //     Block block = ModBlocks.tiberiumPod;
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
                    //|| toReplace == ModBlocks.tiberiumPod||toReplace==Blocks.GRASS || toReplace== Blocks.RED_FLOWER||toReplace==Blocks.YELLOW_FLOWER)<--
      //      {
                // set the block to a bush
                // use 2 as the flag to prevent update -- you don't have to include that parameter
      //          worldIn.setBlockState(bushPos, ModBlocks.tiberiumPod.getDefaultState());
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
