package tiberianeclipse.world.fromthesky;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.network.play.server.SPacketChunkData;
import net.minecraft.server.management.PlayerChunkMap;
import net.minecraft.server.management.PlayerChunkMapEntry;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;
import net.minecraft.world.chunk.Chunk;
//Heavily inspired by the AE2 meteorite code
//Read: Still learning to build my own code for this so I'm adapting his.
//All credit for this goes to the authors behind AE2
public class InChunk extends BasicW {
    private final Chunk target;
    private final int chunkX;
    private final int chunkZ;
    private int verticality = 0;
    public InChunk(final World world, final int chunkX, final int chunkZ){
        super(world);
        this.target=world.getChunkFromChunkCoords(chunkX,chunkZ);
        this.chunkX=chunkX;
        this.chunkZ=chunkZ;

    }
    public static void chunkSender(final Chunk chunk, final int verticality){
        try{
            final WorldServer ws=(WorldServer) chunk.getWorld();
            final PlayerChunkMap cm= ws.getPlayerChunkMap();
            final PlayerChunkMapEntry pi=cm.getEntry(chunk.xPosition, chunk.zPosition);
            if(pi!=null){
                pi.sendPacket(new SPacketChunkData(chunk, verticality));
            }
        }
        catch (final Throwable t){

        }
    }
    @Override
    public int minX(final int in){
        return Math.max(in, this.chunkX<<4);
    }
    @Override
    public int minZ(final int in){
        return Math.max(in, this.chunkZ<<4);
    }
   @Override
   public int maxX(final int in){
        return Math.min(in,(this.chunkX+1)<<4);
   }
   @Override
    public int maxZ(final int in){
       return Math.min(in, (this.chunkZ+1)<<4);
   }
   @Override
    public Block getBlock(final int x, final int y, final int z){
        if(this.range(x,y,z)){
            return this.target.getBlockState(x,y,z).getBlock();
        }
        return Blocks.AIR;
   }
   @Override
    public void setBlock(final int x, final int y, final int z, final Block block){
        if(this.range(x,y,z)){
            this.verticality |=1 <<(y >> 4);
            this.getWorld().setBlockState(new BlockPos(x,y,z), block.getDefaultState());
        }
   }
   @Override
    public void setBlock(final int x, final int y, final int z, final IBlockState state, final int flags){
        if(this.range(x,y,z)){
            this.verticality |=1<<(y>>4);
            this.getWorld().setBlockState(new BlockPos(x,y,z), state,flags &(~2));
        }
   }
   @Override
    public void finish(){
        if(this.verticality !=0){
            chunkSender(this.target, this.verticality);
        }
   }
    @Override
    public boolean range( final int x, final int y, final int z ) {
        return this.chunkX==(x>>4)&&this.chunkZ==(z>>4);
    }
}
