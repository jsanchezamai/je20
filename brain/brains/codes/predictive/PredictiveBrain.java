package brains.codes.predictive;

import brains.court.decision.Brain;

public class PredictiveBrain extends Brain {

    public PredictiveBrain() {
        super(new PredictiveModel());
    }
}
