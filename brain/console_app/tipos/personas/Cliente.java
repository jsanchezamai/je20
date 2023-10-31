package console_app.tipos.personas;

import console_app.interfaces.personas.ICliente;
import console_app.tipos.entidades.EntidadTipos;

/**
 * Ver descripción en {@link console_app.interfaces.personas.ICliente}.
 */
public class Cliente extends Persona implements ICliente
{
    // String clave_de_campo;

    public Cliente() {
        super();
        setTipo(EntidadTipos.Cliente);
    }

    public Cliente(int id) {
        super(id);
        setTipo(EntidadTipos.Cliente);
    }

}
