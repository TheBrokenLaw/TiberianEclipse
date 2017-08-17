package tiberianeclipse.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockDirt;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import java.util.Random;

public class BlockGrass extends BlockGround {

    public BlockGrass(Material material, String name) {
        super(material, name, 2, 3);
        this.setHarvestLevel("spade", 0);
        this.setTickRandomly(true);
    }

    @Override
    public void setHarvestLevel(String toolClass, int level) {
        super.setHarvestLevel("spade", 0);
    }


    public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand) {
        if (!worldIn.isRemote) {
            if (worldIn.getLightFromNeighbors(pos.up()) < 4 && worldIn.getBlockState(pos.up()).getLightOpacity(worldIn, pos.up()) > 2) {
                worldIn.setBlockState(pos, ModBlocks.tiberiumGround.getDefaultState());
            } else {
                if (worldIn.getLightFromNeighbors(pos.up()) >= 9) {
                    for (int i = 0; i < 4; ++i) {
                        BlockPos blockpos = pos.add(rand.nextInt(3) - 1, rand.nextInt(5) - 3, rand.nextInt(3) - 1);

                        if (blockpos.getY() >= 0 && blockpos.getY() < 256 && !worldIn.isBlockLoaded(blockpos)) {
                            return;
                        }

                        IBlockState iblockstate = worldIn.getBlockState(blockpos.up());
                        IBlockState iblockstate1 = worldIn.getBlockState(blockpos);

                        if (iblockstate1.getBlock() == ModBlocks.tiberiumGround && worldIn.getLightFromNeighbors(blockpos.up()) >= 4 && iblockstate.getLightOpacity(worldIn, pos.up()) <= 2) {
                            worldIn.setBlockState(blockpos, ModBlocks.fieldGrass.getDefaultState());
                        }
                        if (iblockstate1.getBlock() == Blocks.LOG || iblockstate.getBlock() == Blocks.LOG2) {
                            worldIn.setBlockState(blockpos, ModBlocks.tibMutLog.getDefaultState());
                        }
                    }
                }
            }
        }
        if (rand.nextInt(20) == 0) {
            int i = 50;
            int j = 4;

            for (BlockPos blockpos : BlockPos.getAllInBoxMutable(pos.add(-4, -1, -4), pos.add(4, 1, 4))) {
                if (worldIn.getBlockState(blockpos).getBlock() == this) {
                    --i;

                    if (i <= 0) {
                        return;
                    }
                }
            }

            BlockPos blockpos1 = pos.add(rand.nextInt(3) - 1, rand.nextInt(2) - rand.nextInt(2), rand.nextInt(3) - 1);

            for (int k = 0; k < 4; ++k) {
                if (worldIn.isAirBlock(blockpos1)) {
                    pos = blockpos1;
                }

                blockpos1 = pos.add(rand.nextInt(3) - 1, rand.nextInt(2) - rand.nextInt(2), rand.nextInt(3) - 1);
            }
            if(rand.nextInt(20)==0){
            if (worldIn.isAirBlock(blockpos1)&&worldIn.isAirBlock(blockpos1.up())&&worldIn.getBlockState(blockpos1.down())==ModBlocks.fieldGrass.getDefaultState()) {
                worldIn.setBlockState(blockpos1.up(), ModBlocks.ripariusTree.getDefaultState(), 2);
                }
            }
            if(rand.nextInt(20)==0){
                if (worldIn.isAirBlock(blockpos1)&&worldIn.isAirBlock(blockpos1.up())&&worldIn.getBlockState(blockpos1.down())==ModBlocks.fieldGrass.getDefaultState()) {
                    worldIn.setBlockState(blockpos1.up(), ModBlocks.blueFona.getDefaultState(), 2);
                }
            }
        }
    }
}
