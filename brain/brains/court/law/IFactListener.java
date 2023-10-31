package brains.court.law;

import brains.court.decision.IDecision;
import worlds.channels.MainEvents;
import worlds.objects.IWorldAgent;

public interface IFactListener {

    abstract IWorldAgent worldAgent();

    abstract void update(MainEvents event, IDecision decision);

}
