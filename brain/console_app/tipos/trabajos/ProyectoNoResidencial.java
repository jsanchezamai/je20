package console_app.tipos.trabajos;

import console_app.tipos.entidades.EntidadTipos;
import console_app.interfaces.entidades.Campos;
import console_app.interfaces.entidades.Campos.CamposEnum;
import console_app.interfaces.trabajos.IEdificacionNoResidencial;
import console_app.interfaces.trabajos.IProyectoNoResidencial;
import console_app.tipos.entidades.Entidad;

/**
 * Ver descripción en {@link console_app.interfaces.trabajos.IProyectoNoResidencial}.
 */
public class ProyectoNoResidencial extends Proyecto implements IProyectoNoResidencial
{

    public ProyectoNoResidencial(int id) {
        super(id);
        configurar();
    }

    private void configurar() {
        setTipo(EntidadTipos.ProyectoNoResidencial);
        campos = Campos.cargarCamposEntidad(this.getTipo(), campos);
    }

    @Override
    public IEdificacionNoResidencial getEdificacion() {
        return (IEdificacionNoResidencial) Entidad.buscarPorId(
            EntidadTipos.EdificacionNoResidencial,
            getCampo(CamposEnum.EdificacionNoResidencial).valorForanea()
        );
    }

}
