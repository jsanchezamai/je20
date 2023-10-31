package brains.court;

import brains.court.decision.IDecisionEngine;
import brains.court.law.ISentence;
import brains.court.people.IDefendant;
import brains.court.people.IDefense;
import brains.court.people.IJudge;
import brains.court.people.IPlaintiff;
import brains.court.people.IProsecutor;
import console_app.interfaces.trabajos.ITrabajo;

public interface ITrial extends ITrabajo {

    IDecisionEngine decisionEngine();

    IJudge judge();

    IDefense defense();
    IProsecutor prosecutor();

    IPlaintiff plaintiff();
    IDefendant defendant();

    ISentence saySentence();

}
