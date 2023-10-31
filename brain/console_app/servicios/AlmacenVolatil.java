package console_app.servicios;

import java.util.List;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import console_app.interfaces.pantallas.IOpcion;
import console_app.pantallas.aplicacion.Pantalla;
import console_app.interfaces.entidades.ICampo;
import console_app.interfaces.entidades.IEntidad;
import console_app.interfaces.entidades.IFactoriaEntidad;
import console_app.interfaces.entidades.IFiltro;
import console_app.interfaces.entidades.Campos.CamposEnum;
import console_app.servicios.calendario.Dia;
import console_app.tipos.entidades.Entidad;
import console_app.tipos.entidades.EntidadTipos;
import console_app.tipos.entidades.Filtro;
import console_app.tipos.personas.*;
import console_app.tipos.trabajos.*;

/**
 * class StorageContainerEntidad - write a description of the class here
 *
 * @author:
 * Date:
 */
public class AlmacenVolatil implements IFactoriaEntidad
{
    public static Map<Integer, IEntidad> registros = new HashMap<>();
    public static int lastID = -1;

    public static int getNewId() {

        return AlmacenVolatil.lastID + 1;
    }

    private ServicioAutorizacion logger;

    /**
     * Usamos este método para saber si una entidad de tipo específico
     * es también del tipo de su superclase.
     * @param entidad La entidad que queremos comprobar
     * @param tipo El tipo de superclase 
     * @return Si la entidad es del tipo de la superclase
     */
    private boolean esDeTipo(IEntidad entidad, EntidadTipos tipo) {
        switch(tipo) {
            case Empleado:
                return entidad instanceof Empleado;
            case Trabajo:
                return entidad instanceof Trabajo;
            case Proyecto:
                return entidad instanceof Proyecto;
            case Certificado:
                return entidad instanceof Certificado;
            case Edificacion:
                return entidad instanceof Edificacion;
            case Entidad:
                return entidad instanceof Entidad;
            default:
                return entidad.getTipo().equals(tipo);
        }
    }

    private List<IEntidad> getEntidades(EntidadTipos tipo, IEntidad filtroForanea, IFiltro filtro) {
        return AlmacenVolatil.registros.entrySet()
            .stream()
            .filter(entidad -> esDeTipo(entidad.getValue(), tipo))
            .filter(entidad -> filtroForanea(entidad.getValue(), filtroForanea))
            .filter(entidad -> filtroEstandar(entidad.getValue(), filtro))
            .map(entidad -> entidad.getValue())
            .collect(Collectors.toList());
    }

    @Override
    public String imprimirLista(EntidadTipos tipo, List<IEntidad> entidades) {

        String impresion = "";

        if (entidades.size() > 0) {

            // Pintar una línea con los nombres de las columnas (Cabecera)
            impresion += Io.TABULACION_REGISTRO + comoRegistroCabecera(tipo, entidades.get(0));

            // Para cada registro, pintarlo
            for(IEntidad entidad: entidades) {
                impresion += Io.TABULACION_REGISTRO + comoRegistro(tipo, entidad);
            }

        }
        impresion += String.format(Io.ETIQUETA_IMPRESION_TOTAL, entidades.size());
        return impresion;

    }

