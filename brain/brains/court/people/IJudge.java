package brains.court.people;

import brains.court.ITrial;
import brains.court.decision.IDecision;
import console_app.interfaces.personas.IEmpleado;

public interface IJudge extends IEmpleado {

    IDecision decide(ITrial trial);

}
