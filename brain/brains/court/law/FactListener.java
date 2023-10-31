package brains.court.law;

import brains.court.decision.IDecision;
import worlds.channels.MainEvents;
import worlds.objects.IWorldAgent;

public abstract class FactListener implements IFactListener {

    @Override
    public abstract IWorldAgent worldAgent();

    @Override
    public abstract void update(MainEvents event, IDecision decision);

}