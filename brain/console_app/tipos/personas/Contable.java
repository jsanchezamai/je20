package console_app.tipos.personas;

import console_app.interfaces.personas.IContable;
import console_app.tipos.entidades.EntidadTipos;

/**
 * Ver descripción en {@link console_app.interfaces.personas.IContable}.
 */
public class Contable extends Empleado implements IContable 
{
    public Contable(int id) {
        super(id);
        setTipo(EntidadTipos.Contable);
    }
}

