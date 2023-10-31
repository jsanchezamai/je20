package brains.court.law;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import brains.court.decision.Decision;
import brains.court.decision.IDecision;
import console_app.pantallas.aplicacion.Pantalla;
import console_app.servicios.Io;
import console_app.tipos.entidades.Entidad;
import worlds.channels.MainEvents;
 
public class Fact extends Entidad implements IFact {

    Map<MainEvents, List<IFactListener>> listeners = new HashMap<>();
    protected IDecision decision;
    protected Timer timer;

    public Fact() {
        initEventsAll();
    }

    public Fact(MainEvents... operations) {
       initEvents(operations);
    }

    public Fact(IDecision decision) {
        this.decision = decision;
        initEventsAll();
    }

    private void initEventsAll() {
        initEvents(MainEvents.GroundChannel, MainEvents.VisionChannel, MainEvents.SoundChannel);
    }

    private void initEvents (MainEvents... operations) {
        for (MainEvents operation : operations) {
            this.listeners.put(operation, new ArrayList<>());
        }
    }

    public void subscribe(MainEvents event, IFactListener listener) {
        List<IFactListener> subscribers = listeners.get(event);
        subscribers.add(listener);
    }

    public void unsubscribe(MainEvents event, IFactListener listener) {
        List<IFactListener> subscribers = listeners.get(event);
        subscribers.remove(listener);
    }

    @Override
    public void notify(MainEvents event, IDecision decision) { 
        notify(event, decision, true);
    }

    @Override
    public void notify(MainEvents event, IDecision decision, boolean internal) {

        String logLabel =  String.format(
            Io.EVENTS_EMITTED,
            internal ? Io.INTERNAL_EVENT : Io.EXTERNAL_EVENT,
            event.label, decision.crime().name(),
            decision.plaintiff().name(),
            decision.defendant().name(),
            decision.crime().damage()
        );
        decision.log().add(logLabel);

        List<IFactListener> subscribers = listeners.get(event);

        subscribers
            .stream()
            // Discard events sended by the listener
            .filter(fl -> internal || !decision.isPlainiff(fl.worldAgent()))
            // Use event channel to check availability
            .filter(fl -> event.checker.check(fl.worldAgent()))
            // Send the message to any listener available
            .forEach(fl -> {
                fl.update(event, decision.clone());
            });

    }

    @Override
    public IDecision decision() {
        return decision == null ? new Decision() : decision;
    }

    @Override
    public void decision(IDecision decision) {
        this.decision = decision;
    }

    @Override
    public void scheduleTask(TimerTask task) {

        if (timer != null) {
            try {
                timer.cancel();
                timer.purge();
            } catch (Exception e) {

            }
        }
        timer = new Timer();
        timer.scheduleAtFixedRate(task, 0, 2000);
    }

    @Override
    public void pulse() {
        Pantalla.volcar("Fact.java/pulse");
    }

    @Override
    public void stop() {
        Pantalla.volcar("Fact.java/stop");
        if (timer == null) return;

        timer.cancel();
    }

    @Override
    public Map<MainEvents, List<IFactListener>> listeners() {
        return listeners;
    }

    @Override
    public void listeners(Map<MainEvents, List<IFactListener>> listeners) {
        this.listeners = listeners;
    }

    @Override
    public Timer timer() {
        return timer;
    }

    @Override
    public void timer(Timer timer) {
        this.timer = timer;
    }

    @Override
    public void subscribeAll(IFactListener listener) {
        for (MainEvents event : listeners.keySet()) {
            listeners.get(event).add(listener);
        }
    }

}
