package console_app.pantallas.aplicacion;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import console_app.Tester;
import console_app.interfaces.pantallas.IPantalla;
import console_app.servicios.Io;

/**
 * Controlador de comunicación entre la aplicación y la {@link console_app.interfaces.pantallas.IPantalla}.
 * 
 * Provee métodos para enviar información a la pantalla y para recibirla.
 *
 * @author Jaime Sánchez
 * @version 1.0.0
 */
public class FactoriaPantalla implements IPantalla
{
    private List<String> secuencia = new ArrayList<>();

    private void println(String eco) {
        if (this.testMode) {

        } else {
            System.out.println(eco);
        }
    }

    @Override
    public boolean inicializar() {
        return true;
    }

    @Override
    public void limpiar() {
        println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        System.out.flush();
    }

    @Override
    public void titulo(String mensaje) {
        String eco = String.format(Io.NUEVA_LINEA, mensaje);
        println(eco);
    }

    @Override
    public void opcion(String opcion) {
        println(opcion);
    }

    @Override
    public String pedirOpcion(String mensaje) {
        return eco(Io.PULSE_OPCION, mensaje);
    }

    @Override
    public String pedirDato(String etiqueta, String valor, boolean sugerido) {
        String texto;

        if (sugerido) {
            texto = String.format(Io.MENSAJE_FORM_PEDIR_CAMPO_SUGERIDO, etiqueta, valor, Io.PULSE_PARA_AVANZAR);
        } else
        {
            texto = String.format(Io.MENSAJE_FORM_PEDIR_CAMPO, etiqueta);
        }

        return eco(texto, "");
    }

    @Override
    public String volcar(String mensaje) {
        println(mensaje);
        return "";
    }

    @Override
    public String pausar() {
        return eco("", "");
    }

    @Override
    public String esperar() {
        return eco(Io.PULSE_ENTER_PARA_SALIR + Io.SELECCIONAR_OPCION, "");
    }

    @Override
    public String confirmar(String mensaje) {
        return eco(Io.PULSE_PARA_CONFIRMAR, mensaje);
    }

    @Override
    public String continuar() {
        return eco(Io.PULSE_PARA_CONTINUAR, "");
    }

    @Override
    public String info(String mensaje) {
        return eco(Io.MENSAJE_INFO + Io.PULSE_PARA_CONTINUAR, mensaje);
    }

    @Override
    public String alerta(String mensaje) {
        return eco(Io.MENSAJE_ALERTA, mensaje);
    }

    @Override
    public String error(String mensaje) {
        return eco(Io.MENSAJE_ERROR, mensaje);
    }

    @Override
    public String confirmacion(String mensaje) {
        return eco(Io.MENSAJE_CONFIRMACION, mensaje);
    }

    @Override
    public String eco(String plantilla, String mensaje) {
        String eco = String.format(plantilla, mensaje);

        if (!this.testMode) System.out.println(eco);
        return leer();
    }

    @Override
    public void test(String[] secuencia) {
        for(String opcion: secuencia) {
            this.secuencia.add(opcion);
        }
    }

    @Override
    public void test(String secuencia) {
        this.secuencia.add(secuencia);
    }

    int testStep = 0;
    private boolean testMode;
    private boolean inputTest;

    /**
     * Método para input automatizado. La variable {@code #secuencia} contiene
     * una lista de "entradas" que deberán ser ejecutadas una a una, en orden,
     * simulando la interacción del usuario.
     */
    public String leer() {
        if(secuencia.size() > 0) {
            return this.usarSecuenciasDeTest();
        } else {
            testMode(false);
            return scanear();
        }
    }

    private String usarSecuenciasDeTest() {
        testStep++;

        String sec = secuencia.get(0);

        if (sec.equals("testModeOff")) {
            this.testMode = false;
            sec = secuencia.set(0, "");
        }
        if (this.inputTest) System.out.println(sec);

        int editEdificioResidencial = 564;
        if (testStep > Tester.NIVEL6) {
            String a = "";
            a = a;
        }
        return secuencia.remove(0);
    }

    /**
     * Toma un dato de la pantalla
     *
     * @return El dato introducido por el usuario.
     */
    public String scanear() {
        Scanner s = new Scanner(System.in);
        String str = s.nextLine();
        return str;
    }

    @Override
    public int testSize() {
        return secuencia.size();
    }

    @Override
    public void testMode(boolean b) {
        this.testMode = b;
    }

    @Override
    public void inputTest(boolean b) {
        this.inputTest = b;
    }
}
