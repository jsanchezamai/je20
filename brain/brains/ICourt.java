package brains;

import brains.court.ITrial;
import brains.court.decision.IDecisionEngine;
import brains.court.law.ICrime;
import brains.court.law.IPunishment;
import brains.court.people.IBailiff;
import brains.court.people.ICourtReporter;
import structures.es.uned.lsi.eped.DataStructures.GTreeIF;
import structures.es.uned.lsi.eped.DataStructures.ListIF;
import structures.es.uned.lsi.eped.DataStructures.QueueIF;
import structures.es.uned.lsi.eped.DataStructures.StackIF;

public interface ICourt {

    ListIF<IDecisionEngine> decisionEngines();

    GTreeIF<ICrime> crimesTree();
    GTreeIF<IPunishment> punishmentsTree();

    QueueIF<ITrial> trialsQueue();
    StackIF<ITrial> trialsStack();

    ICourtReporter courtReporter();
    IBailiff bailiff();

    ITrial trial();

}
