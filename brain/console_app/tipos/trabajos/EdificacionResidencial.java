package console_app.tipos.trabajos;

import console_app.interfaces.entidades.Campos;
import console_app.interfaces.entidades.Campos.CamposEnum;
import console_app.interfaces.trabajos.IEdificacionResidencial;
import console_app.tipos.entidades.EntidadTipos;

/**
 * Ver descripción en {@link console_app.interfaces.trabajos.IEdificacionResidencial}.
 */
public class EdificacionResidencial extends Edificacion implements IEdificacionResidencial
{

    public EdificacionResidencial(int id) {
        super(id);
        setTipo(EntidadTipos.EdificacionResidencial);
        configurar();
    }

    private void configurar() {
        campos = Campos.cargarCamposEntidad(this.getTipo(), campos);
    }

    @Override
    public int getPlantas() {
        return getCampo(CamposEnum.Plantas).valorNumerico();
    }

    @Override
    public int getHabitaciones() {
        return getCampo(CamposEnum.Habitaciones).valorNumerico();
    }

    @Override
    public int getLavabos() {
        return getCampo(CamposEnum.Lavabos).valorNumerico();
    }

}
