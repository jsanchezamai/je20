package brains;

import brains.court.ITrial;
import brains.court.decision.IDecisionEngine;
import brains.court.law.ICrime;
import brains.court.law.IPunishment;
import brains.court.people.IBailiff;
import brains.court.people.ICourtReporter;
import console_app.tipos.entidades.Entidad;
import structures.es.uned.lsi.eped.DataStructures.GTreeIF;
import structures.es.uned.lsi.eped.DataStructures.ListIF;
import structures.es.uned.lsi.eped.DataStructures.QueueIF;
import structures.es.uned.lsi.eped.DataStructures.StackIF;

public class Court extends Entidad implements ICourt {

    private ICourtReporter courtReporter;
    private IBailiff bailiff;

    private ListIF<IDecisionEngine> decisionEngines;
    private GTreeIF<ICrime> crimesTree;
    private GTreeIF<IPunishment> punishmentsTree;
    private QueueIF<ITrial> trialsQueue;
    private StackIF<ITrial> trialsStack;
    private ITrial trial;

    @Override
    public ICourtReporter courtReporter() {
        return courtReporter;
    }

    @Override
    public IBailiff bailiff() {
        return bailiff;
    }

    @Override
    public ListIF<IDecisionEngine> decisionEngines() {
        return decisionEngines;
    }

    @Override
    public GTreeIF<ICrime> crimesTree() {
        return crimesTree;
    }

    @Override
    public GTreeIF<IPunishment> punishmentsTree() {
        return punishmentsTree;
    }

    @Override
    public QueueIF<ITrial> trialsQueue() {
        return trialsQueue;
    }

    @Override
    public StackIF<ITrial> trialsStack() {
        return trialsStack;
    }

    @Override
    public ITrial trial() {
        return trial;
    }
}
