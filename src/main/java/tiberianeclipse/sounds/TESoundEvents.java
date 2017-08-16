package tiberianeclipse.sounds;

import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import tiberianeclipse.Main;

public class TESoundEvents {

   public static final SoundEvent rainnite=new SoundEvent(new ResourceLocation(Main.modId, "rainnite"));
    public static final SoundEvent whatlurk=new SoundEvent(new ResourceLocation(Main.modId, "whatlurk"));
    public static final SoundEvent floatmov=new SoundEvent(new ResourceLocation(Main.modId, "floatmov"));
    public static final SoundEvent floatmov2=new SoundEvent(new ResourceLocation(Main.modId, "floatmov2"));
    public static final SoundEvent floatmov3=new SoundEvent(new ResourceLocation(Main.modId, "floatmov3"));
    public static final SoundEvent floatmov4=new SoundEvent(new ResourceLocation(Main.modId, "floatmov4"));
    public static final SoundEvent basicArmorEquip= new SoundEvent(new ResourceLocation(Main.modId, "basicArmorEquip"));


public static SoundEvent getRegisteredSoundEvent(String name){
    return SoundEvent.REGISTRY.getObject(new ResourceLocation("tiberianeclipse", name));
}
    private TESoundEvents() {}

}
