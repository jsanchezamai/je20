package console_app.pantallas.aplicacion;



import console_app.interfaces.entidades.IServicio;
import console_app.servicios.Io;

/**
 * Se complementa con {@link #FactoriaPlantalla} para controlar el acceso lectura/escritura
 * con la línea de consola.
 *
 * @author Jaime Sánchez
 * @version 1.0.0
 */

public class Pantalla implements IServicio
{
    public static FactoriaPantalla consola = new FactoriaPantalla();

    @Override
    public boolean inicializar() {
       Pantalla.consola = new FactoriaPantalla();
       return true;
    }

    /**
     * Envoltorio interfaz IPantalla
     */
    public static void limpiar() {
        Pantalla.consola.limpiar();
    }

    /**
     * Envoltorio interfaz IPantalla
     */
    public static void titulo(String mensaje) {
        Pantalla.consola.titulo(mensaje);
    }

    /**
     * Envoltorio interfaz IPantalla
     */
    public static void opcion(String opcion) {
        Pantalla.consola.opcion(opcion);;
    }

    /**
     * Envoltorio interfaz IPantalla
     */
    public static String pedirOpcion(String mensaje) {
        return Pantalla.consola.pedirOpcion(mensaje);
    }

    /**
     * Envoltorio interfaz IPantalla
     */
    public static String pedirDato(String etiqueta, String valor, boolean sugerido) {
        return Pantalla.consola.pedirDato(etiqueta, valor, sugerido);
    }

    /**
     * Envoltorio interfaz IPantalla
     */
    public static String volcar(String mensaje) {
        return Pantalla.consola.volcar(mensaje);
    }

    /**
     * Envoltorio interfaz IPantalla
     */
    public static String pausar() {
        return Pantalla.consola.pausar();
    }

    /**
     * Envoltorio interfaz IPantalla
     */
    public static String esperar() {
        return Pantalla.consola.esperar();
    }

    /**
     * Envoltorio interfaz IPantalla
     */
    public static String confirmar(String mensaje) {
        return Pantalla.consola.eco(Io.PULSE_PARA_CONFIRMAR, mensaje);
    }

    /**
     * Envoltorio interfaz IPantalla
     */
    public static String continuar() {
        return Pantalla.consola.eco(Io.PULSE_PARA_CONTINUAR, "");
    }

    /**
     * Envoltorio interfaz IPantalla
     */
    public static String info(String mensaje) {
        return Pantalla.consola.eco(Io.MENSAJE_INFO + Io.PULSE_PARA_CONTINUAR, mensaje);
    }

    /**
     * Envoltorio interfaz IPantalla
     */
    public static String alerta(String mensaje) {
        return Pantalla.consola.eco(Io.MENSAJE_ALERTA, mensaje);
    }

    /**
     * Envoltorio interfaz IPantalla
     */
    public static String error(String mensaje) {
        return Pantalla.consola.eco(Io.MENSAJE_ERROR, mensaje);
    }

    /**
     * Envoltorio interfaz IPantalla
     */
    public static String confirmacion(String mensaje) {
        return Pantalla.consola.eco(Io.MENSAJE_CONFIRMACION, mensaje);
    }

    /**
     * Envoltorio interfaz IPantalla
     */
    public static String eco(String plantilla, String mensaje) {
        return Pantalla.consola.eco(plantilla, mensaje);
    }

    @Override
    public void test(String[] secuencia) {
        Pantalla.consola.test(secuencia);
    }

    @Override
    public void test(String secuencia) {
        Pantalla.consola.test(secuencia);
    }

    @Override
    public int testSize() {
        return Pantalla.consola.testSize();
    }

    @Override
    public void testMode(boolean b) {
        Pantalla.consola.testMode(b);
    }

    @Override
    public void inputTest(boolean b) {
        Pantalla.consola.inputTest(b);
    }
}
