package console_app.pantallas.aplicacion;

import java.util.List;

import console_app.interfaces.pantallas.IMenu;
import console_app.interfaces.pantallas.IMenuOpcion;
import console_app.interfaces.pantallas.IOpcion;
import console_app.interfaces.pantallas.IPantalla;
import console_app.interfaces.personas.IEmpleado;
import console_app.interfaces.entidades.IEntidad;
import console_app.servicios.Io;
import console_app.tipos.entidades.Entidad;
import console_app.tipos.entidades.EntidadTipos;
import console_app.tipos.entidades.Opcion;

import java.util.ArrayList;

/**
 * Ver descripción en {@link console_app.interfaces.pantallas.IMenu}
 *
 * @author:
 * Date:
 */
public abstract class Menu implements IMenu
{

    protected String titulo;
    String tag;

    /**
     * El tipo de entidad vinculada al contenedor
     */
    protected EntidadTipos tipo;

    /**
     * La entidad vinculada al contenedor
     */
    public IEntidad entidad;

    /**
     * El tipo de entidad foranea vinculada al contenedor
     */
    protected EntidadTipos foraneaTipo;

    /**
     * Entidad foranea vinculada al contenedor
     */
    public IEntidad foraneaEntidad;

    /**
     * El usuario de sistema loggeado que usa el contenedor
     */
    public IEmpleado usuario;

    /**
     * Las opciones de menú disponibles en el contenedor.
     */
    public List<IOpcion> opciones;

    /**
     * La accion de menu a lanzar
     */
    protected IMenuOpcion menuOpcion;

    /**
     * Los argumentos recogidos de la consola
     */
    protected IOpcion opcion = new Opcion();

    /**
     * El registro en curso acepta Enter para dejar el valor intacto
     */
    public boolean aceptarEntradaVacia;

    /**
     * Contador inicializado a 0 que permite recorrer las opciones
     */
    public int iteradorOpciones;

    private IEmpleado getEmpleadoOrLogged(IEmpleado usuario) {
        return usuario == null ? Entidad.factoria.getLogger().usuario : usuario;
    }

    protected Menu() {
        init();
    }

    protected Menu(EntidadTipos tipo) {
        this.tipo = tipo;
        init();
    }

    protected Menu(EntidadTipos tipo, EntidadTipos foraneaTipo) {
        this.tipo = tipo;
        this.foraneaTipo = foraneaTipo;
        init();
    }

    protected Menu(EntidadTipos tipo, IEntidad foraneaEntidad) {
        this.tipo = tipo;
        this.foraneaEntidad = foraneaEntidad;
        init();
    }

    protected Menu(IEmpleado usuario, EntidadTipos tipo, IEntidad foraneaEntidad) {
        this.usuario = getEmpleadoOrLogged(usuario);
        this.tipo = tipo;
        this.foraneaEntidad = foraneaEntidad;
        init();
   }

    protected Menu(IEmpleado usuario, EntidadTipos tipo, EntidadTipos foraneaTipo, IEntidad foraneaEntidad) {
        this.usuario = getEmpleadoOrLogged(usuario);
        this.tipo = tipo;
        this.foraneaTipo = foraneaTipo;
        this.foraneaEntidad = foraneaEntidad;
        init();
   }

    protected Menu(IEmpleado usuario, EntidadTipos tipo, EntidadTipos foraneaTipo) {
        this.usuario = getEmpleadoOrLogged(usuario);
        this.tipo = tipo;
        this.foraneaTipo = foraneaTipo;
        init();
    }

    protected Menu(IEmpleado usuario) {
        this.usuario = getEmpleadoOrLogged(usuario);
        init();
    }

    protected Menu(IEmpleado usuario, EntidadTipos tipo) {
        this.usuario = getEmpleadoOrLogged(usuario);
        this.tipo = tipo;
        init();
    }

    public EntidadTipos getTipo() {
        return this.tipo;
    }

    private void init() {
        opciones = new ArrayList<>();
        iteradorOpciones = 0;
    }

    @Override
    public IMenuOpcion menuOpcion() {
        return menuOpcion;
    }

    @Override
    public List<IOpcion> opciones() {
        return opciones;
    }

    @Override
    public void mostrarOpciones(boolean enumerar) {

        limpiarPantalla();

        // Pintar una cabecera
        Pantalla.titulo(Io.TITULO_APP);
        Pantalla.titulo(titulo);

        // Pintar las opciones disponibles en este menú
        int i = 1;  // Solo aplica si el param enumerar es cierto
        for(IOpcion opcion: opciones) {
            if (opcion != null ) {
                // Para que el usuario pueda escoger la opción en pantalla...
                // ... usar una enumeración automática o la "llave" definida en la opción
                enumerar = enumerar && opcion.seleccionable();
                String e = String.format(Io.OPCION_ENUMERACION, enumerar ? i++ : opcion.llave());

                // Pintar en pantalla
                Pantalla.opcion(e + opcion.etiqueta());
            }
        }

    }

    @Override
    public void mostrarOpciones() {
        mostrarOpciones(true);
    }

    @Override
    public String pedirOpcion(){
        return Pantalla.esperar();
    }

    @Override
    public void opcionNoEncontrada() {
        Pantalla.error(String.format(Io.ERROR_NO_ENCONTRADA, opcion.entrada()));
    }

    @Override
    public void opcionNoValida() {
        Pantalla.error(String.format(Io.ERROR_NO_VALIDA, opcion.entrada()));
    }

    @Override
    public void limpiarPantalla() {
        Pantalla.limpiar();

        for (StackTraceElement e: Thread.currentThread().getStackTrace()) {
            // Pantalla.opcion(e.getClassName() + "/" + e.getMethodName());
        }
    }

    public IOpcion buscarEntrada(String entrada) {
        return opciones.stream()
        .filter(o -> o.llave().equals(opcion.entrada()))
        .findFirst()
        .orElse(null);
    }

    public IPantalla getPantalla() {
        return Pantalla.consola;
    }

}
