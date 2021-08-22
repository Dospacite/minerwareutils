package dospacite.minerwareutils.core;

import dospacite.minerwareutils.minigames.MinigameWaitForIt;
import net.minecraft.util.text.ITextComponent;

import java.util.HashMap;
import java.util.Map;

public class MinerwareMinigames {

    /**
     * The hashmap that holds all the minigame classes, with their appropriate titles as keys.
     */
    private static HashMap<String, Class<? extends IMinerwareMinigame>> Minigames = new HashMap<String, Class<? extends IMinerwareMinigame>>() {{
        put("Wait for it...", MinigameWaitForIt.class);
    }};


    /**
     * Returns the appropirate minigame for the given title.
     * @param title, the title for the minigame.
     * @return IMinerwareMinigame, the appropriate minigame handler.
     * @throws InstantiationException if there was an error while running the constructor.
     * @throws IllegalAccessException if the constructor cannot be accessed.
     */
    public static IMinerwareMinigame getMinigame(ITextComponent title) throws InstantiationException, IllegalAccessException {
        IMinerwareMinigame minigame = null;
        for (Map.Entry<String, Class<? extends IMinerwareMinigame>> entry: Minigames.entrySet()) {
            if(title.getString().contains(entry.getKey())) {
                minigame = Minigames.get(entry.getKey()).newInstance();
            }
        }
        return minigame;
    }

}
