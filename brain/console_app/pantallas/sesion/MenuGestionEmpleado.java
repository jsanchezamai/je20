package console_app.pantallas.sesion;

import console_app.interfaces.personas.IEmpleado;
import console_app.pantallas.aplicacion.MenuOpcionOperativa;
import console_app.pantallas.aplicacion.MenuOperativa;
import console_app.servicios.Io;
import console_app.tipos.entidades.EntidadTipos;
import console_app.tipos.entidades.Opcion;

/**
 * Gestión de usuarios de los {@link console_app.interfaces.personas.IEmpleado}. 
 *
 * - altas {@link console_app.pantallas.entidad.FormAltaEntidad}, 
 * - bajas {@link console_app.pantallas.entidad.FormBajaEntidad}, 
 * - modificaciones {@link console_app.pantallas.entidad.FormEditarEntidad},
 * - listado {@link console_app.pantallas.entidad.FormListarEntidad}
 * 
 * @author Jaime Sánchez 
 * @version 1.0.0
 */
public class MenuGestionEmpleado extends MenuOperativa
{
    /**
     * Constructor for objects of class MenuInicial
     */
    public MenuGestionEmpleado(IEmpleado usuario)
    {
        super(usuario);

        titulo = String.format(Io.TITULO_GESTION, Io.TITULO_PERSONA);

        opciones.add(new Opcion(Io.OPCION_GESTION_ADMINISTRADOR, "1"));
        opciones.add(new Opcion(Io.OPCION_GESTION_ARQUITECTO, "2"));
        opciones.add(new Opcion(Io.OPCION_GESTION_APAREJADOR, "3"));
        opciones.add(new Opcion(Io.OPCION_GESTION_CONTABLE, "4"));
        opciones.add(new Opcion(Io.OPCION_GESTION_CLIENTES, "5"));
    }

    public String pedirOpcion() {

        opcion.entrada(super.pedirOpcion());

        EntidadTipos tipo;
        switch(opcion.entrada()) {
            case "1":
                tipo = EntidadTipos.Administrador;
                break;
            case "2":
                tipo = EntidadTipos.Arquitecto;
                break;
            case "3":
                tipo = EntidadTipos.Aparejador;
                break;
            case "4":
                tipo = EntidadTipos.Contable;
                break;
            case "5":
                tipo = EntidadTipos.Cliente;
                break;
            case "":
                return "";
            default:
                opcionNoEncontrada();
                return pedirOpcion();
        }
        menuOpcion = new MenuOpcionOperativa(new MenuGestionEntidad(usuario, tipo));
        menuOpcion.ejecutar();
        return opcion.entrada();
    }

}
