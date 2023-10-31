package console_app.interfaces.trabajos;

import java.util.Date;

/**
 * Un calendario es una lista de {@link console_app.interfaces.trabajos.ICalendarioDia}.
 *
 * Ejecución de obras: Una vez el cliente ha obtenido el proyecto y decide que el
 * propio estudio desarrolle la obra, el administrador gestionará el calendario teniend
 * en cuenta que el estudio no puede tener más de tres obras en marcha al mismo tiempo.
 * Para ello el administrador consultará la duración prevista de la obra que consta en
 * el proyecto y asignará la fecha de inicio de la obra. Cuando la obra haya finalizado,
 * también actualizará la fecha de fin de obra.

 * @author Jaime Sánchez
 * @version 1.0.0
 */
public interface ICalendario
{
    boolean fechaPermitida(ICalendarioDia dia);

    Date disponibilidad(IProyecto trabajo);

    int getId();
}
