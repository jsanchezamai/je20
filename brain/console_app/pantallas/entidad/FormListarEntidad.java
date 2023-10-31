package console_app.pantallas.entidad;

import console_app.interfaces.entidades.IEntidad;
import console_app.interfaces.personas.IEmpleado;
import console_app.pantallas.aplicacion.MenuFormulario;
import console_app.pantallas.aplicacion.Pantalla;
import console_app.servicios.Io;
import console_app.tipos.entidades.Entidad;
import console_app.tipos.entidades.EntidadTipos;
import console_app.tipos.entidades.Filtro;

/**
 * Muestra por pantalla una lista seleccionable de los registros existentes
 * con {@link console_app.tipos.entidades.EntidadTipos}.
 *
 * @author Jaime Sánchez
 * @version 1.0.0
 */
public class FormListarEntidad extends MenuFormulario
{
    public FormListarEntidad(IEmpleado usuario, EntidadTipos tipo)
    {
        super(usuario, tipo);

        titulo = String.format(Io.TITULO_LISTAR, tipo);

    }

    public FormListarEntidad(IEmpleado usuario, EntidadTipos tipo, IEntidad foraneaEntidad)
    {
        super(usuario, tipo, foraneaEntidad);

        titulo = String.format(Io.TITULO_LISTAR, tipo);

    }

    public FormListarEntidad(IEmpleado usuario, EntidadTipos tipo, Filtro filtro) {
        super(usuario, tipo, filtro);

        titulo = String.format(Io.TITULO_LISTAR + Io.TITULO_FILTRADO_POR, tipo, filtro.getEtiqueta());
    }

    public String pedirOpcion() {

        String impresion = "";

        if (foraneaEntidad != null) impresion = Entidad.imprimir(tipo, foraneaEntidad);
        else if (filtro != null) impresion = Entidad.imprimir(tipo, filtro);
        else impresion = Entidad.imprimir(tipo);

        return Pantalla.volcar(impresion);
    }
}
