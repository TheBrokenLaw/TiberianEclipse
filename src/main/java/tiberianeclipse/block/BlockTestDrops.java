package tiberianeclipse.block;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import scala.tools.cmd.Meta;
import tiberianeclipse.Main;
import tiberianeclipse.item.ModItems;


import java.util.Random;

public class BlockTestDrops extends BlockGround {
    private Item drop;
    private int meta;
    private int least_quantity;
    private int most_quantity;
    protected BlockTestDrops(String name, Material material, Item drop, int meta, int least_quantity, int most_quantity) {
        super(material, name,1,1);
        this.setHardness(1);
        this.setResistance(1);
        this.name=(name);
        this.setSoundType(SoundType.STONE);
        this.drop=drop;
        this.meta=meta;
        this.least_quantity=least_quantity;
        this.most_quantity=most_quantity;

    }
    protected BlockTestDrops(String name, Material material, Item drop, int least_quantity, int most_quantity){
        this(name,material,drop,0,least_quantity,most_quantity);
    }
    protected BlockTestDrops(String name, Material mat, Item drop){
        this(name, mat, drop, 1, 1);
    }

    @Override
    public Item getItemDropped(IBlockState blockState, Random random, int fortune){
        return drop;
    }

    @Override
    public int damageDropped(IBlockState blockState){
        return this.meta;
}

    @Override
    public void dropBlockAsItemWithChance(World worldIn, BlockPos pos, IBlockState state, float chance, int fortune)
    {
        super.dropBlockAsItemWithChance(worldIn, pos, state, chance, fortune);
    }

    @Override
    public int quantityDropped(IBlockState blockState, int fortune, Random random){
    if(this.least_quantity>=this.most_quantity)
        return this.least_quantity;
    return this.least_quantity+random.nextInt(this.most_quantity-this.least_quantity+fortune+1);
    }
}
