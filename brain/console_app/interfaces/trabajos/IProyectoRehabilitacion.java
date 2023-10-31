package console_app.interfaces.trabajos;

/**
 * Los proyectos de rehabilitación que consiste en reformar una construcción
 * ya finalizada previamente.
 *
 * @author Jaime Sánchez
 * @version 1.0.0
 */

public interface IProyectoRehabilitacion extends IProyecto
{

    IEdificacion getEdificacion();

}
