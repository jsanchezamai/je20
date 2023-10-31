package brains.court.decision;

import java.util.ArrayList;
import java.util.List;

import brains.court.law.DecisionState;
import brains.court.law.ICrime;
import brains.court.law.IPunishment;
import brains.court.people.Defendant;
import brains.court.people.IDefendant;
import brains.court.people.IPlaintiff;
import brains.court.people.Plaintiff;
import console_app.servicios.Io;
import worlds.objects.IWorldAgent;

public class Decision implements IDecision {

    public List<IPunishment> punishmentCandidates = new ArrayList<>();

    public IPunishment punishment;
    public ICrime crime;
    public IDecisionEngine decidedBy;
    private IDefendant defendant;
    private IPlaintiff plaintiff;
    private DecisionState state = DecisionState.Empty;
    private List<String> log = new ArrayList<>();

    public Decision(ICrime crime, IPunishment punishment, IDecisionEngine decidedBy) {
        this.crime = crime;
        this.punishment = punishment;
        this.decidedBy = decidedBy;
    }

    public Decision() {
    }

    @Override
    public IPunishment punishment() {
        return punishment;
    }

    @Override
    public ICrime crime() {
        return crime;
    }

    @Override
    public IDecisionEngine decidedBy() {
        return decidedBy;
    }

    @Override
    public IDefendant defendant() {
        return defendant == null ? new Defendant() : defendant;
    }

    @Override
    public void defendant(IDefendant d) {
        defendant = d;
    }

    @Override
    public IPlaintiff plaintiff() {
        return plaintiff == null ? new Plaintiff() : plaintiff;
    }

    @Override
    public void plaintiff(IPlaintiff p) {
        plaintiff = p;
    }

    @Override
    public
    String toString() {

        if (state == DecisionState.Empty) return Io.NO_DATA;

        return String.format(
            Io.DECISION_TO_STRING,
            state,
            crime == null ? Io.NO_DATA : crime.name(),
            punishment == null ? Io.NO_DATA : punishment.name(),
            plaintiff == null ? Io.NO_DATA : plaintiff.name(),
            defendant == null ? Io.NO_DATA : defendant.name()
        );
    }

    @Override
    public DecisionState state() {
        return state;
    }

    @Override
    public void state(DecisionState state) {
        this.state = state;    }

    @Override
    public boolean isPlainiff(IWorldAgent worldAgent) {
        return plaintiff().worldAgent().equals(worldAgent);
    }

    @Override
    public List<String> log() {
        return log;
    }

    @Override
    public List<IPunishment> punishmentCandidates() {
        return punishmentCandidates;
    }

    @Override
    public void punishmentCandidates(List<IPunishment> punishmentCandidates) {
        this.punishmentCandidates = punishmentCandidates;
    }

    @Override
    public void punishment(IPunishment punishment) {
       this.punishment = punishment;
    }

    @Override
    public IDecision clone() {
        Decision d = null;
        try {
            d = (Decision) super.clone();
        } catch (CloneNotSupportedException e) {
            d = new Decision();
        }
        return d;
    }
}