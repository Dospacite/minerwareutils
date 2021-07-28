package dospacite.minerwareutils.events;

import net.minecraft.util.text.StringTextComponent;
import net.minecraftforge.eventbus.api.Event;

/** MinerwareTitleEvent is fired when client gets a title popup while in Minerware.
 * @version 1.0-SNAPSHOT
 * @since 1.0-SNAPSHOT
 */
public class MinerwareTitleEvent extends Event {

    public StringTextComponent displayedTitle;
    public StringTextComponent displayedSubtitle;

    public MinerwareTitleEvent(StringTextComponent displayedTitle, StringTextComponent displayedSubtitle) {
        this.displayedTitle = displayedTitle;
        this.displayedSubtitle = displayedSubtitle;
    }

}
