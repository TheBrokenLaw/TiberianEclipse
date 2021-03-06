package tiberianeclipse;

import net.minecraft.block.Block;
import net.minecraft.block.properties.IProperty;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.ItemRenderer;
import net.minecraft.client.renderer.block.model.ModelBakery;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.block.statemap.StateMap;
import net.minecraft.client.resources.I18n;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.client.model.obj.OBJLoader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import tiberianeclipse.block.ModBlocks;
import tiberianeclipse.entities.ModEntities;
import tiberianeclipse.item.ModItems;
import tiberianeclipse.sounds.TESoundHandler;
import tiberianeclipse.world.ModWorldGen;

import static tiberianeclipse.Main.modId;

public class ClientProxy extends CommonProxy {


    @Override

    public void preInit(FMLPreInitializationEvent e) {
        super.preInit(e);
        ModItems.init();
        ModBlocks.init();
        ModEntities.init();
        TESoundHandler.init();
        OBJLoader.INSTANCE.addDomain(Main.modId);



    }
    public void registerOBJRenderer(Item item, int meta, String name) {
        ModelLoader.setCustomModelResourceLocation(item, meta, new ModelResourceLocation(modId + ":" + name, "inventory"));
    }
    public void registerItemRenderer(Item item, int meta, String name) {
        ModelLoader.setCustomModelResourceLocation(item, meta, new ModelResourceLocation(modId + ":" + name, "inventory"));
    }

    @Override
    public String localize(String unlocalized, Object... args) {
        return I18n.format(unlocalized, args);
    }
}





