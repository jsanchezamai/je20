package brains.court.decision;
 
import java.util.Optional;

import brains.Court;
import brains.court.decision.IBrainState.BrainStates;
import brains.court.law.DecisionState;
import brains.court.law.IPunishment;
import console_app.servicios.Io;
import structures.es.uned.lsi.eped.DataStructures.Stack;
import structures.es.uned.lsi.eped.DataStructures.StackIF;

/**
 * Brains are more like a bot process. Like creating a bot
 * and giving to it some kind of soul in the form of a "brain"
 * that is able to take decisions and remember those.
 *
 * pre-condition
 * IDecisionEngine object. It can be an ICode, or IPredictiveModel...
 */
public class Brain extends Court implements IBrain {

    private StackIF<IBrainState> state = new Stack<>();
    private IBrainState currentState = new BrainState(BrainStates.Unborn);
    private ICode code;
    private IPredictiveModel model;

    public Brain(ICode code) {
        this.code = code;
    }

    public Brain(IPredictiveModel model) {
        this.model = model;
    }

    @Override
    public IConcience concience() {
        return currentState.concience();
    }

    @Override
    public IBrainState startToThink() {

        currentState = new BrainState(BrainStates.AliveAwake);
        state.push(currentState);

        return currentState;
    }

    @Override
    public IBrainState goToSleep() {

        currentState = new BrainState(BrainStates.AliveSleep);
        state.push(currentState);

        return currentState;
    }

    @Override
    public IBrainState brainState() {
        return currentState;
    }

    @Override
    public IDecisionEngine decisionEngine() {
        return code == null ? model : code;
    }

    @Override
    public String toString() {
        return String.format(
            Io.BRAIN_TO_STRING,
            brainState().state().label,
            this.concience().getSum().toString()
        );
    }

    @Override
    public void startToThink(IDecision decision) {

        String content = String.format(
            Io.ERGOSUM_CONTENT_LABEL,
            decision.crime().name(),
            decision.defendant().name(),
            decision.state()
        );
        this.concience().getSum().content(content);
        this.concience().getSum().crimePulse(decision);

        startToThink();
    }

    @Override
    public void reactToThink(IDecision decision) {

        String content = String.format(
            Io.ERGOSUM_CONTENT_LABEL,
            decision.crime().name(),
            decision.defendant().name(),
            decision.state()
        );

        Optional<IPunishment> punishment = decision.punishmentCandidates()
            .stream()
            .filter(p ->  decisionEngine().considerCandidate(decision.crime(), p))
            .findAny();

        if (punishment.isPresent()) {

            decision.punishment(punishment.get());
            this.concience().getSum().content(content);
            this.concience().getSum().punishmentPulse(decision);

            startToThink();

        } else {
            decision.state(DecisionState.WaitingForAck_AckSentRejected);
        }


    }

    @Override
    public void stopToThink(IDecision decision) {
        decision.crime().stop();
        decision.state(DecisionState.Abandon);
    }

}
