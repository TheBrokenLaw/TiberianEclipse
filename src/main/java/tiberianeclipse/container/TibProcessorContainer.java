package tiberianeclipse.container;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.inventory.SlotFurnaceFuel;
import net.minecraft.inventory.SlotFurnaceOutput;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.SlotItemHandler;
import tiberianeclipse.tileentities.TibProcessor;
import tiberianeclipse.tileentities.TileEntityTibProcessor;



public class TibProcessorContainer extends Container {

    public TibProcessorContainer(InventoryPlayer playerInv, final TileEntityTibProcessor tibprocessor) {
        IItemHandler inventory = tibprocessor.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, EnumFacing.NORTH);
        addSlotToContainer(new SlotItemHandler(inventory, 0, 56, 17){
            @Override
            public void onSlotChanged() {
                tibprocessor.markDirty();
            }
        });
        addSlotToContainer(new SlotItemHandler(inventory, 1, 56, 53){
            @Override
            public void onSlotChanged() {
                tibprocessor.markDirty();
            }
        });
        addSlotToContainer(new SlotItemHandler(inventory, 2, 116, 35){
            @Override
            public void onSlotChanged() {
                tibprocessor.markDirty();
            }
        });

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 9; j++) {
                addSlotToContainer(new Slot(playerInv, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
            }
        }

        for (int k = 0; k < 9; k++) {
            addSlotToContainer(new Slot(playerInv, k, 8 + k * 18, 142));
        }
    }
    public boolean canInteractWith(EntityPlayer player){
        return true;
    }

    public ItemStack transferStackInSlot(EntityPlayer player, int index){
        ItemStack itemstack = null;
        Slot slot = inventorySlots.get(index);
        if(slot != null&&slot.getHasStack()){
            ItemStack itemstack1=slot.getStack();
            itemstack = itemstack1.copy();
            int containerSlots=inventorySlots.size()-player.inventory.mainInventory.length;
            if(index<containerSlots){
                if(!this.mergeItemStack(itemstack1,containerSlots,inventorySlots.size(),true)){
                    return null;
                }
            }
            else if(!this.mergeItemStack(itemstack1,0,containerSlots,false)){
                return null;
            }
            if (itemstack1.stackSize == 0) {
                slot.putStack(null);
            } else {
                slot.onSlotChanged();
            }

            if (itemstack1.stackSize == itemstack.stackSize) {
                return null;
            }

            slot.onPickupFromSlot(player, itemstack1);
        }

        return itemstack;
    }
}
