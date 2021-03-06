package tiberianeclipse.world.biomes;

import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;

import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.ChunkPrimer;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.event.terraingen.DecorateBiomeEvent;
import tiberianeclipse.block.ModBlocks;
import tiberianeclipse.world.WorldGenMutatedTree;
import tiberianeclipse.world.WorldGenRipariusPod;
import tiberianeclipse.world.WorldGenViniferaPod;

import java.util.Random;

public class BiomeRipariusField extends ModBiome {
    public static WorldGenerator ripariusPod =new WorldGenRipariusPod();
    public static WorldGenerator viniferaPod =new WorldGenViniferaPod();
    public static WorldGenerator tibMutTree=new WorldGenMutatedTree(true, true);
    public static BiomeProperties properties=new BiomeProperties("Riparius Field");
   public BlockPos chunkPos;


    public BiomeRipariusField() {
        super(properties);
        this.theModBiomeDecorator.mushroomsPerChunk=2;
        this.theBiomeDecorator.treesPerChunk = 2;
        this.theBiomeDecorator.grassPerChunk = 64;
        this.theBiomeDecorator.flowersPerChunk=64;
        this.topBlock = Blocks.GRASS.getDefaultState();
        this.spawnableMonsterList.clear();
        this.spawnableCreatureList.clear();
        this.spawnableWaterCreatureList.clear();
        this.fillerBlock=Blocks.DIRT.getDefaultState();

    }

    @Override
    public void decorate(World worldIn, Random rand, BlockPos pos) {
        if(net.minecraftforge.event.terraingen.TerrainGen.decorate(worldIn, rand, pos, DecorateBiomeEvent.Decorate.EventType.GRASS))
        {

            int i = rand.nextInt(32) + 8;
            int j = rand.nextInt(32) + 8;
            int height = worldIn.getHeight(pos.add(i, 0, j)).getY() * 2;
            if (height < 1) height = 1;
            int k = rand.nextInt(height);

            ripariusPod.generate(worldIn, rand, pos.add(i, k, j));
        }
        if(net.minecraftforge.event.terraingen.TerrainGen.decorate(worldIn, rand, pos, DecorateBiomeEvent.Decorate.EventType.FLOWERS))
       {

            int i = rand.nextInt(32) + 8;
            int j = rand.nextInt(32) + 8;
            int height = worldIn.getHeight(pos.add(i, 0, j)).getY() * 2;
            if (height < 1) height = 1;
            int k = rand.nextInt(height);

            ripariusPod.generate(worldIn, rand, pos.add(i, k, j));
        }
        if(net.minecraftforge.event.terraingen.TerrainGen.decorate(worldIn, rand, pos, DecorateBiomeEvent.Decorate.EventType.TREE))
        {

            int i = rand.nextInt(32) + 8;
            int j = rand.nextInt(32) + 8;
            int height = worldIn.getHeight(pos.add(i, 0, j)).getY() * 2;
            if (height < 1) height = 1;
            int k = rand.nextInt(height);

            viniferaPod.generate(worldIn, rand, pos.add(i, k, j));
        }
    }
    public void genTerrainBlocks(World world, Random rand, ChunkPrimer chunkPrimer, int x, int z, double noiseVal){
       this.topBlock=Blocks.GRASS.getDefaultState();
       if(noiseVal>1.0D){
           this.topBlock=Blocks.GRASS.getDefaultState();
           this.fillerBlock=Blocks.DIRT.getDefaultState();
       }
       this.generateBiomeTerrain(world, rand, chunkPrimer, x,z,noiseVal);
    }
}
