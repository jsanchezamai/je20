package worlds.objects;

import brains.court.decision.IDecision;
import brains.court.law.IFact;
import structures.es.uned.lsi.eped.DataStructures.GTree;
import worlds.channels.MainEvents;

public interface IWorldAgent extends IWorldObject {

    public void create(IFact seed);

    public GTree<IFact> fact();

    public void emitEvent(MainEvents event, IDecision decision);

    IDecision lastDecision();

    public IFact lastFact();
}