    // TODO se puede quitar si no se usa
    private String comoRegistroCabecera(EntidadTipos tipo, IEntidad entidad) {
        String linea;
        switch(tipo) {
            case Administrador:
                linea = ((Administrador) entidad).comoRegistroCabecera();
                break;
            case Arquitecto:
                linea = ((Arquitecto) entidad).comoRegistroCabecera();
                break;
            case Aparejador:
                linea = ((Aparejador) entidad).comoRegistroCabecera();
                break;
            case Contable:
                linea = ((Contable) entidad).comoRegistroCabecera();
                break;
            case Cliente:
                linea = ((Cliente) entidad).comoRegistroCabecera();
                break;
            case Proyecto:
                linea = ((Proyecto) entidad).comoRegistroCabecera();
                break;
            case Certificado:
                linea = ((Certificado) entidad).comoRegistroCabecera();
                break;
            case ProyectoResidencial:
                linea = ((ProyectoResidencial) entidad).comoRegistroCabecera();
                break;
            case ProyectoNoResidencial:
                linea = ((ProyectoNoResidencial) entidad).comoRegistroCabecera();
                break;
            case ProyectoRehabilitacion:
                linea = ((ProyectoRehabilitacion) entidad).comoRegistroCabecera();
                break;
            case CertificadoHabitabilidad:
                linea = ((CertificadoHabitabilidad) entidad).comoRegistroCabecera();
                break;
            case CertificadoEficiencia:
                linea = ((CertificadoEficiencia) entidad).comoRegistroCabecera();
                break;
            case CertificadoInforme:
                linea = ((CertificadoInforme) entidad).comoRegistroCabecera();
                break;
            case CertificadoInspeccion:
                linea = ((CertificadoInspeccion) entidad).comoRegistroCabecera();
                break;
            case Edificacion:
                linea = ((Edificacion) entidad).comoRegistroCabecera();
                break;
            case EdificacionResidencial:
                linea = ((EdificacionResidencial) entidad).comoRegistroCabecera();
                break;
            case EdificacionResidencialComunitario:
                linea = ((EdificacionResidencialComunitario) entidad).comoRegistroCabecera();
                break;
            case EdificacionNoResidencial:
                linea = ((EdificacionNoResidencial) entidad).comoRegistroCabecera();
                break;
            case Presupuesto:
                linea = ((Presupuesto) entidad).comoRegistroCabecera();
                break;
            case PresupuestoLinea:
                linea = ((PresupuestoLinea) entidad).comoRegistroCabecera();
                break;
            default:
                linea = "El tipo: " + tipo + " no tiene implementación por defecto. Impresión de cabecera.";
        }
        return linea;
    }

    private boolean filtroForanea(IEntidad entidad, IEntidad filtroForanea) {

        if (filtroForanea == null) return true;

        String name = entidad.getClass().getName();
        Integer lastSegment = name.lastIndexOf(".") + 1;
        String type = name.substring(lastSegment);

        switch(type) {
            case "Administrador":
                return ((Administrador) entidad).filtroForanea(filtroForanea);
            case "Arquitecto":
                return ((Arquitecto) entidad).filtroForanea(filtroForanea);
            case "Aparejador":
                return ((Aparejador) entidad).filtroForanea(filtroForanea);
            case "Contable":
                return ((Contable) entidad).filtroForanea(filtroForanea);
            case "Cliente":
                return ((Cliente) entidad).filtroForanea(filtroForanea);
            case "Proyecto":
                return ((Proyecto) entidad).filtroForanea(filtroForanea);
            case "Certificado":
                return ((Certificado) entidad).filtroForanea(filtroForanea);
            case "ProyectoResidencial":
                return ((ProyectoResidencial) entidad).filtroForanea(filtroForanea);
            case "ProyectoNoResidencial":
                return ((ProyectoNoResidencial) entidad).filtroForanea(filtroForanea);
            case "ProyectoRehabilitacion":
                return ((ProyectoRehabilitacion) entidad).filtroForanea(filtroForanea);
            case "CertificadoHabitabilidad":
                return ((CertificadoHabitabilidad) entidad).filtroForanea(filtroForanea);
            case "CertificadoEficiencia":
                return ((CertificadoEficiencia) entidad).filtroForanea(filtroForanea);
            case "CertificadoInforme":
                return ((CertificadoInforme) entidad).filtroForanea(filtroForanea);
            case "CertificadoInspeccion":
                return ((CertificadoInspeccion) entidad).filtroForanea(filtroForanea);
            case "Edificacion":
                return ((Edificacion) entidad).filtroForanea(filtroForanea);
            case "EdificacionResidencial":
                return ((EdificacionResidencial) entidad).filtroForanea(filtroForanea);
            case "EdificacionNoResidencial":
                return ((EdificacionNoResidencial) entidad).filtroForanea(filtroForanea);
            case "Presupuesto":
                return ((Presupuesto) entidad).filtroForanea(filtroForanea);
            case "PresupuestoLinea":
                return ((PresupuestoLinea) entidad).filtroForanea(filtroForanea);
            default:
                throw new Error("El tipo: " + entidad.getClass().getName() + " no tiene implementación por defecto. Filtro foreign");
        }
    }

