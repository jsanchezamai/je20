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
 * {@link console_app.interfaces.personas.IAdministrador}.
 *
 * @author Jaime Sánchez
 * @version 1.0.0
 */
public class MenuAdministrador extends MenuSesion
{
    /**
     * Constructor for objects of class MenuInicial
     */
    public MenuAdministrador(IEmpleado usuario)
    {
        super(usuario);

        titulo = Io.TITULO_ADMINISTRADOR;

        opciones.add(new Opcion(Io.OPCION_GESTION_PERSONAS, "1"));
        opciones.add(new Opcion(Io.OPCION_ASIGNACION_PERSONAS, "2"));
        opciones.add(new Opcion(Io.OPCION_VISUALIZACION_PERSONAS, "3"));
        opciones.add(new Opcion(String.format(Io.TITULO_LISTAR_CLIENTES_POR_EMPLEADO, Io.TITULO_EMPLEADO), "4"));
        opciones.add(new Opcion(Io.TITULO_LISTAR_VIVIENDAS_FIN_OBRA, "5"));
        opciones.add(new Opcion(Io.TITULO_LISTAR_VIVIENDAS_HABITABILIDAD, "6"));
        opciones.add(new Opcion(Io.TITULO_LISTAR_VIVIENDAS_TRABAJO, "7"));
        opciones.add(new Opcion(Io.OPCION_PLANIFICACION, "8"));
        opciones.add(new Opcion(Io.TITULO_LISTAR_PLANIFICACION_OBRAS, "9"));
        opciones.add(new Opcion(Io.OPCION_LISTAR_CLIENTES_EDIFICACION_CERTIFICADO_HABITABILIDAD, "10"));
        opciones.add(new Opcion(Io.OPCION_LISTAR_CLIENTES_EDIFICACION_CERTIFICADO_INSPECCION, "11"));

    }

    public String pedirOpcion() {

         opcion.entrada(super.pedirOpcion());
         switch(opcion.entrada()) {
            case "1":
                menuOpcion = new MenuOpcionOperativa(new MenuGestionEmpleado(usuario));
                menuOpcion.ejecutar();
                break;
            case "2":
                menuOpcion = new MenuOpcionOperativa(new MenuGestionTrabajos(usuario));
                menuOpcion.ejecutar();
                break;
            case "3":
                menuOpcion = new MenuOpcionOperativa(new MenuListarPersonas(usuario, EntidadTipos.Persona));
                menuOpcion.ejecutar();
                break;
            case "4":
                menuOpcion = new MenuOpcionOperativa(new FormListarClientesPorEmpleado(usuario));
                menuOpcion.ejecutar();
                Pantalla.continuar();
                break;
            case "5":
                menuOpcion = new MenuOpcionOperativa(new FormListarEdificiosConFinObra(usuario));
                menuOpcion.ejecutar();
                Pantalla.continuar();
                break;
            case "6":
                menuOpcion = new MenuOpcionOperativa(new FormListarEdificiosConCertificadoHabitabilidad(usuario, false));
                menuOpcion.ejecutar();
                Pantalla.continuar();
                break;
            case "7":
                menuOpcion = new MenuOpcionOperativa(new FormListarEdificacionTrabajo(usuario));
                menuOpcion.ejecutar();
                Pantalla.continuar();
                break;
            case "8":
                menuOpcion = new MenuOpcionPlanificacion(new MenuAccesoCalendario(usuario));
                menuOpcion.ejecutar();
                break;
            case "9":
                menuOpcion = new MenuOpcionOperativa(new FormListarCalendario(usuario));
                menuOpcion.ejecutar();
                Pantalla.continuar();
            case "10":
                menuOpcion = new MenuOpcionOperativa(new FormListarEdificiosConCertificadoHabitabilidad(usuario, true));
                menuOpcion.ejecutar();
                Pantalla.continuar();
                break;
            case "11":
                menuOpcion = new MenuOpcionOperativa(new FormListarEdificiosConCertificadoInspeccion(usuario));
                menuOpcion.ejecutar();
                Pantalla.continuar();
            case "":
                return "";
            default:
                opcionNoEncontrada();
                return pedirOpcion();
         }
         opcion.entrada("loop");
         return opcion.entrada();
     }

}
