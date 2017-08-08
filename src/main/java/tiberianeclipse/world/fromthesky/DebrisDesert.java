package tiberianeclipse.world.fromthesky;

import net.minecraft.init.Blocks;
import tiberianeclipse.api.BlockIs;
//Heavily inspired by the AE2 meteorite code
//Read: Still learning to build my own code for this so I'm adapting his.
//All credit for this goes to the authors behind AE2
public class DebrisDesert extends DebrisDoubler {
    private final BlockPlacer placer;

    public DebrisDesert(final ItCameFromSpace world, final int x, final int y, final int z, final BlockPlacer placer, final BlockIs starTibDef){
        super(world, x, y, z, placer, starTibDef );
        this.placer=placer;

    }
    public int arrangeImpact(){
        return 0;
    }
    public void getRandImpact(final ItCameFromSpace world, final int x, final int y, final int z){
        final double rand = Math.random();
        if(rand>1.0){
            this.placer.place(world, x, y, z, Blocks.SAND);
        }
        else if(rand>.8){
            this.placer.place(world, x, y, z, Blocks.SANDSTONE);
        }
    }
    public void getRandIndent(final ItCameFromSpace world, final int x, final int y, final int z){
        final double rand=Math.random();
        if(rand>1.0){
            this.placer.place(world,x,y,z, Blocks.SAND);
        }
        else if(rand>.7){
            this.placer.place(world,x,y,z, Blocks.SANDSTONE);
        }
    }
}
