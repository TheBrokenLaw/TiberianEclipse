package tiberianeclipse.world.biomes;


import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import tiberianeclipse.ClientProxy;
import tiberianeclipse.Main;

import java.util.ArrayList;
import java.util.List;

public class ModBiome extends ClientProxy{
   public static List<Biome> biomeList=new ArrayList<>();
    public static Biome ripariusField =new BiomeRipariusField();


   public static void registerBiomes(){
       register(ripariusField, BiomeManager.BiomeType.WARM, "ripariusField",20, BiomeDictionary.Type.SPOOKY, BiomeDictionary.Type.FOREST);



    }
public static void register(Biome biome, BiomeManager.BiomeType type, String name, int weight, BiomeDictionary.Type...biomeDictTypes){
        biome.setRegistryName(new ResourceLocation(Main.modId, name));
    ForgeRegistries.BIOMES.register(biome);
    BiomeManager.addBiome(type,new BiomeManager.BiomeEntry(biome, weight));
    biomeList.add(biome);
    }

}
