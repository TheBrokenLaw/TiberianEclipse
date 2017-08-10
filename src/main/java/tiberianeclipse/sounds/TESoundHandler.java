package tiberianeclipse.sounds;

import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import tiberianeclipse.Main;

public class TESoundHandler {
public static SoundEvent recordEidolon;
public static SoundEvent recordDarkValley;

private static int size=0;
public static void init(){
    size=SoundEvent.REGISTRY.getKeys().size();
    recordEidolon = register("records.Eidolon");
    recordDarkValley = register("records.DarkValley");
}
public static SoundEvent register(String name){
    ResourceLocation loc=new ResourceLocation(Main.modId+":"+name);
    SoundEvent e =new SoundEvent(loc);
    SoundEvent.REGISTRY.register(size, loc, e);
    size++;
    return e;
}
}
