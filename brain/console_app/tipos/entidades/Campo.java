package console_app.tipos.entidades;

import java.util.Date;

import console_app.interfaces.pantallas.IOpcion;
import console_app.interfaces.personas.IEmpleado;
import console_app.interfaces.trabajos.IEdificacion;
import console_app.interfaces.entidades.ICampo;
import console_app.interfaces.entidades.IEntidad;
import console_app.interfaces.entidades.Campos.CamposEnum;
import console_app.pantallas.aplicacion.Pantalla;
import console_app.servicios.Io;
import console_app.tipos.personas.Administrador;
import console_app.tipos.trabajos.EficienciaTipos;

/**
 * Un ICampo es un atributo de la clase {@link console_app.interfaces.entidades.IEntidad},
 * representa una propiedad. Ver {@link console_app.interfaces.entidades.ICampo}.
 *
 * @author Jaime Sánchez
 * @version 1.0.0
 */
public class Campo implements ICampo, Cloneable
{
    private String etiqueta;
    private CamposEnum llave;

    private Boolean valorBoleano = false;
    private String valorCadena = "";
    private Integer valorNumerico = 0;
    private Date valorFecha;
    private TiposDato tipo;
    private boolean requerido;
    private boolean visible = true;
    private Float valorDecimal;
    private Class<?> editor;

    /**
     *
     * @param etiqueta En procesos de edición, el título asociado al campo.
     * @param tipo El tipo de dato del campo.
     * @param requerido Cierto si se puede dejar vacío.
     * @param porDefecto En procesos de edición, el valor sugerido.
     * @param editor Representa la clase de IEmpleado que tiene permisos de escritura en el campo.
     */
    public Campo(CamposEnum llave, String etiqueta, TiposDato tipo, boolean requerido, String porDefecto, Class<?> editor) {
        this.editor = editor;
        inicializar(llave, etiqueta, tipo, requerido, porDefecto, editor);
    }

    public Campo(CamposEnum llave, String etiqueta, TiposDato tipo, boolean requerido) {
        inicializar(llave, etiqueta, tipo, requerido, null, null);
    }

    public Campo(CamposEnum llave, String etiqueta, TiposDato tipo) {
        inicializar(llave, etiqueta, tipo, false, null, null);
    }

    public Campo(CamposEnum llave, String etiqueta, TiposDato tipo, Class<?> editor) {
        inicializar(llave, etiqueta, tipo, false, null, editor);
    }

