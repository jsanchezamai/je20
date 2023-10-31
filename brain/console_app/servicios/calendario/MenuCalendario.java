package console_app.servicios.calendario;


import java.util.Date;
import java.util.List;

import console_app.interfaces.entidades.ICampo;
import console_app.interfaces.entidades.Campos.CamposEnum;
import console_app.interfaces.personas.IEmpleado;
import console_app.interfaces.trabajos.ITrabajo;
import console_app.interfaces.trabajos.ICalendarioDia.Tipos;
import console_app.interfaces.trabajos.ITrabajo.Estados;
import console_app.pantallas.aplicacion.MenuFormulario;
import console_app.pantallas.aplicacion.Pantalla;
import console_app.pantallas.entidad.FormListarEntidad;
import console_app.servicios.Io;
import console_app.tipos.entidades.Campo;
import console_app.tipos.entidades.Entidad;
import console_app.tipos.entidades.EntidadTipos;
import console_app.tipos.entidades.Fecha;
import console_app.tipos.entidades.Filtro;
import console_app.tipos.entidades.Opcion;
import console_app.tipos.entidades.TiposDato;
import console_app.tipos.personas.Administrador;
import console_app.tipos.personas.Aparejador;
import console_app.tipos.personas.Arquitecto;
import console_app.tipos.trabajos.Certificado;
import console_app.tipos.trabajos.CertificadoEficiencia;
import console_app.tipos.trabajos.Proyecto;

/**
 * Write a description of class FormBorrarEntidad here.
 *
 * @author Jaime Sánchez
 * @version 1.0.0
 */
public class MenuCalendario extends MenuFormulario
{
    Estados estado;

    String tituloOriginal;

    public MenuCalendario(IEmpleado usuario, EntidadTipos tipo, ITrabajo.Estados estado)
    {
        super(usuario, tipo);

        this.estado = estado;

        titulo = "";
        tituloOriginal = Io.OPCION_PLANIFICACION + " > " + tipo + " > " + estado;

    }

    private Filtro filtroAdministrador() {
        return new Filtro(Io.CAMPO_ESTADO, (entidad) -> {
            Proyecto trabajo = (Proyecto) entidad;
            return trabajo.getEstado().equals(estado);
        });
    }

    private Filtro filtroArquitectoProyectos() {
        return new Filtro(Io.CAMPO_ESTADO, (entidad) -> {
            Proyecto trabajo = (Proyecto) entidad;
            return trabajo.getEstado().equals(estado);
        });
    }

    private Filtro filtroArquitectoCertificados() {
        return new Filtro(Io.CAMPO_ESTADO, (entidad) -> {

            Certificado trabajo = (Certificado) entidad;

            // Los certificados de eficiencia solo se pueden certificar si han sido calificados
            if (entidad instanceof CertificadoEficiencia) {
                CertificadoEficiencia certificado = (CertificadoEficiencia) entidad;
                if (certificado.getEficiencia() == null) {
                    return false;
                }
            }
            return trabajo.getEstado().equals(estado);
        });
    }

    private Filtro filtroAparejador() {
        return new Filtro(Io.CAMPO_ESTADO, (entidad) -> {
            Certificado trabajo = (Certificado) entidad;
            return trabajo.getEstado().equals(Estados.Solicitado);
        });
    }

