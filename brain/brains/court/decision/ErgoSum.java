package brains.court.decision;

import java.util.Timer;
import java.util.TimerTask;
 
public class ErgoSum implements IErgoSum {

    private Object content;
    private Timer timer;

    public ErgoSum(TimerTask task) {
    }

    @Override
    public Object content() {
        return content;
    }

    @Override
    public Timer pulse(TimerTask task, long frequency) {

        timer = new Timer();
        timer.scheduleAtFixedRate(task, 0, frequency);
        return timer;

    }

    @Override
    public void crimePulse(IDecision decision) {
        decision.crime().pulse();
    }


    @Override
    public void punishmentPulse(IDecision decision) {
        decision.punishment().pulse();
    }

    @Override
    public void content(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return content == null ? "" : content.toString();
    }

}
