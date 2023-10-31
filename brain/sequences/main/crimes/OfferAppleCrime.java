package sequences.main.crimes;

import java.util.TimerTask;

import brains.court.decision.IDecision;
import brains.court.law.Crime;
import brains.court.law.DamageLevel;
import brains.court.law.DecisionState;
import console_app.servicios.Io;
import worlds.channels.MainEvents;
import worlds.channels.ground.WalkTo;

public class OfferAppleCrime extends Crime {

    private static final long RETRY_DELAY_MS = 10000;
    private TimerTask walkTo;
    protected boolean found;

    public OfferAppleCrime(IDecision decision) {
        super(decision);
        name(Io.CRIMES_OFFER_APPLE);
        damage = DamageLevel.MODERATE;
    }

    private void reset() {

        executed = false;
        found = false;
    }

    @Override
    public void pulse() {

        decision.state(DecisionState.InProgress);
        search();

    }

    private void search() {
        lifeCounter = 0;
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
                    offerApple();
                }
            }
        };
        super.scheduleTask(walkTo);
    }

    private void offerApple() {
        decision.state(DecisionState.WaitingForAck);
        notify(MainEvents.SoundChannel, decision());
        execute();

        if (decision.state() == DecisionState.WaitingForAck_AckSentRejected) {

            decision.state(DecisionState.Retrying);

            try {
                Thread.sleep(RETRY_DELAY_MS);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            reset();
            pulse();
        }
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
