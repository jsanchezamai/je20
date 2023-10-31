package console_app.pantallas.sesion;

import console_app.interfaces.pantallas.IOpcion;
import console_app.interfaces.personas.IEmpleado;
import console_app.pantallas.aplicacion.MenuFormulario;
import console_app.pantallas.aplicacion.MenuOpcionOperativa;
import console_app.pantallas.aplicacion.Pantalla;
import console_app.pantallas.entidad.FormListarEntidad;
import console_app.servicios.Io;
import console_app.tipos.entidades.EntidadTipos;
import console_app.tipos.entidades.Opcion;

/**
 * Formulario que lista en pantalla un conjunto de {@link console_app.interfaces.personas.IPersona}
 *
 * @author Jaime Sánchez 
 * @version 1.0.0
 */
public class MenuListarPersonas extends MenuFormulario
{
    public MenuListarPersonas(IEmpleado usuario, EntidadTipos tipo)
    {
        super(usuario, tipo);

        titulo = String.format(Io.TITULO_VISUALIZACION, tipo);

        opciones.add(new Opcion(Io.TITULO_ADMINISTRADOR, "1", EntidadTipos.Administrador));
        opciones.add(new Opcion(Io.TITULO_ARQUITECTO, "2", EntidadTipos.Arquitecto));
        opciones.add(new Opcion(Io.TITULO_APAREJADOR, "3", EntidadTipos.Aparejador));
        opciones.add(new Opcion(Io.TITULO_CONTABLE, "4", EntidadTipos.Contable));
        opciones.add(new Opcion(Io.TITULO_CLIENTE, "5", EntidadTipos.Cliente));
    }

    /**
     * Imprime la lista de acciones disponibles para el usuario
     */
    void mostrarOpcion() {
        super.mostrarOpciones();
        Pantalla.volcar(String.format(Io.TITULO_OPERACIONES_DISPONIBLES, tipo));
    }

    public String pedirOpcion() {

        opcion.entrada(super.pedirOpcion());

        if (opcion.entrada().isEmpty()) {
            return "";
        }

        IOpcion opcionO = buscarEntrada(opcion.entrada());

        if(opcionO == null) {
            opcionNoEncontrada();
            return "seguir";
        } else {
            menuOpcion = new MenuOpcionOperativa(
                new FormListarEntidad(usuario, opcionO.llaveTipo())
            );
            menuOpcion.ejecutar();
            Pantalla.continuar();
            return "cerrar";
        }
    }

}
