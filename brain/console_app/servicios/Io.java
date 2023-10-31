package console_app.servicios;

/**
 * Write a description of class Internacionalizacion here.
 *
 * @author Jaime Sánchez
 * @version 1.0.0
 */
public class Io
{

    public static final String TITULO_CONECTARSE = "Conectarse (login con id de usuario)";
    public static final String TITULO_GESTION = "Gestión de [%s]";
    public static final String TITULO_VISUALIZACION = "Visualización de [%s]";
    public static final String TITULO_GESTION_FORANEA = " para [(%s) %s -- %s]";
    public static final String TITULO_FILTRADO_POR = " Filtro: %s";

    public static final String TITULO_PERSONA = "Personas";
    public static final String TITULO_TRABAJOS = "Trabajos";
    public static final String TITULO_LISTAR  = "Listar %s.";
    public static final String TITULO_LISTAR_CLIENTES_POR_EMPLEADO = "Visualización clientes por %s";
    public static final String TITULO_LISTAR_CLIENTES_POR_CONTABLE = "Visualización clientes con fechas pendiente visita";
    public static final String TITULO_LISTAR_VIVIENDAS_FIN_OBRA = "Visualización viviendas/edificios, fecha fin obra";
    public static final String TITULO_LISTAR_VIVIENDAS_HABITABILIDAD = "Visualización viviendas/edificios, fecha certificado habitabilidad";
    public static final String TITULO_LISTAR_VIVIENDAS_TRABAJO = "Visualización viviendas/edificios, y sus trabajos";
    public static final String TITULO_LISTAR_PLANIFICACION_OBRAS = "Visualización planificación obras";
    public static final String LINEA_ESTADO_TRABAJO_COMO_ETIQUETA = "[ %s] T: (%s) E: (%s)";

    public static final String OPCION_LISTAR_CLIENTES_EDIFICACION_CERTIFICADO_INSPECCION = "Visualización certificados de inspección técnica caducados";
    public static final String TITULO_LISTAR_CLIENTES_EDIFICACION_CERTIFICADO_INSPECCION = "Clientes/Edificación con certificados de inspección técnica caducados";

    public static final String OPCION_LISTAR_CLIENTES_EDIFICACION_CERTIFICADO_HABITABILIDAD = "Visualización certificados de habitabilidad caducados";
    public static final String TITULO_LISTAR_CLIENTES_EDIFICACION_CERTIFICADO_HABITABILIDAD = "Clientes/Edificación con certificados de habitabilidad caducados";
    public static final String TITULO_OPERACIONES_DISPONIBLES = "Operaciones para el tipo: %s";

    public static final String TITULO_ALTA = " Alta %s.";
    public static final String TITULO_EDITAR = " Edición %s.";
    public static final String TITULO_BORRAR = " Borrar %s.";
    public static final String TITULO_ACTUALIZAR_DATOS = " Actualizar datos:";

    public static final String TITULO_EMPLEADO = "Empleado";
    public static final String TITULO_ADMINISTRADOR = "Administrador";
    public static final String TITULO_ARQUITECTO = "Arquitecto";
    public static final String TITULO_APAREJADOR = "Aparejador";
    public static final String TITULO_CONTABLE = "Contable";
    public static final String TITULO_CLIENTE = "Cliente";

    public static final String TITULO_PROYECTO = "Proyecto";
    public static final String TITULO_CERTIFICADO = "Certificado";

    public static final String TITULO_PRESUPUESTO = "Presupuesto";
    public static final String TITULO_COSTE = "Coste";

    public static final String OPCION_ENUMERACION = ". . . [%s] ";
    public static final String OPCION_CREDENCIALES = "0. Datos de prueba: [0 - administrador; 1 - arquitecto; 2 - aparejador; 3 - contable]:";


    public static final String PEDIR_OPCION = " >> [%s]: s% \n";
    public static final String ESPERAR_LECTURA = " \n >> ";

    public static final String NUEVA_LINEA = " \n -- %s";

    public static final String LISTAR = "Listar";
    public static final String BORRAR = "Borrar";
    public static final String EDITAR = "Editar";
    public static final String ALTA = "Alta";
    public static final String SELECCIONAR_ID = "Seleccionar id o Enter para cancelar.";
    public static final String SELECCIONAR_OPCION = "\n >> ";
    public static final String CIERTO = "Cierto";
    public static final String FALSO = "Falso";

