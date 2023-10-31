package console_app.pantallas.aplicacion;

import console_app.interfaces.personas.IEmpleado;

/**
 * Base para los menús que estén relacionados con la funcionalidad que un
 * {@link console_app.interfaces.personas.IEmpleado} puede realizar en el sistema.
 */
public abstract class MenuSesion extends Menu
{
     MenuSesion() {
          super();
     }

     protected MenuSesion(IEmpleado usuario) {
          super(usuario);
     }
}
