package tiberianeclipse.tileentities;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import tiberianeclipse.Main;
import tiberianeclipse.gui.ModGuiHandler;

import javax.annotation.Nullable;

public class TibProcessor extends BaseTileEntity<TileEntityTibProcessor> {
    public TibProcessor(){
        super("tibProcessor", Material.ROCK);
    }
    @Override
    @Deprecated
    public boolean isOpaqueCube(IBlockState state){
        return false;
    }
    @Override
    @Deprecated
    public boolean isFullCube(IBlockState state){
        return false;
    }

    @Override
    public Class<TileEntityTibProcessor> getTileEntityClass() {
        return TileEntityTibProcessor.class;
    }

    @Nullable
    @Override
    public TileEntityTibProcessor createTileEntity(World world, IBlockState state) {
        return new TileEntityTibProcessor();
    }

    public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, @Nullable ItemStack heldItem, EnumFacing side, float hitX, float hitY, float hitZ) {
        if (!world.isRemote) {
            TileEntityTibProcessor tile = getTileEntity(world, pos);
            IItemHandler itemHandler = tile.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, side);

               player.openGui(Main.instance, ModGuiHandler.TIBPROCESSOR,world,pos.getX(),pos.getY(),pos.getZ());
            }

        return true;
    }
    @Override
    public void breakBlock(World world, BlockPos pos, IBlockState state) {
        TileEntityTibProcessor tile = getTileEntity(world, pos);
        IItemHandler itemHandler = tile.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, EnumFacing.NORTH);
        ItemStack stack = itemHandler.getStackInSlot(0);
        if (stack!=null) {
            EntityItem item = new EntityItem(world, pos.getX(), pos.getY(), pos.getZ(), stack);
            world.spawnEntityInWorld(item);
        }
        super.breakBlock(world, pos, state);
    }


}
