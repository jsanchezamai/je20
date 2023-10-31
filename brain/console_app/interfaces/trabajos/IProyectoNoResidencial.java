package console_app.interfaces.trabajos;

/**
 * Los proyectos no residenciales como naves industriales, museos,
 * o cualquier otra construcción no residencial, es decir,
 * se hace sobre {@link console_app.interfaces.trabajos.IEdificacionNoResidencial}.
 *
 * @author Jaime Sánchez
 * @version 1.0.0
 */

public interface IProyectoNoResidencial extends IProyecto
{
    public IEdificacionNoResidencial getEdificacion();
}
