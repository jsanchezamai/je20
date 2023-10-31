package console_app.interfaces.trabajos;

import java.util.List;

import console_app.interfaces.entidades.IEntidad;

/**
 * Un IPresupuesto es una lista de {@link IPresupuestoLineas} y está vinculado a un {@link ITrabajo}.
 *
 * @author Jaime Sánchez
 * @version 1.0.0
 */

public interface IPresupuesto extends IEntidad
{
    List<IPresupuestoLinea> cargos();

    ITrabajo getTrabajo();
}
