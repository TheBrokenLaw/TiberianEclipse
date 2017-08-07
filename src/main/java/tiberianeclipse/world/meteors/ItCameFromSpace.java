package tiberianeclipse.world.meteors;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public interface ItCameFromSpace {
    int minX( int in );
    int minZ( int in );
    int maxX( int in );
    int maxZ( int in );

    boolean isNether();
    Block getBlock( int x, int y, int z );

    boolean canBlockSeeTheSky( int i, int j, int k );
    TileEntity getTileEntity(int x, int y, int z );

    World getWorld();
    void setBlock( int i, int j, int k, Block blk );
    void setBlock( int i, int j, int k, IBlockState state, int l );
    void done();

    IBlockState getBlockState(int x, int y, int z );
}
