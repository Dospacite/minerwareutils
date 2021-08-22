package dospacite.minerwareutils.handlers;

import dospacite.minerwareutils.MinerwareUtils;
import dospacite.minerwareutils.core.IMinerwareMinigame;
import dospacite.minerwareutils.core.MinerwareMinigames;
import dospacite.minerwareutils.events.MinerwareTitleEvent;
import net.minecraft.util.text.ITextComponent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

/**
 * This class deals with the title event and minigame handlers.
 */
public class MinerwareTitleEventHandler {

    private IMinerwareMinigame currentMinigame = null;

    /**
     * Handles the title event.
     * @param event, the title event.
     */
    @SubscribeEvent
    public void handleTitleEvent(MinerwareTitleEvent event) {
        // If minigame is not set, try to get minigame with title information.
        if(currentMinigame == null) {
            getMinigameFromTitle(event.displayedTitle, event.displayedSubtitle);
        }
        else {
            // If the minigame had no use of the title, check if it SUCCESS or FAILED, and reset the minigame if it is.
            if(!currentMinigame.processEvent(event)) {
                if(event.displayedTitle.getString().contains("SUCCESS") || event.displayedTitle.getString().contains("FAILED")) {
                    currentMinigame.cleanUp();
                    currentMinigame = null;
                }
            }
        }
    }

    public void getMinigameFromTitle(ITextComponent title, ITextComponent subtitle) {
        try {
            // Get minigame and initialize it.
            currentMinigame = MinerwareMinigames.getMinigame(title);
            currentMinigame.init();
        }
        catch (Exception exception) {
            // Log exception.
            MinerwareUtils.LOGGER.error("An OH FUCK has occurred: ", exception);
        }
    }

    @SubscribeEvent
    public void handlePlayerTickEvent(TickEvent.PlayerTickEvent event) {
        //If minigame is set, tick.
        if(currentMinigame != null) {
            currentMinigame.tick(event);
        }
    }
}
