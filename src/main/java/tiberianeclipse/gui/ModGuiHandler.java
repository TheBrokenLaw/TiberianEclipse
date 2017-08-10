package tiberianeclipse.gui;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;
import tiberianeclipse.container.TibProcessorContainer;
import tiberianeclipse.tileentities.TibBlockTileEntity;
import tiberianeclipse.tileentities.TileEntityTibProcessor;


public class ModGuiHandler implements IGuiHandler {
    public static final int TIBPROCESSOR=0;

    @Override
    public Container getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z){
        switch (ID){
            case TIBPROCESSOR:
                return new TibProcessorContainer(player.inventory, (TileEntityTibProcessor)world.getTileEntity(new BlockPos(x,y,z)));
                default:
                    return null;
        }
    }
    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z){
        switch (ID){
            case TIBPROCESSOR:
                return new GuiTibProcessor(getServerGuiElement(ID, player, world, x, y, z),player.inventory);
                default:
                    return null;
        }
    }
}
