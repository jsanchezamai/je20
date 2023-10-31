package console_app.tipos.trabajos;

import console_app.interfaces.trabajos.IEdificacionResidencialComunitario;
import console_app.tipos.entidades.EntidadTipos;

/**
 * Ver descripción en {@link console_app.interfaces.trabajos.IEdificacionResidencialComunitario}.
 */
public class EdificacionResidencialComunitario extends EdificacionResidencial implements IEdificacionResidencialComunitario
{

    public EdificacionResidencialComunitario(int id) {
        super(id);
        setTipo(EntidadTipos.EdificacionResidencialComunitario);
    }

}
