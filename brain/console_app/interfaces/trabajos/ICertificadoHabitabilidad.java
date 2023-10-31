package console_app.interfaces.trabajos;

/**
 * Un ICertificadoHabitabilidad es un tipo especial de {@link console_app.interfaces.trabajos.ICertificado}
 * que se hace sobre {@link console_app.interfaces.trabajos.IEdificacionResidencial}
 * y caducan cada 15 años y hay que renovarlos.
 *
 * @author Jaime Sánchez
 * @version 1.0.0
 */
public interface ICertificadoHabitabilidad extends ICertificado,  ICertificadoCaducable
{
    IEdificacionResidencial getEdificacion();
}
