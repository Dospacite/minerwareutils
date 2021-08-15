package dospacite.minerwareutils;

import com.google.gson.Gson;
import com.google.gson.annotations.Expose;
import dospacite.minerwareutils.core.MinerwareMinigame;
import dospacite.minerwareutils.events.MinerwareTitleEvent;
import dospacite.minerwareutils.gui.ConfigScreen;
import dospacite.minerwareutils.minigames.MinigameMilkCow;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ExtensionPoint;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.spongepowered.asm.launch.MixinBootstrap;
import org.spongepowered.asm.mixin.Mixins;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;


// The value here should match an entry in the META-INF/mods.toml file
@Mod(MinerwareUtils.MOD_ID)
public class MinerwareUtils {

    // Directly reference a log4j logger.
    public static final Logger LOGGER = LogManager.getLogger();
    public static final String MOD_ID = "minerwareutils";
    public static final String MOD_NAME = "MinerwareUtils";

    public MinerwareUtils() {
        // This statement must appear first, failing to include
        // it will cause a runtime error
        MixinBootstrap.init();

        // Retrieves the DEFAULT mixin environment and registers
        // the config file
        Mixins.addConfiguration("minerwareutils.mixins.json");

        // Register the setup method for mod-loading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);

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
