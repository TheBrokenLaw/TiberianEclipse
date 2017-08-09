package tiberianeclipse.block.tibcrystals;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.util.math.BlockPos;
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
