package brains.court.decision;

import brains.court.law.ICrime;
import brains.court.law.IPunishment;

public interface IPredictiveModel extends IDecisionEngine {

    public boolean infer(ICrime crime, IPunishment punishment);
}
