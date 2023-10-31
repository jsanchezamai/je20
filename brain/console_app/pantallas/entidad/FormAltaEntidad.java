package console_app.pantallas.entidad;

import console_app.interfaces.entidades.IEntidad;
import console_app.interfaces.personas.IEmpleado;
import console_app.pantallas.aplicacion.MenuFormulario;
import console_app.servicios.Io;
import console_app.tipos.entidades.Entidad;
import console_app.tipos.entidades.EntidadTipos;

/**
 * Menú para agregar una {@link console_app.interfaces.entidades.IEntidad},
 * funciones:
 *  - Llamada a {@link FormEntidad} para editar los campos.
 *
 * @author Jaime Sánchez
 * @version 1.0.0 
 */
public class FormAltaEntidad extends MenuFormulario
{

    public FormAltaEntidad(IEmpleado usuario, EntidadTipos tipo, IEntidad foraneaEntidad) {

        super(usuario, tipo, foraneaEntidad);

        if (foraneaEntidad == null) {
            titulo = String.format(Io.TITULO_ALTA, tipo);
        } else {
            titulo = String.format(Io.TITULO_ALTA + Io.TITULO_GESTION_FORANEA, tipo,
                foraneaEntidad.getTipo(), foraneaEntidad.getId(), foraneaEntidad.name());
        }
    }

    public String pedirOpcion() {

        FormEntidad mnuEntidad = new FormEntidad(usuario, tipo);
        mnuEntidad.aceptarEntradaVacia = false;
        mnuEntidad.entidad = Entidad.porDefecto(tipo);
        mnuEntidad.iteradorOpciones = 0;
        if (foraneaEntidad != null) {
            mnuEntidad.entidad.setValoresDefecto(new String[]{"" + foraneaEntidad.getId()});
        }

        opcion.entrada(mnuEntidad.pedirOpcion());
        if (opcion.entrada().equals("save")) {
            if (mnuEntidad.entidad.agregar()) {
            }
        }

        return "";
    }


}
