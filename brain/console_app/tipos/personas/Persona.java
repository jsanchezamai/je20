package console_app.tipos.personas;

import console_app.interfaces.entidades.Campos;
import console_app.interfaces.personas.IPersona;
import console_app.tipos.entidades.Entidad;
import console_app.tipos.entidades.EntidadTipos;
import worlds.objects.IWorldAgent;

/**
 * Ver descripción en {@link console_app.interfaces.personas.IPersona}.
 */
public class Persona extends Entidad implements IPersona
{

    private IWorldAgent worldAgent;

    public Persona() {
        super();
        configurar();
    }

    Persona(int id) {
        super(id);
        configurar();
    }

    private void configurar() {
        setTipo(EntidadTipos.Persona);
        campos = Campos.cargarCamposEntidad(this.getTipo(), campos);
    }

    @Override
    public IWorldAgent worldAgent() {
        return worldAgent;
    }

    @Override
    public void worldAgent(IWorldAgent wa) {
        name(wa.name());
        this.worldAgent = wa;
    }
}
