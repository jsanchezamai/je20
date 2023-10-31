package console_app.interfaces.entidades;

import java.util.function.Function;

import console_app.tipos.entidades.Entidad;

/**
 * Definición de una condición de búsqueda para obtener conjuntos de
 * {@link console_app.interfaces.entidades.IEntidad} que cumplan la condición.
 */
public interface IFiltro {

    /**
     * Título para identificar en la pantalla que un conjunto ha sido filtrado
     * por este filtro
     */
    public String getEtiqueta();

    /**
     * Función encargada de ejecutar el filtro.
     *
     * @param entidad El elemento que será evaluado 
      */
    public boolean aplicar(Entidad entidad);

    /**
     * La implementación del filtro por la clase llamante deberá
     * proveer una función "criterio" que devuelva si dada una {@link console_app.interfaces.entidades.IEntidad} cumple o 
     * no el criterio.
     */
    Function<IEntidad, Boolean> getFiltro() ;
}
