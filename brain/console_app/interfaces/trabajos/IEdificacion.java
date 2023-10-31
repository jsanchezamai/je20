package console_app.interfaces.trabajos;

import console_app.interfaces.entidades.IEntidad;

/**
 * Base de herencia para las edificaciones.
 * <p>
 * Cada {@link console_app.interfaces.trabajos.IProyecto} arquitectónico tiene que registrar cierta 
 * información asociada al edificio.
 * <p>
 * 
 * Consultar la información específica a almacenar para
 *   {@link console_app.interfaces.trabajos.IEdificacionResidencial},
 *      {@link console_app.interfaces.trabajos.IEdificacionNoResidencial}.
 * 
 * En general, para los {@link console_app.interfaces.trabajos.IProyectoRehabilitacion} habrá que 
 * registrar la {@link console_app.servicios.Io.CAMPO_DIRECCION} y 
 * la {@link console_app.servicios.Io.CAMPO_SUPERFICIE_EDIFICIO}.
 * 
 * @author Jaime Sánchez 
 * @version 1.0.0
 */

public interface IEdificacion extends IEntidad
{
    String getDireccion();
    int getSupTerreno();
    int getSupEdificio();
}
