package console_app.interfaces.trabajos;

import console_app.interfaces.entidades.IEntidad;

/**
 * Una IPresupuestoLinea es una unidad de gasto dentro de un {@link IPresupuesto}.
 * 
 * @author Jaime Sánchez 
 * @version 1.0.0
 */
public interface IPresupuestoLinea extends IEntidad
{

    IPresupuesto getPresupuesto();

}
