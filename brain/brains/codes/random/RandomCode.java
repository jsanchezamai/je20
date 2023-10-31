package brains.codes.random;

import java.util.Random;

import brains.court.decision.IDecision;
import brains.court.law.ICrime;
import brains.court.law.IPunishment;

public class RandomCode implements IRandomCode {

    @Override
    public boolean randomize(ICrime crime, IPunishment punishment) {

        Random rand = new Random(crime.hashCode() + punishment.hashCode());
        int upperbound = 100;
        int int_random = rand.nextInt(upperbound);

        return int_random > (upperbound / 2);
        // double double_random=rand.nextDouble();
        // float float_random=rand.nextFloat();
    }

    @Override
    public boolean considerCandidate(ICrime crime, IPunishment punishment) {
        return randomize(crime, punishment);
    }

    @Override
    public IDecision decide(ICrime crime) {
        // TODO Auto-generated method stub
        return null;
    }

}
