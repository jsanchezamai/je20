package console_app.interfaces.trabajos;

import java.util.Date;

/**
 * Los informes periciales son desarrollados por un arquitecto del estudio 
 * y tendrán una fecha de emisión.
 * 
 * @author Jaime Sánchez 
 * @version 1.0.0
 */

public interface ICertificadoInforme extends ICertificado
{
    IEdificacion getEdificacion();

    Date getFechaEmision();
}
