package tiberianeclipse;


import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraftforge.fml.common.registry.GameRegistry;
import tiberianeclipse.block.ModBlocks;
import tiberianeclipse.gui.ModGuiHandler;
import tiberianeclipse.item.ModItems;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import tiberianeclipse.recipes.ModRecipes;
import tiberianeclipse.util.EclipseTab;
import tiberianeclipse.world.ModWorldGen;
import tiberianeclipse.world.biomes.ModBiomeManager;

@Mod(modid = Main.modId, name = Main.name, version = Main.version, acceptedMinecraftVersions = "[1.10.2]")
public class Main {

    public static final String modId = "tiberianeclipse";
    public static final String name = "Tiberian Eclipse";
    public static final String version = "1.10.2-0.07a";
    @Mod.Instance(modId)
    public static Main instance;
    @SidedProxy(serverSide = "tiberianeclipse.CommonProxy", clientSide = "tiberianeclipse.ClientProxy")
    public static CommonProxy proxy;
    public static SimpleNetworkWrapper packetUtil = NetworkRegistry.INSTANCE.newSimpleChannel(modId);




    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        ModItems.init();
        ModBlocks.init();
        GameRegistry.registerWorldGenerator(new ModWorldGen(), 50);
        ModBiomeManager.registerBiomes();
        NetworkRegistry.INSTANCE.registerGuiHandler(this,new ModGuiHandler());

    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        ModRecipes.init();

    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) {

    }

    public static final EclipseTab creativeTab=new EclipseTab();

}