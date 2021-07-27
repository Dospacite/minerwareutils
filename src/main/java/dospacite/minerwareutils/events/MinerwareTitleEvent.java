package dospacite.minerwareutils.events;

import dospacite.minerwareutils.MinerwareUtils;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.IngameGui;
import net.minecraft.util.text.StringTextComponent;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.ObfuscationReflectionHelper;


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
