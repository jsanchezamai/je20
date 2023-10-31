package brains.court.law;

import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import brains.court.decision.IDecision;
import console_app.interfaces.entidades.IEntidad;
import worlds.channels.MainEvents;

public interface IFact extends IEntidad {

    Map<MainEvents, List<IFactListener>> listeners();
    void listeners(Map<MainEvents, List<IFactListener>> listeners);

    Timer timer();
    void timer(Timer timer);

    public IDecision decision();
    void decision(IDecision decision);

    public void subscribe(MainEvents event, IFactListener listener);

    public void unsubscribe(MainEvents event, IFactListener listener);

    public void notify(MainEvents event, IDecision decision);

    void notify(MainEvents event, IDecision decision, boolean internal);

    public void pulse();
    public void scheduleTask(TimerTask task);

    void stop();

    void subscribeAll(IFactListener listener);


}
