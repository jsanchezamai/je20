package console_app.pantallas.sesion;

import java.util.ArrayList;
import java.util.List;

import console_app.interfaces.pantallas.IOpcion;
import console_app.interfaces.personas.IEmpleado;
import console_app.interfaces.trabajos.ITrabajo;
import console_app.pantallas.aplicacion.MenuOpcionOperativa;
import console_app.pantallas.aplicacion.Pantalla;
import console_app.servicios.Io;
import console_app.servicios.calendario.MenuCalendario;
import console_app.tipos.entidades.Entidad;
import console_app.tipos.entidades.EntidadTipos;
import console_app.tipos.entidades.Opcion;
import console_app.tipos.personas.Administrador;
import console_app.tipos.personas.Aparejador;
import console_app.tipos.personas.Arquitecto;

/**
 * {@link console_app.servicios.calendario.Empresa} mantiene hasta 3 colas de
 * {@link console_app.servicios.calendario.Calendario} para obras de proyectos.
 * 
 * Además, permite registrar las fechas de visita y de estado de certificados. 
 * 
 *
 * @author Jaime Sánchez
 * @version 1.0.0
 */
public class MenuAccesoCalendario extends MenuGestionTrabajos
{
    IOpcion opcionTipo = null;

    /**
     * Constructor for objects of class MenuInicial
     */
    public MenuAccesoCalendario(IEmpleado usuario)
    {
        super(usuario);
        configurar();

    }

    public MenuAccesoCalendario(IEmpleado usuario, EntidadTipos tipo) {
        super(usuario);
        this.tipo = tipo;
        configurar();
    }

    private void configurar() {
        titulo =  Io.OPCION_PLANIFICACION + " > " + titulo;
        opcion.entrada("loop");
    }

    private List<IOpcion> menuOpciones(EntidadTipos tipo) {
        titulo = Io.OPCION_PLANIFICACION + " > " + tipo;

        List<IOpcion> opcionesSubMenu = new ArrayList<>();

        if (usuario instanceof Administrador) {
            opcionesSubMenu.add(new Opcion(Io.OPCION_PLANIFICACION_INICIO, "1"));
            opcionesSubMenu.add(new Opcion(Io.OPCION_PLANIFICACION_FIN, "2"));
            opcionesSubMenu.add(new Opcion(Io.OPCION_VISUALIZACION_FINALIZADOS, "3"));
        }

        if (usuario instanceof Arquitecto) {
            if (Entidad.esDeTipo(EntidadTipos.Proyecto, tipo)) {
                opcionesSubMenu.add(new Opcion(Io.OPCION_FECHA_ENTREGA, "1"));
            } else {
                opcionesSubMenu.add(new Opcion(Io.OPCION_FECHA__CERTIFICACION, "1"));
                opcionesSubMenu.add(new Opcion(Io.OPCION_FECHA_ENTREGA, "2"));
            }

        }
        if (usuario instanceof Aparejador) {
            opcionesSubMenu.add(new Opcion(Io.OPCION_FECHA_VISITA, "1"));
        }

        return opcionesSubMenu;
    }

    public void mostrarOpcionesProgramacion(List<IOpcion> opciones) {

        limpiarPantalla();

        Pantalla.titulo(Io.TITULO_APP);
        Pantalla.titulo(titulo);

        int i = 1;
        for(IOpcion opcion: opciones) {
            String e = String.format(Io.OPCION_ENUMERACION, i++);
            Pantalla.opcion(e + opcion.etiqueta());
        }
    }

    @Override
    public String pedirOpcion() {

        if (opcion.entrada().isEmpty()) return "";

        // Selección del tipo de Trabajo
        if (opcionTipo == null) {

            opcion.entrada(Pantalla.esperar());

            if (opcion.entrada().isEmpty()) return "";

            opcionTipo = buscarEntrada(opcion.entrada());

            if (opcionTipo == null)  {
                opcionNoEncontrada();
                return pedirOpcion();
            }
        }

        // Seleccion del tipo de fecha a actualizar
        mostrarOpcionesProgramacion(menuOpciones(opcionTipo.llaveTipo()));

        // En los casos de que solo haya una fecha, saltamos directamente
        if (usuario instanceof Aparejador) {
            opcion.entrada("1");
        } else if (usuario instanceof Arquitecto && tipo == EntidadTipos.Proyecto) {
            opcion.entrada("1");
        } else {
            opcion.entrada(Pantalla.esperar());
        }

        // Ejecutamos la acción escogida por el usuario
        if (usuario instanceof Administrador) {
            opcion.entrada(accionesAdministrador());
        } else if (usuario instanceof Arquitecto) {
            opcion.entrada(accionesArquitecto());
        } else if (usuario instanceof Aparejador) {
            opcion.entrada(accionesAparejador());
        } else {
            Pantalla.error("Operativa no implementada para el tipo de usuario");
            return "";
        }

        // Resetar la acción previa, volver a ofrecer planificar
        opcionTipo = null;
        mostrarOpciones();
        return pedirOpcion();
    }

    private String accionesAdministrador() {

        ITrabajo.Estados estado = null;
        switch(opcion.entrada()) {
            case "1":
                estado = ITrabajo.Estados.Entregado;
                break;
            case "2":
                estado = ITrabajo.Estados.Iniciado;
                break;
            case "3":
                estado = ITrabajo.Estados.Finalizado;
                break;
            case "":
                return "";
            default:
                opcionNoEncontrada();
                return pedirOpcion();
        }
        menuOpcion = new MenuOpcionOperativa(new MenuCalendario(usuario, opcionTipo.llaveTipo(), estado));
        menuOpcion.ejecutar();
        return "loop";
    }

    private String accionesArquitecto() {

        ITrabajo.Estados estado = null;
        switch(opcion.entrada()) {
            case "1":
                if (tipo == EntidadTipos.Proyecto) {
                    estado = ITrabajo.Estados.Solicitado;
                    break;
                } else if (tipo == EntidadTipos.Certificado) {
                    estado = ITrabajo.Estados.Visitado;
                    break;
                } else {
                    Pantalla.error("Opción no implementada para arquitecto. Tipo de fecha.");
                }
                break;
            case "2":
                estado = ITrabajo.Estados.Certificado;
                break;
            case "":
                return "";
            default:
                opcionNoEncontrada();
                return pedirOpcion();
        }
        menuOpcion = new MenuOpcionOperativa(new MenuCalendario(usuario, opcionTipo.llaveTipo(), estado));
        menuOpcion.ejecutar();
        return "loop";
    }

    private String accionesAparejador() {
        switch(opcion.entrada()) {
            case "1":
                menuOpcion = new MenuOpcionOperativa(new MenuCalendario(usuario, opcionTipo.llaveTipo(), ITrabajo.Estados.Solicitado));
                menuOpcion.ejecutar();
                break;
            case "":
                return "";
            default:
                opcionNoEncontrada();
                return pedirOpcion();
        }
        return "loop";
    }
}
