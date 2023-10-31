package things;

import console_app.interfaces.pantallas.IOpcion;
import console_app.servicios.Io;
import console_app.tipos.entidades.Opcion;
import worlds.objects.WorldSubject;

public class Thing extends WorldSubject implements IThing {

    public Thing(String name) {
        super(name);
    }

    @Override
    public IOpcion opcion() {
        IOpcion opcion = new Opcion(asOptionLabel(),
            name()
        );
        return opcion;
    }

    @Override
    public String asOptionLabel() {

        String subjectLabel = super.asOptionLabel();

        String label = String.format(
            Io.THING_AS_OPTION,
                subjectLabel
        );
        return label;
    }

}
