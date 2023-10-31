package console_app.servicios.calendario;

import java.util.Comparator;
import java.util.Date;

import console_app.interfaces.trabajos.ICalendarioDia;
import console_app.tipos.entidades.Entidad;
import console_app.tipos.entidades.EntidadTipos;
import console_app.tipos.entidades.Fecha;

/**
 * Write a description of class Dia here.
 *
 * @author Jaime Sánchez
 * @version 1.0.0
 */
public class Dia extends Entidad implements ICalendarioDia, Comparable<Dia>
{
    private Date fecha;
    private Integer trabajoId;
    private Integer calendarioId;
    private Tipos tipoFecha;

    public Dia(int id) {
        super(id);
        configurar();
    }

    public Dia(int calendarioId, Date fecha, Integer trabajoId) {
        this.calendarioId = calendarioId;
        this.fecha = fecha;
        this.trabajoId = trabajoId;
        configurar();
    }

    public void setValor(Tipos tipoFecha, Date fecha, Integer trabajoId) {
        this.tipoFecha = tipoFecha;
        this.fecha = fecha;
        this.trabajoId = trabajoId;
    }

    private void configurar() {
        setTipo(EntidadTipos.Dia);
    }

    @Override
    public void setCalendarioId(int calendarioId) {
        this.calendarioId = calendarioId;
    }

    @Override
    public int getCalendarioId() {
        return this.calendarioId;
    }

    @Override
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    @Override
    public Date getFecha() {
        return this.fecha;
    }

    @Override
    public void setTrabajoId(int trabajoId) {
        this.trabajoId = trabajoId;
    }

    @Override
    public int getTrabajoId() {
        return trabajoId;
    }

    @Override
    public Date masDias(int dias) {
        return Fecha.masDias(fecha, dias);
    }

    @Override
    public boolean fechaEnRango(Date fechaMin, Date fechaMax) {
        return Fecha.fechaEnRango(fecha, fechaMin, fechaMax);
    }

    @Override
    public Tipos getTipoFecha() {
        return this.tipoFecha;
    }

    @Override
    public int compareTo(Dia arg0) {
        try {
            return fecha.compareTo(arg0.getFecha());
        } catch(Exception e) {
            return 1;
        }
    }

    public static Comparator<Dia> ordenarEstados =  new Comparator<Dia>() {
        public int compare(Dia s1, Dia s2) {
            return Integer.valueOf(s1.getTipoFecha().ordinal())
                .compareTo(Integer.valueOf(s2.getTipoFecha().ordinal()));
        }
    };

    @Override
    public String getFechaComoEtiqueta() {
        return Fecha.fechaComoCadena(getFecha());
    }

}
