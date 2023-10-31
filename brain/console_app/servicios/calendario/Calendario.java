package console_app.servicios.calendario;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import console_app.interfaces.entidades.IEntidad;
import console_app.interfaces.trabajos.ICalendario;
import console_app.interfaces.trabajos.ICalendarioDia;
import console_app.interfaces.trabajos.IProyecto;
import console_app.interfaces.trabajos.ITrabajo;
import console_app.interfaces.trabajos.ICalendarioDia.Tipos;
import console_app.tipos.entidades.Entidad;
import console_app.tipos.entidades.EntidadTipos;
import console_app.tipos.entidades.Fecha;
import console_app.tipos.entidades.Filtro;
import console_app.tipos.trabajos.Proyecto;

/**
 *
 * @author Jaime Sánchez
 * @version 1.0.0
 */
public class Calendario implements ICalendario
{
    private int id;

    Calendario(int id) {
        this.id = id;
    }

    /**
     * Busca todos los proyectos cuyas fechas entren en
    * conflicto
    */
    @Override
    public boolean fechaPermitida(ICalendarioDia dia) {

        Filtro filtro = new Filtro((entidad) -> {

            Proyecto trabajo = (Proyecto) entidad;

            if (dia.getCalendarioId() != id) return false;

            if ((trabajo.getEstado() == ITrabajo.Estados.Solicitado) ||
                (trabajo.getEstado() == ITrabajo.Estados.Entregado)) {
                return false;
            }

            ICalendarioDia diaTrabajo = Empresa.get().getDia(Tipos.Inicio, trabajo.getId());
            boolean perteneceAlCalendario = diaTrabajo == null ? false : diaTrabajo.getCalendarioId() == id;

            if (!perteneceAlCalendario) return false;

            if (trabajo.getEstado() == ITrabajo.Estados.Iniciado) {
                return dia.fechaEnRango(trabajo.getInicio(), trabajo.getPrevisto());
            }

            if (trabajo.getEstado() == ITrabajo.Estados.Finalizado) {
                return !dia.fechaEnRango(trabajo.getInicio(), trabajo.getFin());
            }

            return true;
        });
        List<IEntidad> trabajosEnConflicto = Entidad.buscar(EntidadTipos.Proyecto, filtro);
        return trabajosEnConflicto.size() == 0;

    }

    @Override
    public Date disponibilidad(IProyecto trabajo) {

        // Lista de todos los trabajos en curso
        // y cuya fecha de inicio pertenezca a este calendario
        Filtro filtro = new Filtro((entidad) -> {
            Proyecto t = (Proyecto) entidad;
            ICalendarioDia dia = Empresa.get().getDia(Tipos.Inicio, t.getId());
            boolean perteneceAlCalendario = dia == null ? false : dia.getCalendarioId() == id;
            return t.getEstado() == ITrabajo.Estados.Iniciado && perteneceAlCalendario;
        });

        // Ordenados por fecha de inicio
        List<Proyecto> trabajosEnCurso = Entidad
            .buscar(EntidadTipos.Proyecto, filtro)
            .stream()
            .map(entidad -> (Proyecto) entidad)
            .sorted(Proyecto.ordenarFechaInicio)
            .collect(Collectors.toList());

        // Creamos una marca con la fecha actual
        Dia mInicio = new Dia(id, new Date(), null);

        // Para cada trabajo programado
        for(Proyecto t: trabajosEnCurso) {

            // A partir de la marca de inicio, obtenemos su marca final
            Date mFinal = Fecha.masDias(mInicio.getFecha(), trabajo.getDiasEstimados());

            // Comprobamos si hay conflicto
            boolean conflicto = Fecha.fechaEnRango(mFinal, t.getInicio(), t.getPrevisto());

            // Si hay conflicto avanzamos la marca de inicio a la fecha prevista del proyecto
            if (conflicto) {
                mInicio.setFecha(t.getPrevisto());
            } else {
                return mInicio.getFecha();
            }
        }
        return mInicio.getFecha();
    }

    @Override
    public int getId() {
        return id;
    }

}
