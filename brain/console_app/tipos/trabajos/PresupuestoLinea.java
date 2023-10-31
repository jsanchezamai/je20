package console_app.tipos.trabajos;

import console_app.interfaces.entidades.Campos;
import console_app.interfaces.entidades.Campos.CamposEnum;
import console_app.interfaces.trabajos.IPresupuesto;
import console_app.interfaces.trabajos.IPresupuestoLinea;
import console_app.tipos.entidades.Entidad;
import console_app.tipos.entidades.EntidadTipos;

/**
 * Ver descripción en {@link console_app.interfaces.trabajos.IPresupuestoLinea}.
 */
public class PresupuestoLinea extends Entidad implements IPresupuestoLinea {

    public PresupuestoLinea(int id) {
        super(id);
        configurar();
    }

    private void configurar() {

        setTipo(EntidadTipos.PresupuestoLinea);
        campos = Campos.cargarCamposEntidad(getTipo(), campos);
    }

    public IPresupuesto getPresupuesto() {
        String idTrabajo = getCampo(CamposEnum.Presupuesto).valorCadena();
        IPresupuesto presupuesto = (IPresupuesto) Entidad.buscarPorId(idTrabajo);
        Presupuesto entidad = (Presupuesto) presupuesto;
        return entidad;
    }

    @Override
    public void setValoresDefecto(String[] valores) {

        if (valores == null || valores.length < 1) return;
        getCampo(CamposEnum.Presupuesto).setValor(valores[0]);
    }

}