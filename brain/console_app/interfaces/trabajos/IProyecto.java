package console_app.interfaces.trabajos;

import java.util.Date;

/**
 * Interfaz para reunir la base parental de herencia de los Proyectos, dentro de los proyectos de arquitectura 
 * que se pueden realizar encontramos tres tipos: 
 * <p>
 * <li> los proyectos residenciales {@link console_app.interfaces.trabajos.IProyectoResidencial} 
 * que engloban edificios y viviendas unifamiliares {@link console_app.interfaces.trabajos.IEdificacionResidencial}; 
 * <li> los proyectos no residenciales {@link console_app.interfaces.trabajos.IProyectoNoResidencial} 
 * como naves industriales, museos, o cualquier otra construcción no residencial; 
 * <li> y los proyectos de rehabilitación {@link console_app.interfaces.trabajos.IProyectoRehabilitacion} 
 * que consiste en reformar una construcción {@link console_app.interfaces.trabajos.IEdificacion} ya finalizada previamente.
 * 
 * @author Jaime Sánchez
 * @version 1.0.0
 */

public interface IProyecto extends ITrabajo
{
    int getDiasEstimados();

    Date getInicio();
    Date getPrevisto();
    Date getFin();

    IPresupuesto getPresupuesto();
}
