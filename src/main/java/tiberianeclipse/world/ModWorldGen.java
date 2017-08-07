package tiberianeclipse.world;

import net.minecraft.block.BlockPumpkin;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkGenerator;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.fml.common.IWorldGenerator;
import tiberianeclipse.block.ModBlocks;

import java.util.Random;

public class ModWorldGen  implements IWorldGenerator{

    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider){
       if(world.provider.getDimension()==0){
           generateOverworld(random, chunkX,chunkZ, world, chunkGenerator, chunkProvider);
       }


    }
    private void generateOverworld(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) {
            generateOre(ModBlocks.rockRiparius.getDefaultState(), world, random, chunkX*16, chunkZ*16, 5, 250, 6+random.nextInt(8),6);
        generateOre(ModBlocks.rockVinifera.getDefaultState(), world, random, chunkX*16, chunkZ*16, 5, 150, 8+random.nextInt(12),3);
        generateOre(ModBlocks.rockCruentus.getDefaultState(), world, random, chunkX*16, chunkZ*16, 5, 20, 12+random.nextInt(18),2);
        generateOre(ModBlocks.rockArborea.getDefaultState(), world, random, chunkX*16, chunkZ*16, 5, 15, 18+random.nextInt(24),1);
    }
       private void generateOre(IBlockState ore, World world, Random random, int x, int z, int minY, int maxY,int size,int chances){
         int deltaY=maxY-minY;
         for(int i =0; i< chances; i++){
             BlockPos pos=new BlockPos(x+random.nextInt(16), minY+random.nextInt(deltaY), z+random.nextInt(16));
             WorldGenMinable generator=new WorldGenMinable(ore, size);
             generator.generate(world, random, pos);
         }
        }



}
