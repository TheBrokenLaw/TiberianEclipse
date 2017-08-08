package tiberianeclipse.world.fromthesky;

import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import tiberianeclipse.api.BlockIs;
//Heavily inspired by the AE2 meteorite code
//Read: Still learning to build my own code for this so I'm adapting his.
//All credit for this goes to the authors behind AE2
public class DebrisDoubler extends Debris {
   private static final double THRESHOLD = .07;
   private static final double AIR_THRESHOLD=.06;
   private static final double STEP_THRESHOLD=.01;
   private final IBlockState block;
   private final BlockPlacer placer;
    public DebrisDoubler(final ItCameFromSpace world, final int x, final int y, final int z, final BlockPlacer placer, final BlockIs starTibDef){
       super(placer, starTibDef);
        this.placer=placer;
        this.block=world.getBlockState(x,y,z);
    }
    @Override
    public void getRandImpact(final ItCameFromSpace world, final int x, final int y, final int z){
        final double rand = Math.random();
        if(rand>THRESHOLD){
            this.placer.place(world, x, y, z, this.block, 2);
        }
        else
            this.getOther(world, x, y, z, rand);
        }
    public void getOther(final ItCameFromSpace world, final int x, final int y, final int z, final double rand){

    }
    @Override
    public void getRandIndent(final ItCameFromSpace world, final int x, final int y, final int z){
        final double rand=Math.random();
        if(rand>THRESHOLD){
            this.placer.place(world,x,y,z, this.block, 2);
        }
        else if(rand>AIR_THRESHOLD){
            this.placer.place(world,x,y,z, Blocks.AIR);
            }
        else{
            this.getOther(world, x, y, z, rand -STEP_THRESHOLD);
        }
    }
}
