package tiberianeclipse.sounds;

import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import tiberianeclipse.Main;

public class TESoundHandler {
public static final SoundEvent recordEidolon= getRegisteredSoundEvent("record.Eidolon");
public static final SoundEvent recordDarkValley= getRegisteredSoundEvent("record.DarkValley");
    public static final SoundEvent basicArmorEquip= getRegisteredSoundEvent("basicArmorEquip");


public static SoundEvent getRegisteredSoundEvent(String name){
    return SoundEvent.REGISTRY.getObject(new ResourceLocation("tiberianeclipse", name));
}
}
