package tiberianeclipse.potion;

import net.minecraft.client.Minecraft;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

public class TEPotion extends Potion {
    static ResourceLocation loc=new ResourceLocation("tiberianeclipse","textures/gui/potioneffects.png");
    final int tickrate;
    final boolean halfTick;
    boolean showInventory;
    boolean showHud;
    public TEPotion(ResourceLocation location, boolean isBad, int color, int tick, boolean halfTick, int icon, boolean showInventory, boolean showHud){
        super(isBad, color);
        this.setPotionName("potion"+location.getResourcePath());
        this.showInventory=showInventory;
        this.showHud=showHud;
        this.tickrate=tick;
        this.halfTick=halfTick;
        this.setIconIndex(icon%8, icon/8);
        ForgeRegistries.POTIONS.register(this.setRegistryName(location));
    }
    public boolean shouldRender(PotionEffect effect){
        return showInventory;
    }
    public boolean shouldRenderInvText(PotionEffect effect){
        return showInventory;
    }
    public boolean shouldRenderHud(PotionEffect effect){
        return showHud;
    }
    public boolean isReady(int time, int amp)
    {
        if(tickrate<0)
            return false;
        int x = tickrate >> amp;
        return x <= 0 || time % x == 0;
    }
}