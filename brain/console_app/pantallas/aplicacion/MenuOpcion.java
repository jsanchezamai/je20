package console_app.pantallas.aplicacion;

import console_app.interfaces.pantallas.IMenu;
import console_app.interfaces.pantallas.IMenuOpcion;
import console_app.tipos.entidades.EntidadTipos;

/**
 * Ver descripción en {@link console_app.interfaces.pantallas.IMenuOpcion}
  */
public abstract class MenuOpcion implements IMenuOpcion
{
    String key;
    protected EntidadTipos tipo;

    protected IMenu menu;

    protected MenuOpcion() {

    }

    MenuOpcion(EntidadTipos tipo) {
        this.tipo = tipo;
    }

    public boolean ejecutar() {

        Pantalla.limpiar();

        return true;
    }
}
