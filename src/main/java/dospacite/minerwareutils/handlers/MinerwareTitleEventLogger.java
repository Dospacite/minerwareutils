package dospacite.minerwareutils.handlers;

import dospacite.minerwareutils.MinerwareUtils;
import dospacite.minerwareutils.events.MinerwareTitleEvent;

/**
 * This class is for debugging purposes ONLY. This will not be in the final build.
 */
public class MinerwareTitleEventLogger {

    /**
     * Logs title information.
     * @param event, the title event.
     */
    public void log(MinerwareTitleEvent event) {
        MinerwareUtils.LOGGER.debug(String.format("Title title: %s, Title subtitle: %s", event.displayedTitle, event.displayedSubtitle));
    }

}
