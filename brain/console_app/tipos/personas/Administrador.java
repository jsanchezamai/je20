package console_app.tipos.personas;

import console_app.interfaces.personas.IAdministrador;
import console_app.tipos.entidades.EntidadTipos;

/**
 * Ver descripción en {@link console_app.interfaces.personas.IAdministrador}.
 */
public class Administrador extends Empleado implements IAdministrador 
{
    public Administrador(int id) {
        super(id);
        setTipo(EntidadTipos.Administrador);
    }
}
