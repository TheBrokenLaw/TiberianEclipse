package tiberianeclipse.tileentities;

import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import tiberianeclipse.block.BlockBase;
import tiberianeclipse.block.TiberiumGrowth;

import javax.annotation.Nullable;

public abstract class BaseTileEntity<TE extends TileEntity> extends BlockBase {

    public BaseTileEntity(String name, Material material) {
        super(material,name, "pickaxe", 0);
    }

    public abstract Class<TE> getTileEntityClass();

    public TE getTileEntity(IBlockAccess world, BlockPos pos) {
        return (TE)world.getTileEntity(pos);
    }

    @Override
    public boolean hasTileEntity(IBlockState state) {
        return true;
    }

    @Nullable
    @Override
    public abstract TE createTileEntity(World world, IBlockState state);

}