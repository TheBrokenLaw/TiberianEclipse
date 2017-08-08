package tiberianeclipse.api;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

import java.util.Optional;

public interface BlockIs extends ItemIs{
    Optional<Block> maybeBlock();
    Optional<ItemBlock> maybeItemBlock();
    boolean isSameAs(IBlockAccess world, BlockPos pos );
}