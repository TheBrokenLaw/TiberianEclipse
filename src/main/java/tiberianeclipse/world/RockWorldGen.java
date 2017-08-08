package tiberianeclipse.world;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkGenerator;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraftforge.fml.common.IWorldGenerator;
import tiberianeclipse.world.TiberiumRoidDropper;
import tiberianeclipse.world.fromthesky.InChunk;

import java.util.Random;

public class RockWorldGen implements IWorldGenerator {
    private static final Random rand=new Random();
    @Override
    public void generate(final Random r, final int chunkX, final int chunkZ, final World w, final IChunkGenerator chunkGenerator, final IChunkProvider chunkProvider )
    {

            final int x = r.nextInt( 16 ) + ( chunkX << 4 );
            final int z = r.nextInt( 16 ) + ( chunkZ << 4 );
            final int depth = 200 + r.nextInt( 20 );




    }

    private boolean tryMeteorite( final World w, int depth, final int x, final int z )
    {
        for( int tries = 0; tries < 20; tries++ )
        {
            final TiberiumRoidDropper mp = new TiberiumRoidDropper();

            if( mp.spawnRock( new InChunk( w, x >> 4, z >> 4 ), x, depth, z ) )
            {
                final int px = x >> 4;
                final int pz = z >> 4;

                for( int cx = px - 6; cx < px + 6; cx++ )
                {
                    for( int cz = pz - 6; cz < pz + 6; cz++ )
                    {
                        if( w.getChunkProvider().getLoadedChunk( cx, cz ) != null )
                        {
                            if( px == cx && pz == cz )
                            {
                                continue;
                            }
                        }
                    }
                }

                return true;
            }

            depth -= 15;
            if( depth < 40 )
            {
                return false;
            }
        }

        return false;
    }



    private class RockSpawn
    {

        private final int x;
        private final int z;
        private final int depth;

        public RockSpawn( final int x, final int depth, final int z )
        {
            this.x = x;
            this.z = z;
            this.depth = depth;
        }


        public Object call( final World world ) throws Exception
        {
            final int chunkX = this.x >> 4;
            final int chunkZ = this.z >> 4;

            double minSqDist = Double.MAX_VALUE;


            final boolean isCluster = ( minSqDist < 30 * 30 );

            return null;
        }
    }
}
