package console_app.interfaces.pantallas;

import console_app.tipos.entidades.EntidadTipos;

/**
 * Representa una opción de IMenu con las siguientes propiedades:
 * 
 * - Es unívoco. Mediante llave() obtenemos su identificador.
 * - Es listable por pantalla. El texto de usuario lo proporciona etiqueta().
 * - Es seleccionable. Mediante entrada() obtenemos la pulsación del usuario.
 *
 * @author Jaime Sánchez
 * @version 1.0.0
 */
public interface IOpcion
{
    // Linea que se muestra en el pantalla para ofrecer la opcion
    String etiqueta();

    // Valor ofrecido al usuario para ejecutar la opcion
    String llave();

    // Valor interno asociada a la opción
    EntidadTipos llaveTipo();

    // Valor introducido por el usuario
    String entrada();

    void entrada(String argumentos);

    void etiqueta(String string);

    boolean seleccionable();
}