    private boolean filtroEstandar(IEntidad entidad, IFiltro filtro) {

        if (filtro == null) return true;

        String name = entidad.getClass().getName();
        Integer lastSegment = name.lastIndexOf(".") + 1;
        String type = name.substring(lastSegment);

        switch(type) {
            case "Administrador":
                return ((Administrador) entidad).filtrar(filtro);
            case "Arquitecto":
                return ((Arquitecto) entidad).filtrar(filtro);
            case "Aparejador":
                return ((Aparejador) entidad).filtrar(filtro);
            case "Contable":
                return ((Contable) entidad).filtrar(filtro);
            case "Cliente":
                return ((Cliente) entidad).filtrar(filtro);
            case "Trabajo":
                return ((Trabajo) entidad).filtrar(filtro);
            case "Proyecto":
                return ((Proyecto) entidad).filtrar(filtro);
            case "Certificado":
                return ((Certificado) entidad).filtrar(filtro);
            case "ProyectoResidencial":
                return ((ProyectoResidencial) entidad).filtrar(filtro);
            case "ProyectoNoResidencial":
                return ((ProyectoNoResidencial) entidad).filtrar(filtro);
            case "ProyectoRehabilitacion":
                return ((ProyectoRehabilitacion) entidad).filtrar(filtro);
            case "CertificadoHabitabilidad":
                return ((CertificadoHabitabilidad) entidad).filtrar(filtro);
            case "CertificadoEficiencia":
                return ((CertificadoEficiencia) entidad).filtrar(filtro);
            case "CertificadoInforme":
                return ((CertificadoInforme) entidad).filtrar(filtro);
            case "CertificadoInspeccion":
                return ((CertificadoInspeccion) entidad).filtrar(filtro);
            case "Edificacion":
                return ((Edificacion) entidad).filtrar(filtro);
            case "EdificacionResidencial":
                return ((EdificacionResidencial) entidad).filtrar(filtro);
            case "EdificacionResidencialComunitario":
                return ((EdificacionResidencialComunitario) entidad).filtrar(filtro);
            case "EdificacionNoResidencial":
                return ((EdificacionNoResidencial) entidad).filtrar(filtro);
            case "Presupuesto":
                return ((Presupuesto) entidad).filtrar(filtro);
            case "PresupuestoLinea":
                return ((PresupuestoLinea) entidad).filtrar(filtro);
            case "Dia":
                return ((Dia) entidad).filtrar(filtro);
            default:
                throw new Error("El tipo: " + entidad.getClass().getName() + " no tiene implementación por defecto. Filtro estandar");
        }
    }

    // TODO se puede quitar si no se usa
    private String comoRegistro(EntidadTipos tipo, IEntidad entidad) {
        String linea;
        switch(tipo) {
            case Administrador:
                linea = ((Administrador) entidad).comoRegistro();
                break;
            case Arquitecto:
                linea = ((Arquitecto) entidad).comoRegistro();
                break;
            case Aparejador:
                linea = ((Aparejador) entidad).comoRegistro();
                break;
            case Contable:
                linea = ((Contable) entidad).comoRegistro();
                break;
            case Cliente:
                linea = ((Cliente) entidad).comoRegistro();
                break;
            case Proyecto:
                linea = ((Proyecto) entidad).comoRegistro();
                break;
            case Certificado:
                linea = ((Certificado) entidad).comoRegistro();
                break;
            case ProyectoResidencial:
                linea = ((ProyectoResidencial) entidad).comoRegistro();
                break;
            case ProyectoNoResidencial:
                linea = ((ProyectoNoResidencial) entidad).comoRegistro();
                break;
            case ProyectoRehabilitacion:
                linea = ((ProyectoRehabilitacion) entidad).comoRegistro();
                break;
            case CertificadoHabitabilidad:
                linea = ((CertificadoHabitabilidad) entidad).comoRegistro();
                break;
            case CertificadoEficiencia:
                linea = ((CertificadoEficiencia) entidad).comoRegistro();
                break;
            case CertificadoInforme:
                linea = ((CertificadoInforme) entidad).comoRegistro();
                break;
            case CertificadoInspeccion:
                linea = ((CertificadoInspeccion) entidad).comoRegistro();
                break;
            case Edificacion:
                linea = ((Edificacion) entidad).comoRegistro();
                break;
            case EdificacionResidencial:
                linea = ((EdificacionResidencial) entidad).comoRegistro();
                break;
            case EdificacionResidencialComunitario:
                linea = ((EdificacionResidencialComunitario) entidad).comoRegistro();
                break;
            case EdificacionNoResidencial:
                linea = ((EdificacionNoResidencial) entidad).comoRegistro();
                break;
            case Presupuesto:
                linea = ((Presupuesto) entidad).comoRegistro();
                break;
            case PresupuestoLinea:
                linea = ((PresupuestoLinea) entidad).comoRegistro();
                break;
            default:
                linea = "El tipo: " + tipo + " no tiene implementación por defecto. Impresión de registro.";  
        }
        return linea;
    }

