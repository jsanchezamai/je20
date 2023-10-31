package worlds.objects;

import brains.court.decision.IDecision;
import brains.court.law.DecisionState;
import brains.court.law.Fact;
import brains.court.law.IFact;
import brains.court.law.IFactListener;
import brains.court.people.IPlaintiff;
import brains.court.people.Plaintiff;
import console_app.servicios.Io;
import structures.es.uned.lsi.eped.DataStructures.GTree;
import worlds.channels.MainEvents;

public class WorldAgent extends WorldObject implements IWorldAgent, IFactListener  {

    IFact worldFact;
    private GTree<IFact> facts = new GTree<>();

    public WorldAgent(String name, IFact worldFact) {
        super(name);
        this.worldFact = worldFact;
        this.worldFact.subscribeAll(this);
    }

    /**
     * Places last fact of top of the facts tree.
     */
    @Override
    public GTree<IFact> fact() {
        return facts;
    }

    @Override
    public void create(IFact seed) {

        if (seed == null) return;
        seed.subscribeAll(this);
        addToRoot(seed);

    }

    @Override
    public void emitEvent(MainEvents event, IDecision decision) {

        IPlaintiff p = new Plaintiff(this);
        decision.plaintiff(p);

        facts.getRoot().notify(event, decision);
    }

    @Override
    public void update(MainEvents event, IDecision decision) {

        if (decision.plaintiff().worldAgent().equals(this)) {
            worldFact.notify(event, decision, false);
        } else {
            IFact lastFact = decision.crime();
            lastFact.name("WorldAgent/" +
                decision.plaintiff().name() + "/" +
                decision.crime().name() +  "/" +
                decision.state()
            );

            decision.state(DecisionState.WaitingForAck_PingArrived);
            lastFact.decision(decision);
            addToRoot(lastFact);

            facts.setRoot(lastFact);
        }
    }

    private void addToRoot(IFact lastFact) {

        if (lastFact == null) return;

        if (facts.getRoot() == null) {
            facts.setRoot(lastFact);
        }

        GTree<IFact> child = new GTree<>();
        child.setRoot(facts.getRoot());
        facts.addChild(
            facts.getNumChildren() + 1,
            child
        );
        facts.setRoot(lastFact);

    }

    @Override
    public IWorldAgent worldAgent() {
        return this;
    }

    @Override
    public IDecision lastDecision() {

        return lastFact().decision();

    }

    @Override
    public IFact lastFact() {

        return facts.getRoot() == null ? new Fact() : facts.getRoot();

    }

    @Override
    public String asOptionLabel() {

        String objectLabel = super.asOptionLabel();

        String label = String.format(
            Io.WORLD_AGENT_AS_OPTION,
                objectLabel,
                lastDecision().toString()
        );
        return label;
    }

}
