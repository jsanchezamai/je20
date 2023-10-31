package worlds;

import java.util.List;

import bots.IBot;
import brains.court.law.IFact;
import console_app.interfaces.entidades.IEntidad;
import console_app.interfaces.pantallas.IOpcion;
import things.IThing;

public interface IWorld extends IEntidad {

    IFact fact();

    public List<IBot> bots();

    public List<IThing> things();

    public List<IOpcion> opciones();

    public void create();
}
