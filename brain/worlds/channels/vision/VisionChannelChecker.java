package worlds.channels.vision;

import worlds.channels.EventChecker;
import worlds.channels.MainEvents;
import worlds.objects.IWorldObject;

/**
 * Check if waReceiver is able to "see" waEmitter message
 */
public class VisionChannelChecker extends EventChecker {

    @Override
    public boolean check() {

        if (waEmitter == null || waReceiver == null) return false;

        return Math.abs(
            waEmitter().position().getX() -
            waReceiver.position().getX()
        ) <
            MainEvents.VisionChannel.atomicNumber;
    }

}