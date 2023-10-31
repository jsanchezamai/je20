package console_app.interfaces.personas;

import console_app.interfaces.entidades.IEntidad;
import worlds.objects.IWorldAgent;

/**
 * En la aplicación que se desea desarrollar, es necesario almacenar dos tipos 
 * distintos de persona, para diferenciar si se trata de un {@link console_app.tipos.personas.Cliente} del estudio,
 * o de un {@link console_app.tipos.personas.Empleado} del mismo.
 * <p>
 * Dentro de los {@link console_app.tipos.personas.Empleado}, encontramos cuatro subtipos: 
 * <li>el {@link console_app.interfaces.personas.IAdministrador} del sistema, 
 * <li>los {@link console_app.interfaces.personas.IArquitecto} que realizan los {@link console_app.interfaces.trabajos.IProyecto} y {@link console_app.interfaces.trabajos.ICertificado}, 
 * <li>los {@link console_app.interfaces.personas.IAparejador} que llevan el día a día de una construcción, 
 * <li>y los {@link console_app.interfaces.personas.IContable} que llevan la economía del estudio.
 * 
 * @author Jaime Sánchez 
 * @version 1.0.0
 */

public interface IPersona extends IEntidad
{
    IWorldAgent worldAgent();
    void worldAgent(IWorldAgent wa);
}
