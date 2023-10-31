package console_app.pantallas.aplicacion;

import console_app.interfaces.pantallas.IMenu;

/**
 * Pieza conectora entre menús relativos al IEmpleado y las funcionalidades
 * asignadas.
 * 
 */
public class MenuOpcionSesion extends MenuOpcion
{
   IMenu mnu;

    public MenuOpcionSesion(MenuSesion mnu) {
        this.mnu = mnu;
    }

   public boolean ejecutar() {
        super.ejecutar();

        String opcion = "Loop";

        while(!opcion.isEmpty())
        {
            mnu.mostrarOpciones();
            opcion = mnu.pedirOpcion();
        }
        return true;
   }
}
