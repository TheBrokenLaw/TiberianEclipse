package tiberianeclipse.item;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.world.World;
import tiberianeclipse.sounds.TESoundEvents;
import tiberianeclipse.sounds.TESoundHandler;

public class DummyItem extends ItemBase {
    public DummyItem(){
        super("dummyitem", 0);
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn, EnumHand hand) {
        ItemStack stack=playerIn.getHeldItem(hand);
        worldIn.playSound(null, playerIn.posX,playerIn.posY,playerIn.posZ, TESoundEvents.floatmov, SoundCategory.PLAYERS, 1f, 1f);
        return ActionResult.newResult(EnumActionResult.SUCCESS, stack);
    }
}
