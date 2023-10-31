package brains.court;

import brains.court.decision.IDecisionEngine;
import brains.court.law.ISentence;
import brains.court.people.IDefendant;
import brains.court.people.IDefense;
import brains.court.people.IJudge;
import brains.court.people.IPlaintiff;
import brains.court.people.IProsecutor;
import console_app.tipos.trabajos.Trabajo;

public class Trial extends Trabajo implements ITrial {

    public IJudge judge;

    public IPlaintiff plaintiff;
    public IDefendant defendant;

    public IDefense defense;
    public IProsecutor prosecutor;

    private IDecisionEngine decisionEngine;

    @Override
    public IPlaintiff plaintiff() {
        return plaintiff;
    }

    @Override
    public IDefendant defendant() {
        return defendant;
    }

    @Override
    public IJudge judge() {
        return judge;
    }

    @Override
    public IDefense defense() {
        return defense;
    }

    @Override
    public IProsecutor prosecutor() {
        return prosecutor;
    }

    @Override
    public IDecisionEngine decisionEngine() {
        return decisionEngine;
    }

    @Override
    public ISentence saySentence() {
        return (ISentence) this.judge().decide(this);
    }

}
