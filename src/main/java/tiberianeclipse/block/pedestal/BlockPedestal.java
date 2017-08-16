package tiberianeclipse.block.pedestal;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import tiberianeclipse.Main;
import tiberianeclipse.tileentities.BaseTileEntity;

import javax.annotation.Nullable;

public class BlockPedestal extends BaseTileEntity<TileEntityPedestal>{
    public BlockPedestal(String name, Material material) {
        super("pedestal", Material.ROCK);
    }

    @Override
    public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, @Nullable ItemStack heldItem, EnumFacing side, float hitX, float hitY, float hitZ) {
        if (!world.isRemote) {
            TileEntityPedestal tile = getTileEntity(world, pos);
            IItemHandler itemHandler = tile.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, side);
            if (!player.isSneaking()) {
                if (heldItem == null) {
                    player.setHeldItem(hand, itemHandler.extractItem(0, 64, false));
                } else {
                    player.setHeldItem(hand, itemHandler.insertItem(0, heldItem, false));
                }
                tile.markDirty();
            } else {
                ItemStack stack = itemHandler.getStackInSlot(0);
                if (stack != null) {
                    String localized = Main.proxy.localize(stack.getUnlocalizedName() + ".name");
                    player.addChatMessage(new TextComponentString(stack.stackSize + "x " + localized));
                } else {
                    player.addChatMessage(new TextComponentString("Empty"));
                }
            }
        }
        return true;
    }
    @Override
    public void breakBlock(World world, BlockPos pos, IBlockState state){
        TileEntityPedestal tile= (TileEntityPedestal) getTileEntity(world, pos);
        IItemHandler itemHandler=tile.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, EnumFacing.NORTH);
        ItemStack stack=itemHandler.getStackInSlot(0);
        if(stack!=null){
            EntityItem item =new EntityItem(world, pos.getX(), pos.getY(), pos.getZ(), stack);
            world.spawnEntityInWorld(item);
        }
        super.breakBlock(world, pos, state);
    }



    @Override
    public Class<TileEntityPedestal> getTileEntityClass() {
        return TileEntityPedestal.class;
    }

    @Nullable
    @Override
    public TileEntityPedestal createTileEntity(World world, IBlockState state){
        return new TileEntityPedestal();
    }
}
