package tiberianeclipse.util;


import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.ConfigManager;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import tiberianeclipse.Main;



import static tiberianeclipse.Main.modId;

@Config(modid = modId)
public class TibEcConfig {
    @Mod.EventBusSubscriber
    private static class ConfigHandler{
        @SubscribeEvent
        public static void onConfigChanged(ConfigChangedEvent.OnConfigChangedEvent event){
            if(event.getModID().equals(Main.modId))
                ConfigManager.load(Main.modId, Config.Type.INSTANCE);
        }
    }
}
