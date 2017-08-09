package tiberianeclipse.util;
import net.minecraft.item.Item;
public interface IModelProvider {
    void registerItemModel(Item item, int meta);
}
