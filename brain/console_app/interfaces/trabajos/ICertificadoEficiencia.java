package console_app.interfaces.trabajos;

import console_app.tipos.trabajos.EficienciaTipos;

/**
 * Un ICertificadoEficiencia es un tipo especial de ICertificado
 * que otorga {@link console_app.tipos.trabajos.EficienciaTipos}.
 * 
 * @author Jaime Sánchez 
 * @version 1.0.0
 */

public interface ICertificadoEficiencia extends ICertificado
{
    IEdificacion getEdificacion();

    /**
     * @return Eficiencia con que se calificado la IEdificacion.
     */
    EficienciaTipos getEficiencia();
}
