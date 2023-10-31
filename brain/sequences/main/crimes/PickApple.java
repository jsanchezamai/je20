package sequences.main.crimes;

import brains.court.decision.IDecision;
import brains.court.law.Crime;
import brains.court.law.DamageLevel;

public class PickApple extends Crime {

    PickApple(IDecision decision) {
        super(decision);
        damage = DamageLevel.LOW;
    }
}
