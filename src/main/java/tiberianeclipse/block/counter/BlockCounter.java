package tiberianeclipse.block.counter;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;
import tiberianeclipse.tileentities.BaseTileEntity;

import javax.annotation.Nullable;

public class BlockCounter extends BaseTileEntity {
    public BlockCounter(){
        super( "counter",Material.ROCK);
    }
    @Override
    public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, @Nullable ItemStack heldItem, EnumFacing side, float hitX, float hitY, float hitZ){
        if(!world.isRemote){
            TileEntityCounter tile= (TileEntityCounter) getTileEntity(world, pos);
            if(side== EnumFacing.DOWN){
                tile.decrementCount();

            }else if(side==EnumFacing.UP){
                tile.incrementCount();

            }
            player.addChatMessage(new TextComponentString("Count:"+tile.getCount()));
        }
        return true;
    }

    @Override
    public Class<TileEntityCounter> getTileEntityClass(){
        return TileEntityCounter.class;
    }
    @Nullable
    @Override
    public TileEntityCounter createTileEntity(World world, IBlockState state){
        return new TileEntityCounter();
    }
}
