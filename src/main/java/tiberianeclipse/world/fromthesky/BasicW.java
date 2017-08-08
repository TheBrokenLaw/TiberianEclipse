package tiberianeclipse.world.fromthesky;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
//Heavily inspired by the AE2 meteorite code
//Read: Still learning to build my own code for this so I'm adapting his.
//All credit for this goes to the authors behind AE2
public class BasicW implements ItCameFromSpace {
    private final World world;
    public BasicW(final World world){
        this.world=world;
    }
    public boolean range( final int x, final int y, final int z ){
        return true;
    }
    @Override
    public int minX(final int in){
        return in;
    }
    @Override
    public int minZ(final int in){
        return in;
    }
    @Override
    public int maxX(final int in){
        return in;
    }
    @Override
    public int maxZ(final int in){
        return in;
    }
    @Override
    public World getWorld(){
        return this.world;
    }
    @Override
    public Block getBlock(final int x, final int y, final int z){
        if(this.range(x,y,z)){
            return this.getWorld().getBlockState(new BlockPos(x,y,z)).getBlock();
        }
        return Blocks.AIR;
    }

    @Override
    public boolean canBlockSeeStars(final int x, final int y, final int z){
        if(this.range(x,y,z)){
            return this.getWorld().canBlockSeeSky(new BlockPos(x,y,z));
        }
        return false;
    }

    @Override
    public void setBlock(final int x, final int y, final int z, final Block block){
        if(this.range(x,y,z)){
            this.getWorld().setBlockState(new BlockPos(x,y,z),block.getDefaultState());
        }
    }
    @Override
    public void finish(){

    }
    @Override
    public void setBlock(final int x, final int y, final int z, final IBlockState state, final int l){
        if(this.range(x,y,z)){
            this.world.setBlockState(new BlockPos(x,y,z),state,l);
        }
    }
    @Override
    public IBlockState getBlockState(final int x, final int y, final int z){
        if(this.range(x,y,z)){
            return this.world.getBlockState(new BlockPos(x,y,z));
        }
        return Blocks.AIR.getDefaultState();
    }
    @Override
    public TileEntity getTileEntity(final int x, final int y, final int z){
        if(this.range(x,y,z)){
            return this.getWorld().getTileEntity(new BlockPos(x,y,z));
        }
        return null;
    }

}
