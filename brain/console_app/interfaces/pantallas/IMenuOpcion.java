package console_app.interfaces.pantallas;

/**
 * Desencadenante que se ejecuta cuando un usuario activa
 * una opción de IMenu. 
 * 
 * Generalmente, carga otro menú o formulario y lo encadena en la secuencia
 * de navegación.
 *
 * @author Jaime Sánchez
 * @version 1.0.0
 */
public interface IMenuOpcion
{
    boolean ejecutar();
}
