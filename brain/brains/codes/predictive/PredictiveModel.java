package brains.codes.predictive;

import brains.court.decision.Decision;
import brains.court.decision.IDecision;
import brains.court.decision.IPredictiveModel;
import brains.court.law.ICrime;
import brains.court.law.IPunishment;
import structures.es.uned.lsi.eped.DataStructures.IteratorIF;
import structures.es.uned.lsi.eped.DataStructures.List;
import structures.es.uned.lsi.eped.DataStructures.ListIF;

public class PredictiveModel implements IPredictiveModel {

    ListIF<IPunishment> punishmentCandidates = new List<>();

    @Override
    public boolean infer(ICrime crime, IPunishment punishment) {
        return false;
    }

    @Override
    public boolean considerCandidate(ICrime crime, IPunishment punishment) {
        return infer(crime, punishment);
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
