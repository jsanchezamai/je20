package sequences.main;

import brains.court.decision.Decision;
import console_app.servicios.Io;
import sequences.main.crimes.OfferAppleCrime;
import sequences.main.punishment.OfferApplePunishmentAccept;
import sequences.main.punishment.OfferApplePunishmentReject;

public class OfferAppleDecision extends Decision  {

    public OfferAppleDecision() {
        crime = new OfferAppleCrime(this);

        punishmentCandidates.add(new OfferApplePunishmentAccept(this));
        punishmentCandidates.add(new OfferApplePunishmentReject(this));
    }

    @Override
    public String toString() {

        String label = String.format(
            Io.OFFER_APPLE_DECISION_LABEL,
            crime.lifeCounter(),
            super.toString()
        );
        return label;

    }

}
