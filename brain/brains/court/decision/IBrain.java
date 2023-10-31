package brains.court.decision;

import brains.ICourt;
import console_app.interfaces.entidades.IEntidad;

public interface IBrain extends ICourt, IEntidad {

    IConcience concience();

    IDecisionEngine decisionEngine();

    /**
     * This is main thinking process, opens the concience
     */
    IBrainState startToThink();

    /**
     * Report current Brain state
     */
    IBrainState brainState();

    /**
     * Just drop the cogito part of the brain...
     */
    public IBrainState goToSleep();

    String toString();

    void startToThink(IDecision decision);

    void reactToThink(IDecision decision);

    void stopToThink(IDecision decision);

}
