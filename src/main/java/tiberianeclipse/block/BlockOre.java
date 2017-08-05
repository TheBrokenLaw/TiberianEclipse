package tiberianeclipse.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

import java.util.Random;

public class BlockOre extends BlockBase {
    public Item drop;
    public int meta;
    public int leastQuantity;
    public int mostQuantity;
    public float setLightLevel;
    public BlockOre(String name, Item drop, int meta, int leastQuantity, int mostQuantity, float setLightLevel) {
        super(Material.ROCK, name);
        this.drop = drop;
        this.meta = meta;
        this.leastQuantity = leastQuantity;
        this.mostQuantity = mostQuantity;
        setHardness(3f);
        setResistance(5f);
        this.setLightLevel=setLightLevel;
    }

    @Override
    public BlockOre setCreativeTab(CreativeTabs tab) {
        super.setCreativeTab(tab);
        return this;
    }

    @Override
    public Item getItemDropped(IBlockState blockstate, Random random, int fortune) {
        return this.drop;
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