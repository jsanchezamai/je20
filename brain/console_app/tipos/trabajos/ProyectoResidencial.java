package console_app.tipos.trabajos;

import console_app.interfaces.entidades.Campos;
import console_app.interfaces.entidades.Campos.CamposEnum;
import console_app.interfaces.trabajos.IEdificacionResidencial;
import console_app.interfaces.trabajos.IProyectoResidencial;
import console_app.tipos.entidades.Entidad;
import console_app.tipos.entidades.EntidadTipos;

/**
 * Ver descripción en {@link console_app.interfaces.trabajos.IProyectoResidencial}.
 */
public class ProyectoResidencial extends Proyecto implements IProyectoResidencial
{
    public ProyectoResidencial(int id) {
        super(id);
        configurar();
    }

    private void configurar() {
        setTipo(EntidadTipos.ProyectoResidencial);
        campos = Campos.cargarCamposEntidad(this.getTipo(), campos);
    }

    @Override
    public IEdificacionResidencial getEdificacion() {
        return (IEdificacionResidencial) Entidad.buscarPorId(
            EntidadTipos.EdificacionResidencial,
            getCampo(CamposEnum.EdificacionResidencial).valorForanea()
        );
    }
}
