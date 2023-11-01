package console_app.tipos.personas;

import console_app.interfaces.personas.IAparejador;
import console_app.tipos.entidades.EntidadTipos;

/**
 * Ver descripción en {@link console_app.interfaces.personas.IAparejador}.
 */
public class Aparejador extends Empleado implements IAparejador 
{
    public Aparejador(int id) {
        super(id);
        setTipo(EntidadTipos.Aparejador);
    }
}