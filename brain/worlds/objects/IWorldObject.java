package worlds.objects;

import console_app.interfaces.entidades.IEntidad;
import worlds.physics.Vector3;
import worlds.physics.Vector3m;

public interface IWorldObject extends IEntidad {

    Vector3 position();
    void position(Vector3m vector3);

    String asOptionLabel();

}