    public Campo(CamposEnum llave, String etiqueta, TiposDato tipo, boolean requerido, boolean visible) {
        this.visible = visible;
        inicializar(llave, etiqueta, tipo, requerido, null, null);
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public boolean getVisible() {
        return this.visible;
    }

    private void inicializar(CamposEnum llave, String etiqueta, TiposDato tipo, boolean requerido, String porDefecto, Class<?> editor) {
        this.llave = llave;
        this.etiqueta = etiqueta;
        this.tipo = tipo;
        this.requerido = requerido;
        if (porDefecto != null && !porDefecto.isEmpty()) {
            setValor(porDefecto);
        }
        this.editor = editor;
    }

    @Override
    public String etiqueta() {
        return this.etiqueta;
    }

    @Override
    public TiposDato tipo() {
        return this.tipo;
    }

    @Override
    public CamposEnum getLlave() {
        return this.llave;
    }

    @Override
    public void setLlave(CamposEnum llave) {
        this.llave = llave;
    }

    @Override
    public String valorCadena() {

        switch(tipo) {
            case Fecha:
               return Fecha.fechaComoCadena(valorFecha());
            default:
                return valorCadena;
        }
    }

    @Override
    public void valorCadena(String valor) {
        valorCadena = valor;
    }

    @Override
    public Integer valorNumerico() {
        return this.valorNumerico;
    }

    @Override
    public void valorNumerico(Integer valor) {
        valorNumerico = valor;
    }

    @Override
    public Float valorDecimal() {
        return valorDecimal;
    }

    @Override
    public void valorDecimal(Float valor) {
        valorDecimal = valor;
    }

    @Override
    public Date valorFecha() {
        return valorFecha;
    }

    @Override
    public void valorFecha(Date valor) {
        valorFecha = valor;
    }

    @Override
    public Boolean valorBoleano() {
        return this.valorBoleano;
    }

    @Override
    public void valorBoleano(Boolean valor) {
        this.valorBoleano = valor;
    }

    @Override
    public String valorNMForanea() {
        return null;
    }

    @Override
    public String valorForanea() {
        return valorCadena();
    }

    @Override
    public IOpcion comoOpcion() {
        return new Opcion(etiqueta, llave.ordinal());
    }

    private EntidadTipos tipoDatoATipoEntidad(TiposDato tipoDato) {
        switch(tipo) {
            case Arquitecto:
                return EntidadTipos.Arquitecto;
            case Aparejador:
                return EntidadTipos.Aparejador;
            case Contable:
                return EntidadTipos.Contable;
            case Cliente:
                return EntidadTipos.Cliente;
            case Edificacion:
                return EntidadTipos.Edificacion;
            case EdificacionResidencial:
                return EntidadTipos.EdificacionResidencial;
            case EdificacionResidencialComunitario:
                return EntidadTipos.EdificacionResidencialComunitario;
            case EdificacionNoResidencial:
                return EntidadTipos.EdificacionNoResidencial;
            case Trabajo:
                return EntidadTipos.Trabajo;
            default:
                Pantalla.error("No se ha implementado el cambio de TipoDato a EntidadTipo para: " + tipo);
                return null;
        }
    }

    @Override
    public String valorComoEtiqueta() {

        switch(tipo) {
            case Cadena:
                return valorCadena == null ? "" : valorCadena;
            case Numero:
                return valorNumerico == null ? "" : "" + valorNumerico;
            case Decimal:
                return valorDecimal == null ? "" : "" + valorDecimal;
            case Boleano:
                return valorBoleano ? Io.CIERTO : Io.FALSO;
            case Fecha:
                return valorCadena();
            case Arquitecto:
            case Aparejador:
            case Contable:
            case Cliente:
                    if (valorCadena() == null) return "";
                    IEntidad entidad = Entidad.buscarPorId(tipoDatoATipoEntidad(tipo), valorCadena());
                    if (entidad != null) {
                        return String.format(Io.CAMPO_FORANEA, entidad.getId(), entidad.name());
                    }
                    return "";
            case Edificacion:
            case EdificacionResidencial:
            case EdificacionResidencialComunitario:
            case EdificacionNoResidencial:
                if (valorCadena() == null) return "";
                IEntidad e = Entidad.buscarPorId(tipoDatoATipoEntidad(tipo), valorCadena());
                if (e != null) {
                    IEdificacion edificio = (IEdificacion) e;
                    return String.format(Io.CAMPO_FORANEA, edificio.getId(), edificio.getDireccion());
                }
                return "";
            case EnumeracionEficiencia:
                return valorNumerico == null ? "" : EficienciaTipos.values()[valorNumerico].toString();
            default:
                return valorCadena == null ? "" : valorCadena;
        }
    }

    @Override
    public boolean setValor(String valor) {
        if ((valor == null || valor.isEmpty()) && this.requerido) {
            return false;
        }
        if ((valor == null || valor.isEmpty()) && !this.requerido) {
            return true;
        }
        switch(tipo) {
            case Fecha:
                try {
                    valorFecha(Fecha.stringLocalToDate(valor));
                } catch (java.time.format.DateTimeParseException e) {
                    Pantalla.volcar(String.format(Io.ERROR_ENTRADA_INVALIDA, valor, etiqueta(), Io.TIPO_FECHA));
                    return false;
                }
                break;
            case Numero:
                try {
                    Integer valorNumerico = Integer.valueOf(valor);
                    valorNumerico(valorNumerico);
                } catch(NumberFormatException ex) {
                    Pantalla.volcar(String.format(Io.ERROR_ENTRADA_INVALIDA, valor, etiqueta(), Io.TIPO_NUMERO));
                    return false;
                }
                break;
            case Decimal:
                try {
                    Float valorDecimal = Float.valueOf(valor);
                    valorDecimal(valorDecimal);
                } catch(NumberFormatException ex) {
                    Pantalla.volcar(String.format(Io.ERROR_ENTRADA_INVALIDA, valor, etiqueta(), Io.TIPO_NUMERO));
                    return false;
                }
                break;
            case Arquitecto:
            case Aparejador:
            case Contable:
            case Cliente:
            case Edificacion:
            case EdificacionResidencial:
            case EdificacionResidencialComunitario:
            case EdificacionNoResidencial:
            case Trabajo:
                if (!Entidad.existe(tipoDatoATipoEntidad(tipo), valor)) {
                    Pantalla.volcar(String.format(Io.ERROR_ENTRADA_INVALIDA, valor, etiqueta(), tipo));
                    return false;
                }
                valorCadena(valor);
                break;
            case EnumeracionEficiencia:
                try {
                    // Intentamos castear antes de asignar para ver si existe el 
                    // elemento en la enum, si no, saltará excepción;
                    valorNumerico(EficienciaTipos.valueOf(valor).ordinal());
                } catch (IllegalArgumentException ex) {
                    Pantalla.volcar(String.format(Io.ERROR_ENTRADA_INVALIDA, valor, etiqueta(), tipo));
                    return false;
                }
                break;
            default:
                valorCadena(valor);
        }
        return true;
    }

    @Override
    public Class<?> getEditor() {
        return editor;
    }

    @Override
    public boolean puedeEditar(IEmpleado usuario) {

        if (this.editor == null) {
            return usuario instanceof Administrador;
        } else {
            return usuario.getClass() == editor;
        }
    }

    @Override
    public ICampo clone() {
        ICampo clone;
        try {
            clone = (ICampo) super.clone();
        } catch (CloneNotSupportedException e) {
            return null;
        }
        return clone;
    }
}
