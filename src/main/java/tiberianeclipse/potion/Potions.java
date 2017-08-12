package tiberianeclipse.potion;

import net.minecraft.potion.Potion;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import tiberianeclipse.Main;

public class Potions {
    public static Potion irradiated;
    public static Potion radResistant;
    public static Potion radImmune;
    public static void init(){
        irradiated=new TEPotion(new ResourceLocation(Main.modId,"irradiated"), true, 0x4f6f7f, 0,false,0, true,true).setPotionName("tiberianeclipse.potion.irradiated");
        radResistant=new TEPotion(new ResourceLocation(Main.modId,"radResistant"), false, 0x4f6f7f, 0,false,0, false,false).setPotionName("tiberianeclipse.potion.radResistant");
        radImmune=new TEPotion(new ResourceLocation(Main.modId,"radImmune"), false, 0x4f6f7f, 0,false,0, false,false).setPotionName("tiberianeclipse.potion.radImmune");

    }
}

