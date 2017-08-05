package tiberianeclipse.item;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;
import tiberianeclipse.util.IModelProvider;

public class ModItems {
    public static ItemGreenShard greenShard;


    public static void init() {
        greenShard = register(new ItemGreenShard());

    }

    private static <T extends Item> T register(T item) {
        GameRegistry.register(item);

        if (item instanceof IModelProvider) {
            ((IModelProvider) item).registerItemModel(item);
        }

        return item;
    }
}