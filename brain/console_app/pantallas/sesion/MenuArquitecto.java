package console_app.pantallas.sesion;

import console_app.interfaces.personas.IEmpleado;
import console_app.pantallas.aplicacion.MenuOpcionOperativa;
import console_app.pantallas.aplicacion.MenuOpcionPlanificacion;
import console_app.pantallas.aplicacion.MenuSesion;
import console_app.pantallas.aplicacion.Pantalla;

import console_app.servicios.Io;
import console_app.tipos.entidades.EntidadTipos;
import console_app.tipos.entidades.Opcion;

/**
 * Menú con todas las opciones del {@link console_app.interfaces.personas.IEmpleado} de tipo 
 * {@link console_app.interfaces.personas.IArquitecto}.
 * 
 * @author Jaime Sánchez
 * @version 1.0.0
 */
public class MenuArquitecto extends MenuSesion
{

    public MenuArquitecto(IEmpleado usuario)
    {
        super(usuario);

        titulo = Io.TITULO_ARQUITECTO;

        opciones.add(new Opcion(Io.OPCION_GESTION_TRABAJOS, "1"));
        opciones.add(new Opcion(Io.OPCION_VISUALIZACION_CLIENTES, "2"));
        opciones.add(new Opcion(Io.OPCION_PLANIFICACION_ENTREGAS, "3"));
        opciones.add(new Opcion(Io.OPCION_PLANIFICACION_CERTIFICACION, "4"));
    }

    public String pedirOpcion() {
         opcion.entrada(super.pedirOpcion());
         switch(opcion.entrada()) {
            case "1":
                menuOpcion = new MenuOpcionOperativa(new MenuGestionTrabajos(usuario));
                menuOpcion.ejecutar();
                break;
            case "2":
                menuOpcion = new MenuOpcionOperativa(new FormListarClientesPorEmpleado(usuario));
                menuOpcion.ejecutar();
                Pantalla.continuar();
                break;
            case "3":
                menuOpcion = new MenuOpcionPlanificacion(new MenuAccesoCalendario(usuario, EntidadTipos.Proyecto));
                menuOpcion.ejecutar();
                break;
            case "4":
                menuOpcion = new MenuOpcionPlanificacion(new MenuAccesoCalendario(usuario, EntidadTipos.Certificado));
                menuOpcion.ejecutar();
                break;
            case "":
                return "";
            default:
                opcionNoEncontrada();
         }
         return opcion.entrada();
     }

}
