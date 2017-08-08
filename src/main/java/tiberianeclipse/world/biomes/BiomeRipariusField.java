package tiberianeclipse.world.biomes;

import net.minecraft.entity.passive.EntityMooshroom;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.ChunkPrimer;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.event.terraingen.DecorateBiomeEvent;
import net.minecraftforge.event.terraingen.TerrainGen;
import net.minecraftforge.fml.common.registry.GameRegistry;
import tiberianeclipse.block.ModBlocks;
import tiberianeclipse.world.WorldGenTiberiumPod;

import java.util.Random;

public class BiomeRipariusField extends Biome {
    public static WorldGenerator tiberiumPod =new WorldGenTiberiumPod();
    protected int tiberiumPodPerChunk;
    public static BiomeProperties properties=new BiomeProperties("Riparius Field");
   static{

   }


    public BiomeRipariusField() {
        super(properties);
        this.theBiomeDecorator.treesPerChunk = -100;
        this.theBiomeDecorator.flowersPerChunk = -100;
        this.theBiomeDecorator.grassPerChunk = -100;
        this.topBlock = ModBlocks.tiberiumGround.getDefaultState();
        this.spawnableMonsterList.clear();
        this.spawnableCreatureList.clear();
        this.spawnableWaterCreatureList.clear();

    }

    @Override
    public void decorate(World world, Random rand, BlockPos pos){
       if(TerrainGen.decorate(world, rand, pos, DecorateBiomeEvent.Decorate.EventType.FLOWERS)){
           for(int j=0;64<this.tiberiumPodPerChunk;j++){
               int i=rand.nextInt(16)+8;
               int k=rand.nextInt(16)+8;
               int l=world.getHeight(pos.add(i,0,k)).getY()*2;
                if(l>0){
                    int o =rand.nextInt(l);
                    this.tiberiumPod.generate(world, rand, pos.add(i,o,l));
                }

           }
       }

       else if(TerrainGen.decorate(world, rand, pos, DecorateBiomeEvent.Decorate.EventType.GRASS)){
            for(int j=0;64<this.tiberiumPodPerChunk;j++){
                int i=rand.nextInt(16)+8;
                int k=rand.nextInt(16)+8;
                int l=world.getHeight(pos.add(i,0,k)).getY()*2;
                if(l>0){
                    int o =rand.nextInt(l);
                    this.tiberiumPod.generate(world, rand, pos.add(i,o,l));
                }

            }
        }
    }
    public void genTerrainBlocks(World world, Random rand, ChunkPrimer chunkPrimer, int x, int z, double noiseVal){
       this.topBlock=ModBlocks.tiberiumGround.getDefaultState();
       if(noiseVal>1.0D){
           this.topBlock=ModBlocks.tiberiumGround.getDefaultState();
       }
       this.generateBiomeTerrain(world, rand, chunkPrimer, x,z,noiseVal);
    }
}
