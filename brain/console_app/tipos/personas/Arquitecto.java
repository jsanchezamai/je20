package console_app.tipos.personas;

import console_app.interfaces.personas.IArquitecto;
import console_app.tipos.entidades.EntidadTipos;

/**
 * Ver descripción en {@link console_app.interfaces.personas.IArquitecto}.
 */
public class Arquitecto extends Empleado implements IArquitecto 
{
    public Arquitecto(int id) {
        super(id);
        setTipo(EntidadTipos.Arquitecto);
    }
}
