package console_app.interfaces.trabajos;

/**
 * En el caso de proyectos no residenciales, será necesario
 * registrar la {@link console_app.servicios.Io#CAMPO_DIRECCION}, 
 * {@link console_app.servicios.Io#CAMPO_SUPERFICIE_TERRENO}, {@link console_app.servicios.Io#CAMPO_SUPERFICIE_EDIFICIO} 
 * y {@link console_app.servicios#Io.CAMPO_FINALIDAD}.
 *
 * @author Jaime Sánchez
 * @version 1.0.0
 */

public interface IEdificacionNoResidencial extends IEdificacion
{
    String getFinalidad();
}
