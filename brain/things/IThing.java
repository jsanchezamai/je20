package things;

import console_app.interfaces.pantallas.IOpcion;
import worlds.objects.IWorldSubject;

public interface IThing extends IWorldSubject {

    public IOpcion opcion();

}
