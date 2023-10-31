package worlds;

import java.util.ArrayList;
import java.util.List;

import bots.IBot;
import brains.court.law.Fact;
import brains.court.law.IFact;
import console_app.interfaces.pantallas.IOpcion;
import console_app.tipos.entidades.Entidad;
import things.IThing;
import worlds.channels.MainEvents;

public class World extends Entidad implements IWorld {

    List<IOpcion> opciones = new ArrayList<>();

    protected List<IBot> bots = new ArrayList<>();
    protected List<IThing> things = new ArrayList<>();

    private IFact fact = new Fact(
        MainEvents.GroundChannel,
        MainEvents.VisionChannel,
        MainEvents.SoundChannel
    );

    World() {
        fact.name("World");
    }
    @Override
    public List<IBot> bots() {
        return bots;
    }

    @Override
    public List<IThing> things() {
        return things;
    }

    @Override
    public List<IOpcion> opciones() {
        return opciones;
    }

    @Override
    public void create() {

    }

    @Override
    public IFact fact() {
        return fact;
    }

}
