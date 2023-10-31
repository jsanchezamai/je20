package console_app.interfaces.entidades;

import java.util.List;

import console_app.interfaces.entidades.Campos.CamposEnum;
import console_app.interfaces.pantallas.IOpcion;
import console_app.servicios.ServicioAutorizacion;
import console_app.tipos.entidades.EntidadTipos;


/**
 * Permite crear, leer, editar, borrar y buscar objetos {@link console_app.interfaces.entidades.IEntidad}.
 *
 * @author Jaime Sánchez
 * @version 1.0.0
 */
public interface IFactoriaEntidad
{
    /**
     * Obtener una nueva entidad inicializada lista para alta o edición
     */
    IEntidad porDefecto(EntidadTipos tipo);

    IEntidad buscarPorId(int id);

    IEntidad buscarPorId(String id);

    IEntidad buscarPorId(EntidadTipos tipo, String id);

    List<IEntidad> buscarPorCampo(EntidadTipos tipo, CamposEnum campo, String valorFiltro);

    boolean existe(int id);

    boolean existe(EntidadTipos tipo, String id);

    String imprimir(EntidadTipos tipo);

    String imprimir(EntidadTipos tipo, IEntidad filtroForanea);

    String imprimir(EntidadTipos tipo, IFiltro filtro);

    boolean agregar(IEntidad entidad);

    boolean editar(IEntidad entidad);

    boolean borrar(int id);

    boolean borrar(String id);

    List<IEntidad> buscar(EntidadTipos tipo, IFiltro filtro);

    /**
     * Devuelve el mapeo entre entidades y opciones
     */
    List<IOpcion> opciones(EntidadTipos tipo);

    /**
     * Devuelve un listado según la lista
     *
     * @param tipo
     * @param entidades
     * @return
     */
    String imprimirLista(EntidadTipos tipo, List<IEntidad> entidades);

    /**
     * Representa una instancia válida de autorización. Contiene un usuario autenticado.
     */
    void setLogger(ServicioAutorizacion servicioAutorizacion);

    /**
     * Devuelve la instancia de autorización
     */
    ServicioAutorizacion getLogger();
}
