package console_app.interfaces.trabajos;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * Base de herencia común para aquellos certificados que deban renovarse a partir de un determinado
 * plazo desde su fecha de certificación.
 */
public interface ICertificadoCaducable {

    /**
     * Comprueba si la fecha de certificación ha excedido la fecha Ahora.
     */
    boolean getCaducado();

    /**
     * Comprueba si la fecha de certificación ha excedido la fecha date.
     */
    boolean getCaducado(LocalDateTime date);

    /**
     * Fecha resultante de sumar a la fecha de certificación
     * el número de años de vigencia.
     * 
     */
    public Date getCaduca();
}
