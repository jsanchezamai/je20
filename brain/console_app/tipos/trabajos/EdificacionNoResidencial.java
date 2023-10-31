package console_app.tipos.trabajos;

import console_app.interfaces.entidades.Campos;
import console_app.interfaces.entidades.Campos.CamposEnum;
import console_app.interfaces.trabajos.IEdificacionNoResidencial;
import console_app.tipos.entidades.EntidadTipos;

/**
 * Ver descripción en {@link console_app.interfaces.trabajos.IEdificacionNoResidencial}.
 */
public class EdificacionNoResidencial extends Edificacion implements IEdificacionNoResidencial
{

    public EdificacionNoResidencial(int id) {
        super(id);
        setTipo(EntidadTipos.EdificacionNoResidencial);
        configurar();
    }

    private void configurar() {
        campos = Campos.cargarCamposEntidad(this.getTipo(), campos);
    }

    @Override
    public String getFinalidad() {
        return getCampo(CamposEnum.Finalidad).valorCadena();
    }

}
