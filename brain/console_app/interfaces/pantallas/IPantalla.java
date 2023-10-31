package console_app.interfaces.pantallas;

import console_app.interfaces.entidades.IServicio;

/**
 * Interfaz para describir las operaciones con la Pantalla.
 * 
 * Se proveen métodos para escribir/leer/interaccionar.
 *
 * @author Jaime Sánchez
 * @version 1.0.0
 */
public interface IPantalla extends IServicio
{
    void limpiar() ;

    void titulo(String mensaje);

    void opcion(String opcion);

    String pedirOpcion(String mensaje);

    String pedirDato(String etiqueta, String valor, boolean sugerido);

    String volcar(String mensaje);

    String pausar();

    String esperar() ;

    String confirmar(String mensaje);

    String continuar();

    String info(String mensaje);

    String alerta(String mensaje);

    String error(String mensaje);

    String confirmacion(String mensaje);

    String eco(String plantilla, String mensaje);

    String leer();
}
