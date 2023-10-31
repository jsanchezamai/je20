package sequences.main.punishment;

import java.util.TimerTask;

import brains.court.decision.IDecision;
import brains.court.law.DamageLevel;
import brains.court.law.DecisionState;
import brains.court.law.Punishment;
import console_app.servicios.Io;
import worlds.channels.MainEvents;
import worlds.channels.ground.WalkTo;

public class OfferApplePunishmentAccept extends Punishment{

    private boolean found;
    private TimerTask walkTo;

    public OfferApplePunishmentAccept(IDecision decision) {
        super(decision);
        name(Io.PUNISHMENT_OFFER_APPLE_ACCEPT);
        damage = DamageLevel.MODERATE;
    }

    @Override
    public void pulse() {

        decision.state(DecisionState.InProgress);

        if (found) {
            offerApple();
        } else {
            search();
        }
    }

    private void search() {

        walkTo = new TimerTask() {
            Integer direction = 1;

            @Override
            public void run() {
                lifeCounter++;
                direction = WalkTo.searchToSound(
                    direction,
                    decision().plaintiff().worldAgent(),
                    decision().defendant().worldAgent()
                );
                found = direction == 0;
                if (found) {
                    walkTo.cancel();
                    pulse();
                }
            }
        };
        super.scheduleTask(walkTo);
    }

    private void offerApple() {
        notify(MainEvents.SoundChannel, decision());
        execute();
        decision.state(DecisionState.WaitingForAck);
    }

    private boolean canTalk() {
        return decision().defendant() != null;
    }

    @Override
    public String toString() {

        if (executed()) return Io.STATE_TALKED_LABEL;

        if (found) {
            if (canTalk()) {
                return Io.STATE_TALKING_TO_LABEL;
            }
            return Io.STATE_WALKING_TO_LABEL;
        } else {
            return Io.STATE_SEARCHING_LABEL;
        }
    }
}
