package console_app.pantallas.sesion;

import console_app.interfaces.personas.IEmpleado;
import console_app.pantallas.aplicacion.MenuOpcionOperativa;
import console_app.pantallas.aplicacion.MenuSesion;
import console_app.pantallas.aplicacion.Pantalla;
import console_app.pantallas.entidad.FormEntidadForanea;

import console_app.servicios.Io;
import console_app.tipos.entidades.EntidadTipos;
import console_app.tipos.entidades.Opcion;

/**
 * Menú con todas las opciones del {@link console_app.interfaces.personas.IEmpleado} de tipo 
 * {@link console_app.interfaces.personas.IContable}.
 * 
 * @author Jaime Sánchez
 * @version 1.0.0
 */
public class MenuContable extends MenuSesion
{

    public MenuContable(IEmpleado usuario)
    {
        super(usuario);

        titulo = Io.TITULO_CONTABLE;

        opciones.add(new Opcion(Io.OPCION_GESTION_PRESUPUESTO + " " + Io.TITULO_PROYECTO, "1"));
        opciones.add(new Opcion(Io.OPCION_GESTION_PRESUPUESTO_LINEAS + " " + Io.TITULO_PROYECTO, "3"));
        opciones.add(new Opcion(Io.OPCION_GESTION_COSTES, "3"));
        opciones.add(new Opcion(Io.OPCION_VISUALIZACION_CLIENTES, "4"));
    }

    public String pedirOpcion() {
         opcion.entrada(super.pedirOpcion());
         switch(opcion.entrada()) {
            case "1":
                menuOpcion = new MenuOpcionOperativa(new FormEntidadForanea(usuario, EntidadTipos.Presupuesto, EntidadTipos.Proyecto));
                menuOpcion.ejecutar();
                break;
            case "2":
                menuOpcion = new MenuOpcionOperativa(new FormEntidadForanea(usuario, EntidadTipos.PresupuestoLinea, EntidadTipos.Presupuesto));
                menuOpcion.ejecutar();
                break;
            case "3":
                menuOpcion = new MenuOpcionOperativa(new MenuGestionTrabajos(usuario));
                menuOpcion.ejecutar();
                break;
            case "4":
                menuOpcion = new MenuOpcionOperativa(new FormListarClientesPorEmpleado(usuario));
                menuOpcion.ejecutar();
                Pantalla.continuar();
                break;
            case "":
                return "";
            default:
                opcionNoEncontrada();
         }
         opcion.entrada("mostrar-opciones");
         return opcion.entrada();
     }

}
