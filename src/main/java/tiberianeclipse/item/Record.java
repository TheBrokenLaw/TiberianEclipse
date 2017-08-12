package tiberianeclipse.item;

import com.google.common.collect.Maps;
import net.minecraft.block.BlockJukebox;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemRecord;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatList;
import net.minecraft.util.*;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.translation.I18n;
import net.minecraft.world.World;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.client.model.ModelLoaderRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import tiberianeclipse.Main;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.List;
import java.util.Map;

public class Record extends ItemRecord{
    private final String location;
    private final String name;
    public Record(String record, SoundEvent sound, String name){
        super(record, sound);
        setCreativeTab(Main.creativeTab);
         GameRegistry.register(this, new ResourceLocation(Main.modId, name));
        setUnlocalizedName(name);
        location=record;
        this.name=record;
    }
    @Nonnull
    @Override
    public ResourceLocation getRecordResource(String name){return new ResourceLocation(location);}
    @SideOnly(Side.CLIENT)

    public void registerItemModel(Item item, int meta) {
        Main.proxy.registerItemRenderer(item, 0, name);
    }

}