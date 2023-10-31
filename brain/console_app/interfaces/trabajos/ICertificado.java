package console_app.interfaces.trabajos;
import java.util.*;


/**
 * Interfaz para reunir la base parental de herencia de los Certificados.
 * 
 * Los certificados que desarrolla un estudio de arquitectura pueden ser de cuatro tipos: 
 * 
 * - los certificados de habitabilidad {@link console_app.interfaces.trabajos.ICertificadoHabitabilidad.java}, que además caducan cada 15 años y hay que renovarlos; 
 * - la inspección técnica {@link console_app.interfaces.trabajos.ICertificadoInspeccion} de edificios que se aplica a edificios comunitarios {@link console_app.interfaces.trabajos.IEdificacionResidencialComunitario} y es obligatoria a partir de los 45 años de su construcción; 
 * - los certificados de eficiencia energética  {@link console_app.interfaces.trabajos.ICertificadoEficiencia} que se emiten con una categoría  {@link console_app.tipos.trabajos.EficienciaTipos} que puede ser desde la “A” (la más eficiente) a la “G” (la menos eficiente);
 * - y finalmente los informes periciales {@link console_app.interfaces.trabajos.ICertificadoInforme}.
 *
 * @author Jaime Sánchez
 * @version 1.0.0
 */

public interface ICertificado extends ITrabajo
{
    /**
     * Fecha en la que el IArquitecto concede el certificado
     * @return
     */
    Date getFechaCertificacion();

    /**
     * Fecha en la que el IAparejador visita la IEdificacion con el certificado
     * caducado.
     */
    Date getFechaVisita();
}
