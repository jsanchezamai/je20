package worlds.objects;

import console_app.servicios.Io;
import console_app.tipos.entidades.Entidad;
import worlds.physics.Vector3;
import worlds.physics.Vector3m;

public class WorldObject extends Entidad implements IWorldObject {

    private Vector3m position = new Vector3m(0, 0, 0);

    public WorldObject(String name) {
        name(name);
    }

    @Override
    public Vector3 position() {
        return position;
    }

    @Override
    public String asOptionLabel() {
        String label = String.format(
            Io.WORLD_OBJECT_AS_OPTION,
                name(),
                position().toString()
        );
        return label;
    }

    @Override
    public void position(Vector3m vector3) {
        this.position = vector3;
    }
}
