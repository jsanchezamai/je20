package console_app.pantallas.aplicacion;

import console_app.interfaces.personas.IEmpleado;

/**
 * Base para menús de alto nivel, como el de {@link console_app.pantallas.sesion.MenuInicial},
 * u otros de configuración que pudieran ser requeridos.
 *
 */
public abstract class MenuAplicacion extends Menu
{
   protected MenuAplicacion() {
      super();
   }

   MenuAplicacion(IEmpleado usuario) {
        super(usuario);
   }
}
