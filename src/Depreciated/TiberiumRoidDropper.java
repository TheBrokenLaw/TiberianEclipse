package tiberianeclipse.world;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.init.Blocks;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import tiberianeclipse.api.BlockIs;
import tiberianeclipse.block.ModBlocks;
import tiberianeclipse.world.fromthesky.*;

import java.util.Collection;
import java.util.HashSet;

//Heavily inspired by the AE2 meteorite code
//Read: Still learning to build my own code for this so I'm adapting his.
//All credit for this goes to the authors behind AE2
public final class TiberiumRoidDropper {
    private static Collection<Block> canDrop=new HashSet<>();
    private static Collection<Block> cannotDrop=new HashSet<>();
    private static BlockIs starTibDef;
    private final BlockPlacer placer=new BlockPlacer();
    private double rockSize=(Math.random()*4)+2;
    private double impactSize=this.rockSize*1.5 + 3;
    private double rockSizeSq=this.rockSize*this.rockSize;
    private double impactSite=this.impactSize*this.impactSize;
    private NBTTagCompound options;
    private Debris type;
    public TiberiumRoidDropper(){
    this.canDrop.add(Blocks.STONE);
    this.canDrop.add(Blocks.GRASS);
    this.canDrop.add(Blocks.GRAVEL);
    this.canDrop.add(Blocks.GRASS_PATH);
    this.canDrop.add(Blocks.SAND);
    this.canDrop.add(Blocks.DIRT);
    this.canDrop.add(Blocks.GRAVEL);
    this.canDrop.add(Blocks.ICE);
    this.canDrop.add(Blocks.PACKED_ICE);
    this.canDrop.add(Blocks.SNOW);
    this.canDrop.add(Blocks.SNOW_LAYER);
    this.canDrop.add(Blocks.HARDENED_CLAY);

        this.cannotDrop.add(Blocks.PLANKS);
        this.cannotDrop.add(Blocks.IRON_DOOR);
        this.cannotDrop.add(Blocks.IRON_BARS);
        this.cannotDrop.add(Blocks.IRON_BLOCK);
        this.cannotDrop.add(Blocks.IRON_TRAPDOOR);
        this.cannotDrop.add(Blocks.OAK_DOOR);
        this.cannotDrop.add(Blocks.ACACIA_DOOR);
        this.cannotDrop.add(Blocks.SPRUCE_DOOR);
        this.cannotDrop.add(Blocks.BIRCH_DOOR);
        this.cannotDrop.add(Blocks.DARK_OAK_DOOR);
        this.cannotDrop.add(Blocks.JUNGLE_DOOR);
        this.cannotDrop.add(Blocks.BRICK_BLOCK);
        this.cannotDrop.add(Blocks.WATER);
        this.cannotDrop.add(Blocks.CLAY);
        this.cannotDrop.add(Blocks.LOG);
        this.cannotDrop.add(Blocks.LOG2);

        this.type=new Debris(this.placer, this.starTibDef);
    }
    boolean spawnRock(final ItCameFromSpace world, final NBTTagCompound rockBlock){
        this.options=rockBlock;
        final int x =this.options.getInteger("x");
        final int y =this.options.getInteger("y");
        final int z =this.options.getInteger("z");
        this.rockSize=this.options.getDouble("trueRockSize");
        this.impactSize=this.options.getDouble("impactSize");
        this.rockSizeSq=this.options.getDouble("rockSize");
        this.impactSite=this.options.getDouble("impactSite");
        final Block block=Block.getBlockById(this.options.getInteger("block"));
        if(block==Blocks.SAND){
            this.type=new DebrisDesert(world,x,y,z,this.placer,this.starTibDef);
        }
        else if(block==Blocks.HARDENED_CLAY){
            this.type=new DebrisDoubler(world,x,y,z,this.placer,this.starTibDef);
        }
        else if(block==Blocks.ICE||block==Blocks.SNOW){
            this.type=new DebrisWinter(world,x,y,z,this.placer,this.starTibDef);
        }
        final int dropType=this.options.getInteger("dropType");
        if(dropType>10){
            this.placeImpact(world,x,y,z);
        }
        this.placeRock(world,x,y,z);
        if(dropType>3){
            this.decay(world,x,y,z);
        }
        world.finish();
        return true;
    }
    private void placeImpact(final ItCameFromSpace world, final int x, final int y, final int z){
        final boolean lava=this.options.getBoolean("lava");
        final int maxY =255;
        final int minX=world.minX(x-200);
        final int maxX=world.maxX(x+200);
        final int minZ=world.minZ(z-200);
        final int maxZ=world.maxZ(z+200);
        for(int j=y-5; j<maxY;j++){
            boolean changed =false;
            for(int i=minX;i<maxX;i++){
                for(int k=minZ; k<maxZ;k++){
                    final double dx=i-x;
                    final double dz=k-z;
                    final double h=y-this.rockSize+1+this.type.arrangeImpact();
                    final double distance=dx*dx+dz*dz;
                    if(j>h+distance*0.02){
                        if(lava&&j<y&&world.getBlockState(i,j,k).getMaterial().isSolid()){
                            if(j>h+distance*0.02){
                               this.placer.place(world,i,j,k,Blocks.LAVA);
                            }
                        }
                        else{
                            changed= this.placer.place(world,i,j,k,Blocks.AIR)||changed;
                        }
                    }
                }
            }
        }
        for(final Object o:world.getWorld().getEntitiesWithinAABB(EntityItem.class,
                new AxisAlignedBB( world.minX( x - 30 ), y - 5, world.minZ( z - 30 ), world.maxX( x + 30 ), y + 30, world.maxZ( z + 30 ) ) ) ){
            final Entity e=(Entity) o;
            e.setDead();
        }
    }
      private void placeRock(final ItCameFromSpace world, final int x, final int y, final int z){
        this.placeTibRock(world, x, y, z, ModBlocks.rockRiparius);
      }
      private void placeTibRock(ItCameFromSpace world, final int x, final int y, final int z, Block block){
          final int rockXLength=world.minX(x-6);
          final int rockXHeight=world.maxX(x+6);
          final int rockZLength=world.minZ(z-8);
          final int rockZHeight=world.maxZ(z+8);
          for(int i=rockXLength; i<rockXHeight;i++){
              for(int j=y-8;j<y+8;j++){
                  for(int k=rockZLength;k<rockZHeight;k++) {
                      final double dx = i - x;
                      final double dy = j - y;
                      final double dz = k - z;
                      if(dx*dx*0.7+dy*dy*(j>y?1.4:0.8)+dz*dz*0.7<this.rockSizeSq){
                          this.placer.place(world, i, j, k, block);
                      }
                  }
              }
          }

      }
    private void decay(ItCameFromSpace world, final int x, final int y, final int z){
          double rand=0;
        final int rockXLength=world.minX(x-6);
        final int rockXHeight=world.maxX(x+6);
        final int rockZLength=world.minZ(z-8);
        final int rockZHeight=world.maxZ(z+8);
        for(int i=rockXLength; i<rockXHeight;i++){
            for(int k=rockZLength;k<rockZHeight;k++) {
                for(int j=y-9;j<y+30;j++) {
                    Block block1=world.getBlock(i,j,k);
                    if(block1==Blocks.LAVA){
                        continue;
                    }
                    if(block1.isReplaceable(world.getWorld(),new BlockPos(i,j,k))){
                        block1= Blocks.AIR;
                        final Block block2=world.getBlock(i,j+1,k);
                        if(block2!=block1){
                            final IBlockState meta2=world.getBlockState(i,j+1,k);
                            world.setBlock(i,j,k,meta2,3);
                        }
                        else if(rand<100*this.impactSite){
                            final double dx = i - x;
                            final double dy = j - y;
                            final double dz = k - z;
                            final double dist=dx*dx+dy*dy+dz*dz;
                            final Block blk=world.getBlock(i,j-1,k);
                            if(!blk.isReplaceable(world.getWorld(),new BlockPos(i,j-1,k))){
                                final double xtra=Math.random()*0.5;
                                final double height=this.impactSite*(xtra+0.2)-Math.abs(dist-this.impactSite*1.7);
                                if(blk!=block1&&height>0&&Math.random()>0.6){
                                    rand++;
                                    this.type.getRandImpact(world, i, j, k);
                                }
                            }
                        }
                    }
                    else{
                        final Block blocka=world.getBlock(i,j+1,k);
                        if(blocka==Blocks.AIR){
                            if(Math.random()>0.4){
                                final double dx = i - x;
                                final double dy = j - y;
                                final double dz = k - z;
                                if(dx*dx+dy*dy+dz*dz<this.impactSite*1.6){
                                    this.type.getRandIndent(world,i,j,k);
                                }
                            }
                        }
                    }
                }
            }
        }

    }
    double getSqDist(final int x, final int z){
        final int chunkX=this.options.getInteger("x")-x;
        final int chunkZ=this.options.getInteger("z")-z;
        return chunkX*chunkX+chunkZ*chunkZ;
    }
    public boolean spawnRock(final ItCameFromSpace world, final int x, final int y, final int z){
        Block block=world.getBlock(x,y,z);
        if(!this.canDrop.contains(block)){
            return false;
        }
        this.options=new NBTTagCompound();
        this.options.setInteger("x",x);
        this.options.setInteger("y",y);
        this.options.setInteger("z",z);
        this.options.setInteger("block",Block.getIdFromBlock(block));
        this.options.setDouble("trueRockSize",this.rockSize);
        this.options.setDouble("impactSize",this.impactSize);
        this.options.setDouble("rockSizeSq",this.rockSizeSq);
        this.options.setDouble("impactSite",this.impactSite);
        this.options.setBoolean("lava",Math.random()>0.9);
        if(block==Blocks.SAND){
            this.type= new DebrisDesert(world,x,y,z,this.placer,this.starTibDef);
        }
        else if(block==Blocks.HARDENED_CLAY){
            this.type= new DebrisDoubler(world,x,y,z,this.placer,starTibDef);
        }
        else if(block==Blocks.ICE||block==Blocks.SNOW){
            this.type= new DebrisWinter(world,x,y,z,this.placer,starTibDef);
        }
        int realValidBlocks=0;
        for (int i=x-6;i<x+6;i++) {
            for(int j=y-6;j<y+6;j++) {
                for(int k=z-6;k<z+6;k++) {
                    block=world.getBlock(i,j,k);
                    if(this.canDrop.contains(block)) {
                        realValidBlocks++;
                    }
                }
            }
        }
        int validBlocks=0;
        for(int i=x-15;i<x+15;i++) {
            for(int j=y-15;j<y+15;j++) {
                for(int k=z-15;k<z+15;k++) {
                    block=world.getBlock(i,j,k);
                    if(this.cannotDrop.contains(block)) {
                        return false;
                    }
                    if(this.canDrop.contains(block)) {
                        validBlocks++;
                    }
                }
            }
        }
        final int minBlocks=200;
        if(validBlocks>minBlocks&&realValidBlocks>80) {
            int dropType=0;
            for( int i = x - 15; i < x + 15; i++ ) {
                for( int j = y - 15; j < y + 11; j++ ) {
                    for( int k = z - 15; k < z + 15; k++ ) {
                        if( world.canBlockSeeStars( i, j, k ) ) {
                            dropType++;
                        }
                    }
                }
            }
            boolean solid = true;
            for( int j = y - 15; j < y - 1; j++ ) {
                if( world.getBlock( x, j, z ) ==Blocks.AIR) {
                    solid = false;
                }
            }
            if( !solid ) {
                dropType = 0;
            }
            if( dropType> 10 ) {
                this.placeImpact( world, x, y, z );
            }
            this.placeRock(world, x, y, z );
            if( dropType > 3 ) {
                this.decay(world, x, y, z );
            }
            this.options.setInteger( "dropType", dropType );
            world.finish();
            return true;
        }
        return false;
    }

        NBTTagCompound getSettings()
        {
        return this.options;
        }
}

