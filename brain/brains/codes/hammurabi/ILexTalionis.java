package brains.codes.hammurabi;

import brains.court.decision.ICode;
import brains.court.law.ICrime;
import brains.court.law.IPunishment;

public interface ILexTalionis extends ICode
{
    boolean isEyeForAnEye(ICrime crime, IPunishment punishment);

}
