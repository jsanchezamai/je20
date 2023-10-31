package console_app.tipos.trabajos;

import java.util.Comparator;
import java.util.Date;
import console_app.interfaces.entidades.Campos;
import console_app.interfaces.entidades.Campos.CamposEnum;
import console_app.interfaces.trabajos.IPresupuesto;
import console_app.interfaces.trabajos.IProyecto;
import console_app.interfaces.trabajos.ICalendarioDia.Tipos;
import console_app.servicios.calendario.Empresa;
import console_app.tipos.entidades.Entidad;
import console_app.tipos.entidades.EntidadTipos;
import console_app.tipos.entidades.Fecha;

/**
 * Ver descripción en {@link console_app.interfaces.trabajos.IProyecto}.
 */
public class Proyecto extends Trabajo implements IProyecto {

    public Proyecto(int id) {
        super(id);
        setTipo(EntidadTipos.Proyecto);
        configurar();
    }

    private void configurar() {
        campos = Campos.cargarCamposEntidad(this.getTipo(), campos);
    }

    @Override
    public int getDiasEstimados() {
        return getCampo(CamposEnum.Duracion).valorNumerico();
    }

    @Override
    public Date getInicio() {
        return Empresa.get().getFecha(Tipos.Inicio, id);
    }

    @Override
    public Date getPrevisto() {
        return Fecha.masDias(getInicio(), getDiasEstimados() + 1);
    }

    @Override
    public Date getFin() {
        return Empresa.get().getFecha(Tipos.Fin, id);
    }

    @Override
    public IPresupuesto getPresupuesto() {
        return (IPresupuesto) Entidad.buscarPorId(EntidadTipos.Presupuesto, "" + getId());
    }

    @Override
    public Estados getEstado() {

        if (getFin() != null)
            return Estados.Finalizado;

        if (getInicio() != null)
            return Estados.Iniciado;

        if (getEntrega() != null)
            return Estados.Entregado;

        return Estados.Solicitado;
    }

    @Override
    public Date getFechaEstado() {

        if (getFin() != null)
            return getFin();

        if (getInicio() != null)
            return getInicio();

        if (getEntrega() != null)
            return getEntrega();

        return getSolicitud();
    }

    public static Comparator<Proyecto> ordenarFechaInicio =  new Comparator<Proyecto>() {
        public int compare(Proyecto s1, Proyecto s2) {
            return s1.getInicio().compareTo(s2.getInicio());
        }
    };

    public static Comparator<Proyecto> ordenarFechaFin =  new Comparator<Proyecto>() {
        public int compare(Proyecto s1, Proyecto s2) {
            return s1.getFin().compareTo(s2.getFin());
        }
    };

}
