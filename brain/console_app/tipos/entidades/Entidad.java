package console_app.tipos.entidades;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import console_app.interfaces.pantallas.IOpcion;
import console_app.interfaces.entidades.Campos;
import console_app.interfaces.entidades.ICampo;
import console_app.interfaces.entidades.IEntidad;
import console_app.interfaces.entidades.IFactoriaEntidad;
import console_app.interfaces.entidades.IFiltro;
import console_app.interfaces.entidades.IFiltroEntidad;
import console_app.interfaces.entidades.Campos.CamposEnum;
import console_app.pantallas.aplicacion.Pantalla;
import console_app.servicios.Io;

/**
 * Abstract class Entidad - write a description of the class here
 *
 * @author:
 * Date:
 */
public class Entidad implements IEntidad, IFiltroEntidad<IFiltro>
{
    EntidadTipos tipo;
    public int id;

    protected int indiceBase = 1; // Indica el número de campos internos

    protected List<ICampo> campos = new ArrayList<>();

    public static IFactoriaEntidad factoria;

    public static boolean esDeTipo(EntidadTipos tipo1, EntidadTipos tipo2) {

        switch(tipo1) {
            case Proyecto:
                switch(tipo2) {
                    case ProyectoResidencial:
                    case ProyectoNoResidencial:
                    case ProyectoRehabilitacion:
                        return true;
                    default:
                        return false;
                }
            default:
                return false;
        }
    }

    public Entidad () {
        configurar();
    }

    protected Entidad (int id) {
        configurar();
        this.id = id;
    }

    /**
     * Devuelve el número de campos visibles para el usuario 
     * que hay en esta entidad
     */
    protected int numeroCampos() {
        return getVisibleCampos()
           .size() + indiceBase;
    }

    /**
     * Devuelve los campos visibles para el usuario 
     * que hay en esta entidad
     */
    protected List<ICampo> getVisibleCampos() {
        return campos
           .stream()
           .filter(campo -> campo.getVisible())
           .collect(Collectors.toList());
    }

    private void configurar() {
        campos = Campos.cargarCamposEntidad(EntidadTipos.Entidad, this.campos);
    }

    /**
     * {@link console_app.interfaces.entidades.IServicio}
     */
    @Override
    public boolean inicializar() {
       Entidad.factoria = new FactoriaEntidad();
       return true;
    }

    /**
     * {@link console_app.interfaces.entidades.IFactoriaEntidad}
     */
    public static IEntidad porDefecto(EntidadTipos tipo) {
        return Entidad.factoria.porDefecto(tipo);
    }

    /**
     * {@link console_app.interfaces.entidades.IFactoriaEntidad}
     */
    public static IEntidad buscarPorId(int id) {
       return Entidad.factoria.buscarPorId(id);
    }

    /**
     * {@link console_app.interfaces.entidades.IFactoriaEntidad}
     */
    public static IEntidad buscarPorId(String id) {
        return Entidad.factoria.buscarPorId(id);
    }

    /**
     * {@link console_app.interfaces.entidades.IFactoriaEntidad}
     */
    public static IEntidad buscarPorId(EntidadTipos tipo, String id) {
        return Entidad.factoria.buscarPorId(tipo, id);
    }

    /**
     * {@link console_app.interfaces.entidades.IFactoriaEntidad}
     */
    public static List<IEntidad> buscar(EntidadTipos tipo, IFiltro filtro) {
        return Entidad.factoria.buscar(tipo, filtro);
    }

    /**
     * Ver {@link console_app.interfaces.entidades.IFactoriaEntidad}.
     */
    public List<IEntidad> buscarPorCampo(EntidadTipos tipo, CamposEnum campo, String valorFiltro) {

       return Entidad.factoria.buscarPorCampo(tipo, campo, valorFiltro);

    }

    /**
     * {@link console_app.interfaces.entidades.IFactoriaEntidad}
     */
    public static String imprimirLista(EntidadTipos tipo, List<IEntidad> entidades) {
        return Entidad.factoria.imprimirLista(tipo, entidades);
    }

