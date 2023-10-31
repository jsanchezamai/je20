package console_app.pantallas.sesion;

import java.util.Date;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import console_app.interfaces.entidades.ICampo;
import console_app.interfaces.entidades.Campos.CamposEnum;
import console_app.interfaces.personas.IEmpleado;
import console_app.interfaces.trabajos.ICalendarioDia;
import console_app.interfaces.trabajos.IProyecto;
import console_app.interfaces.trabajos.ITrabajo;
import console_app.pantallas.aplicacion.MenuFormulario;
import console_app.pantallas.aplicacion.Pantalla;
import console_app.servicios.Io;
import console_app.servicios.calendario.Dia;
import console_app.tipos.entidades.Campo;
import console_app.tipos.entidades.Entidad;
import console_app.tipos.entidades.EntidadTipos;
import console_app.tipos.entidades.Fecha;
import console_app.tipos.entidades.Filtro;
import console_app.tipos.entidades.TiposDato;
import console_app.tipos.trabajos.Proyecto;

/**
 * Lista por pantalla la actividad del calendario, filtrado por fecha.
 *
 * @author Jaime Sánchez
 * @version 1.0.0
 */
public class FormListarCalendario extends MenuFormulario
{

    public 
    FormListarCalendario(IEmpleado usuario)
    {
        super(usuario, EntidadTipos.Edificacion);

        titulo = Io.TITULO_LISTAR_PLANIFICACION_OBRAS;

    }

    public String pedirOpcion() {

        ICampo c = new Campo(CamposEnum.FechaFiltro, Io.CAMPO_FECHA_FILTRO, TiposDato.Fecha);
        c.setValor(Fecha.ahora());

        opcion.entrada("loop");
        while(!opcion.entrada().isEmpty()) {

            String etiqueta = c.etiqueta();
            String valorActual = c.valorCadena();

            boolean sugerido = aceptarEntradaVacia || (valorActual != null && (!valorActual.isEmpty()));
            opcion.entrada(
                Pantalla.pedirDato(etiqueta, valorActual, sugerido)
            );

            // Si la fecha es válida dejamos continuar, si no, volvemos a pedirla...
            if (c.setValor(opcion.entrada())) {
                opcion.entrada("");
            } else {
                opcion.entrada("loop");
            }

        }
        return Pantalla.volcar(
            listaAPantalla(
                obtenerDatos(c.valorFecha())
            )
        );
    }

    private String listaAPantalla(Map<ICalendarioDia, List<ITrabajo>>  datos) {

        String impresion = "";
        String n = "\n";
        int totalRegistros = 0;
        for(ICalendarioDia dia: datos.keySet().stream()
                                    .map(entidad -> (Dia) entidad)
                                    .sorted(Dia.ordenarEstados)
                                    .collect(Collectors.toList())) {

            impresion += n;
            impresion += n + Io.CAMPO_FECHA + " > " + dia.getFechaComoEtiqueta() + " > " + dia.getTipoFecha();

            List<ITrabajo> trabajosDelDia = datos.get(dia);
            for(ITrabajo trabajo: trabajosDelDia) {
                impresion += n;
                impresion += n + " .. " + trabajo.comoRegistroCabecera();
                impresion += n + " .. " + trabajo.comoRegistro();
                totalRegistros++;
            }

        }
        impresion += String.format(Io.ETIQUETA_IMPRESION_TOTAL, totalRegistros);
        return impresion;
    }

    private Map<ICalendarioDia, List<ITrabajo>> obtenerDatos(Date fecha) {

        Map<ICalendarioDia, List<ITrabajo>> registros = new HashMap<>();

        // Recuperar todos los dias
        Filtro filtroTrabajos = new Filtro((entidad) -> {
            ICalendarioDia dia = (ICalendarioDia) entidad;
            ITrabajo proyecto = (ITrabajo) Entidad.buscarPorId(EntidadTipos.Proyecto, "" + dia.getTrabajoId());
            return proyecto instanceof Proyecto && dia.getFecha().compareTo(fecha) >= 0;
        });

        List<Dia> dias = Entidad
            .buscar(EntidadTipos.Dia, filtroTrabajos)
            .stream()
            .map(entidad -> (Dia) entidad)
            .sorted()
            .collect(Collectors.toList());

        for(ICalendarioDia dia: dias) {

            ICalendarioDia diaIt;

            Optional<ICalendarioDia> find = registros
                .keySet()
                .stream()
                .filter((c) ->
                            c.getFecha().getTime() == dia.getFecha().getTime() && 
                            c.getTipoFecha() == dia.getTipoFecha()
                ).findFirst();

            List<ITrabajo> proyectosDelDia;

            if (find.isPresent()) {
                diaIt = find.get();
                proyectosDelDia = registros.get(diaIt);
            } else {
                diaIt = dia;
                proyectosDelDia = new ArrayList<>();

            }
            IProyecto proyecto = (IProyecto) Entidad.buscarPorId(EntidadTipos.Proyecto, "" + dia.getTrabajoId());
            proyectosDelDia.add(proyecto);
            registros.put(diaIt, proyectosDelDia);
        }

        return registros;
    }
}
