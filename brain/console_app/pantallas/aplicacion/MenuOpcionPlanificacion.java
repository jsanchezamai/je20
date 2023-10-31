package console_app.pantallas.aplicacion;

import console_app.pantallas.sesion.MenuAccesoCalendario;
import console_app.tipos.entidades.EntidadTipos;
import console_app.tipos.personas.Administrador;
import console_app.tipos.personas.Aparejador;
import console_app.tipos.personas.Arquitecto;

/**
 * Pieza conectora entre menús relativas al ICalendario y la gestión de fechas.
 * 
 * @author:  
 * Date:
 */
public class MenuOpcionPlanificacion extends MenuOpcion
{
    MenuAccesoCalendario menu;

    public MenuOpcionPlanificacion(MenuAccesoCalendario menu) {
        super();

        this.menu = menu;
    }

    public boolean ejecutar() {

        super.ejecutar();

        String opcion = "Loop";

        if (menu.usuario instanceof Administrador) {
            menu.opciones = menu.opcionesProyecto();
        } else if (menu.usuario instanceof Arquitecto) {
            if (menu.getTipo() == EntidadTipos.Proyecto) {
                menu.opciones = menu.opcionesProyecto();
            } else {
                menu.opciones = menu.opcionesCertificado(1);
            }
        } else if (menu.usuario instanceof Aparejador) {
            menu.opciones = menu.opcionesCertificado(1);
        } else {
            Pantalla.error("No implementado planificacion para  este tipo de usuario");
            opcion = "";
        }

        while(!opcion.isEmpty())
        {
            menu.mostrarOpciones();
            opcion = menu.pedirOpcion();
        }
        return true;
    }
}
