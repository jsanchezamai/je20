package console_app.tipos.trabajos;

import console_app.interfaces.entidades.Campos;
import console_app.interfaces.entidades.Campos.CamposEnum;
import console_app.interfaces.trabajos.IEdificacion;
import console_app.interfaces.trabajos.IProyectoRehabilitacion;
import console_app.tipos.entidades.Entidad;
import console_app.tipos.entidades.EntidadTipos;

/**
 * Ver descripción en {@link console_app.interfaces.trabajos.IProyectoRehabilitacion}.
 */
public class ProyectoRehabilitacion extends Proyecto implements IProyectoRehabilitacion
{

    public ProyectoRehabilitacion(int id) {
        super(id);
        configurar();
    }

    private void configurar() {
        setTipo(EntidadTipos.ProyectoRehabilitacion);
        campos = Campos.cargarCamposEntidad(this.getTipo(), campos);
    }

    @Override
    public IEdificacion getEdificacion() {
        return (IEdificacion) Entidad.buscarPorId(
            EntidadTipos.Edificacion,
            getCampo(CamposEnum.Edificacion).valorForanea()
        );
    }
}
