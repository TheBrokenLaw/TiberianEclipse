package tiberianeclipse.world.biomes;

import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.ChunkPrimer;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.event.terraingen.DecorateBiomeEvent;
import net.minecraftforge.event.terraingen.TerrainGen;
import tiberianeclipse.block.ModBlocks;
import tiberianeclipse.world.WorldGenCruentusPod;

import java.util.Random;

public class BiomeCruentusField extends Biome {
    public static WorldGenerator cruentusPod =new WorldGenCruentusPod();
    protected int cruentusPodPerChunk;
    public static BiomeProperties properties=new BiomeProperties("Cruentus Field");
   public BlockPos chunkPos;


    public BiomeCruentusField() {
        super(properties);
        this.theBiomeDecorator.treesPerChunk = -100;
        this.theBiomeDecorator.grassPerChunk = 64;
        this.topBlock = Blocks.GRASS.getDefaultState();
        this.spawnableMonsterList.clear();
        this.spawnableCreatureList.clear();
        this.spawnableWaterCreatureList.clear();
        this.cruentusPodPerChunk=64;
        this.fillerBlock=Blocks.DIRT.getDefaultState();

    }

    @Override
    public void decorate(World worldIn, Random rand, BlockPos pos) {
        if(TerrainGen.decorate(worldIn, rand, pos, DecorateBiomeEvent.Decorate.EventType.GRASS))
        {

            int i = rand.nextInt(32) + 8;
            int j = rand.nextInt(32) + 8;
            int height = worldIn.getHeight(pos.add(i, 0, j)).getY() * 2;
            if (height < 1) height = 1;
            int k = rand.nextInt(height);

            cruentusPod.generate(worldIn, rand, pos.add(i, k, j));
        }
       else if(TerrainGen.decorate(worldIn, rand, pos, DecorateBiomeEvent.Decorate.EventType.FLOWERS))
        {

            int i = rand.nextInt(32) + 8;
            int j = rand.nextInt(32) + 8;
            int height = worldIn.getHeight(pos.add(i, 0, j)).getY() * 2;
            if (height < 1) height = 1;
            int k = rand.nextInt(height);

            cruentusPod.generate(worldIn, rand, pos.add(i, k, j));
        }
        else if(TerrainGen.decorate(worldIn, rand, pos, DecorateBiomeEvent.Decorate.EventType.TREE))
        {

            int i = rand.nextInt(32) + 8;
            int j = rand.nextInt(32) + 8;
            int height = worldIn.getHeight(pos.add(i, 0, j)).getY() * 2;
            if (height < 1) height = 1;
            int k = rand.nextInt(height);

            cruentusPod.generate(worldIn, rand, pos.add(i, k, j));
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
