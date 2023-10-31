package console_app.interfaces.trabajos;
import java.util.Date;
import java.util.List;

import console_app.interfaces.entidades.IServicio;
import console_app.interfaces.trabajos.ICalendarioDia.Tipos;

/**
 * Una IEmpresa gestiona n ICalendario. En el caso concreto, la empresa puede llevar hasta 3 proyectos
 * simultáneos para lo que usará 3 ICalendario.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

public interface IEmpresa extends IServicio
{
        List<ICalendario> getCapacidad();

        List<Date> disponibilidad(IProyecto trabajo);

        ICalendarioDia getDia(Tipos tipoFecha, Integer trabajoId);

        Date getFecha(Tipos tipo, Integer trabajoId);

        /**
         * Crear una fecha de solicitud para el trabajo
         * registrándola con la fecha actual.
         *
         * @param trabajoId
         */
        void agregarSolicitud(Integer trabajoId);
}
