package dospacite.minerwareutils.events;

import dospacite.minerwareutils.core.MinerwareMinigame;
import net.minecraftforge.eventbus.api.Event;

public class MinerwareMinigameStartEvent extends Event {

    public MinerwareMinigame minigame;

    public MinerwareMinigameStartEvent(MinerwareMinigame minigameIn) {
        this.minigame = minigameIn;
    }
}
