package console_app.servicios;

import java.util.List;

import console_app.interfaces.entidades.IEntidad;
import console_app.interfaces.pantallas.IOpcion;
import console_app.interfaces.personas.IAdministrador;
import console_app.interfaces.personas.IEmpleado;
import console_app.tipos.entidades.Entidad;
import console_app.tipos.entidades.EntidadTipos;
import console_app.tipos.personas.Administrador;



/**
 * Write a description of class LoggerManager here.
 *
 * @author Jaime Sánchez
 * @version 1.0.0
 */
public class ServicioAutorizacion
{
    public static IAdministrador superAdmin;
    public static boolean inicializado;
    private String credenciales;
    public IEmpleado usuario;
    /**
     * Constructor for objects of class LoggerManager
     */
    public ServicioAutorizacion(IOpcion credentials)
    {
        this.credenciales = credentials.entrada();

        List<IEntidad> lista = Entidad.buscar(EntidadTipos.Administrador, null);

        inicializado = lista.size() > 0;
        if (inicializado) {
            superAdmin = (IAdministrador) lista.get(0);
        } else {
            superAdmin = new Administrador(0);
            superAdmin.setTipo(EntidadTipos.Administrador);
            superAdmin.name("AdminInicial");
        }
    }

    public boolean estaAutenticado() {

        if (!inicializado) {
            usuario = superAdmin;
            return true;
        }

        if (credenciales.isEmpty()) {
            return false;
        } else {
            usuario = (IEmpleado) Entidad.buscarPorId(EntidadTipos.Empleado, credenciales);
        }

        if (usuario == null) {
            return false;
        }
        return true;
    }
}
