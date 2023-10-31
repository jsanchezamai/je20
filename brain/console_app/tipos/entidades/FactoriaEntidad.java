package console_app.tipos.entidades;

import java.util.List;

import console_app.interfaces.pantallas.IOpcion;
import console_app.interfaces.entidades.IEntidad;
import console_app.interfaces.entidades.IFactoriaEntidad;
import console_app.interfaces.entidades.IFiltro;
import console_app.interfaces.entidades.Campos.CamposEnum;
import console_app.servicios.AlmacenVolatil;
import console_app.servicios.ServicioAutorizacion;

/**
 * Write a description of class FactoriaEntidad here.
 *
 * @author Jaime Sánchez
 * @version 1.0.0
 */
public class FactoriaEntidad implements IFactoriaEntidad
{
    FactoriaEntidad() {

    }

    IFactoriaEntidad storage = new AlmacenVolatil();
    private ServicioAutorizacion logger;

    @Override
    public IEntidad porDefecto(EntidadTipos tipo) {
        return storage.porDefecto(tipo);
    }

    @Override
    public IEntidad buscarPorId(int id) {
       return storage.buscarPorId(id);
    }

    @Override
    public IEntidad buscarPorId(EntidadTipos tipo, String id) {
        return storage.buscarPorId(tipo, id);
    }

    @Override
    public IEntidad buscarPorId(String id) {
        try {
            int valor = Integer.valueOf(id);
            return storage.buscarPorId(valor);
        } catch(NumberFormatException ex) {
            // pass
        }
        return null;
    }

    @Override
    public List<IEntidad> buscarPorCampo(EntidadTipos tipo, CamposEnum campo, String valorFiltro) {

        return storage.buscarPorCampo(tipo, campo, valorFiltro);
    }

    @Override
    public String imprimir(EntidadTipos tipo) {
        return storage.imprimir(tipo);
    }

    @Override
    public String imprimir(EntidadTipos tipo, IEntidad filtroForanea) {
        return storage.imprimir(tipo, filtroForanea);
    }

    @Override
    public boolean existe(int id) {
        return storage.existe(id);
    }

    @Override
    public boolean existe(EntidadTipos tipo, String id) {
        return storage.existe(tipo, id);
    }

    @Override
    public boolean agregar(IEntidad entidad) {
        return storage.agregar(entidad);
    }

    @Override
    public boolean editar(IEntidad entidad){
        return storage.editar(entidad);
    }

    @Override
    public boolean borrar(int id){
        return storage.borrar( "" + id);
    }

    public boolean borrar(String id){
        return storage.borrar(id);
    }

    @Override
    public List<IOpcion> opciones(EntidadTipos tipo) {
        return storage.opciones(tipo);
    }

    @Override
    public String imprimirLista(EntidadTipos tipo, List<IEntidad> entidades) {
        return storage.imprimirLista(tipo, entidades);
    }

    @Override
    public String imprimir(EntidadTipos tipo, IFiltro filtro) {
        return storage.imprimir(tipo, filtro);
    }

    @Override
    public List<IEntidad> buscar(EntidadTipos tipo, IFiltro filtro) {
        return storage.buscar(tipo, filtro);
    }

    @Override
    public void setLogger(ServicioAutorizacion servicioAutorizacion) {
        this.logger = servicioAutorizacion;
    }

    @Override
    public ServicioAutorizacion getLogger() {
        return this.logger;
    }

}
