package brains.court.law;

import brains.court.decision.Decision;
import brains.court.decision.IDecisionEngine;
 
public class Sentence extends Decision implements ISentence {

    public Sentence(ICrime crime, IPunishment punishment, IDecisionEngine decidedBy) {
        super(crime, punishment, decidedBy);
    }

}
