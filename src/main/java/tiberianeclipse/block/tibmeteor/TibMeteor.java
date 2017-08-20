package tiberianeclipse.block.tibmeteor;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import tiberianeclipse.block.BlockBase;
import tiberianeclipse.block.ModBlocks;
import tiberianeclipse.block.TiberiumGrowth;
import tiberianeclipse.block.tibcrystals.RipariusCrystal;

import java.util.Random;

public class TibMeteor extends BlockBase {
    public TibMeteor(){
        super(Material.ROCK, "tibMeteor", "none", 500);
        this.setHardness(50);
        this.setHarvestLevel("none", 500);
        this.setTickRandomly(true);
    }
    @Override
    public boolean isOpaqueCube(IBlockState state)
    {
        return false;
    }
    @SideOnly(Side.CLIENT)
    public BlockRenderLayer getBlockLayer()
    {
        return BlockRenderLayer.TRANSLUCENT;
    }
    public boolean isFullCube(IBlockState state)
    {
        return false;
    }

    public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand) {

        if (rand.nextInt(5) == 1)
        {
            int i = 64;
            int j = 4;

            for (BlockPos blockpos : BlockPos.getAllInBoxMutable(pos.add(-4, -1, -4), pos.add(4, 1, 4)))
            {
                if (worldIn.getBlockState(blockpos).getBlock() == ModBlocks.ripariusPod)
                {
                    --i;

                    if (i <= 0)
                    {
                        return;
                    }
                }
            }

            BlockPos blockpos1 = pos.add(rand.nextInt(3) - 1, rand.nextInt(2) - rand.nextInt(2), rand.nextInt(3) - 1);

            for (int k = 0; k < 16; ++k)
            {
                if (worldIn.isAirBlock(blockpos1) && this.canBlockStay(worldIn, blockpos1, ModBlocks.ripariusPod.getDefaultState()))
                {
                    pos = blockpos1;
                }

                blockpos1 = pos.add(rand.nextInt(3) - 1, rand.nextInt(2) - rand.nextInt(2), rand.nextInt(3) - 1);


            if (worldIn.isAirBlock(blockpos1) && this.canBlockStay(worldIn, blockpos1, ModBlocks.ripariusPod.getDefaultState())||worldIn.getBlockState(blockpos1)==Blocks.TALLGRASS && this.canBlockStay(worldIn, blockpos1, ModBlocks.ripariusPod.getDefaultState()))
            {
                worldIn.setBlockState(blockpos1, ModBlocks.ripariusPod.getDefaultState(), 2);
            }
            if(worldIn.getBlockState(blockpos1.up())== Blocks.LOG.getDefaultState()&&worldIn.getBlockState(blockpos1.up())!= ModBlocks.tibMutLog.getDefaultState()||worldIn.getBlockState(blockpos1.up())==Blocks.LOG2.getDefaultState()&&worldIn.getBlockState(blockpos1)!=ModBlocks.tibMutLog.getDefaultState()){
                worldIn.setBlockState(blockpos1.up(),ModBlocks.tibMutLog.getDefaultState());
            }
        }
        for (BlockPos blockpos2 : BlockPos.getAllInBoxMutable(pos.add(rand.nextInt(4), -1, rand.nextInt(4)), pos.add(rand.nextInt(4), 1, rand.nextInt(4)))) {
            BlockPos blockPos = pos.down();
            if (worldIn.getBlockState(blockPos) != ModBlocks.fieldGrass.getDefaultState() && worldIn.getBlockState(blockPos)==Blocks.GRASS) {
                worldIn.setBlockState(blockPos, ModBlocks.fieldGrass.getDefaultState());
            }
            if(worldIn.getBlockState(blockPos)!=ModBlocks.tiberiumGround && worldIn.getBlockState(blockPos)==Blocks.DIRT){
                worldIn.setBlockState(blockPos, ModBlocks.tiberiumGround.getDefaultState());
            }




            }
        }
        if (rand.nextInt(10) == 0){
        for(BlockPos blockpos1 : BlockPos.getAllInBoxMutable(pos.add(-16,-5,-16),pos.add(16,5,16))){
            blockpos1 = pos.add(rand.nextInt(4) -rand.nextInt(4), 5+rand.nextInt(5), rand.nextInt(4) - rand.nextInt(4));
            BlockPos blockPos = pos.down();
            if (worldIn.getBlockState(blockPos) != ModBlocks.fieldGrass.getDefaultState() && worldIn.getBlockState(blockPos)==Blocks.GRASS) {
                worldIn.setBlockState(blockPos, ModBlocks.fieldGrass.getDefaultState());
            }
            if(worldIn.getBlockState(blockPos)!=ModBlocks.tiberiumGround && worldIn.getBlockState(blockPos)==Blocks.DIRT){
                worldIn.setBlockState(blockPos, ModBlocks.tiberiumGround.getDefaultState());
            }
            if (worldIn.isAirBlock(blockpos1) && this.canBlockStay(worldIn, blockpos1, ModBlocks.ripariusPod.getDefaultState())||worldIn.getBlockState(blockpos1)==Blocks.TALLGRASS && this.canBlockStay(worldIn, blockpos1, ModBlocks.ripariusPod.getDefaultState()))
            {
                worldIn.setBlockState(blockpos1, ModBlocks.ripariusPod.getDefaultState(), 2);
                worldIn.setBlockState(blockPos, ModBlocks.fieldGrass.getDefaultState());
                worldIn.setBlockState(blockPos.down(), ModBlocks.tiberiumGround.getDefaultState());
            }
            if(worldIn.getBlockState(blockpos1.up())== Blocks.LOG.getDefaultState()&&worldIn.getBlockState(blockpos1.up())!= ModBlocks.tibMutLog.getDefaultState()||worldIn.getBlockState(blockpos1.up())==Blocks.LOG2.getDefaultState()&&worldIn.getBlockState(blockpos1)!=ModBlocks.tibMutLog.getDefaultState()){
                worldIn.setBlockState(blockpos1.up(),ModBlocks.tibMutLog.getDefaultState());
            }
        }

        }
    }
    public boolean canBlockStay(World worldIn, BlockPos pos, IBlockState state)
    {
        if (state.getBlock() == this) //Forge: This function is called during world gen and placement, before this block is set, so if we are not 'here' then assume it's the pre-check.
        {
            return this.canSustainBush(worldIn.getBlockState(pos.down()));
        }
        return this.canSustainBush(worldIn.getBlockState(pos.down()));
    }
    protected boolean canSustainBush(IBlockState state) {
        return state.getBlock()==ModBlocks.tiberiumGround
                ||state.getBlock()==ModBlocks.fieldGrass
                ||state.getBlock()==Blocks.GRASS
                ||state.getBlock()==Blocks.DIRT
                ||state.getBlock()==Blocks.STONE
                ||state.getBlock()==Blocks.SAND;
    }

}