    public static final String PULSE_ENTER_PARA_SALIR = "\n >> Pulsar Enter para volver.";
    public static final String PULSE_PARA_CONTINUAR = "\n >> Pulsar cualquier tecla para seguir.";
    public static final String PULSE_PARA_CONFIRMAR = "\n %s \n >> Pulsar y para confirmar.";
    public static final String PULSE_PARA_AVANZAR = "\n >> Pulsar Enter para dejar igual.";
    public static final String PULSE_OPCION = "\n >> %s.";
    public static final String CONFIRMACION_BORRADO = "¿Seguro que desea borrar el registro: %s? ";

    public static final String MENSAJE_INFO = " >>> [INFO] %s";
    public static final String MENSAJE_ALERTA = " >>> [ALERTA] %s";
    public static final String MENSAJE_ERROR = " >>> [ERROR] %s";
    public static final String MENSAJE_CONFIRMACION = " >>> [RESULTADO] %s";

    public static final String MENSAJE_FORM_PEDIR_CAMPO = " >>>> [%s]";
    public static final String MENSAJE_FORM_PEDIR_CAMPO_SUGERIDO = " >>>> [%s]: %s %s";

    public static final String ETIQUETA_REGISTRO =  " registro de tipo: %s con " + Io.CAMPO_ID + " %s.";
    public static final String NOTIFICACION_NUEVO = "Creado" + ETIQUETA_REGISTRO;
    public static final String NOTIFICACION_EDITADO = "Editado" + ETIQUETA_REGISTRO;
    public static final String NOTIFICACION_BORRADO = "Borrado" + ETIQUETA_REGISTRO;

    public static final String ETIQUETA_IMPRESION_TOTAL =  "\n Total registros: %s.";

    public static final String ERROR_OPERAR = "Fallo al procesar elemento de tipo %s.";
    public static final String ERROR_NO_VALIDA = "La opcion %s no es válida.";
    public static final String ERROR_NO_ENCONTRADA = "La opcion %s no se ha encontrado.";
    public static final String ERROR_FECHA_OCUPADA = "El trabajo no tiene hueco en esa fecha de inicio.";
    public static final String NOT_FOUND = "404. NO ENCONTRADO";
    public static final String ERROR_ENTRADA_INVALIDA = "El valor %s para el campo %s de tipo %s no es válido.";
    public static final String TIPO_FECHA = "FECHA";
    public static final String TIPO_NUMERO = "NÚMERO";

    // Comunes
    public static final String CAMPO_NOMBRE = "Nombre";
    public static final String CAMPO_FORANEA = "(%s) %s";

    // IEmpleado, ICliente
    public static final String CAMPO_ID = "Id";
    public static final String CAMPO_APELLIDO = "Apellido";

    // ITrabajo
    public static final String CAMPO_CONTABLE = "Contable";
    public static final String CAMPO_APAREJADOR = "Aparejador";
    public static final String CAMPO_ARQUITECTO = "Arquitecto";
    public static final String CAMPO_CLIENTE = "Cliente";
    public static final String CAMPO_EDIFICACION = "Edificación";
    public static final String CAMPO_ESTADO = "Estado";

    // IProyecto
    public static final String CAMPO_DURACION = "Duración";
    public static final String CAMPO_FECHA = "Fecha";
    public static final String CAMPO_FECHA_FILTRO = "Fecha Filtro";

    public static final String CAMPO_FECHA_SOLICITUD = "Fecha Solicitud";
    public static final String CAMPO_FECHA_INICIO = "Fecha Inicio";
    public static final String CAMPO_FECHA_PREVISTO = "Fecha Previsto";
    public static final String CAMPO_FECHA_FIN = "Fecha Fin";
    public static final String CAMPO_FECHA_ENTREGA = "Fecha Entrega";
    public static final String CAMPO_FECHA_VISITA = "Fecha Visita";
    public static final String CAMPO_FECHA_CERTIFICACION = "Fecha Certificación";
    public static final String CAMPO_FECHA_CADUCA = "Fecha Caducidad";
    public static final String CAMPO_PRESUPUESTO = "Presupuesto";
    public static final String CAMPO_COSTE = "Coste";

    public static final String OPCION_GESTION_RESIDENCIAL = "Residencial";
    public static final String OPCION_GESTION_RESIDENCIAL_COMUNITARIO = "Residencial Comunitario";
    public static final String OPCION_GESTION_NORESIDENCIAL = "No residencial";
    public static final String OPCION_GESTION_PROYECTO_REHABILITACION = "Rehabilitación";

