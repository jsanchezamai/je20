package console_app.pantallas.sesion;

import console_app.interfaces.entidades.IEntidad;
import console_app.interfaces.personas.IEmpleado;
import console_app.pantallas.aplicacion.MenuFormulario;
import console_app.pantallas.aplicacion.MenuOpcionOperativa;
import console_app.pantallas.aplicacion.Pantalla;
import console_app.pantallas.entidad.FormAltaEntidad;
import console_app.pantallas.entidad.FormBorrarEntidad;
import console_app.pantallas.entidad.FormEditarEntidad;
import console_app.pantallas.entidad.FormListarEntidad;
import console_app.servicios.Io;
import console_app.tipos.entidades.EntidadTipos;
import console_app.tipos.entidades.Opcion;

/**
 * Gestión de usuarios de los {@link console_app.interfaces.personas.IEntidad}. 
 *
 * - altas {@link console_app.pantallas.entidad.FormAltaEntidad}, 
 * - bajas {@link console_app.pantallas.entidad.FormBajaEntidad}, 
 * - modificaciones {@link console_app.pantallas.entidad.FormEditarEntidad},
 * - listado {@link console_app.pantallas.entidad.FormListarEntidad}
 * 
 * @author Jaime Sánchez 
 * @version 1.0.0
 */
public class MenuGestionEntidad extends MenuFormulario
{

    /**
     * Constructor for objects of class MenuInicial
     */
    public MenuGestionEntidad(IEmpleado usuario, EntidadTipos tipo, EntidadTipos foraneaTipo, IEntidad entidadForanea)
    {
        super(usuario, tipo, foraneaTipo, entidadForanea);

        titulo = String.format(Io.TITULO_GESTION + Io.TITULO_GESTION_FORANEA, tipo,
            entidadForanea.getTipo(), entidadForanea.getId(), entidadForanea.name());
        configurar();
    }

    /**
     * Constructor for objects of class MenuInicial
     */
    public MenuGestionEntidad(IEmpleado usuario, EntidadTipos tipo)
    {
        super(usuario, tipo);
        titulo = String.format(Io.TITULO_GESTION, tipo);
        configurar();

    }

    private void configurar() {

        opciones.add(new Opcion(Io.LISTAR, "1"));
        opciones.add(new Opcion(Io.ALTA, "2"));
        opciones.add(new Opcion(Io.EDITAR, "3"));
        opciones.add(new Opcion(Io.BORRAR, "4"));
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

        switch(opcion.entrada()) {
            case "1":
                menuOpcion = new MenuOpcionOperativa(new FormListarEntidad(usuario, tipo, foraneaEntidad));
                menuOpcion.ejecutar();
                Pantalla.continuar();
                return "cerrar";
            case "2":
                menuOpcion = new MenuOpcionOperativa(new FormAltaEntidad(usuario, tipo, foraneaEntidad));
                break;
            case "3":
                menuOpcion = new MenuOpcionOperativa(new FormEditarEntidad(usuario, tipo, foraneaEntidad));
                break;
            case "4":
                menuOpcion = new MenuOpcionOperativa(new FormBorrarEntidad(usuario, tipo, foraneaEntidad));
                break;
            case "":
                return "";
            default:
                opcionNoEncontrada();
                return "seguir";
        }
        menuOpcion.ejecutar();
        return opcion.entrada();
     }

}
