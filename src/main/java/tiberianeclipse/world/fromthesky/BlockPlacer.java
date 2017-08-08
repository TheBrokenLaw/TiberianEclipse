package tiberianeclipse.world.fromthesky;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
//Heavily inspired by the AE2 meteorite code
//Read: Still learning to build my own code for this so I'm adapting his.
//All credit for this goes to the authors behind AE2
public class BlockPlacer {
    public boolean place(final ItCameFromSpace world, final int i, final int j, final int k, final Block block){
        final Block original=world.getBlock(i, j, k);
        if(original== Blocks.BEDROCK||original==block){
            return false;
        }
        world.setBlock(i,j,k,block);
        return true;
    }
    void place(final ItCameFromSpace world, final int i, final int j, final int k, final IBlockState state, final int meta){
        if(world.getBlock(i,j,k)==Blocks.BEDROCK){
            return;
        }
        world.setBlock(i,j,k,state,3);
    }
}
