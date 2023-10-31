package console_app.pantallas.entidad;

import console_app.interfaces.personas.IEmpleado;
import console_app.pantallas.aplicacion.MenuFormulario;
import console_app.pantallas.aplicacion.MenuOpcionOperativa;
import console_app.pantallas.aplicacion.Pantalla;
import console_app.pantallas.sesion.MenuGestionEntidad;
import console_app.servicios.Io;
import console_app.tipos.entidades.Entidad;
import console_app.tipos.entidades.EntidadTipos;

/**
 * Permite seleccionar una {@link console_app.tipos.entidades.Entidad} por 
 * @{link console_app.tipos.entidades.EntidadTipos} y abrir {@link console_app.pantallas.sesion.MenuGestionEntidad}.
 *
 * @author Jaime Sánchez
 * @version 1.0.0
 */
public class FormEntidadForanea extends MenuFormulario
{
    public FormEntidadForanea(IEmpleado usuario, EntidadTipos tipo, EntidadTipos foraneaTipo)
    {
        super(usuario, tipo, foraneaTipo);

        titulo = String.format(Io.TITULO_GESTION, tipo);
    }

    public String pedirOpcion() {

        FormListarEntidad mnu = new FormListarEntidad(usuario, foraneaTipo);
        mnu.mostrarOpciones();

        opcion.entrada("mostrar-registros");

        while(!opcion.entrada().isEmpty())
        {
            mnu.pedirOpcion();

            Pantalla.titulo(titulo);

            opcion.entrada(Pantalla.pedirOpcion(Io.SELECCIONAR_ID));

            if (opcion.entrada().isEmpty()) {
                break;
            }

            foraneaEntidad = Entidad.buscarPorId(opcion.entrada());

            if (foraneaEntidad == null) {
                opcionNoValida();
                continue;
            }

            menuOpcion = new MenuOpcionOperativa(new MenuGestionEntidad(usuario, tipo, foraneaTipo, foraneaEntidad));
            menuOpcion.ejecutar();

            // Limpiar la entrada para que al volver no vuelva a mostrar
            opcion.entrada("");
        }
        return opcion.entrada();
    }
}
