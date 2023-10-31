package console_app.pantallas.sesion;

import console_app.interfaces.personas.IEmpleado;
import console_app.pantallas.aplicacion.MenuFormulario;
import console_app.pantallas.aplicacion.MenuOpcionSesion;
import console_app.servicios.Io;
import console_app.servicios.ServicioAutorizacion;
import console_app.tipos.entidades.Entidad;
import console_app.tipos.entidades.Opcion;

/**
 * Permite la identificación de un IEmpleado y otorgar acceso a su perfil en la
 * aplicación.
 *
 * @author Jaime Sánchez
 * @version 1.0.0
 */
public class FormConectarse extends MenuFormulario
{
    /**
     * Constructor for objects of class MenuInicial 
     */
    public FormConectarse()
    {
        titulo = Io.TITULO_CONECTARSE;
        opciones.add(new Opcion(Io.OPCION_CREDENCIALES, 1));

    }

    public IEmpleado getUsuarioLoggeado() {

        if (Entidad.factoria.getLogger() == null) {
            return null;
        } else {
            return  Entidad.factoria.getLogger().usuario;
        }
    }

    public String pedirOpcion() {

        opcion.entrada(super.pedirOpcion());
        Entidad.factoria.setLogger(new ServicioAutorizacion(opcion));
        ServicioAutorizacion logger = Entidad.factoria.getLogger();
        if (logger.estaAutenticado()) {

            switch(logger.usuario.getTipo()) {
                case Administrador:
                    menuOpcion = new MenuOpcionSesion(new MenuAdministrador(logger.usuario));
                    break;
                case Arquitecto:
                    menuOpcion = new MenuOpcionSesion(new MenuArquitecto(logger.usuario));
                    break;
                case Aparejador:
                    menuOpcion = new MenuOpcionSesion(new MenuAparejador(logger.usuario));
                    break;
                case Contable:
                    menuOpcion = new MenuOpcionSesion(new MenuContable(logger.usuario));
                    break;
                default:
                    opcionNoValida();
                    return pedirOpcion();
            }
            menuOpcion.ejecutar();

        } else {
            if (!opcion.entrada().isEmpty()) {
                opcionNoValida();
                return pedirOpcion();
            }
        }
        return opcion.entrada();
    }

}
