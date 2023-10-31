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
import console_app.interfaces.trabajos.IProyecto;
import console_app.interfaces.trabajos.ITrabajo.Estados;
import console_app.pantallas.aplicacion.MenuFormulario;
import console_app.pantallas.aplicacion.Pantalla;
import console_app.servicios.Io;
import console_app.tipos.entidades.Entidad;
import console_app.tipos.entidades.EntidadTipos;
import console_app.tipos.entidades.Fecha;
import console_app.tipos.entidades.Filtro;
import console_app.tipos.trabajos.Proyecto;
import console_app.tipos.trabajos.ProyectoNoResidencial;
import console_app.tipos.trabajos.ProyectoRehabilitacion;
import console_app.tipos.trabajos.ProyectoResidencial;

/**
 * Lista de edificios con la obra finalizada, entregada o no.
 *
 * @author Jaime Sánchez
 * @version 1.0.0
 */
public class FormListarEdificiosConFinObra extends MenuFormulario
{

    public FormListarEdificiosConFinObra(IEmpleado usuario)
    {
        super(usuario, EntidadTipos.Edificacion);

        titulo = Io.TITULO_LISTAR_VIVIENDAS_FIN_OBRA;

    }

    public String pedirOpcion() {

        return Pantalla.volcar(
            listaAPantalla(
                obtenerDatos()
            )
        );
    }

    private String listaAPantalla(Map<IEdificacion, List<IProyecto>> datos) {

        String impresion = "";
        String n = "\n";
        int totalRegistros = 0;
        boolean primero = true;
        for(IEntidad edificacion: datos.keySet()) {

            if (primero) {
                impresion += n + Io.CAMPO_EDIFICACION + ":" + edificacion.comoRegistroCabecera();
                primero = false;
            }

            impresion += n + Io.CAMPO_EDIFICACION + ":" + edificacion.comoRegistro();

            List<IProyecto> proyectosDelEdificio = datos.get(edificacion);
            for(IProyecto proyecto: proyectosDelEdificio) {

                impresion += n + "   (" + proyecto.getIdS() + ") " + proyecto.getTipo();
                impresion += " >> " + Io.CAMPO_FECHA_FIN + ": " + Fecha.fechaComoCadena(proyecto.getFin());
                totalRegistros++;
            }

        }
        impresion += String.format(Io.ETIQUETA_IMPRESION_TOTAL, totalRegistros);
        return impresion;
    }

    private Map<IEdificacion, List<IProyecto>> obtenerDatos() {

        Map<IEdificacion, List<IProyecto>> registros = new HashMap<>();

        // Recuperar todos los trabajos
        Filtro filtroProyectos = new Filtro((entidad) -> {
            IProyecto p = ((IProyecto) entidad);
            return p.getEstado() == Estados.Finalizado || p.getEstado() == Estados.Entregado;
        });
        List<Proyecto> proyectos = Entidad
            .buscar(EntidadTipos.Proyecto, filtroProyectos)
            .stream()
            .map(entidad -> (Proyecto) entidad)
            .sorted(Proyecto.ordenarFechaFin)
            .collect(Collectors.toList());

        for(Proyecto proyecto: proyectos) {

            IEdificacion edificacion;

            Optional<IEdificacion> find = registros
                .keySet()
                .stream()
                .filter((c) -> !(c == null || entidad == null) && c.getIdS().equals(entidad.getIdS()))
                .findFirst();

            List<IProyecto> proyectosDelEdificio;
            if (find.isPresent()) {
                edificacion = find.get();
                proyectosDelEdificio = registros.get(edificacion);
            } else {
                switch(proyecto.getTipo()) {
                    case ProyectoResidencial:
                        edificacion = ((ProyectoResidencial) proyecto).getEdificacion();
                        break;
                    case ProyectoNoResidencial:
                        edificacion = ((ProyectoNoResidencial) proyecto).getEdificacion();
                        break;
                    case ProyectoRehabilitacion:
                        edificacion = ((ProyectoRehabilitacion) proyecto).getEdificacion();
                        break;
                    default:
                        // pass;
                        continue;
                }
                proyectosDelEdificio = new ArrayList<>();
            }
            proyectosDelEdificio.add(proyecto);
            registros.put(edificacion, proyectosDelEdificio);
        }

        return registros;
    }

}
