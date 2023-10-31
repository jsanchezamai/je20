package brains.court.people;

import brains.court.ITrial;
import brains.court.decision.IDecision;
import console_app.tipos.personas.Empleado;

public class Judge extends Empleado implements IJudge {

    private IDecision decision;

    @Override
    public IDecision decide(ITrial trial) {
        return decision;
    }

}
