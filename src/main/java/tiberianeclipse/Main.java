package tiberianeclipse;


import tiberianeclipse.block.ModBlocks;
import tiberianeclipse.item.ModItems;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import tiberianeclipse.recipes.ModRecipes;
import tiberianeclipse.util.EclipseTab;

@Mod(modid = Main.modId, name = Main.name, version = Main.version, acceptedMinecraftVersions = "[1.10.2]")
public class Main {

    public static final String modId = "TiberianEclipse";
    public static final String name = "Tiberian Eclipse";
    public static final String version = "0.0.01a";

    @Mod.Instance(modId)
    public static Main instance;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {

        ModBlocks.init();
        ModItems.init();
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        ModRecipes.init();

    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) {

    }
    @SidedProxy(serverSide = "tiberianeclipse.CommonProxy", clientSide = "tiberianeclipse.ClientProxy")
    public static CommonProxy proxy;
    public static final EclipseTab creativeTab=new EclipseTab();
}