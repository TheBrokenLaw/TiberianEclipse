package tiberianeclipse.world.biomes;

import java.util.Random;

import net.minecraft.block.BlockStone;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeDecorator;
import net.minecraft.world.gen.ChunkProviderSettings;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.fml.common.eventhandler.Event;
import net.minecraftforge.fml.common.eventhandler.IEventExceptionHandler;
import tiberianeclipse.world.WorldGenMutatedTree;

public class ModBiomeDecorator extends BiomeDecorator {
    public WorldGenerator tibMutTrees= new WorldGenMutatedTree(true, true);

    private static int maxID = 0;
    private final int busID = maxID++;
    private IEventExceptionHandler exceptionHandler;
    public int tibMutTreesPerChunk;
    public float extraTibTreeChance=.01f;
    public World world;
    public Random rand;
    public BlockPos pos;
    public Event.Result result;
    public ModDecorateBiomeEvent.ModDecorate.EventType type;

    public ModBiomeDecorator() {
    }


    public static boolean decorate(World world, Random rand, BlockPos pos, ModDecorateBiomeEvent.ModDecorate.EventType type)
    {

        ModDecorateBiomeEvent.ModDecorate event = new ModDecorateBiomeEvent.ModDecorate(world, rand, pos, type);
        return true;
    }
    public void moddecorate(World worldIn, Random random, Biome biome, BlockPos pos)
    {
        if (this.decorating)
        {
            throw new RuntimeException("Already decorating");
        }
        else
        {
            this.chunkProviderSettings = ChunkProviderSettings.Factory.jsonToFactory(worldIn.getWorldInfo().getGeneratorOptions()).build();
            this.chunkPos = pos;
            this.dirtGen = new WorldGenMinable(Blocks.DIRT.getDefaultState(), this.chunkProviderSettings.dirtSize);
            this.gravelGen = new WorldGenMinable(Blocks.GRAVEL.getDefaultState(), this.chunkProviderSettings.gravelSize);
            this.graniteGen = new WorldGenMinable(Blocks.STONE.getDefaultState().withProperty(BlockStone.VARIANT, BlockStone.EnumType.GRANITE), this.chunkProviderSettings.graniteSize);
            this.dioriteGen = new WorldGenMinable(Blocks.STONE.getDefaultState().withProperty(BlockStone.VARIANT, BlockStone.EnumType.DIORITE), this.chunkProviderSettings.dioriteSize);
            this.andesiteGen = new WorldGenMinable(Blocks.STONE.getDefaultState().withProperty(BlockStone.VARIANT, BlockStone.EnumType.ANDESITE), this.chunkProviderSettings.andesiteSize);
            this.coalGen = new WorldGenMinable(Blocks.COAL_ORE.getDefaultState(), this.chunkProviderSettings.coalSize);
            this.ironGen = new WorldGenMinable(Blocks.IRON_ORE.getDefaultState(), this.chunkProviderSettings.ironSize);
            this.goldGen = new WorldGenMinable(Blocks.GOLD_ORE.getDefaultState(), this.chunkProviderSettings.goldSize);
            this.redstoneGen = new WorldGenMinable(Blocks.REDSTONE_ORE.getDefaultState(), this.chunkProviderSettings.redstoneSize);
            this.diamondGen = new WorldGenMinable(Blocks.DIAMOND_ORE.getDefaultState(), this.chunkProviderSettings.diamondSize);
            this.lapisGen = new WorldGenMinable(Blocks.LAPIS_ORE.getDefaultState(), this.chunkProviderSettings.lapisSize);
            this.modGenDecorations((ModBiome) biome, worldIn, random);
            this.decorating = false;
        }
    }
    protected void modGenDecorations(ModBiome biomeIn, World worldIn, Random random) {
        net.minecraftforge.common.MinecraftForge.EVENT_BUS.post(new ModDecorateBiomeEvent.Pre(worldIn, random, chunkPos));
        int k1 = this.tibMutTreesPerChunk;

        if (random.nextFloat() < this.extraTibTreeChance)
        {
            ++k1;
        }

        if(this.decorate(worldIn, random, chunkPos, ModDecorateBiomeEvent.ModDecorate.EventType.TibTree))
            for (int j2 = 0; j2 < k1; ++j2)
            {
                int k6 = random.nextInt(16) + 8;
                int l = random.nextInt(16) + 8;
                WorldGenMutatedTree worldGenMutatedTree = (WorldGenMutatedTree) biomeIn.genBigTreeChance(random);
                worldGenMutatedTree.setDecorationDefaults();
                BlockPos blockpos = worldIn.getHeight(this.chunkPos.add(k6, 0, l));

                if (worldGenMutatedTree.generate(worldIn, random, blockpos))
                {
                    worldGenMutatedTree.generateSaplings(worldIn, random, blockpos);
                }
            }
    }
}
