package sequences.main.crimes;

import brains.court.decision.IDecision;
import brains.court.law.Crime;
import brains.court.law.DamageLevel;

public class AcceptApple extends Crime {

    AcceptApple(IDecision decision) {
        super(decision);
        damage = DamageLevel.HIGH;
    }
}