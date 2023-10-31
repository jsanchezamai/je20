package console_app.interfaces.entidades;
import java.util.Date;

import console_app.interfaces.entidades.Campos.CamposEnum;
import console_app.interfaces.pantallas.IOpcion;
import console_app.interfaces.personas.IEmpleado;
import console_app.tipos.entidades.TiposDato;

/**
 * Representa un atributo de la {@link console_app.interfaces.entidades.IEntidad} tanto desde la perspectiva de usuario
 * como de aplicación.
 * 
 * Características:
 * 
 * - Es de un y solo un {@link console_app.tipos.entidades.TiposDato}.
 * - La inicialización de su valor se produce a partir de String, independiente de su TiposDato,
 * representando la entrada por consola del usuario. El dato deberá ser convertido al tipo correspondiente.
 * - Es listable. La función {@link #etiqueta()} devuelve su título en pantalla.
 * - Es representable como {@link console_app.interfaces.pantallas.IOpcion}, es decir, 
 * puede formar parte de un {@link console_app.pantallas.aplicacion.MenuFormulario}.
 * 
 * Ejemplo de invocación:
 * 
      String llaveApellido = setCampo(new Campo(Io.CAMPO_APELLIDO, TiposDato.Cadena));
 * 
 * Ejemplo de establecimiento de valor:
 * 
    public void setApellido(String valor) {
        this.campo(llaveApellido, valor);
    }
 *
 * Ejemplo de lectura de valor:
 * 
    public String getApellido(String valor) {
        this.campo(llaveApellido).valorCadena();
    }
 *
 * @author Jaime Sánchez
 * @version 1.0.0
 */
public interface ICampo
{
    String etiqueta();

    public TiposDato tipo();

    CamposEnum getLlave();
    void setLlave(CamposEnum llave);

    public String valorCadena();

    public Integer valorNumerico();

    public Float valorDecimal();

    public Date valorFecha();

    public Boolean valorBoleano();

    public void valorCadena(String valor);

    public void valorDecimal(Float valor);

    public void valorNumerico(Integer valor);

    public void valorFecha(Date valor);

    public void valorBoleano(Boolean valor);

    String valorNMForanea();

    String valorForanea();

    public IOpcion comoOpcion();

    public String valorComoEtiqueta();

    boolean setValor(String valor);

    void setVisible(boolean visible);

    boolean getVisible();

    Class<?> getEditor();

    boolean puedeEditar(IEmpleado usuario);

    ICampo clone();
}
