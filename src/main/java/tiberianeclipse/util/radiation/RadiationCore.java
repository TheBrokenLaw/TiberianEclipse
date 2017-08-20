package tiberianeclipse.util.radiation;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.world.WorldSavedData;
import net.minecraftforge.common.util.Constants;

public class RadiationCore extends WorldSavedData {

    public RadiationCore(String name) {
        super(name);
    }

    @Override
    public void readFromNBT(NBTTagCompound compound) {
        NBTTagList list =compound.getTagList("radiation", Constants.NBT.TAG_COMPOUND);
    }

    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound compound){
        NBTTagList list=new NBTTagList();
        compound.setTag("radiation", list);
        return compound;
    }
}
