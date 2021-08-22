package dospacite.minerwareutils.minigames;

import dospacite.minerwareutils.core.IMinerwareMinigame;
import net.minecraft.client.Minecraft;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.util.text.ITextComponent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.Event;

public class MinigameWaitForIt implements IMinerwareMinigame {

    @Override
    public void init() {

    }

    @Override
    public void tick(TickEvent.PlayerTickEvent event) {

    }

    @Override
    public boolean processEvent(Event event) {
        return false;
    }

    @Override
    public void cleanUp() {

    }

}
