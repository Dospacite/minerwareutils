package dospacite.minerwareutils.core;

import net.minecraft.util.text.ITextComponent;

public interface IMinerwareMinigame {

    /**
     * Do any initialization if necessary.
     */
    void init();

    /**
     * Is run on every player tick.
     */
    void tick();

    /**
     * Processes the title.
     * @param title, the title.
     * @param subtitle, the subtitle.
     * @return If the title was used fully utilized by the handler or not.
     */
    boolean processTitle(ITextComponent title, ITextComponent subtitle);

    /**
     * Ran when the minigame is reset to clean up.
     */
    void cleanUp();

}
