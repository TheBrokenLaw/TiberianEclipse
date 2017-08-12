package tiberianeclipse.machine;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import tiberianeclipse.Main;
import tiberianeclipse.block.ModBlocks;
import tiberianeclipse.gui.ModGuiHandler;

import java.util.Random;

public class BlockGrinder extends BlockContainer {
    public static final PropertyDirection FACING =
            PropertyDirection.create("facing",
                    EnumFacing.Plane.HORIZONTAL);
    private static boolean hasTileEntity;

    public BlockGrinder()
    {
        super(Material.ROCK);
        setUnlocalizedName("grinder");
        setDefaultState(blockState.getBaseState().withProperty(
                FACING, EnumFacing.NORTH));
        setCreativeTab(Main.creativeTab);
        setSoundType(SoundType.SNOW);
        blockParticleGravity = 1.0F;
        slipperiness = 0.6F;
        lightOpacity = 20; // cast a light shadow
        setTickRandomly(false);
        useNeighborBrightness = false;
    }
    @Override
    public Item getItemDropped(
            IBlockState state,
            Random rand,
            int fortune)
    {
        return Item.getItemFromBlock(ModBlocks.blockGrinder);
    }

    @Override
    public void onBlockAdded(
            World parWorld,
            BlockPos parBlockPos,
            IBlockState parIBlockState)
    {
        if (!parWorld.isRemote)
        {
            // Rotate block if the front side is blocked
            Block blockToNorth = parWorld.getBlockState(
                    parBlockPos.north()).getBlock();
            Block blockToSouth = parWorld.getBlockState(
                    parBlockPos.south()).getBlock();
            Block blockToWest = parWorld.getBlockState(
                    parBlockPos.west()).getBlock();
            Block blockToEast = parWorld.getBlockState(
                    parBlockPos.east()).getBlock();
            EnumFacing enumfacing = (EnumFacing)parIBlockState
                    .getValue(FACING);

            if (enumfacing == EnumFacing.NORTH
                    && blockToNorth.isFullBlock(parIBlockState)
                    && !blockToSouth.isFullBlock(parIBlockState))
            {
                enumfacing = EnumFacing.SOUTH;
            }
            else if (enumfacing == EnumFacing.SOUTH
                    && blockToSouth.isFullBlock(parIBlockState)
                    && !blockToNorth.isFullBlock(parIBlockState))
            {
                enumfacing = EnumFacing.NORTH;
            }
            else if (enumfacing == EnumFacing.WEST
                    && blockToWest.isFullBlock(parIBlockState)
                    && !blockToEast.isFullBlock(parIBlockState))
            {
                enumfacing = EnumFacing.EAST;
            }
            else if (enumfacing == EnumFacing.EAST
                    && blockToEast.isFullBlock(parIBlockState)
                    && !blockToWest.isFullBlock(parIBlockState))
            {
                enumfacing = EnumFacing.WEST;
            }

            parWorld.setBlockState(parBlockPos, parIBlockState
                    .withProperty(FACING, enumfacing), 2);
        }
    }


    public boolean onBlockActivated(
            World parWorld,
            BlockPos parBlockPos,
            IBlockState parIBlockState,
            EntityPlayer parPlayer,
            EnumFacing parSide,
            float hitX,
            float hitY,
            float hitZ)
    {
        if (!parWorld.isRemote)
        {
            parPlayer.openGui(Main.instance,
                    ModGuiHandler.GRINDER,
                    parWorld,
                    parBlockPos.getX(),
                    parBlockPos.getY(),
                    parBlockPos.getZ());
        }

        return true;
    }

    @Override
    public TileEntity createNewTileEntity(World worldIn, int meta)
    {
        // DEBUG
        System.out.println("BlockGrinder createNewTileEntity()");
        return new TileEntityGrinder();
    }

    @Override
    public IBlockState onBlockPlaced(
            World worldIn,
            BlockPos pos,
            EnumFacing facing,
            float hitX,
            float hitY,
            float hitZ,
            int meta,
            EntityLivingBase placer)
    {
        return getDefaultState().withProperty(FACING,
                placer.getHorizontalFacing().getOpposite());
    }

    @Override
    public void onBlockPlacedBy(
            World worldIn,
            BlockPos pos,
            IBlockState state,
            EntityLivingBase placer,
            ItemStack stack)
    {
        worldIn.setBlockState(pos, state.withProperty(
                FACING,
                placer.getHorizontalFacing().getOpposite()),
                2);
    }

    @Override
    public void breakBlock(
            World worldIn,
            BlockPos pos,
            IBlockState state)
    {
        if (!hasTileEntity)
        {
            TileEntity tileentity = worldIn.getTileEntity(pos);

            if (tileentity instanceof TileEntityGrinder)
            {
                InventoryHelper.dropInventoryItems(worldIn, pos,
                        (IInventory) tileentity);
                worldIn.updateComparatorOutputLevel(pos, this);
            }
        }

        super.breakBlock(worldIn, pos, state);
    }


    @SideOnly(Side.CLIENT)
    public Item getItem(World worldIn, BlockPos pos)
    {
        return Item.getItemFromBlock(ModBlocks.blockGrinder);
    }


    public int getRenderType()
    {
        return 3;
    }

    @SideOnly(Side.CLIENT)
    public IBlockState getStateForEntityRender(IBlockState state)
    {
        return getDefaultState().withProperty(FACING, EnumFacing.SOUTH);
    }

    @Override
    public IBlockState getStateFromMeta(int meta)
    {
        EnumFacing enumfacing = EnumFacing.getFront(meta);

        if (enumfacing.getAxis() == EnumFacing.Axis.Y)
        {
            enumfacing = EnumFacing.NORTH;
        }

        return getDefaultState().withProperty(FACING, enumfacing);
    }

    @Override
    public int getMetaFromState(IBlockState state)
    {
        return ((EnumFacing)state.getValue(FACING)).getIndex();
    }

    @Override
    protected BlockStateContainer createBlockState()
    {
        return new BlockStateContainer(this, new IProperty[] {FACING});
    }

    public static void changeBlockBasedOnGrindingStatus(boolean grindingsomething, World worldObj, BlockPos pos) {
    }

    @SideOnly(Side.CLIENT)
    static final class SwitchEnumFacing
    {
        static final int[] enumFacingArray = new int[EnumFacing.values()
                .length];

        static
        {
            try
            {
                enumFacingArray[EnumFacing.WEST.ordinal()] = 1;
            }
            catch (NoSuchFieldError var4)
            {
                ;
            }

            try
            {
                enumFacingArray[EnumFacing.EAST.ordinal()] = 2;
            }
            catch (NoSuchFieldError var3)
            {
                ;
            }

            try
            {
                enumFacingArray[EnumFacing.NORTH.ordinal()] = 3;
            }
            catch (NoSuchFieldError var2)
            {
                ;
            }

            try
            {
                enumFacingArray[EnumFacing.SOUTH.ordinal()] = 4;
            }
            catch (NoSuchFieldError var1)
            {
                // You should improve the error handling here
            }
        }
    }
}
