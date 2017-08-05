package tiberianeclipse.item;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;
import tiberianeclipse.util.IModelProvider;

public class ModItems {
    public static ItemBase greenShard;

    public static void init() {
        greenShard = register(new ItemBase("greenShard").setCreativeTab(CreativeTabs.MATERIALS));
    }

    private static <T extends Item> T register(T item) {
        GameRegistry.register(item);

        if (item instanceof IModelProvider) {
            ((IModelProvider) item).registerItemModel();
        }

        return item;
    }
}