package brains.court.decision;

import java.util.TimerTask;
 
public class Concience implements IConcience {

    private IErgoSum sum;

    public Concience() {

        TimerTask task = new TimerTask() {
            @Override
            public void run() {
            }
        };
        sum = new ErgoSum(task);

    }

    @Override
    public IErgoSum getSum() {
        return sum;
    }

}
