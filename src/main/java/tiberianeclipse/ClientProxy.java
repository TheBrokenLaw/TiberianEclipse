package tiberianeclipse;

import net.minecraft.block.Block;
import net.minecraft.block.properties.IProperty;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.ItemRenderer;
import net.minecraft.client.renderer.block.model.ModelBakery;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.block.statemap.StateMap;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import tiberianeclipse.block.ModBlocks;
import tiberianeclipse.entities.ModEntities;
import tiberianeclipse.item.ModItems;
import tiberianeclipse.world.ModWorldGen;

import static tiberianeclipse.Main.modId;

public class ClientProxy extends CommonProxy {


    @Override
    public void preInit(FMLPreInitializationEvent e) {
        super.preInit(e);
        ModItems.init();
        ModBlocks.init();
        ModEntities.init();
    }

    public void registerItemRenderer(Item item, int meta, String name) {
        ModelLoader.setCustomModelResourceLocation(item, meta, new ModelResourceLocation(modId + ":" + name, "inventory"));
    }


}





