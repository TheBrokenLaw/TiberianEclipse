package tiberianeclipse.world.fromthesky;

import net.minecraft.init.Blocks;
import tiberianeclipse.api.BlockIs;
//Heavily inspired by the AE2 meteorite code
//Read: Still learning to build my own code for this so I'm adapting his.
//All credit for this goes to the authors behind AE2
public class Debris{
    private final BlockPlacer placer;
    private final BlockIs starTibDef;
    public Debris(final BlockPlacer placer, final BlockIs starTibDef){
        this.placer=placer;
        this.starTibDef=starTibDef;
    }
    public int arrangeImpact(){
        return 0;
    }
    public void getRandImpact(final ItCameFromSpace world, final int x, final int y, final int z){
        final double rand = Math.random();
        if(rand>1.0){
            this.placer.place(world, x, y, z, Blocks.STONE);
        }
        else if(rand>.8){
            this.placer.place(world, x, y, z, Blocks.COBBLESTONE);
        }
    }
    public void getRandIndent(final ItCameFromSpace world, final int x, final int y, final int z){
        final double rand=Math.random();
        if(rand>1.0){
            this.placer.place(world,x,y,z, Blocks.COBBLESTONE);
        }
        else if(rand>.7){
            this.placer.place(world,x,y,z, Blocks.STONE);
        }
    }
}
