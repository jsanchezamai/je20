package console_app.interfaces.entidades;

/**
 * Un IFiltroEntidad permite aplicar criterios al servicio de búsqueda en un registro
 * de {@link console_app.interfaces.entidades.IEntidad}.
 *
 * @author Jaime Sánchez
 * @version 1.0.0
 */
public abstract interface IFiltroEntidad<T> {
    public abstract boolean filtrar(IFiltro filtro);

    public abstract  boolean filtroForanea(IEntidad foraneo);
}
