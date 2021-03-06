package tiberianeclipse.world;

import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;
import tiberianeclipse.block.ModBlocks;

import java.util.Random;

public class WorldGenRipariusPod extends WorldGenerator {
    private final IBlockState ripariusPodState;
    private final IBlockState fieldGrassState;
    protected void setBlock(Random random, World world, BlockPos pos, IBlockState state2){
        if(world.getBlockState(pos).isOpaqueCube()){
            world.setBlockState(pos,state2);
        }
    }
    {
        this.fieldGrassState=ModBlocks.fieldGrass.getDefaultState();
    }
    protected void setBlockAndAge(Random random, World world, BlockPos pos, IBlockState stateNew)
    {
        if (!world.getBlockState(pos).isOpaqueCube())
        {
            world.setBlockState(pos, stateNew, 2);
        }
    }

    {
        this.ripariusPodState = ModBlocks.ripariusPod.getDefaultState();
    }

    public boolean generate(World worldIn, Random rand, BlockPos position)
    {

        for (IBlockState iblockstate = worldIn.getBlockState(position); (iblockstate.getBlock().isAir(iblockstate, worldIn, position) || iblockstate.getBlock().isLeaves(iblockstate, worldIn, position)) && position.getY() > 0; iblockstate = worldIn.getBlockState(position))
        {
            position = position.down();
        }

        for (int i = 0; i < 128; ++i)

        {
            BlockPos blockpos = position.add(rand.nextInt(16) - rand.nextInt(16), rand.nextInt(4) - rand.nextInt(4), rand.nextInt(16) - rand.nextInt(16));

            if (worldIn.isAirBlock(blockpos) && ModBlocks.ripariusPod.canBlockStay(worldIn, blockpos, this.ripariusPodState))
            {
                this.setBlockAndAge(rand, worldIn, blockpos, this.ripariusPodState.withProperty(ModBlocks.ripariusPod.AGE, this.randomAge(rand)));
                this.setBlock(rand, worldIn, blockpos.down(), this.fieldGrassState);
            }
        }

        return true;
    }

    int randomAge(Random random)
    {
        return random.nextInt(6);
    }

}
