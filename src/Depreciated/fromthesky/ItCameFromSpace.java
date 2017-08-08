package tiberianeclipse.world.fromthesky;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
//Heavily inspired by the AE2 meteorite code
//Read: Still learning to build my own code for this so I'm adapting his.
//All credit for this goes to the authors behind AE2
public interface ItCameFromSpace {
    int minX( int in );
    int minZ( int in );
    int maxX( int in );
    int maxZ( int in );

    boolean canBlockSeeStars( int i, int j, int k );

    void setBlock( int i, int j, int k, Block blk );
    void setBlock( int i, int j, int k, IBlockState state, int l );
    void finish();

    IBlockState getBlockState(int x, int y, int z );
    Block getBlock( int x, int y, int z );
    TileEntity getTileEntity(int x, int y, int z );
    World getWorld();



}
