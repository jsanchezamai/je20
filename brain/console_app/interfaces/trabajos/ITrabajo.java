package console_app.interfaces.trabajos;

import java.util.*;

import console_app.interfaces.entidades.IEntidad;
import console_app.interfaces.personas.IAparejador;
import console_app.interfaces.personas.IArquitecto;
import console_app.interfaces.personas.ICliente;
import console_app.interfaces.personas.IContable;

/**
 * Interfaz para reunir la base parental de herencia de Proyectos y Certificados.
 *
 * @author Jaime Sánchez
 * @version 1.0.0
 */

public interface ITrabajo extends IEntidad
{
    /**
     * Conjugado con los distintos {@link console_app.interfaces.trabajos.ICalendarioDia.Tipos},
     * devuelve el estado actual del trabajo. La estrategia utilizada ha sido:
     * "dada una secuencia de estados por las que debe pasar el proyecto, un estado 
     * estará pasado si existe una fecha de su tipo en el calendario."
     */
    public enum Estados {
            Presupuestado,  // ????
        Solicitado,
        Entregado,

        Iniciado,
        Finalizado,

        Visitado,
        Certificado

    }

    Date getSolicitud();
    Date getEntrega();

    IArquitecto getArquitecto();
    IAparejador getAparejador();
    IContable getContable();
    ICliente getCliente();

    String getArquitectoId();

    /**
     * Un aparejador tendrá que llevar a cabo el control de la obra.
     */
    String getAparejadorId();

    /**
     * Cada proyecto tiene un coste que será determinado por un {@link console_app.interfaces.personas.IContable}.
     * @return
     */
    String getContableId();
    String getClienteId();

    /**
     * El coste tendrá que estar asociado al {@link console_app.interfaces.trabajos.IProyecto} y quedar 
     * constancia en el sistema.
     */
    Float getCoste();

    Date getFechaEstado();

    String getFechaEstadoComoEtiqueta();

    Estados getEstado();

    String getEstadoComoEtiqueta();

    String getTipoComoEtiqueta();

    IEdificacion getEdificacion();

    String comoResumen();

}
