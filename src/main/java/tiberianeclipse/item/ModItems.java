package tiberianeclipse.item;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;
import tiberianeclipse.ClientProxy;
import tiberianeclipse.item.tools.BaseSword;
import tiberianeclipse.item.tools.BaseTool;
import tiberianeclipse.util.IModelProvider;

public class ModItems extends ClientProxy{
    // Tiberium Varieties
    public static ItemBase ripariusShard;
    public static ItemBase viniferaShard;
    public static ItemBase cruentusShard;
    public static ItemBase arboreaShard;
    public static ItemBase ripariusCluster;
    public static ItemBase viniferaCluster;
    public static ItemBase cruentusCluster;
    public static ItemBase arboreaCluster;
    public static ItemBase ripVinCluster;
    public static ItemBase vinRipCluster;
    public static ItemBase vinCruCluster;
    public static ItemBase cruVinCluster;
    public static ItemBase cruArborCluster;
    public static ItemBase arborCruCluster;
    //Tools
        //Swords
    public static BaseSword ripariusBlade;
    public static BaseSword viniferaBlade;
    public static BaseSword cruentusBlade;
    public static BaseSword arboreaBlade;

    public static ItemBase refinedTiberium;
    public static void init() {
        //Tiberium shards and clusters
        ripariusShard = register(new ItemBase("ripariusShard",0));
        viniferaShard = register(new ItemBase("viniferaShard",0));
        cruentusShard = register(new ItemBase("cruentusShard",0));
        arboreaShard = register(new ItemBase("arboreaShard",0));
        ripariusCluster =register(new ItemBase("ripariusCluster",0));
        viniferaCluster = register(new ItemBase("viniferaCluster",0));
        cruentusCluster = register(new ItemBase("cruentusCluster",0));
        arboreaCluster = register(new ItemBase("arboreaCluster",0));
        ripVinCluster =register(new ItemBase("ripVinCluster",0));
        vinRipCluster = register(new ItemBase("vinRipCluster",0));
        vinCruCluster = register(new ItemBase("vinCruCluster",0));
        cruVinCluster = register(new ItemBase("cruVinCluster",0));
        cruArborCluster =register(new ItemBase("cruArborCluster",0));
        arborCruCluster = register(new ItemBase("arborCruCluster",0));
        refinedTiberium = register(new ItemBase("refinedTiberium",0));
        //Tiberium Tools
            //Swords
        ripariusBlade = register(new BaseSword(BaseTool.riparius, "ripariusBlade"));
        viniferaBlade = register(new BaseSword(BaseTool.vinifera, "viniferaBlade"));
        cruentusBlade = register(new BaseSword(BaseTool.cruentus, "cruentusBlade"));
        arboreaBlade = register(new BaseSword(BaseTool.arborea, "arboreaBlade"));

    }

    private static <T extends Item> T register(T item) {
        GameRegistry.register(item);

        if (item instanceof IModelProvider) {
            ((IModelProvider) item).registerItemModel(item, 0);
        }

        return item;
    }
}