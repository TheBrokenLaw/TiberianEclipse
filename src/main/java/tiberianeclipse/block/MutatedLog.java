package tiberianeclipse.block;

import net.minecraft.block.BlockDirt;
import net.minecraft.block.BlockLog;
import net.minecraft.block.BlockNewLog;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.client.model.obj.OBJModel;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.Random;

public class MutatedLog extends BlockBase {

    public MutatedLog(String name) {
        super(Material.WOOD, name, "axe", 0);
        this.setTickRandomly(true);
        this.setDefaultState(this.blockState.getBaseState());
    }

    public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand)
    {
        if (!worldIn.isRemote)
        {


            BlockPos blockpos = pos.up();

            if (worldIn.getBlockState(blockpos)== Blocks.LOG2 ||worldIn.getBlockState(blockpos)==Blocks.LOG)
            {
                worldIn.setBlockState(blockpos, this.getDefaultState());
            }


            }
        }
    }
