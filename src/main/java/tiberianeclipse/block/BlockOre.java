package tiberianeclipse.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

import java.util.Random;

public class BlockOre extends BlockBase {
    public Item drop;
    public Material material;
    public float hardness;
    public float resistance;
    private int meta;
    public int leastQuantity;
    public int mostQuantity;
    public float setLightLevel;
    protected BlockOre(String name, Material material, Item drop, int meta, int leastQuantity, int mostQuantity, float hardness, float resistance, float setLightLevel) {
        super(material, name, "pickaxe", 5);
        this.drop = drop;
        this.meta = meta;
        this.material=material;
  //      this.setHarvestLevel("pickaxe",0);
        this.leastQuantity = leastQuantity;
        this.mostQuantity = mostQuantity;
        this.setHardness(hardness);
        this.setResistance(resistance);
        this.setLightLevel(setLightLevel);
    }
    protected BlockOre(String unlocalizedName, Material mat, Item drop, int leastQuantity, int mostQuantity) {
        this(unlocalizedName, mat, drop, 0, leastQuantity, mostQuantity,0,0,0);
    }
    protected BlockOre(String name, Material material, Item drop){
        this(name,material,drop,1,1);
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