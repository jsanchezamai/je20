package console_app.interfaces.trabajos;

/**
 *  Los proyectos residenciales que engloban edificios y viviendas unifamiliares,
 * es decir, se hace sobre {@link console_app.interfaces.trabajos.IEdificacionResidencial}.
 *
 * @author Jaime Sánchez
 * @version 1.0.0
 */

public interface IProyectoResidencial extends IProyecto
{
    IEdificacionResidencial getEdificacion();
}
