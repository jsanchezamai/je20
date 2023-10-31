package bots;

import brains.court.decision.IBrain;
import brains.court.decision.IDecision;
import console_app.interfaces.pantallas.IOpcion;
import worlds.objects.IWorldAgent;

public interface IBot extends IWorldAgent {

    IBrain brain();

    public IOpcion opcion();

    void startToThink(IDecision decision);

    void reactToDecision(IDecision decision);

}
