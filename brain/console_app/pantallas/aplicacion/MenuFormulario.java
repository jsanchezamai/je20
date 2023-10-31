package console_app.pantallas.aplicacion;

import console_app.interfaces.entidades.IEntidad;
import console_app.interfaces.personas.IEmpleado;
import console_app.tipos.entidades.EntidadTipos;
import console_app.tipos.entidades.Filtro;

/**
 * Base para un tipo especial de menú que presentará un {@link console_app.interfaces.entidades.IEntidad}
 * y permitirá listarla, añadirla, editarla o borrarla.
 */
public abstract class MenuFormulario extends Menu
{
     protected Filtro filtro;

     protected MenuFormulario() {
          super();
     }

     protected MenuFormulario(IEmpleado empleado) {
          super(empleado);
     }

     protected MenuFormulario(IEmpleado usuario, EntidadTipos tipo) {
          super(usuario, tipo);
     }

     protected MenuFormulario(IEmpleado usuario, EntidadTipos tipo, IEntidad foraneaEntidad) {
          super(usuario, tipo, foraneaEntidad);
     }

     protected MenuFormulario(IEmpleado usuario, EntidadTipos tipo, EntidadTipos foraneaTipo) {
          super(usuario, tipo, foraneaTipo);
     }

     protected MenuFormulario(IEmpleado usuario, EntidadTipos tipo, EntidadTipos foraneaTipo, IEntidad foraneaEntidad) {
          super(usuario, tipo, foraneaTipo, foraneaEntidad);
     }

    public MenuFormulario(IEmpleado usuario, EntidadTipos tipo, Filtro filtro) {
         this.tipo = tipo;
         this.filtro = filtro;
    }
}
