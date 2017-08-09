package tiberianeclipse.tileentities;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import javax.annotation.Nullable;

public class BlockTibPod extends TibBlockTileEntity<TibTileEntity> {
    protected static final AxisAlignedBB TIB_AABB = new AxisAlignedBB(0.30000001192092896D, 0.0D, 0.30000001192092896D, 0.699999988079071D, 0.2D, 0.699999988079071D);
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

    public BlockTibPod(String name, Material material, Item drop, int meta, int meta2, int leastQuantity, int mostQuantity, float hardness, float resistance, float lightLevel, boolean whatthefuck) {
        super(name, material, drop, meta, meta2, leastQuantity, mostQuantity, hardness, resistance, lightLevel, whatthefuck);
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
        this.pos = pos;

    }

    @Override
    public Class<TibTileEntity> getTileEntityClass() {
        return TibTileEntity.class;
    }

    @Nullable
    @Override
    public TibTileEntity createTileEntity(World world, IBlockState state) {
        return new TibTileEntity();
    }
}

