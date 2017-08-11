package tiberianeclipse.block.tibcrystals;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import tiberianeclipse.block.ModBlocks;
import tiberianeclipse.block.TiberiumGrowth;
import tiberianeclipse.item.ModItems;

import java.util.Random;

public class CruentusCrystal extends TiberiumGrowth {
    public int meta;
    public float hardness;
    public float resistance;
    public float lightLevel;
    public Item drop;
    public int leastQuantity;
    public int mostQuantity;
    public String name;
    public Material material;
    public boolean whatthefuck;
    public int meta2;
    public static final PropertyInteger AGE = PropertyInteger.create("age", 0, 7);
    public BlockPos pos;

    public CruentusCrystal(String name, Material material, Item drop, int meta, int leastQuantity, int mostQuantity, float hardness, float resistance, float lightLevel, boolean whatthefuck) {
        super(name, material, drop, meta, leastQuantity, mostQuantity, lightLevel, hardness, resistance, true);
        setUnlocalizedName(name);
        this.material = material;
        this.setHarvestLevel("pickaxe", 0);
        this.drop = drop;
        this.leastQuantity = leastQuantity;
        this.mostQuantity = mostQuantity;
        this.meta = meta;
        this.meta2 = meta2;
        this.hardness = hardness;
        this.resistance = resistance;
        this.setDefaultState(this.blockState.getBaseState().withProperty(AGE, Integer.valueOf(0)));
        this.setTickRandomly(true);
        this.setHardness(hardness);
        this.setResistance(resistance);
        this.setLightLevel(lightLevel);
        this.setSoundType(SoundType.GLASS);
        this.disableStats();
        this.whatthefuck = whatthefuck;
        this.setTickRandomly(true);

    }
    @Override
    public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand) {

        if (rand.nextInt(15) == 0)
        {
            int i = 50;
            int j = 4;

            for (BlockPos blockpos : BlockPos.getAllInBoxMutable(pos.add(-4, -1, -4), pos.add(4, 1, 4)))
            {
                if (worldIn.getBlockState(blockpos).getBlock() == this)
                {
                    --i;

                    if (i <= 0)
                    {
                        return;
                    }
                }
            }

            BlockPos blockpos1 = pos.add(rand.nextInt(3) - 1, rand.nextInt(2) - rand.nextInt(2), rand.nextInt(3) - 1);

            for (int k = 0; k < 4; ++k)
            {
                if (worldIn.isAirBlock(blockpos1) && this.canBlockStay(worldIn, blockpos1, this.getDefaultState()))
                {
                    pos = blockpos1;
                }

                blockpos1 = pos.add(rand.nextInt(3) - 1, rand.nextInt(2) - rand.nextInt(2), rand.nextInt(3) - 1);
            }

            if (worldIn.isAirBlock(blockpos1) && this.canBlockStay(worldIn, blockpos1, this.getDefaultState())
                    ||worldIn.getBlockState(blockpos1)== ModBlocks.ripariusPod.getDefaultState()
                    ||worldIn.getBlockState(blockpos1)== ModBlocks.viniferaPod.getDefaultState())
            {
                worldIn.setBlockState(blockpos1, this.getDefaultState(), 2);
            }
        }
        for (BlockPos blockpos : BlockPos.getAllInBoxMutable(pos.add(-4, -1, -4), pos.add(4, 1, 4))) {
            BlockPos blockPos = pos.down();
            if (worldIn.getBlockState(blockPos) != ModBlocks.fieldGrass.getDefaultState() && worldIn.getBlockState(blockPos).isOpaqueCube()) {
                worldIn.setBlockState(blockPos, ModBlocks.fieldGrass.getDefaultState());

            }
        }
        super.updateTick(worldIn, pos, state, rand);

        if (worldIn.getLightFromNeighbors(pos.up()) >= 2) {
            int k = this.getAge(state);

            if (k < this.getMaxAge()) {
                float f = getGrowthChance(this, worldIn, pos);

                if (net.minecraftforge.common.ForgeHooks.onCropsGrowPre(worldIn, pos, state, rand.nextInt((int) (50F / f) + 1) == 0)) {
                    worldIn.setBlockState(pos, this.withAge(k + 1), 2);
                    net.minecraftforge.common.ForgeHooks.onCropsGrowPost(worldIn, pos, state, worldIn.getBlockState(pos));
                }
            }
        }
    }
    @Override
    public Item getItemDropped(IBlockState blockstate, Random random, int fortune) {
        return ModItems.cruentusShard;
    }

    @Override
    public int damageDropped(IBlockState blockstate) {
        return this.meta;
    }

    @Override
    public int quantityDropped(IBlockState blockstate, int fortune, Random random) {
        if (this.leastQuantity >= this.mostQuantity)
            return this.leastQuantity;
        return this.leastQuantity + random.nextInt(this.mostQuantity - this.leastQuantity + fortune + 1);
    }
}
