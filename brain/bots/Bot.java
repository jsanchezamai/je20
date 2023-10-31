package bots;

import brains.court.decision.IBrain;
import brains.court.decision.IDecision;
import brains.court.law.DecisionState;
import brains.court.law.IFact;
import brains.court.people.Plaintiff;
import console_app.interfaces.pantallas.IOpcion;
import console_app.servicios.Io;
import console_app.tipos.entidades.Opcion;
import worlds.channels.MainEvents;
import worlds.objects.IWorldAgent;
import worlds.objects.WorldAgent;

public class Bot extends WorldAgent implements IBot {

    private IBrain brain;

    public Bot(IBrain brain, String name, IFact worldFact) {
        super(name, worldFact);
        this.brain = brain;
        name(name);
        lastFact().subscribeAll(this);
    }

    @Override
    public IBrain brain() {
        return brain;
    }

    @Override
    public IOpcion opcion() {
        IOpcion opcion = new Opcion(
            asOptionLabel(),
            name()
        );
        return opcion;
    }

    @Override
    public String asOptionLabel() {

        String agentLabel = super.asOptionLabel();

        String label = String.format(
            Io.BOT_AS_OPTION,
                brain.toString(),
                agentLabel
        );
        return label;
    }

    @Override
    public void startToThink(IDecision decision) {

        decision.state(DecisionState.Requested);

        decision.plaintiff(new Plaintiff(this));

        create(decision.crime());

        // Try to decide
        brain().startToThink(decision);

    }

    @Override
    public void reactToDecision(IDecision decision) {

        decision.state(DecisionState.WaitingForAck_AckSent);

        create(decision.crime());

        // Try to decide
        brain().reactToThink(decision);

    }

    @Override
    public IWorldAgent worldAgent() {
        return this;
    }

    @Override
    public void update(MainEvents event, IDecision decision) {

    if (decision.plaintiff().worldAgent().equals(this)) {
            super.update(event, decision);
        } else {

            switch(brain.brainState().state()) {
                case AliveSleep:
                    reactToDecision(decision);
                    break;
                default:
                    decision.state(DecisionState.Abandon);
                    break;
            }
        }
    }

}
