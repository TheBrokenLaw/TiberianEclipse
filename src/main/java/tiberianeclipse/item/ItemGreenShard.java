package tiberianeclipse.item;

import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemSeeds;
import tiberianeclipse.Main;
import tiberianeclipse.block.ModBlocks;
import tiberianeclipse.util.IModelProvider;

public class ItemGreenShard extends ItemSeeds implements IModelProvider {

        public ItemGreenShard() {
            super(ModBlocks.greenTibBush, Blocks.GRASS);
            setUnlocalizedName("greenShard");
            setRegistryName("greenShard");
        }

        @Override
        public void registerItemModel(Item item) {
            Main.proxy.registerItemRenderer(item, 0, "greenShard");
        }

    }