    public String pedirOpcion() {

        // El titulo se modifica cuando se selecciona un trabajo
        // por eso lo restauramos si se regresa a la pantalla
        titulo = tituloOriginal;

        // Mostrar los trabajos en estado correspondiente
        Filtro filtroEstado;

        if (usuario instanceof Administrador) {
            filtroEstado = filtroAdministrador();
        } else if (usuario instanceof Arquitecto) {
            if (Entidad.esDeTipo(EntidadTipos.Proyecto, tipo)) {
                filtroEstado = filtroArquitectoProyectos();
            } else {
                filtroEstado = filtroArquitectoCertificados();
            }
        } else if (usuario instanceof Aparejador) {
            filtroEstado = filtroAparejador();
        } else {
            Pantalla.error("Operativa no implementada para el tipo de usuario");
            return "";
        }
        FormListarEntidad mnu = new FormListarEntidad(usuario, tipo, filtroEstado);
        mnu.mostrarOpciones();

        opcion.entrada("mostrar-registros");

        while(!opcion.entrada().isEmpty())
        {
            mnu.pedirOpcion();

            Pantalla.titulo(titulo);

            if (estado == Estados.Finalizado) {
                // Como esta opción es para listar, agregamos una pausa tras mostrar
                Pantalla.esperar();
                // y acabamos
                return "";
            }

            // El usuario debe escoger un proyecto para actualizar su fecha
            opcion.entrada(Pantalla.pedirOpcion(Io.SELECCIONAR_ID));

            if (opcion.entrada().isEmpty()) {
                return "";
            }

            // Recuperar el proyecto del registro
            foraneaEntidad = Entidad.buscarPorId(opcion.entrada());

            if (foraneaEntidad == null) {
                opcionNoValida();
                continue;
            }

            if (usuario instanceof Administrador) {
                opcion.entrada(accionesAdministrador());
            } else if (usuario instanceof Arquitecto) {
                opcion.entrada(accionesArquitecto());
            } else if (usuario instanceof Aparejador) {
                opcion.entrada(accionesAparejador());
            } else {
                Pantalla.error("Operativa no implementada para el tipo de usuario");
                return "";
            }

        }
        opcion.entrada("");
        return opcion.entrada();

    }

    private String accionesAdministrador() {

        // Iniciar logica para programarlo
        switch(estado) {
            case Entregado:
                if (programarProyecto()) {

                    // El trabajo ha sido programado, recargamos y ofrecemos
                    // programar otro trabajo sabiendo que el proyecto no
                    // volverá a salir en "Solicitados"
                    return pedirOpcion();
                }
                break;
            case Iniciado:
                if (actualizarProyecto(Tipos.Fin)) {

                    // El trabajo ha sido programado, recargamos y ofrecemos
                    // programar otro trabajo sabiendo que el proyecto no
                    // volverá a salir en "Solicitados"
                    return pedirOpcion();
                }
                break;
            default:
                Pantalla.esperar();
        }

        return "";

    }

    private String accionesArquitecto() {

        // Iniciar logica para programarlo
        switch(estado) {
            case Solicitado:
                if (actualizarDirecto(Tipos.Entrega)) {
                    return pedirOpcion();
                }
                break;
            case Visitado:
                if (actualizarDirecto(Tipos.Certificacion)) {
                    return pedirOpcion();
                }
                break;
            case Certificado:
                if (actualizarDirecto(Tipos.Entrega)) {
                    return pedirOpcion();
                }
                break;
            default:
                Pantalla.esperar();
        }

        return "";

    }

    private String accionesAparejador() {

        if (actualizarDirecto(Tipos.Visita)) {
            return pedirOpcion();
        }
        return "";

    }

    /**
     * Agrega al calendario la la fecha de inicio para un trabajo
     * @return si se ha podido relizar la acción
     */
    private boolean programarProyecto() {

        Proyecto trabajo = (Proyecto) foraneaEntidad;
        Pantalla.volcar("DEBUG Buscar slot para (dias de duración): " + trabajo.getDiasEstimados());

        // Obtener los slots disponibles y mostrarlos
        List<Date> fechas = Empresa.get().disponibilidad(trabajo);

        opciones.clear();
        int i = 0;
        for(Date fecha: fechas) {
            opciones.add(new Opcion(
                String.format(Io.OPCION_FECHA_DISPONIBLE, Fecha.fechaComoCadena(fecha), "--"), "" + i));
        }
        titulo = tituloOriginal + " > " + String.format(Io.CAMPO_FORANEA, trabajo.getId(), trabajo.name());
        mostrarOpciones();

        // Pedir fecha de inicio
        opcion.entrada("loop");
        ICampo c = new Campo(CamposEnum.FechaInicio, Io.CAMPO_FECHA_INICIO, TiposDato.Fecha);
        while(!opcion.entrada().isEmpty()) {

            String etiqueta = c.etiqueta();
            String valorActual = c.valorComoEtiqueta();

            boolean sugerido =  aceptarEntradaVacia || (valorActual != null && (!valorActual.isEmpty()));
            opcion.entrada(
                Pantalla.pedirDato(etiqueta, valorActual, sugerido)
            );

            // Si el usuario cancela
            if (opcion.entrada().isEmpty()) return false;

            // Guardar la fecha en el calendario
            Dia dia = (Dia) Entidad.porDefecto(EntidadTipos.Dia);
            dia.setValor(Tipos.Inicio, Fecha.stringLocalToDate(opcion.entrada()), trabajo.getId());
            if (Empresa.get().agregar(dia, false)) {
                opcion.entrada("");
                return true;
            }

        }

        return false;
    }