    public static final String OPCION_GESTION_CERTIFICADO_INFORME = "Informe pericial";
    public static final String OPCION_GESTION_CERTIFICADO_INSPECCION = "Inspección técnica";
    public static final String OPCION_GESTION_CERTIFICADO_EFICIENCIA = "Calificación eficiencia";
    public static final String OPCION_GESTION_CERTIFICADO_HABITABILIDAD = "Habitabilidad";


    // IEdificacion
    public static final String CAMPO_DIRECCION = "Dirección";
    public static final String CAMPO_SUPERFICIE_TERRENO = "Terreno m2";
    public static final String CAMPO_SUPERFICIE_EDIFICIO = "Edificio m2";

    // IEdificacionResidencial
    public static final String CAMPO_PLANTAS = "Plantas";
    public static final String CAMPO_LAVABOS = "Baños";
    public static final String CAMPO_HABITACIONES = "Habitaciones";

    // IEdificacionNoResidencial
    public static final String CAMPO_FINALIDAD = "Finalidad";

    // IPresupuesto
    public static final String CAMPO_COSTE_IVA = "I.V.A.";
    public static final String CAMPO_COSTE_CANTIDAD = "Cantidad";
    public static final String CAMPO_COSTE_PRECIO_UNIDAD = "P/u ($)";

    // ICertificadoEficencia
    public static final String CAMPO_EFICIENCIA = "Eficiencia";

    public static final String OPCION_GESTION_PERSONAS = "Gestión de Personas.";
    public static final String OPCION_ASIGNACION_PERSONAS = "Asignación de Personas.";
    public static final String OPCION_VISUALIZACION_PERSONAS = "Visualización de Personas.";
    public static final String OPCION_VISUALIZACION_CLIENTES = "Visualización de Clientes.";
    public static final String OPCION_VISUALIZACION_CLIENTES_CERTIFICADOS = "Visualización de Clientes/Certificados.";
    public static final String OPCION_VISUALIZACION_OBRAS = "Visualización de Obras.";
    public static final String OPCION_VISUALIZACION_CERTIFICADOS = "Visualiación Viviendas/Certificados.";
    public static final String OPCION_VISUALIZACION_VIVIENDAS = "Visualización Viviendas.";
    public static final String OPCION_PLANIFICACION = "Planificación.";
    public static final String OPCION_PLANIFICACION_ENTREGAS = "Entregas de proyecto.";
    public static final String OPCION_PLANIFICACION_CERTIFICACION = "Certificaciones y Entregas.";
    public static final String OPCION_PLANIFICACION_VISITA = "Visitas certificación.";

    public static final String OPCION_PLANIFICACION_INICIO = "Asignar fecha de inicio de obra.";
    public static final String OPCION_PLANIFICACION_FIN = "Asignar fecha de fin de obra.";
    public static final String OPCION_FECHA_ENTREGA = "Asignar fecha entrega.";
    public static final String OPCION_VISUALIZACION_FINALIZADOS = "Visualizacion finalizados.";
    public static final String OPCION_FECHA_VISITA = "Asignación fecha de visita.";
    public static final String OPCION_FECHA__CERTIFICACION = "Asignación fecha de certificación.";

    public static final String OPCION_GESTION_ADMINISTRADOR = "Gestión de Administrador.";
    public static final String OPCION_GESTION_ARQUITECTO = "Gestión de Arquitecto.";
    public static final String OPCION_GESTION_APAREJADOR = "Gestión de Aparejador.";
    public static final String OPCION_GESTION_CONTABLE = "Gestión de Contable.";
    public static final String OPCION_GESTION_CLIENTES = "Gestión de Clientes.";


    public static final String OPCION_GESTION_TRABAJOS = "Gestión Trabajos";
    public static final String OPCION_GESTION_PROYECTO = "Gestión de Proyectos.";
    public static final String OPCION_GESTION_CERTIFICADO = "Gestión de Certificados.";
    public static final String OPCION_GESTION_EDIFICACIONES = "Gestión de Edificaciones.";

    public static final String OPCION_GESTION_PRESUPUESTO = "Gestión Presupuesto";
    public static final String OPCION_GESTION_PRESUPUESTO_LINEAS = "Gestión Líneas de Prespuesto";
    public static final String OPCION_GESTION_COSTES = "Gestión Costes";

    public static final String OPCION_FECHA_DISPONIBLE = "Fecha disponible: %s a %s ";

