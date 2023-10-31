package console_app.pantallas.entidad;

import console_app.interfaces.entidades.IEntidad;
import console_app.interfaces.personas.IEmpleado;
import console_app.pantallas.aplicacion.MenuFormulario;
import console_app.pantallas.aplicacion.Pantalla;
import console_app.servicios.Io;
import console_app.tipos.entidades.Entidad;
import console_app.tipos.entidades.EntidadTipos;

/**
 * Menú para la eliminación de una {@link console_app.interfaces.entidades.IEntidad},
 * funciones:
 *  - Listado de las entidades del {@link console_app.tipos.entidades.EntidadTipos} 
 *  existentes. Y ofrece seleccionar la que se va a editar.
 *  - Borrado del registro seleccionado.
 *
 * @author Jaime Sánchez
 * @version 1.0.0
 */
public class FormBorrarEntidad extends MenuFormulario 
{

    public FormBorrarEntidad(IEmpleado usuario, EntidadTipos tipo, IEntidad foraneaEntidad) {
        super(usuario, tipo, foraneaEntidad);

        if (foraneaEntidad == null) {
            titulo = String.format(Io.TITULO_BORRAR, tipo);
        } else {
            titulo = String.format(Io.TITULO_BORRAR + Io.TITULO_GESTION_FORANEA, tipo,
                foraneaEntidad.getTipo(), foraneaEntidad.getId(), foraneaEntidad.name());
        }
    }

    public String pedirOpcion() {

        FormListarEntidad mnu = new FormListarEntidad(usuario, tipo, foraneaEntidad);

        opcion.entrada("mostrar-registros");

        while(!opcion.entrada().isEmpty())
        {
            mnu.pedirOpcion();

            Pantalla.titulo(titulo);

            opcion.entrada(Pantalla.pedirOpcion(Io.SELECCIONAR_ID));

            if (opcion.entrada().isEmpty()) {
                break;
            }

            mnu.entidad = Entidad.buscarPorId(opcion.entrada());

            if (mnu.entidad == null) {
                opcionNoValida();
                continue;
            }

            if (mnu.entidad.borrar()) {

            }
            opcion.entrada("siguiente");
        }
        return opcion.entrada();

    }

}
