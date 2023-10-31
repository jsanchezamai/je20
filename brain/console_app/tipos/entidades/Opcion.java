package console_app.tipos.entidades;

import console_app.interfaces.pantallas.IOpcion;

/**
 * Write a description of class Opcion here. 
 * 
 * @author Jaime Sánchez
 * @version 1.0.0
 */
public class Opcion implements IOpcion, Comparable<IOpcion>
{
    String entrada =  "";
    String llave =  "";
    EntidadTipos llaveTipo;
    String etiqueta =  "";
    private boolean seleccionable;

    public Opcion(String etiqueta, String llave, EntidadTipos llaveTipo) {
        this.etiqueta = etiqueta;
        this.llave = llave;
        this.llaveTipo = llaveTipo;
        this.entrada = llave;
    }

    public Opcion(String etiqueta, String llave) {
        this.etiqueta = etiqueta;
        this.llave = llave;
        this.entrada = llave;
    }

    public Opcion(String etiqueta, String llave, boolean seleccionable) {
        this.etiqueta = etiqueta;
        this.llave = llave;
        this.entrada = llave;
        this.seleccionable = seleccionable;
    }

    public Opcion(String etiqueta, int llave) {
        this.etiqueta = etiqueta;
        this.llave = "" + llave;
        this.entrada = "" + llave;
    }

    public Opcion() {
    }

    /**
     * Interfaz IOpcion
     */
    public String etiqueta() {
        return this.etiqueta;
    };

    public void etiqueta(String etiqueta) {
        this.etiqueta += etiqueta;
    };

    /**
     * Interfaz IOpcion
     */
    public EntidadTipos llaveTipo() {
        return llaveTipo;
    }

    /**
     * Interfaz IOpcion
     */
    public String llave() {
        return llave;
    }

    /**
     * Interfaz IOpcion
     */
    public String entrada() {
        return this.entrada;
    }

    /**
     * Interfaz IOpcion
     */
    public void entrada(String argumentos) {
        entrada = argumentos;
    }

    @Override
    public int compareTo(IOpcion arg0) {
        try {
            return Integer.compare(Integer.valueOf(llave()), Integer.valueOf(arg0.llave()));
        } catch(Exception e) {
            return 1;
        }
    }

    @Override
    public boolean seleccionable() {
        return seleccionable;
    }
}
