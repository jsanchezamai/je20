package console_app.interfaces.trabajos;

/**
 * La inspección técnica de edificios que se aplica a edificios comunitarios
 * {@link console_app.interfaces.trabajos.IEdificacionResidencialComunitario}. Y es
 * obligatoria a partir de los 45 años de su construcción.
 *
 * @author Jaime Sánchez
 * @version 1.0.0
 */

public interface ICertificadoInspeccion extends ICertificado, ICertificadoCaducable
{
    public IEdificacionResidencialComunitario getEdificacion();
}
