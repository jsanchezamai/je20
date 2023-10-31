package console_app.interfaces.trabajos;
import java.util.Date;

/**
 * Un ICalendarioDia es un elemento de la lista ICalendario.
 *
 * Se representa con una única fecha que pude ser de varios Tipos. Los trabajos
 * pueden agregar sus registros al calendario mediante este objeto creando fechas
 * del Tipo adecuado.
 *
 * Conjugado con  {@link console_app.interfaces.trabajos.ITrabajo.Estados}.
 *
 * @author Jaime Sánchez
 * @version 1.0.0
 */
public interface ICalendarioDia
{
    /**
     * Representa el tipo de fecha que significa el registro de este día
     * en el calendario.
     */
    public enum Tipos {
        Solicitud,
        Entrega,

        Inicio,
        Fin,

        Visita,
        Certificacion
    }

    void setCalendarioId(int capacidad);

    int getCalendarioId();

    void setFecha(Date fecha);

    Date getFecha();

    String getFechaComoEtiqueta();

    int getTrabajoId();

    void setTrabajoId(int trabajo);

    Date masDias(int dias);

    boolean fechaEnRango(Date fechaMin, Date fechaMax);

    Tipos getTipoFecha();
}
