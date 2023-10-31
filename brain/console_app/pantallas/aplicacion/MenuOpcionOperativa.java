package console_app.pantallas.aplicacion;

/**
 * Pieza conectora entre menús relativos a IEntidad la gestión sobre ellas.
 * 
 */
public class MenuOpcionOperativa extends MenuOpcion
{

    public MenuOpcionOperativa(MenuOperativa menu) {
        super();
        this.menu = menu;
    }

    public MenuOpcionOperativa(MenuFormulario menu) {
        super();
        this.menu = menu;
    }

    public boolean ejecutar() {

        super.ejecutar();

        String opcion = "Loop";

        while(!opcion.isEmpty())
        {
            menu.mostrarOpciones();
            opcion = menu.pedirOpcion();
        }
        return true;
    }
}
