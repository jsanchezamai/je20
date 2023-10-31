package brains.codes.hammurabi;

import brains.court.decision.Decision;
import brains.court.decision.IDecision;
import brains.court.law.ICrime;
import brains.court.law.IPunishment;
import structures.es.uned.lsi.eped.DataStructures.IteratorIF;
import structures.es.uned.lsi.eped.DataStructures.List;
import structures.es.uned.lsi.eped.DataStructures.ListIF;

public class LexTalionis implements ILexTalionis {

    ListIF<IPunishment> punishmentCandidates = new List<>();

    @Override
    public boolean considerCandidate(ICrime crime, IPunishment punishment) {
        return isEyeForAnEye(crime, punishment);
    }

    @Override
    public boolean isEyeForAnEye(ICrime crime, IPunishment punishment) {
        return crime.damage().equals(punishment.damage());
    }

    @Override
    public IDecision decide(ICrime crime) {

        IteratorIF<IPunishment> iterator = this.punishmentCandidates.iterator();

        boolean foundFirst = false;
        while(!foundFirst && iterator.hasNext()) {
            IPunishment punishment = iterator.getNext();
            if (considerCandidate(crime, punishment)) {
                return new Decision(crime, punishment, this);
            }
        }
        return null;
    }

}
