package brains.court.decision;

import java.util.List;

import brains.court.law.DecisionState;
import brains.court.law.ICrime;
import brains.court.law.IPunishment;
import brains.court.people.IDefendant;
import brains.court.people.IPlaintiff;
import worlds.objects.IWorldAgent;

public interface IDecision {

    IDecisionEngine decidedBy();

    List<IPunishment> punishmentCandidates();
    void punishmentCandidates(List<IPunishment> punishmentCandidates);

    IPunishment punishment();
    void punishment(IPunishment punishment);
    ICrime crime();

    IDefendant defendant();
    void defendant(IDefendant d);

    IPlaintiff plaintiff();
    void plaintiff(IPlaintiff p);

    String toString();

    DecisionState state();

    void state(DecisionState requested);

    boolean isPlainiff(IWorldAgent worldAgent);

    List<String> log();

    IDecision clone();

}