    public static final String ERROR_FALTA_ENTIDAD = "No se puede continuar, por favor, reintente.";

    public static final String NO_INICIALIZADO = "<ninguno>";

    public static final String TABULACION_REGISTRO = "\n ----- ";

    public static final String CALENDARIO_PULSO = "[INFO] Ejecutando refresco de notificaciones.";



    public static final String TITULO_APP = "The Eden Garden 2.0 console app (the draft version) \n";

    public static final String TITULO_INICIAL = "We are at Eden Garden, that's what you see...";
    public static final String OPCION_SESSION = "Session box";
    public static final String OPCION_CLOCK = "Clock: %s";



    public static final String BOT_EVE_NAME = "Eve";
    public static final String BOT_SNAKE_NAME = "Snake";
    public static final String BOT_ADAN_NAME = "Adan";

    public static final String BRAINSTATE_UNBORN = "Unborn";
    public static final String BRAINSTATE_ALIVE_SLEEP = "Sleeping";
    public static final String BRAINSTATE_ALIVE_AWAKE = "Awake";
    public static final String BRAINSTATE_ALIVE_IMAGINING = "Imagining";
    public static final String BRAINSTATE_ALIVE_REMEMBERING = "Remembering";
    public static final String BRAINSTATE_DEAD = "Dead";
    public static final String CRIMES_OFFER_APPLE = "Offer an apple";
    public static final String MAIN_EVENTS_SOUND_CHANNEL = "Event: Sound Channel";
    public static final String EVENTS_RECEIVED = "Received [%s] event [%s] from [%s] with damage [%s].";
    public static final String EVENTS_EMITTED = "Emitted [%s.%s] event [%s] from [%s] to [%s] with damage [%s].";
    public static final String DECISION_TO_STRING = "State: [%s]; (crime/punish): %s / %s; (plaintiff/defendant); %s / %s";
    public static final String NO_DATA = " -";
    public static final String THING_WISDOM_TREE = "Apple tree";

    public static final String BOT_AS_OPTION = "B [%s] %s";
    public static final String WORLD_OBJECT_AS_OPTION = "name: %s at %s";
    public static final String WORLD_AGENT_AS_OPTION = "%s;\n           - interaction: %s";
    public static final String THING_AS_OPTION = "Thing --> %s";
    public static final String MAIN_EVENTS_VISION_CHANNEL = null;
    public static final String MAIN_EVENTS_GROUND_CHANNEL = null;
    public static final String EDENGARDEN_OPTIONS_SNAKE_TO_TEMP_EVE = "Send snake to tempt Eve.";
    public static final String EDENGARDEN_OPTIONS_SNAKE_TO_TEMP_EVE_WAITING = "Waiting for snake to tempt Eve.";
    public static final String EDENGARDEN_OPTIONS_STOPIT = " Stop it!";
    public static final String BRAIN_TO_STRING = "%s %s";
    public static final String ERGOSUM_CONTENT_LABEL = "Do: %s, against: %s. Status: %s.";
    public static final String NO_NAME = "";
    public static final String OFFER_APPLE_DECISION_LABEL = "Pulses [%s] %s";
    public static final String STATE_SEARCHING_LABEL = "Searching";
    public static final String STATE_WALKING_TO_LABEL = "Walking to";
    public static final String STATE_DONE = "finished!";
    public static final String STATE_TALKING_TO_LABEL = "Traying to talk to";
    public static final String SUBSTATE_LABEL = ". Now doing: [%s]";
    public static final String STATE_TALKED_LABEL = "Already spoken!";
    public static final Object INTERNAL_EVENT = "(BRAIN TO AGENT)";
    public static final Object EXTERNAL_EVENT = "(AGENT TO WORLD)";
    public static final String PUNISHMENT_OFFER_APPLE_ACCEPT = "ACCEPTED";
    public static final String PUNISHMENT_OFFER_APPLE_REJECT = "REJECTED";
    public static final String STATE_REJECTED = "Rejected";

    public static String formatearLinea(String[] columnas) {
        String linea = "";
        for(String valor: columnas) {
            linea += "|" + formatearColumna(valor, 15, " ");
        }
        return linea;
    }

    public static String formatearColumna(String valor, int longitud, String separador) {
        if (("" + valor).length() >= longitud) {
            return valor.substring(0, longitud - 2) + "...";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(valor);
        while (sb.length() <= longitud) {
            sb.append(separador);
        }

        return sb.toString();
    }

}
