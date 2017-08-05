package tiberianeclipse.item;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;
import tiberianeclipse.util.IModelProvider;

public class ModItems {
    public static ItemRipariusShard ripariusShard;
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

    public static ItemBase refinedTiberium;
    public static void init() {
        ripariusShard = register(new ItemRipariusShard());
        viniferaShard = register(new ItemBase("viniferaShard"));
        cruentusShard = register(new ItemBase("cruentusShard"));
        arboreaShard = register(new ItemBase("arboreaShard"));
        ripariusCluster =register(new ItemBase("ripariusCluster"));
        viniferaCluster = register(new ItemBase("viniferaCluster"));
        cruentusCluster = register(new ItemBase("cruentusCluster"));
        arboreaCluster = register(new ItemBase("arboreaCluster"));
        ripVinCluster =register(new ItemBase("ripVinCluster"));
        vinRipCluster = register(new ItemBase("vinRipCluster"));
        vinCruCluster = register(new ItemBase("vinCruCluster"));
        cruVinCluster = register(new ItemBase("cruVinCluster"));
        cruArborCluster =register(new ItemBase("cruArborCluster"));
        arborCruCluster = register(new ItemBase("arborCruCluster"));
        refinedTiberium = register(new ItemBase("refinedTiberium"));

    }

    private static <T extends Item> T register(T item) {
        GameRegistry.register(item);

        if (item instanceof IModelProvider) {
            ((IModelProvider) item).registerItemModel(item);
        }

        return item;
    }
}