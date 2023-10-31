package sequences.main.punishment;

import brains.court.decision.IDecision;
import brains.court.law.DamageLevel;
import brains.court.law.DecisionState;
import brains.court.law.Punishment;
import console_app.servicios.Io;

public class OfferApplePunishmentReject extends Punishment{

    public OfferApplePunishmentReject(IDecision decision) {
        super(decision);
        name(Io.PUNISHMENT_OFFER_APPLE_REJECT);
        damage = DamageLevel.MODERATE;
    }

    @Override
    public void pulse() {

        decision.state(DecisionState.Rejected);
        execute();
    }

    @Override
    public String toString() {

        return Io.STATE_REJECTED;
    }
}
