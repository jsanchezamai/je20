package console_app.interfaces.pantallas;
import java.util.List;

import console_app.interfaces.entidades.IEntidad;
import console_app.interfaces.entidades.IServicio;
import console_app.interfaces.entidades.Campos.CamposEnum;
import console_app.tipos.entidades.EntidadTipos;
import console_app.tipos.entidades.Filtro;

/**
 * La clase principal de la solución. Deberá incializar los {@link console_app.interfaces.entidades.IServicio} e iniciar
 * el bucle principal con el primer menú {@link console_app.pantallas.sesion.MenuInicial}.
 *
 * @author Jaime Sánchez
 * @version 1.0.0
 */

public interface IAplicacion
{
    /**
     * Ver {@link IServicio}.
     * @return Servicios configurados en la aplicación.
     */
    List<IServicio> getServicios();

    /**
     * Ver {@link IServicio}.
     * @return Si la aplicación ha podido cargar los servicios correctamente.
     */
    boolean inicializarServicios();

    /**
     * Ver {@link IMenu}.
     * @return El nodo raíz del árbol de menús que maneja la aplicación.
     */
    IMenu getMenu();

    /**
     * El nodo raíz del árbol de menús inicia su bucle.
     */
    void buclePrincipal();

    List<IEntidad> getAlmacen();

    List<IEntidad> getAlmacen(EntidadTipos tipo, Filtro filtro);

    List<IEntidad> buscarPorCampo(EntidadTipos tipo, CamposEnum campo, String valorFiltro);
}

