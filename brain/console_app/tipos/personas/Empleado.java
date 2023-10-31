package console_app.tipos.personas;

import console_app.interfaces.personas.IEmpleado;
import console_app.tipos.entidades.EntidadTipos;

/**
 * Ver descripción en {@link console_app.interfaces.personas.IEmpleado}.
 */
public class Empleado extends Persona implements IEmpleado
{
    public Empleado() {
        super();
        setTipo(EntidadTipos.Empleado);
    }

    public Empleado(int id) {
        super(id);
        setTipo(EntidadTipos.Empleado);
    }
}
