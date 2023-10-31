package brains.codes.random;

import brains.court.decision.Brain;

public class RandomBrain  extends Brain {

    public RandomBrain() {
        super(new RandomCode());
    }

}