    @Override
    public String imprimir(EntidadTipos tipo, IEntidad filtroForanea) {

        List<IEntidad> entidades = getEntidades(tipo, filtroForanea, null);
        return imprimirLista(tipo, entidades);
    }

    /**
     * Imprime en pantalla una tabla con cabecera y una línea por cada registro
     * existente del tipo indicado.
     */
    @Override
    public String imprimir(EntidadTipos tipo) {

        List<IEntidad> entidades = getEntidades(tipo, null, null);
        return imprimirLista(tipo, entidades);
    }

    @Override
    public boolean existe(int id) {
        return buscarPorId(id) != null;
    }

    @Override
    public boolean existe(EntidadTipos tipo, String id) {
        return buscarPorId(tipo, id) != null;
    }

    @Override
    public IEntidad buscarPorId(EntidadTipos tipo, String id) {

        int intId;
        try {
            intId = Integer.valueOf(id);
        } catch(NumberFormatException ex) {
            return null;
        }

        Filtro filtro = new Filtro((entidad) -> {
            return entidad.getId() == intId;
        });
        List<IEntidad> lista = getEntidades(tipo, null, filtro);
        if (lista.size() > 0) return lista.get(0);
        else return null;
    }

    @Override
    public List<IEntidad> buscarPorCampo(EntidadTipos tipo, CamposEnum campo, String valorFiltro) {

        Filtro filtro = new Filtro((entidad) -> {
            ICampo c = entidad.getCampo(campo);
            if (c == null) return false;
            return c.valorComoEtiqueta().contains(valorFiltro);
        });
        List<IEntidad> lista = getEntidades(tipo, null, filtro);
        return lista;
    }

    @Override
    public IEntidad buscarPorId(String id) {

        try {
            int valor = Integer.valueOf(id);
            return buscarPorId(valor);
        } catch(NumberFormatException ex) {
            // pass
        }
        return null;
    }

    @Override
    public IEntidad buscarPorId(int id) {
        String searchKey = "" + id;
        boolean encontrado = registros.containsKey(Integer.valueOf(searchKey));
        if (encontrado) {
            return registros.get(id);
        } else {
            return null;
        }

    }

    @Override
    public boolean borrar(int id) {
        registros.remove(id);
        return true;
    }

    @Override
    public boolean borrar(String id) {
        try {
            int valor = Integer.valueOf(id);
            registros.remove(valor);
            return true;
        } catch(NumberFormatException ex) {
            // pass
        }

        return false;
    }

    @Override
    public boolean editar(IEntidad entidad) {
        registros.put(entidad.getId(), entidad);
        return true;
    }

