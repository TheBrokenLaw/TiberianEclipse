package tiberianeclipse.block.tibcrystals;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.SoundEvents;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import tiberianeclipse.block.BlockBase;
import tiberianeclipse.sounds.TESoundEvents;

import java.util.Random;


public class RipariusTree extends BlockBase {

    protected static final AxisAlignedBB TIB_AABB = new AxisAlignedBB(0D, -1D, 0D, 1D, 2D, 1D);
    public RipariusTree(){
        super(Material.WOOD, "ripariusTree", "axe", 5);
        this.setTickRandomly(true);
    }

    @Override
    public boolean isOpaqueCube(IBlockState state)
    {
        return false;
    }
    @Override
    @SideOnly(Side.CLIENT)
    public BlockRenderLayer getBlockLayer()
    {
        return BlockRenderLayer.TRANSLUCENT;
    }
    @Override
    public boolean isFullCube(IBlockState state)
    {
        return false;
    }
    public AxisAlignedBB getBoundingBox( IBlockState state, IBlockAccess source, BlockPos pos) {
        return TIB_AABB;
    }
    @SideOnly(Side.CLIENT)
    public void updateTick(World world, BlockPos pos, IBlockState state, Random rand){

        if(rand.nextInt(100)<=15){
            world.playSound(null, pos, TESoundEvents.floatmov, SoundCategory.AMBIENT, 2f,1f);
        }
        else if(rand.nextInt(100)>15 && rand.nextInt(100)<=30){
            world.playSound(null, pos, TESoundEvents.floatmov2, SoundCategory.AMBIENT, 2f,1f);
        }
        else if(rand.nextInt(100)>30 && rand.nextInt(100)<=45){
            world.playSound(null, pos, TESoundEvents.floatmov3, SoundCategory.AMBIENT, 2f,1f);
        }
        else if(rand.nextInt(100)>45 && rand.nextInt(100)<=60){
            world.playSound(null, pos, TESoundEvents.floatmov4, SoundCategory.AMBIENT, 2f,1f);
        }
    }
}