    /**
     * {@link console_app.interfaces.entidades.IFactoriaEntidad}
     */
    public static boolean existe(EntidadTipos tipo, String id) {
        return Entidad.factoria.existe(tipo, id);
    }

    /**
     * {@link console_app.interfaces.entidades.IFactoriaEntidad}
     */
    public static boolean existe(int id) {
        return Entidad.factoria.existe(id);
    }

    /**
     * {@link console_app.interfaces.entidades.IFactoriaEntidad}
     */
    public static String imprimir(EntidadTipos tipo, IFiltro filtro) {
        return Entidad.factoria.imprimir(tipo, filtro);
    }

    /**
     * {@link console_app.interfaces.entidades.IFactoriaEntidad}
     */
    public static String imprimir(EntidadTipos tipo) {

        return Entidad.factoria.imprimir(tipo);
    }

    /**
     * {@link console_app.interfaces.entidades.IFactoriaEntidad}
     */
    public static String imprimir(EntidadTipos tipo, IEntidad filtroForanea) {

        return Entidad.factoria.imprimir(tipo, filtroForanea);
    }

    /**
     * {@link console_app.interfaces.entidades.IFactoriaEntidad}
     */
    @Override
    public List<IOpcion> camposComoOpciones() {
        return campos
           .stream()
           .filter(campo -> campo.getVisible())
           .map(campo -> campo.comoOpcion())
           .sorted()
           .collect(Collectors.toList());
    }

    @Override
    public Integer getId() {
        return id;
    }

    /**
     * {@link console_app.interfaces.entidades.IEntidad}
     */
    @Override
    public EntidadTipos getTipo() {
        return tipo;
    }

    /**
     * {@link console_app.interfaces.entidades.IEntidad}
     */
    @Override
    public void name(String valor) {
        this.setCampo(CamposEnum.Nombre, valor);
    }

    /**
     * {@link console_app.interfaces.entidades.IEntidad}
     */
    @Override
    public String name() {
        return this.getCampo(CamposEnum.Nombre).valorCadena();
    }

    /**
     * {@link console_app.interfaces.entidades.IEntidad}
     */
    @Override
    public void setTipo(EntidadTipos tipo) {
        this.tipo = tipo;
    }

    /**
     * {@link console_app.interfaces.entidades.IEntidad}
     */
    @Override
    public ICampo getCampo(CamposEnum llave) {
        Optional<ICampo> find = campos
            .stream()
            .filter(campo -> campo.getLlave().equals(llave))
            .findFirst();

        if (find.isPresent()) {
            return find.get();
        } else {
            String mensaje = "No encontrado campo con llave: " + llave;
            Pantalla.info(mensaje);
            // TODO Caso no esperado, forzar error, quitar para distribución
            return find.get();
        }

    }

    /**
     * {@link console_app.interfaces.entidades.IEntidad}
     */
    @Override
    public boolean setCampo(CamposEnum llave, String valor) {
        ICampo campo = getCampo(llave);

        if (campo != null) {
            return campo.setValor(valor);
        }
        return false;
    }

    /**
     * {@link console_app.interfaces.entidades.IEntidad}
     */
    @Override
    public String comoRegistroCabecera() {
        String columnas[] = new String[numeroCampos()];
        columnas[0] = Io.CAMPO_ID;
        int i = 1;
        for(ICampo c : getVisibleCampos()) {
            columnas[i++] = c.etiqueta();
        }
        return Io.formatearLinea(columnas);
    }

    /**
     * {@link console_app.interfaces.entidades.IEntidad}
     */
    @Override
    public String comoRegistro() {
        String columnas[] = new String[numeroCampos()];
        columnas[0] = getAbreviatura() + ": " + id;;
        int i = 1;
        for(ICampo c : getVisibleCampos()) {
            columnas[i++] = c.valorComoEtiqueta();
        }
        return Io.formatearLinea(columnas);
    }

    /**
     * {@link console_app.interfaces.entidades.IEntidad}
     */
    @Override
    public boolean agregar() {

        boolean resultado = Entidad.factoria.agregar(this);

        if (resultado) {
            Pantalla.info(String.format(Io.NOTIFICACION_NUEVO, tipo, id));
        } else {
            Pantalla.error(String.format(Io.ERROR_OPERAR, tipo));
        }

        return resultado;
    }

