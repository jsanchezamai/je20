package console_app.pantallas.entidad;

import console_app.interfaces.entidades.IEntidad;
import console_app.interfaces.personas.IEmpleado;
import console_app.pantallas.aplicacion.MenuFormulario;
import console_app.pantallas.aplicacion.Pantalla;
import console_app.servicios.Io;
import console_app.tipos.entidades.Entidad;
import console_app.tipos.entidades.EntidadTipos;

/**
 * Menú para la edición de una {@link console_app.interfaces.entidades.IEntidad},
 * funciones:
 *  - Listado de las entidades del {@link console_app.tipos.entidades.EntidadTipos} 
 *  existentes. Y ofrece seleccionar la que se va a editar.
 *  - Llamada a {@link FormEntidad} para editar los campos.
 *
 * @author Jaime Sánchez
 * @version 1.0.0
 */
public class FormEditarEntidad extends MenuFormulario
{
    public FormEditarEntidad(IEmpleado usuario, EntidadTipos tipo, IEntidad foraneaEntidad) {
        super(usuario, tipo, foraneaEntidad);

        if (foraneaEntidad == null) {
            titulo = String.format(Io.TITULO_EDITAR, tipo);
        } else {
            titulo = String.format(Io.TITULO_EDITAR + Io.TITULO_GESTION_FORANEA, tipo,
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

            FormEntidad mnuForm = new FormEntidad(usuario, tipo);
            mnuForm.aceptarEntradaVacia = true;

            mnuForm.entidad = Entidad.buscarPorId(opcion.entrada());
            if (mnuForm.entidad == null) {
                opcionNoValida();
                continue;
            }

            opcion.entrada(mnuForm.pedirOpcion());

            if (opcion.entrada().equals("save")) {
                if (mnuForm.entidad.editar()) {

                }
            }

            opcion.entrada("siguiente");
        }

        return opcion.entrada();
    }
}
