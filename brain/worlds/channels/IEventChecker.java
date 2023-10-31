package worlds.channels;

import worlds.channels.sound.SoundChannelChecker;
import worlds.objects.IWorldObject;

/**
 * Use this class to check if waEmitter is able to send an event to waReceiver.
 *
 * It will depend on the channel where this event will be sent.
 *
 * Each channel should implement a checker.
 *
 * For example, {@link SoundChannelChecker}
 */
public interface IEventChecker {

    IWorldObject waEmitter();
    IWorldObject waReceiver();

    void waEmitter(IWorldObject waEmitter);
    void waReceiver(IWorldObject waReceiver);

    abstract boolean check();

    public boolean check(IWorldObject waReceiver);

    public boolean check(IWorldObject waEmitter, IWorldObject waReceiver);
}
