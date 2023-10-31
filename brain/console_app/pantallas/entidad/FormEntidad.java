package console_app.pantallas.entidad;

import console_app.interfaces.entidades.ICampo;
import console_app.interfaces.entidades.IEntidad;
import console_app.interfaces.personas.IEmpleado;
import console_app.pantallas.aplicacion.MenuFormulario;
import console_app.pantallas.aplicacion.Pantalla;
import console_app.servicios.Io;
import console_app.tipos.entidades.EntidadTipos;

/**
 * Gestión CRUD:
 * <li>altas {@link console_app.pantallas.entidad.FormAltaEntidad}, 
 * <li>bajas {@link console_app.pantallas.entidad.FormBajaEntidad}, 
 * <li>modificaciones {@link console_app.pantallas.entidad.FormEditarEntidad},
 * <li>listado {@link console_app.pantallas.entidad.FormListarEntidad}
 * de las {@link console_app.interfaces.entidades.IEntidad} 
 * que figuran en el sistema.
 *
 * El menú que llama debe comprobar si {@link #opciones.entrada() == "save"}
 * para registar con persistencia el cambio.
 * 
 * @author Jaime Sánchez
 * @version 1.0.0
 */
public class FormEntidad extends MenuFormulario
{
    IEntidad entidad;
    /**
     * Constructor for objects of class MenuInicial
     */
    public FormEntidad(IEmpleado usuario, EntidadTipos tipo)
    {
        super(usuario, tipo);

        titulo = Io.TITULO_ACTUALIZAR_DATOS;

    }

    /**
     * Controla la entrada de teclado en el formulario
     *
     * @returns "save" Si la entidad ha superado el formulario y puede ser grabada. Empty si cancelar.
     */
     public String pedirOpcion() {

        if (entidad == null) {
            Pantalla.error(Io.ERROR_FALTA_ENTIDAD);
            return "";
        }

        if (entidad.camposComoOpciones().size() == 0) {
            return "no hay opciones";
        }

        if (iteradorOpciones >= entidad.camposComoOpciones().size()) {
            return "save";
        }

        ICampo c = entidad.campoNext(iteradorOpciones);

        if (!c.puedeEditar(usuario)) {
            iteradorOpciones++;
            return pedirOpcion();
        };

        String etiqueta = c.etiqueta();
        String valorActual = c.valorComoEtiqueta();

        boolean sugerido =  aceptarEntradaVacia || (valorActual != null && (!valorActual.isEmpty()));
        opcion.entrada(
            Pantalla.pedirDato(etiqueta, valorActual, sugerido)
        );

        if (opcion.entrada().isEmpty() && sugerido) {
            // Pass
        } else
        {
            if (c.setValor(opcion.entrada())) {
                // Pass
            } else {
                pedirOpcion();
            }
        }

        iteradorOpciones++;

        return pedirOpcion();

    }
}