    @Override
    public IEntidad porDefecto(EntidadTipos tipo) {

        int newId = getNewId();

        switch(tipo) {
            case Empleado:
                return new Empleado(newId);
            case Administrador:
                return new Administrador(newId);
            case Arquitecto:
                return new Arquitecto(newId);
            case Aparejador:
                return new Aparejador(newId);
            case Contable:
                return new Contable(newId);
            case Cliente:
                return new Cliente(newId);

            case Proyecto:
                return new Proyecto(newId);
            case ProyectoResidencial:
                return new ProyectoResidencial(newId);
            case ProyectoNoResidencial:
                return new ProyectoNoResidencial(newId);
            case ProyectoRehabilitacion:
                return new ProyectoRehabilitacion(newId);

            case Certificado:
                return new Certificado(newId);
            case CertificadoHabitabilidad:
                return new CertificadoHabitabilidad(newId);
            case CertificadoEficiencia:
                return new CertificadoEficiencia(newId);
            case CertificadoInforme:
                return new CertificadoInforme(newId);
            case CertificadoInspeccion:
                return new CertificadoInspeccion(newId);
            case Edificacion:
                return new Edificacion(newId);
            case EdificacionResidencial:
                return new EdificacionResidencial(newId);
            case EdificacionNoResidencial:
                return new EdificacionNoResidencial(newId);
            case EdificacionResidencialComunitario:
                return new EdificacionResidencialComunitario(newId);
            case Presupuesto:
                return new Presupuesto(newId);
            case PresupuestoLinea:
                return new PresupuestoLinea(newId);
            case Dia:
                return new Dia(newId);
            default:
                System.out.println("El tipo: " + tipo + " no tiene implementación por defecto. Creación de objeto");
         }
         return null;
    }

    @Override
    public List<IOpcion> opciones(EntidadTipos tipo) {

        int newId = getNewId();

        switch(tipo) {
            case Empleado:
                return new Empleado(newId).camposComoOpciones();
            case Administrador:
                return new Administrador(newId).camposComoOpciones();
            case Arquitecto:
                return new Arquitecto(newId).camposComoOpciones();
            case Aparejador:
                return new Aparejador(newId).camposComoOpciones();
            case Contable:
                return new Contable(newId).camposComoOpciones();
            case Cliente:
                return new Cliente(newId).camposComoOpciones();

            case Proyecto:
                return new Proyecto(newId).camposComoOpciones();
            case ProyectoResidencial:
                return new ProyectoResidencial(newId).camposComoOpciones();
            case ProyectoNoResidencial:
                return new ProyectoNoResidencial(newId).camposComoOpciones();
            case ProyectoRehabilitacion:
                return new ProyectoRehabilitacion(newId).camposComoOpciones();

            case Certificado:
                return new Certificado(newId).camposComoOpciones();
            case CertificadoHabitabilidad:
                return new CertificadoHabitabilidad(newId).camposComoOpciones();
            case CertificadoEficiencia:
                return new CertificadoEficiencia(newId).camposComoOpciones();
            case CertificadoInforme:
                return new CertificadoInforme(newId).camposComoOpciones();
            case CertificadoInspeccion:
                return new CertificadoInspeccion(newId).camposComoOpciones();

            case Edificacion:
                return new Edificacion(newId).camposComoOpciones();
            case EdificacionResidencial:
                return new EdificacionResidencial(newId).camposComoOpciones();
            case EdificacionNoResidencial:
                return new EdificacionNoResidencial(newId).camposComoOpciones();
            default:
                System.out.println("El tipo: " + tipo + " no tiene implementación por defecto. Definición de opciones");
         }
         return null;
    }

    @Override
    public boolean agregar(IEntidad entidad) {
        registros.put(entidad.getId(), entidad);
        lastID = entidad.getId();

        // for(Map.Entry<Integer, IEntidad> entry: registros.entrySet()) {
        //     IEntidad e = entry.getValue();
        //    Pantalla.volcar(e.getId() + ", " + e.getTipo());
        //}

        return true;
    }

    @Override
    public String imprimir(EntidadTipos tipo, IFiltro filtro) {
        List<IEntidad> entidades = getEntidades(tipo, null, filtro);
        return imprimirLista(tipo, entidades);
    }

    @Override
    public List<IEntidad> buscar(EntidadTipos tipo, IFiltro filtro) {
        return getEntidades(tipo, null, filtro);
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