    /**
     * {@link console_app.interfaces.entidades.IEntidad}
     */
    @Override
    public boolean editar() {
        IEntidad existe = Entidad.factoria.buscarPorId(id);
        if (existe != null) {
            boolean resultado = Entidad.factoria.editar(this);
            if (resultado) {
                Pantalla.info(String.format(Io.NOTIFICACION_EDITADO, tipo, id));
            } else {
                Pantalla.error(String.format(Io.ERROR_OPERAR, tipo));
            }

            return true;
        } else {
            return false;
        }
    }

    /**
     * {@link console_app.interfaces.entidades.IEntidad}
     */
    @Override
    public boolean borrar() {

        IEntidad existe = Entidad.factoria.buscarPorId(id);
        if (existe != null) {
            String opcion = Pantalla.confirmar(String.format(Io.CONFIRMACION_BORRADO, id));
            if (opcion.equals("y")) {
                boolean resultado = Entidad.factoria.borrar(this.id);
                if (resultado) {
                    Pantalla.info(String.format(Io.NOTIFICACION_BORRADO, tipo, id));
                } else {
                    Pantalla.error(String.format(Io.ERROR_OPERAR, tipo));
                }
               return resultado;
            }
            return true;
        }

        return false;
    }

    /**
     * {@link console_app.interfaces.entidades.IEntidad}
     */
    @Override
    public boolean filtroForanea(IEntidad id) {
        return true;
    }

    /**
     * {@link console_app.interfaces.entidades.IEntidad}
     */
    @Override
    public void setValoresDefecto(String[] valores) {
    }

    /**
     * {@link console_app.interfaces.entidades.IEntidad}
     */
    @Override
    public boolean filtrar(IFiltro filtro) {
        return filtro.aplicar(this);
    }

    @Override
    public void test(String[] secuencia) {
        // TODO Auto-generated method stub

    }

    @Override
    public void test(String secuencia) {
        // TODO Auto-generated method stub

    }

    /**
     * {@link console_app.interfaces.entidades.IEntidad}
     */
    @Override
    public String setCampo(ICampo campo) {
        campos.add(campo);
        return campo.getLlave().toString();
    }

    /**
     * {@link console_app.interfaces.entidades.IEntidad}
     */
    @Override
    public String getIdS() {
        return "" + getId();
    }
    /**
     * {@link console_app.interfaces.entidades.IEntidad}
     */
    @Override
    public ICampo campoNext(int indice) {
        return getVisibleCampos().get(indice);
    }

    /**
     * {@link console_app.interfaces.entidades.IEntidad}
     */
    @Override
    public String getTipoComoEtiqueta() {
        return  getAbreviatura();
    }

    /**
     * {@link console_app.interfaces.entidades.IEntidad}
     */
    @Override
    public int testSize() {
        return 0;
    }

    @Override
    public void testMode(boolean b) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void inputTest(boolean b) {
        // TODO Auto-generated method stub
        
    }

    private String getAbreviatura() {

        switch(getTipo()) {
            case Administrador:
                return "Adm";
            case Arquitecto:
                return "Arq";
            case Aparejador:
                return "Apa";
            case Contable:
                return "Con";
            case Cliente:
                return "Cli";
            case ProyectoResidencial:
                return "PRes";
            case ProyectoNoResidencial:
                return "PNoR";
            case ProyectoRehabilitacion:
                return "PReh";
            case CertificadoEficiencia:
                return "CEfi";
            case CertificadoHabitabilidad:
                return "CHab";
            case CertificadoInforme:
                return "CInf";
            case CertificadoInspeccion:
                return "CIns";
            case EdificacionResidencial:
                return "ERes";
            case EdificacionResidencialComunitario:
                return "ECom";
            case EdificacionNoResidencial:
                return "ENoRes";
            case Presupuesto:
                return "Pres";
            case PresupuestoLinea:
                return "PreL";
            default:
                return "";
        }
    }


}
