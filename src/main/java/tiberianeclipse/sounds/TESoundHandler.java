package tiberianeclipse.sounds;

import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import tiberianeclipse.Main;

public class TESoundHandler {
    public static SoundEvent rainnite;
    public static SoundEvent whatlurk;
    public static SoundEvent floatmov;
    public static SoundEvent floatmov2;
    public static SoundEvent floatmov3;
    public static SoundEvent floatmov4;

    private static int size = 0;

    public static void init() {
        size = SoundEvent.REGISTRY.getKeys().size();

        rainnite = register("rainnite");
        whatlurk = register("whatlurk");
        floatmov = register("floatmov");
        floatmov2 = register("floatmov2");
        floatmov3 = register("floatmov3");
        floatmov4 = register("floatmov4");
    }

    public static SoundEvent register(String name) {
        ResourceLocation loc = new ResourceLocation(Main.modId + name);
        SoundEvent e = new SoundEvent(loc);

        SoundEvent.REGISTRY.register(size, loc, e);
        size++;

        return e;
    }

}
