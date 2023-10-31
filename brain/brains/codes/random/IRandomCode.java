package brains.codes.random;

import brains.court.decision.ICode;
import brains.court.law.ICrime;
import brains.court.law.IPunishment;

public interface IRandomCode extends ICode {

    boolean randomize(ICrime crime, IPunishment punishment);

}
