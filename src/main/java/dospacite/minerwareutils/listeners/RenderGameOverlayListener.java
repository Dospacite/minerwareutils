package dospacite.minerwareutils.listeners;

import dospacite.minerwareutils.MinerwareUtils;
import dospacite.minerwareutils.events.MinerwareTitleEvent;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.IngameGui;
import net.minecraft.util.text.StringTextComponent;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.ObfuscationReflectionHelper;

public class RenderGameOverlayListener {

    public StringTextComponent displayedTitle;
    public StringTextComponent displayedSubtitle;

    private StringTextComponent lastDisplayedTitle;
    private StringTextComponent lastDisplayedSubtitle;

    /** Gets the current title on the screen, returns null if there is none.
     * @since 1.0-SNAPSHOT
     * @param is_subtitle: If the subtitle should be fetched instead of the title.
     * @return Current title (StringTextComponent) or null
     */
    private StringTextComponent getCurrentTitle(Boolean is_subtitle) {
        // Set the fieldName to avoid making separate functions for title and the subtitle.
        String fieldName = is_subtitle ? "field_175200_y" : "field_175201_x";
        try {
            // Cast the field (Object) to StringTextComponent
            return (StringTextComponent) ObfuscationReflectionHelper.findField(IngameGui.class, fieldName).get(Minecraft.getInstance().ingameGUI);
        } catch (IllegalAccessException e) {
            // Print the exception just in case
            MinerwareUtils.LOGGER.error("getCurrentTitle threw an IllegalAccessException. is_subtitle: " + is_subtitle);
        }
        return null;
    }

    @SubscribeEvent
    public void minerwareTitleChange(RenderGameOverlayEvent event) {
        displayedTitle = getCurrentTitle(false);
        displayedSubtitle = getCurrentTitle(true);

        MinerwareUtils.LOGGER.debug("Title: " + displayedTitle);

        //Check if the title OR the subtitle has not triggered an event yet
        if ((displayedTitle != null && !displayedTitle.equals(lastDisplayedTitle)) ||
                (displayedSubtitle != null && !displayedSubtitle.equals(lastDisplayedSubtitle))) {
            lastDisplayedTitle = displayedTitle;  // Set the last hash so that this title only fires an event once.
            lastDisplayedSubtitle = displayedSubtitle;  // Set the last hash so that this subtitle only fires an event once.

            switch (displayedTitle.getText()) {
                /*
                case "3":
                    //MinecraftForge.EVENT_BUS.post(new MinerwareTitleEvent(displayedTitle, displayedSubtitle));
                    break;
                case "GO":
                    MinecraftForge.EVENT_BUS.post(new MinerwareTitleEvent(displayedTitle, displayedSubtitle));
                    break;
                 */
                default:
                    MinecraftForge.EVENT_BUS.post(new MinerwareTitleEvent(displayedTitle, displayedSubtitle));
            }

        }
    }
}
