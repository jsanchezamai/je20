package brains.court.decision;
 
public class BrainState implements IBrainState {

    private BrainStates state;
    private IConcience concience;

    public BrainState(BrainStates state) {
        concience = new Concience();
        this.state = state;
    }

    public BrainState(IConcience concience, BrainStates state) {
        this.concience = concience;
        this.state = state;
    }

    @Override
    public BrainStates state() {
        return state;
    }

    @Override
    public IConcience concience() {
        return concience;
    }

    @Override
    public void state(BrainStates state) {
        this.state = state;
    }


}
