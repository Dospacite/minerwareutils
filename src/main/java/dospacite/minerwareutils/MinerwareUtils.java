package dospacite.minerwareutils;

import dospacite.minerwareutils.core.IMinerwareMinigame;
import dospacite.minerwareutils.events.MinerwareTitleEvent;
import dospacite.minerwareutils.gui.ConfigScreen;
import dospacite.minerwareutils.handlers.MinerwareTitleEventHandler;
import dospacite.minerwareutils.handlers.MinerwareTitleEventLogger;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ExtensionPoint;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


// The value here should match an entry in the META-INF/mods.toml file
@Mod(MinerwareUtils.MOD_ID)
public class MinerwareUtils {

    // Directly reference a log4j logger.
    public static final Logger LOGGER = LogManager.getLogger();
    public static final String MOD_ID = "minerwareutils";
    public static final String MOD_NAME = "MinerwareUtils";

    public MinerwareUtils() {
        // Register the setup method for mod-loading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
        //MinecraftForge.EVENT_BUS.register(new MinerwareTitleEventHandler());
        MinecraftForge.EVENT_BUS.register(new MinerwareTitleEventLogger());

        // Register the configuration GUI factory
        ModLoadingContext.get().registerExtensionPoint(
                ExtensionPoint.CONFIGGUIFACTORY,
                () -> (mc, screen) -> new ConfigScreen()
        );
    }

    private void setup(final FMLCommonSetupEvent event) {
        LOGGER.info(MinerwareUtils.MOD_NAME + " with the id of: " + MinerwareUtils.MOD_ID + " is up and running.");
    }

    @SubscribeEvent
    public void onMinigameChange(MinerwareTitleEvent event) {
        if (event.displayedTitle != null) {
            LOGGER.info(event.displayedTitle.getString());
        }
    }

}
