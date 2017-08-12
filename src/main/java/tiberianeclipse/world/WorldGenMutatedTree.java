package tiberianeclipse.world;

import net.minecraft.block.BlockOldLeaf;
import net.minecraft.block.BlockOldLog;
import net.minecraft.block.BlockPlanks;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraft.world.gen.feature.WorldGenerator;
import tiberianeclipse.block.ModBlocks;

import java.util.Random;

public class WorldGenMutatedTree extends WorldGenAbstractTree{

        private static final IBlockState LOG = ModBlocks.tibMutLog.getDefaultState();
        private final boolean useExtraRandomHeight;
        public WorldGenMutatedTree(boolean notify, boolean useExtraRandomHeightIn)
        {
            super(notify);
            this.useExtraRandomHeight = useExtraRandomHeightIn;
        }

        public boolean generate(World worldIn, Random rand, BlockPos position)
        {
            int i = rand.nextInt(3) + 5;

            if (this.useExtraRandomHeight)
            {
                i += rand.nextInt(7);
            }

            if (position.getY() >= 1 && position.getY() + i + 1 <= 256)
            {
                for (int j = position.getY(); j <= position.getY() + 1 + i; ++j)
                {
                    int k = 1;

                    if (j == position.getY())
                    {
                        k = 0;
                    }

                    if (j >= position.getY() + 1 + i - 2)
                    {
                        k = 2;
                    }
                    if (position.getY() < worldIn.getHeight() - i - 1)
                    {
                        for (int j2 = 0; j2 < i; ++j2)
                        {
                            BlockPos upN = position.up(j2);
                            IBlockState state2 = worldIn.getBlockState(upN);

                            if (state2.getBlock().isAir(state2, worldIn, upN) || state2.getBlock().isLeaves(state2, worldIn, upN))
                            {
                                this.setBlockAndNotifyAdequately(worldIn, position.up(j2), LOG);
                            }
                        }
                        return true;
                    }
                    else
                    {
                        return false;
                    }

            }

        }
        return true;

        }
}



