package console_app.interfaces.entidades;
import java.util.List;

import console_app.interfaces.entidades.Campos.CamposEnum;
import console_app.interfaces.pantallas.IOpcion;
import console_app.tipos.entidades.EntidadTipos;

/**
 * Representación genérica de un conjunto de {@link console_app.interfaces.entidades.ICampo} producida por {@link console_app.interfaces.entidades.IFactoriaEntidad} 
 * funcionando como estructura para {@link console_app.interfaces.personas.IPersona}, {@link console_app.interfaces.trabajos.IProyecto} o {@link console_app.interfaces.trabajos.ICertificado}.
 * 
 * Provee acceso a la capa de persistencia, {@poo console_app.servicios.AlmacenVolatil} y 
 * a la pantalla a través de {@link console_app.pantallas.entidad.MenuEntidad}.
 * 
 * Se implementa como servicio conectado al backend para la persistencia.
 *
 * @author Jaime Sánchez
 * @version 1.0.0 
 */

public interface IEntidad extends IServicio
{
    /**
     * Agrega un campo a la lista de campos de la entidad
     */
    String setCampo(ICampo campo);

    Integer getId();

    String getIdS();

    /**
     * lee el tipo de la entidad
     */
    EntidadTipos getTipo();

    /**
     * Permite establecer el tipo de la entidad
     */
    void setTipo(EntidadTipos tipo);

    /**
     * Getter para {@link console_app.interfaces.entidades.Cammpos.CamposEnum#Nombre}
     */
    String name();

    /**
     * Setter para {@link console_app.interfaces.entidades.Cammpos.CamposEnum#Nombre}
     */
    void name(String valor);

    /**
     * Devuelve el campo asociado a la llave pasada
     */
    ICampo getCampo(CamposEnum llave);

    /**
     * Cuando se está iterando por los campos de la entidad,
     * devuelve el siguiente a partir de un índice
     */
    ICampo campoNext(int indice);

    /**
     * Establecer el valor del campo pasándole un dato
     * introducido por pantalla.
     */
    boolean setCampo(CamposEnum llave, String valor);

    /**
     * Devuelve la representación del campo como cabecera de tabla
     */
    public String comoRegistroCabecera();

    /**
     * Devuelve la representación del campo como línea de tabla
     */
    public String comoRegistro();

    /**
     * Crea la entidad en el registro 
     */
    boolean agregar();

    /**
     * Guarda la entidad en el registro 
     */
    boolean editar();

    /**
     * Borra la entidad en el registro 
     */
    boolean borrar();

    /**
     * Devuelve los campos de esta entidad como
     * opciones para menú de gestión
     */
    List<IOpcion> camposComoOpciones();

    /**
     *  Establece valores iniciales en los campos
     */
    void setValoresDefecto(String[] valores);

    /**
     * Representa el tipo de la entidad como texto para el usuario
     */
    String getTipoComoEtiqueta();
}
