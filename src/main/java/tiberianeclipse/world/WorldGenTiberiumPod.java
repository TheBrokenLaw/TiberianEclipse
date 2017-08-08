package tiberianeclipse.world;

import net.minecraft.block.BlockBush;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;
import tiberianeclipse.block.ModBlocks;

import java.util.Random;

public class WorldGenTiberiumPod extends WorldGenerator {

    public boolean generate(World worldIn, Random rand, BlockPos position)
    {
        for (int i = 0; i < 64; ++i)
        {
            BlockPos blockpos = position.add(rand.nextInt(8) - rand.nextInt(8), rand.nextInt(4) - rand.nextInt(4), rand.nextInt(8) - rand.nextInt(8));

            if (worldIn.isAirBlock(blockpos)|| blockpos.getY() < worldIn.getHeight() - 1)
            {
                worldIn.setBlockState(blockpos, ModBlocks.tiberiumPod.getDefaultState(), 2);
            }
        }

        return true;
    }
}
