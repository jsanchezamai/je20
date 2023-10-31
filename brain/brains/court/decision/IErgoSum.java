package brains.court.decision;

import java.util.Timer;
import java.util.TimerTask;

import brains.court.law.IFact;

/**
 * When said: "cogito ergo sum" this class represents a "Sum" for a "cogito"
 */
public interface IErgoSum {

    Object content();

    /**
     * @param task
     * @param frequency timer pulse in milliseconds
     */
    Timer pulse(TimerTask task, long frequency);

    void crimePulse(IDecision decision);
    void punishmentPulse(IDecision decision);

    void content(String name);

    String toString();
}
