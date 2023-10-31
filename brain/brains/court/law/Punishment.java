package brains.court.law;

import brains.court.decision.IDecision;

public class Punishment extends Fact implements IPunishment {
 
    private boolean executed;

    public Integer lifeCounter = 0;

    protected DamageLevel damage;

    protected Punishment(IDecision decision){
        this.decision = decision;
    }

    public Punishment(IFact worldFact) {

        listeners(worldFact.listeners());
        timer(worldFact.timer());

    }

    @Override
    public DamageLevel damage() {
        return damage;
    }

    @Override
    public boolean executed() {
        return executed;
    }

    @Override
    public void execute() {
        executed = true;
    }

    @Override
    public Integer lifeCounter() {
        return lifeCounter;
    }

}
