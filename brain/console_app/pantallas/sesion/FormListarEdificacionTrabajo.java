package console_app.pantallas.sesion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import console_app.interfaces.entidades.IEntidad;
import console_app.interfaces.personas.IEmpleado;
import console_app.interfaces.trabajos.IEdificacion;
import console_app.interfaces.trabajos.ITrabajo;
import console_app.pantallas.aplicacion.MenuFormulario;
import console_app.pantallas.aplicacion.Pantalla;
import console_app.servicios.Io;
import console_app.tipos.entidades.Entidad;
import console_app.tipos.entidades.EntidadTipos;
import console_app.tipos.entidades.Filtro;

/**
 * Lista todos los trabajos por cada edificio.
 *
 * @author Jaime Sánchez
 * @version 1.0.0
 */
public class FormListarEdificacionTrabajo extends MenuFormulario
{
    public FormListarEdificacionTrabajo(IEmpleado usuario)
    {
        super(usuario, EntidadTipos.Edificacion);

        titulo = Io.TITULO_LISTAR_VIVIENDAS_TRABAJO;

    }

    public String pedirOpcion() {
        return Pantalla.volcar(
            listaAPantalla(
                obtenerDatos()
            )
        );
    }

    private String listaAPantalla(Map<IEdificacion, List<ITrabajo>> datos) {
        String impresion = "";
        String n = "\n";
        int totalRegistros = 0;
        // boolean primero = true;
        for(IEntidad edificacion: datos.keySet()) {
            impresion += n;
            // if (primero) {
                impresion += n + Io.CAMPO_EDIFICACION + ":" + edificacion.comoRegistroCabecera();
                // primero = false;
            // }
            impresion += n + Io.CAMPO_EDIFICACION + ":" + edificacion.comoRegistro();

            List<ITrabajo> trabajosDelCliente = datos.get(edificacion);
            for(ITrabajo trabajo: trabajosDelCliente) {
                impresion += n;
                impresion += n + " .. " + trabajo.comoResumen();
                impresion += n + " .. " + trabajo.comoRegistroCabecera();
                impresion += n + " .. " + trabajo.comoRegistro();

                totalRegistros++;
            }

        }

        impresion += n;
        impresion += String.format(Io.ETIQUETA_IMPRESION_TOTAL, totalRegistros);
        return impresion;
    }

    private Map<IEdificacion, List<ITrabajo>> obtenerDatos() {
        Map<IEdificacion, List<ITrabajo>> registros = new HashMap<>();

        // Recuperar todos los Trabajos
        Filtro filtroTrabajos = new Filtro((entidad) -> {
            return true;
        });
        List<ITrabajo> trabajos = Entidad
            .buscar(EntidadTipos.Trabajo, filtroTrabajos)
            .stream()
            .map(entidad -> (ITrabajo) entidad)
            .collect(Collectors.toList());

        for(ITrabajo trabajo: trabajos) {
            IEdificacion edificacion;

            Optional<IEdificacion> find = registros
                .keySet()
                .stream()
                .filter((c) -> c.getIdS().equals(trabajo.getEdificacion().getIdS()))
                .findFirst();

            List<ITrabajo> proyectosDelEdificio;

            if (find.isPresent()) {
                edificacion = find.get();
                proyectosDelEdificio = registros.get(edificacion);
            } else {
                edificacion = trabajo.getEdificacion();
                proyectosDelEdificio = new ArrayList<>();

            }
            proyectosDelEdificio.add(trabajo);
            registros.put(edificacion, proyectosDelEdificio);
        }

        return registros;
    }

}
