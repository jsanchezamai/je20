package brains.court.law;

import brains.court.decision.IDecision;

 public class Crime extends Fact implements ICrime {

    protected boolean executed;

    public Integer lifeCounter = 0;

    protected DamageLevel damage;

    protected Crime(IDecision decision){
        this.decision = decision;
    }

    public Crime(IFact worldFact) {

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
