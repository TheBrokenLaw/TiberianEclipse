package tiberianeclipse.world;

import net.minecraft.init.Biomes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.IChunkGenerator;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.fml.common.IWorldGenerator;
import tiberianeclipse.world.biomes.ModBiomes;

import java.util.Random;

public class ModWorldGen implements IWorldGenerator{
    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider){
       int blockX=chunkX*16;
       int blockZ=chunkZ*16;
       switch(world.provider.getDimension()){
           case -1:generateNether(world, random, blockX, blockZ);
           case 0: generateOverworld(world, random, blockX, blockZ);
           case 1: generateEnd(world, random, blockX,blockZ);
       }

    }
    private void generateNether(World world, Random rand, int blockX, int blockZ){}
    private void generateEnd(World world, Random rand, int blockX, int blockZ){}
    private void generateOverworld(World world, Random rand, int blockX, int blockZ){
        WorldGenerator RipariusPod= new WorldGenRipariusPod();
        Biome biome= world.getBiome(new BlockPos(blockX, 64, blockZ));
        if(biome== Biomes.PLAINS||biome== Biomes.FOREST||biome== Biomes.MUTATED_DESERT||biome== Biomes.DESERT||biome== Biomes.DESERT_HILLS){
            int min =4;
            int max =12;
            int numPods=min+rand.nextInt(max);
            for(int i=0; i<numPods;i++){
                int randX=blockX+rand.nextInt(16);
                int randZ=blockZ+rand.nextInt(16);
                RipariusPod.generate(world, rand, new BlockPos(randX, 24, randZ));
            }
        }
        WorldGenerator mutatedTree=new WorldGenMutatedTree(false, false);
       if(
                 biome== ModBiomes.ripariusField
               ||biome== ModBiomes.viniferaField
               ||biome== ModBiomes.cruentusField
               ||biome== ModBiomes.arboreaField){
           int min =4;
           int max =12;
           int numTrees=min+rand.nextInt(max);
           for(int i=0; i<numTrees;i++){
               int randX=blockX+rand.nextInt(16);
               int randZ=blockZ+rand.nextInt(16);
               mutatedTree.generate(world, rand, new BlockPos(randX, 24, randZ));
           }
       }
    }
}
