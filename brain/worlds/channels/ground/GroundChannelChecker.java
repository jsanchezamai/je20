package worlds.channels.ground;

import worlds.channels.EventChecker;
import worlds.channels.MainEvents;

/**
 * Check if waReceiver is able to "hear" waEmitter message
 */
public class GroundChannelChecker extends EventChecker {

    @Override
    public boolean check() {

        if (waEmitter == null || waReceiver == null) return false;

        return Math.abs(
            waEmitter().position().getX() -
            waReceiver.position().getX()
        ) <
            MainEvents.GroundChannel.atomicNumber;
    }

}
