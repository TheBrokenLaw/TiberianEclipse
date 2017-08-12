package tiberianeclipse.world.biomes;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeDecorator;
import tiberianeclipse.world.biomes.ModBiomeDecorator;
import java.util.Random;

public class ModBiome extends Biome {
    public BiomeDecorator theModBiomeDecorator;
    public ModBiome(Biome.BiomeProperties properties){
        super(properties);
        this.theModBiomeDecorator=this.createModBiomeDecorator();
    }
    public ModBiomeDecorator createModBiomeDecorator()
    {
        return (ModBiomeDecorator) getModModdedBiomeDecorator(new ModBiomeDecorator());
    }
    public void decorate(World worldIn, Random rand, BlockPos pos)
    {
        this.theModBiomeDecorator.decorate(worldIn, rand, this, pos);
    }

    public ModBiomeDecorator getModModdedBiomeDecorator(ModBiomeDecorator original)
    {
        return new ModBiomeDecorator();
    }

}