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

    public BlockBase(Material material, String name, float hardness, float resistance) {
        super(material);
        this.name = name;
        setUnlocalizedName(name);
        setRegistryName(name);
        this.setHarvestLevel("pickaxe",2);
        setCreativeTab(Main.creativeTab);
    }

    @Override
    public void registerItemModel(Item item) {
        Main.proxy.registerItemRenderer(item, 0, name);
    }

    @Override
    public BlockBase setCreativeTab(CreativeTabs tab) {
        super.setCreativeTab(tab);
        return this;
    }

}