    /**
     * Agrega una fecha de un trabajo sin consultar el calendario
     *
     * Pre: El trabajo tiene fecha de inicio
     *
     * @param El tipo de fecha que se quiere actualizar, deber ser Fin o Entrega
     * @return Si se ha actualizado con éxito
     */
    private boolean actualizarProyecto(Tipos tipoFecha) {

        Proyecto trabajo = (Proyecto) foraneaEntidad;

        ICampo c;
        String valorSugerido;

        if (tipoFecha == Tipos.Fin) {
            c = new Campo(CamposEnum.FechaFin, Io.CAMPO_FECHA_FIN, TiposDato.Fecha);
            valorSugerido = Fecha.fechaComoCadena(trabajo.getPrevisto());
        } else {
            Pantalla.error("Funcion no implementada para tipo de fecha: " + tipoFecha);
            return false;
        }
        c.setValor(valorSugerido);
        // Guardar la fecha en el mismo calendario que su fecha de inicio
        Integer calendarioId =  Empresa.get().getDia(Tipos.Inicio, trabajo.getId()).getCalendarioId();
        return actualizarFecha(c, tipoFecha, trabajo, calendarioId);
    }

    private boolean actualizarFecha(ICampo c, Tipos tipoFecha, ITrabajo trabajo, Integer calendarioId) {

        opcion.entrada("loop");
        while(!opcion.entrada().isEmpty()) {

            String etiqueta = c.etiqueta();
            String valorActual = c.valorCadena();

            boolean sugerido = aceptarEntradaVacia || (valorActual != null && (!valorActual.isEmpty()));
            opcion.entrada(
                Pantalla.pedirDato(etiqueta, valorActual, sugerido)
            );

            Dia dia = (Dia) Entidad.porDefecto(EntidadTipos.Dia);
            dia.setCalendarioId(calendarioId);

            String fecha;
            if (opcion.entrada().isEmpty()) {
                fecha = valorActual;
            } else {
                // Si la fecha es válida dejamos continuar, si no, volvemos a pedirla...
                if (c.setValor(opcion.entrada())) {
                    fecha = opcion.entrada();
                } else {
                    continue;
                }
            }
            dia.setValor(tipoFecha, Fecha.stringLocalToDate(fecha), trabajo.getId());
            if (dia.agregar()) {
                opcion.entrada("");
                return true;
            }

        }

        return false;
    }

    /**
     * Agrega una fecha de un trabajo sin consultar el calendario
     *
     * Pre: El trabajo tiene fecha de inicio
     *
     * @param El tipo de fecha que se quiere actualizar, deber ser Fin o Entrega
     * @return Si se ha actualizado con éxito
     */
    private boolean actualizarDirecto(Tipos tipoFecha) {

        ITrabajo trabajo = (ITrabajo) foraneaEntidad;

        ICampo c;
        String valorSugerido;

        if (tipoFecha == Tipos.Entrega) {
            c = new Campo(CamposEnum.FechaEntrega, Io.CAMPO_FECHA_ENTREGA, TiposDato.Fecha);
        } else if (tipoFecha == Tipos.Visita) {
            c = new Campo(CamposEnum.FechaVisita, Io.CAMPO_FECHA_VISITA, TiposDato.Fecha);
        } else if (tipoFecha == Tipos.Certificacion) {
            c = new Campo(CamposEnum.FechaCertificacion, Io.CAMPO_FECHA_CERTIFICACION, TiposDato.Fecha);
        } else {
            Pantalla.error("Funcion no implementada para tipo de fecha: " + tipoFecha);
            return false;
        }
        valorSugerido = Fecha.ahora();
        c.setValor(valorSugerido);
        // Guardar la fecha en el mismo calendario que su fecha de Solicitud
        Integer calendarioId =  Empresa.get().getDia(Tipos.Solicitud, trabajo.getId()).getCalendarioId();
        return actualizarFecha(c, tipoFecha, trabajo, calendarioId);
    }

}
