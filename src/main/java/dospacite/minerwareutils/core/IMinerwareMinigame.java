package dospacite.minerwareutils.core;

import net.minecraft.util.text.ITextComponent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.Event;

public interface IMinerwareMinigame {

    /**
     * Do any initialization if necessary.
     */
    void init();

    /**
     * Is run on every player tick.
     */
    void tick(TickEvent.PlayerTickEvent event);

    /**
     * Processes the latest event.
     * @param event, the event to process.
     * @return if the event was fully utilized by the handler or not.
     */
    boolean processEvent(Event event);


    /**
     * Ran when the minigame is reset to clean up.
     */
    void cleanUp();
}
