package tiberianeclipse.block;

import javafx.application.Platform;
import net.minecraft.block.material.Material;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import tiberianeclipse.Main;
import tiberianeclipse.util.IModelProvider;

public class BlockBase extends Block implements IModelProvider {
    protected String name;
    public Material material;
    public BlockBase(Material material, String name, String tool, int level) {
        super(material);
        this.name = name;
        setUnlocalizedName(name);
        setRegistryName(name);
        this.material=material;
        setCreativeTab(Main.creativeTab);
        setHarvestLevel(tool, level);
    }

    @Override
    public void registerItemModel(Item item, int meta) {
        Main.proxy.registerItemRenderer(item, 0, name);
    }

    @Override
    public BlockBase setCreativeTab(CreativeTabs tab) {
        super.setCreativeTab(tab);
        return this;
    }

}
