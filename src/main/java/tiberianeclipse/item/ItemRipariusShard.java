package tiberianeclipse.item;

import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemSeeds;
import tiberianeclipse.Main;
import tiberianeclipse.block.ModBlocks;
import tiberianeclipse.util.IModelProvider;

public class ItemRipariusShard extends ItemSeeds implements IModelProvider {

        public ItemRipariusShard() {
            super(ModBlocks.greenTibBush, Blocks.GRASS);
            setUnlocalizedName("ripariusShard");
            setRegistryName("ripariusShard");
            setCreativeTab(Main.creativeTab);
        }

        @Override
        public void registerItemModel(Item item) {
            Main.proxy.registerItemRenderer(item, 0, "ripariusShard");
        }

    }

