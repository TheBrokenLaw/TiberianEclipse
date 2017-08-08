package tiberianeclipse;

import net.minecraft.item.Item;

import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import tiberianeclipse.block.ModBlocks;
import tiberianeclipse.entities.ModEntities;
import tiberianeclipse.item.ModItems;
import tiberianeclipse.recipes.ModRecipes;
import tiberianeclipse.world.biomes.ModBiome;

import java.io.File;

public class CommonProxy {
    public static Configuration config;
    public void registerItemRenderer(Item item, int meta, String id) {
    }
    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event){
        File directory = event.getModConfigurationDirectory();
        config =new Configuration(new File(directory.getPath(),"TiberianEclipse.cfg"));
        ModItems.init();
        ModBlocks.init();

        ModRecipes.init();
        ModEntities.init();
        ModBiome.registerBiomes();

    }

}
