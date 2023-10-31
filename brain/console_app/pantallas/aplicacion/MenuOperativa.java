package console_app.pantallas.aplicacion;

import console_app.interfaces.personas.IEmpleado;

/**
 * Abstract class MenuManagerLevel1 - write a description of the class here
 * 
 * @author:
 * Date: 
 */
public abstract class MenuOperativa extends Menu
{
     MenuOperativa() {
     }

     protected MenuOperativa(IEmpleado usuario) {
          super(usuario);
     }
}
