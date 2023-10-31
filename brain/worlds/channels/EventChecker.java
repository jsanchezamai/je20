package worlds.channels;

import worlds.objects.IWorldObject;

public abstract class EventChecker implements IEventChecker {

    protected IWorldObject waEmitter;
    protected IWorldObject waReceiver;

    @Override
    public IWorldObject waEmitter() {
        return waEmitter;
    }

    @Override
    public IWorldObject waReceiver() {
        return waReceiver;
    }

    @Override
    public void waEmitter(IWorldObject waEmitter) {
        this.waEmitter = waEmitter;
    }

    @Override
    public void waReceiver(IWorldObject waReceiver) {
        this.waReceiver = waReceiver;
    }

    @Override
    public boolean check(IWorldObject waEmitter, IWorldObject waReceiver) {
        this.waEmitter = waEmitter;
        this.waReceiver = waReceiver;
        return check();
    }

    @Override
    public boolean check(IWorldObject waReceiver) {
        this.waReceiver = waReceiver;
        return check();
    }

    @Override
    public abstract boolean check();
}