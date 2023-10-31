package console_app.tipos.trabajos;

import console_app.interfaces.entidades.Campos;
import console_app.interfaces.entidades.Campos.CamposEnum;
import console_app.interfaces.trabajos.IEdificacion;
import console_app.tipos.entidades.Entidad;
import console_app.tipos.entidades.EntidadTipos;

/**
 * Ver descripción en {@link console_app.interfaces.trabajos.IEdificacion}.
 */
public class Edificacion extends Entidad implements IEdificacion
{

    public Edificacion() {
        super();
        configurar();
    }

    public Edificacion(int id) {
        super(id);
        configurar();
    }

    private void configurar() {
        setTipo(EntidadTipos.Edificacion);
        campos = Campos.cargarCamposEntidad(this.getTipo(), campos);
    }

    @Override
    public String getDireccion() {
        return getCampo(CamposEnum.Direccion).valorCadena();
    }

    @Override
    public int getSupTerreno() {
        return getCampo(CamposEnum.SuperficieTerreno).valorNumerico();
    }

    @Override
    public int getSupEdificio() {
        return getCampo(CamposEnum.SuperFicieEdificio).valorNumerico();
    }

}
