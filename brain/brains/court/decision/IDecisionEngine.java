package brains.court.decision;

import brains.court.law.ICrime;
import brains.court.law.IPunishment;
 
public interface IDecisionEngine {

    public boolean considerCandidate(ICrime crime, IPunishment punishment);

    IDecision decide (ICrime crime);

}
