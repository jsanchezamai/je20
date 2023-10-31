package worlds.channels.sound;

import worlds.channels.EventChecker;
import worlds.channels.MainEvents;
import worlds.objects.IWorldObject;

/**
 * Check if waReceiver is able to "hear" waEmitter message
 */
public class SoundChannelChecker extends EventChecker {

    @Override
    public boolean check() {

        if (waEmitter == null || waReceiver == null) return false;

        return Math.abs(
            waEmitter().position().getX() -
            waReceiver.position().getX()
        ) <
            MainEvents.SoundChannel.atomicNumber;
    }

}
