package console_app.tipos.trabajos;

import java.util.List;

import console_app.interfaces.entidades.Campos;

import console_app.interfaces.entidades.IEntidad;
import console_app.interfaces.entidades.Campos.CamposEnum;
import console_app.interfaces.trabajos.IPresupuesto;
import console_app.interfaces.trabajos.IPresupuestoLinea;
import console_app.interfaces.trabajos.ITrabajo;
import console_app.tipos.entidades.Entidad;
import console_app.tipos.entidades.EntidadTipos;

/**
 * Ver descripción en {@link console_app.interfaces.trabajos.IPresupuesto}.
 */
public class Presupuesto extends Entidad implements IPresupuesto {

    public Presupuesto(int id) {
        super(id);
        configurar();
    }

    private void configurar() {

        setTipo(EntidadTipos.Presupuesto);
        campos = Campos.cargarCamposEntidad(getTipo(), campos);
    }

    @Override
    public List<IPresupuestoLinea> cargos() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean filtroForanea(IEntidad foraneo) {

        if (foraneo == null) return true;
        return getCampo(CamposEnum.Proyecto).valorCadena().equals("" + foraneo.getId());
    }

    @Override
    public void setValoresDefecto(String[] valores) {

        if (valores == null || valores.length < 1) return;
        getCampo(CamposEnum.Proyecto).setValor(valores[0]);
    }

    @Override
    public ITrabajo getTrabajo() {
        String idTrabajo = getCampo(CamposEnum.Proyecto).valorCadena();
        ITrabajo trabajo = (ITrabajo) Entidad.buscarPorId(idTrabajo);
        return trabajo;
    }

}