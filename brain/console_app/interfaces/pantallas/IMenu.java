package console_app.interfaces.pantallas;

import java.util.List;
import console_app.tipos.entidades.EntidadTipos;

/**
 * Definición mínima de menú.
 * 
 * Funcionalidad:
 * 
 * - a) Mostrar en Pantalla una serie de opciones
 * - b) Recoger la selección del usuario
 * 
 * Detalles:
 * 
 * Funciona como un bucle con tecla de escape.
 *
 * @author Jaime Sánchez
 * @version 1.0.0
 */

public interface IMenu
{
    IMenuOpcion menuOpcion();

    List<IOpcion> opciones();

    void mostrarOpciones();

    void mostrarOpciones(boolean enumerar);

    String pedirOpcion();

    void opcionNoEncontrada();

    void opcionNoValida();

    void limpiarPantalla();

    IOpcion buscarEntrada(String entrada);

    EntidadTipos getTipo();

    IPantalla getPantalla();

    
}
