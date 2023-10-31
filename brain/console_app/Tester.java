package console_app;

import java.util.Date;
import java.util.Random;

import console_app.interfaces.entidades.IServicio;
import console_app.tipos.entidades.Fecha;

public class Tester {

    IServicio pantalla;

    Random rnd = new Random();

    private Date baseTime;

    public static int NIVEL1;
    public static int NIVEL2;
    public static int NIVEL3;
    public static int NIVEL4;
    public static int NIVEL4b;
    public static int NIVEL5;
    public static int NIVEL5_2;
    public static int NIVEL6;
    public static int NIVEL6_2;

    public Tester(IServicio pantalla) {
        this.pantalla = pantalla;
        rnd.setSeed(55);
        this.baseTime = Fecha.ahoraDate();
    }

    private void l(String[] opciones) {
        pantalla.test(opciones);
    }

    private void l(String opcion) {
        pantalla.test(opcion);
    }

    public Integer r() {
        Integer r = rnd.nextInt(100);
        // System.out.println("Nuevo random: " + r);
        return r;
    }

    /**
     * El administrador crea 2 usuarios de cada tipo.
     *
     * Simulamos la llegada de 2 clientes al estudio.
     *
     * Cada cliente pide un proyecto/certificado de cada tipo.
     */
    public void Administrador_Crear_Personas_y_Trabajos() {

        System.out.println("(Administrador) Cargando datos de prueba Personas...");

        // Login + Pantalla Administrador + Gestión de Usuarios
        l(irAPantallaEmpleado("", "1"));

        // Por dada tipo de usuario crear uno...
        for(int i = 1; i < 6; i++) {
            l(crearPersona("" + i));
            l("");
        }

        // Por dada tipo de usuario crear un segundo...
        for(int i = 1; i < 6; i++) {
            l(crearPersona("" + i));
            l("");
        }

        /**
         * Registros creados
         *
         *
0, Administrador
1, Arquitecto
2, Aparejador
3, Contable
4, Cliente
5, Administrador
6, Arquitecto
7, Aparejador
8, Contable
9, Cliente
         */
        System.out.println("(Administrador) Cargando datos de prueba Proyectos...");
        // Pantalla Administrador + Asignación
        l("");
        l("2");

        // Crear Proyectos y asignar los empleados y el cliente...
        for(int i = 1; i < 4; i++) {
            l(crearProyecto("" + i));
            l("");
        }

        // Crear Proyectos y asignar los empleados y el cliente...
        for(int i = 1; i < 4; i++) {
            l(crearProyecto2("" + i));
            l("");
        }

        /**
         * Registros creados
         *
10, ProyectoResidencial
11, Dia (Solicitud)
12, ProyectoNoResidencial
13, Dia (Solicitud)
14, ProyectoRehabilitacion
15, Dia (Solicitud)
16, ProyectoResidencial
17, Dia (Solicitud)
18, ProyectoNoResidencial
19, Dia (Solicitud)
20, ProyectoRehabilitacion
21, Dia (Solicitud)
         */

        /** Registros creados
         * 
22, CertificadoEficiencia
23, Dia (Solicitud)
24, CertificadoHabitabilidad
25, Dia (Solicitud)
26, CertificadoInspeccion
27, Dia (Solicitud)
28, CertificadoInforme
29, Dia (Solicitud)
30, CertificadoEficiencia
31, Dia (Solicitud)
32, CertificadoHabitabilidad
33, Dia (Solicitud)
34, CertificadoInspeccion
35, Dia (Solicitud)
36, CertificadoInforme
37, Dia (Solicitud)
         */
        System.out.println("(Administrador) Cargando datos de prueba Certificados...");
        // Crear Certificados y asignar los empleados y el cliente 4...
        l(crearCertificado("4"));
        l(crearCertificado("5"));
        l(crearCertificado("6"));
        l(crearCertificado("7"));

        // Crear Certificados y asignar los empleados y el cliente 9...
        l(crearCertificado2("4"));
        l(crearCertificado2("5"));
        l(crearCertificado2("6"));
        l(crearCertificado2("7"));

        // Salir de administrador
        l("");
        l("");

        NIVEL1 = pantalla.testSize();
    }

    /**
     * El Arquitecto crea 2 edificios para cada uno de los 2 clientes
     * creados en el Nivel1.
     *
     * Edita los dias y el edificio para cada proyecto.
     * 
     * Edita el eficicio para cada certificado
     */
    public void Arquitecto_Crear_Edificios_Asignarlos_A_Trabajos() {

        System.out.println("(Arquitecto) Cargando datos de prueba Edificios...");

        // Login + Pantalla Arquitecto + Gestión de Trabajos
        l(irAPantallaEmpleado("1", "1"));

        // Crear Edificios para el cliente 4...
        l(crearEdificioResidencial("8","4"));
        l("");
        l(crearEdificioNoResidencial("9", "4"));
        l("");
        l(crearEdificioResidencial("10", "4")); // Comunitario
        l("");

        // Crear Edificios para el cliente 9...
        l(crearEdificioResidencial("8","9"));
        l("");
        l(crearEdificioNoResidencial("9", "9"));
        l("");
        l(crearEdificioResidencial("10", "9"));  // Comunitario
        l("");

        /**
         * Registros creados
38, EdificacionResidencial
39, EdificacionNoResidencial
40, EdificacionResidencialComunitario
41, EdificacionResidencial
42, EdificacionNoResidencial
43, EdificacionResidencialComunitario
         */

        // Editar Proyectos
        l(proyectoArquitecto("1", "10", "38", "1")); // Residencial
        l(""); l("");
        l(proyectoArquitecto("2", "12", "39", "1")); // NoResidencial
        l(""); l("");
        l(proyectoArquitecto("3", "14", "40", "1")); // Rehabilitacion
        l(""); l("");

        // Editar Proyectos
        l(proyectoArquitecto("1", "16", "41", "1")); // Residencial
        l(""); l("");
        l(proyectoArquitecto("2", "18", "42", "1")); // NoResidencial
        l(""); l("");
        l(proyectoArquitecto("3", "20", "43", "1")); // Rehabilitacion
        l(""); l("");

        l(certificadoArquitecto("4", "22", "38"));  // Eficiencia Edificio Indiferente
        l(""); l("");
        l(certificadoArquitecto("5", "24", "38")); // Habitabilidad Residencial
        l(""); l("");
        l(certificadoArquitecto("6", "26", "40")); // Inspección Edificio comunitaro
        l(""); l("");
        l(certificadoArquitecto("7", "28", "39")); // Informe Edificio Indiferente
        l(""); l("");

        l(certificadoArquitecto("4", "30", "41"));  // Eficiencia Edificio Indiferente
        l(""); l("");
        l(certificadoArquitecto("5", "32", "41")); // Habitabilidad Residencial
        l(""); l("");
        l(certificadoArquitecto("6", "34", "43")); //  Inspeccion Edificio comunitario
        l(""); l("");
        l(certificadoArquitecto("7", "36", "42")); // Informe Edificio Indiferente
        l(""); l("");

        // Volver pantalla login
        l(""); l("");

        NIVEL2 = pantalla.testSize();
    }

    /**
     * El contable crea un presupuesto y una linea para cada proyecto.
     *
     * Agrega un coste para cada proyecto y para cada certificado.
     */
    public void Contable_Agregar_Presupuesto_Y_Costes() {

        System.out.println("(Contable) Cargando datos de prueba Presupuestos y Costes...");

        // Pantalla contable
        l("3"); // id contable
        // Presupuestos
        l(contablePresupuesto("10"));
        l(contablePresupuestoLinea("44"));

        l(contablePresupuesto("12"));
        l(contablePresupuestoLinea("46"));

        l(contablePresupuesto("14"));
        l(contablePresupuestoLinea("48"));

        l(contablePresupuesto("16"));
        l(contablePresupuestoLinea("50"));

        l(contablePresupuesto("18"));
        l(contablePresupuestoLinea("52"));

        l(contablePresupuesto("20"));
        l(contablePresupuestoLinea("54"));

        /**
         * Registros creados
44, Presupuesto
45, PresupuestoLinea
46, Presupuesto
47, PresupuestoLinea
48, Presupuesto
49, PresupuestoLinea
50, Presupuesto
51, PresupuestoLinea
52, Presupuesto
53, PresupuestoLinea
54, Presupuesto
55, PresupuestoLinea
         */

        // entrar en costes
        l("3");
        // Coste a cada proyecto
        l(contableCoste("1", "10"));
        l(contableCoste("2", "12"));
        l(contableCoste("3", "14"));
        l(contableCoste("1", "16"));
        l(contableCoste("2", "18"));
        l(contableCoste("3", "20"));

        // Coste a cada certificado
        l(contableCoste("4", "22"));
        l(contableCoste("5", "24"));
        l(contableCoste("6", "26"));
        l(contableCoste("7", "28"));

        l(contableCoste("4", "30"));
        l(contableCoste("5", "32"));
        l(contableCoste("6", "34"));
        l(contableCoste("7", "36"));

        // Salir
        l("");
        l("");

        NIVEL3 = pantalla.testSize();
    }

    /**
     * El arquitecto registra la fecha de entrega de 3 proyectos
     */
    public void Arquitecto_Entrega_Proyectos() {

        System.out.println("(Arquitecto) Cargando datos de prueba Planificación Obras...");
        String moverTiempo = Fecha.fechaComoCadena(Fecha.dateToLocal(this.baseTime).plusDays(1));
        // Entrar como arch
        l("1"); // id arquitecto
        // Pantalla de planificación
        l("3");
          // Agregar fecha de Entrega
          l("1");
          l("10");
          l(moverTiempo);l("confirmar");
          l("");
          l("2");
          l("12");
          l(moverTiempo);
          l("confirmar");
          l("");
          l("3");
          l("14");
          l(moverTiempo);
          l("confirmar");
          l("");
          l("");
          l("");

          NIVEL4 = pantalla.testSize();
    }

    /**
     * El administrador avanza los proyectos desde solicitados a entregados
     */
    public void Administrador_Actualiza_Calendario_Obra() {

        System.out.println("(Administrador) Cargando datos de prueba Planificación Obras...");

        String moverTiempo = Fecha.fechaComoCadena(Fecha.dateToLocal(this.baseTime).plusDays(2));
        // Entrar como admin
        l("0");
        // Pantalla de planificación
        l("8");
            // Agregar fecha de Inicio
            l(calendario(moverTiempo, "1", "1", "10"));
            l(calendario(moverTiempo, "1", "2", "12"));
            l(calendario(moverTiempo, "1", "3", "14"));
            moverTiempo = Fecha.fechaComoCadena(Fecha.dateToLocal(this.baseTime).plusDays(3));
            // Agregar fecha de finalización
            l(calendario(moverTiempo, "2", "1", "10")); // dejar fecha sugerida
            l(calendario(moverTiempo, "2", "2", "12"));
            l(calendario(moverTiempo, "2", "3", "14"));
        // Salir
        l("");
        l("");

        NIVEL4b = pantalla.testSize();
    }

    /**
     * Un aparejador visita un certificado de tipo Eficiencia
     */
    public void Aparejador_Visita_Certificado_Eficiencia() {

        System.out.println("(Aparejador) Cargando datos de prueba Certificado Eficiencia...");

        String moverTiempo = Fecha.fechaComoCadena(Fecha.dateToLocal(this.baseTime).plusDays(4));

        l("1");
        l("2");
        l("4"); // Seleccionar gestion visitas
        l("1"); // Seleccionar eficiencia
        l("22");
        l(moverTiempo); // fecha por defecto
        l("confirmar"); // fecha por defecto
        l(""); // Salir de gestion visitas
        l("");
        l(""); // Salir de Aparejador
        NIVEL5 = pantalla.testSize();
    }

    /**
     * Un aparejador visita un certificado de tipo Habitabilidad
     */
    public void Aparejador_Visita_Certificado_Habitabilidad() {

        System.out.println("(Aparejador) Cargando datos de prueba Certificado Habitabilidad...");

        String moverTiempo = Fecha.fechaComoCadena(Fecha.dateToLocal(this.baseTime).plusDays(4));
        l("2");
        l("4"); // Seleccionar gestion visitas
        l("2"); // Seleccionar Habitabilidad
        l("24");
        l(moverTiempo); // fecha por defecto
        l("confirmar"); 
        l(""); // Salir de gestion visitas
        l("");
        l(""); // Salir de Aparejador
        NIVEL5_2 = pantalla.testSize();
    }

    /**
     * Un arquitecto actualiza eficiencia de un certificado,
     * luego actualiza fecha de certificación
     * y por último la fecha de entrega
     */
    public void Arquitecto_Expedir_Certificado_Eficiencia() {

        System.out.println("(Arquitecto) Cargando datos de prueba Certificado Eficiencia...");
        l("1");

        // Otorgar eficiencia
        l("1"); // Seleccionar gestión trabajos
        l("4"); // Seleccionar certificados de eficiencia
        l("3"); // Editar
        l("22"); // Seleccionar proyecto
        l(""); // Omitir edificacion
        l("A"); // Otorgar eficiencia
        l("confirmar");
        l(""); // Salir de gestion certificado eficiencia
        l("");

        l(""); // Salir de Gestión trabajos

        String moverTiempo = Fecha.fechaComoCadena(Fecha.dateToLocal(this.baseTime).plusDays(5));

        // Agregar fecha de certificación
        l("4"); // Seleccionar certificación y entrega
        l("1"); // Seleccionar certificado tipo eficiencia
        l("1"); // Seleccionar fecha certificación
        l("22"); // Seleccionar proyecto
        l(moverTiempo); // Dejar fecha defecto
        l("confirmar"); // 
        l(""); // Salir certificados eficiencia

        // Agregar fecha de entrega
        l("1"); // Seleccionar Proyectos eficiencia
        l("2"); // Seleccionar trabajos entregados
        l("22"); // Seleccionar proyecto
        l(moverTiempo); // Dejar fecha defecto
        l("confirmar"); // 
        l(""); // Salir certificados eficiencia

        // Salir de Certificaciones y entregas
        l("");
        // Salir de arquitecto
        l("");
        NIVEL6 = pantalla.testSize();
    }


    /**
     * Un arquitecto actualiza  fecha de certificación de tipo Habitabilidad
     * y por último la fecha de entrega
     */
    public void Arquitecto_Expedir_Certificado_Habitabilidad() {

        System.out.println("(Arquitecto) Cargando datos de prueba Certificado Habitabilidad...");
        l("1");
        String moverTiempo = Fecha.fechaComoCadena(Fecha.dateToLocal(this.baseTime).plusDays(5));
        // Agregar fecha de certificación
        l("4"); // Seleccionar certificación y entrega
        l("2"); // Seleccionar certificado tipo Habitabilidad
        l("1"); // Seleccionar fecha certificación

        l("24"); // Seleccionar proyecto
        l(moverTiempo); // Dejar fecha defecto
        l("confirmar"); // 
        l(""); // Salir certificados Habitabilidad

        // Agregar fecha de entrega
        l("4"); // Seleccionar Proyectos Habitabilidad
        l("2"); // Seleccionar trabajos entregados
        l("24"); // Seleccionar proyecto
        l(moverTiempo); // Dejar fecha defecto
        l("confirmar"); // 
        l(""); // Salir certificados Habitabilidad

        // Salir de Certificaciones y entregas
        l("");
        // Salir de arquitecto
        l("");
        l("testModeOff");
        NIVEL6_2 = pantalla.testSize();
    }

    private String[] calendario(String fecha, String tipoFecha, String tipoProyecto, String proyectoId) {
        String[] opciones = {
            // Seleccion tipo de proyecto
            tipoProyecto,
                // Seleccion Solicitados/EnCurso/Finalizado
                tipoFecha,
                    // Seleccionar proyecto
                    proyectoId,
                        // Establecer fecha de inicio
                        fecha,
                        "confirmar dia",
                // Salir de solicitados
                ""
        };
        return opciones;
    }

    private String[] irAPantallaEmpleado(String login, String indEntidadTipos) {

        String[] opciones = {
            // Pantalla Inicial: Conectarse
            "1",
            // Pantalla Login: Credenciales
            login,
            // Opcion 1
            indEntidadTipos
        };
        return opciones;
    }

    private String[] crearPersona(String indEntidadTipos) {

        String[] opciones = {
            //Opcion 1",
            indEntidadTipos,
            //Opcion Alta",
            "2",
            //Opcion Alta",
            "nombre" + indEntidadTipos + "_" + r(),
            //Opcion Alta",
            "apellido" + r(),
            //Opcion Alta",
            "confirmar",
        };
        return opciones;

    }

    private String[] secuenciaEditaUsuarioTipo(String indEntidadTipos, String indice) {

        Random rnd = new Random();
        rnd.setSeed(55);

        String[] opciones = {
            //Opcion Editar",
            "3",
            //Opcion Editar",
            indice,
            //Opcion Editar",
            "nombre" + r(),
            //Opcion Editar",
            "apellido" + r(),
            //Opcion Editar",
            "confirmar",
        };
        return opciones;

    }

    private String[] secuenciaBorrarUsuarioTipo(String indEntidadTipos, String indice) {

        String[] opciones = {
            //Opcion Borrar",
            "4",
            //Opcion Borrar",
            "0",
            //Opcion Borrar",
            "no borrar",
            //Opcion Borrar",
            "0",
            //Opcion Borrar",
            "y",
            //Opcion Borrar",
            "confirmar",
            //Opcion Borrar",
            ""
        };
        return opciones;
    }

    private String[] secuenciaListarUsuarioTipo(String indEntidadTipos) {

        String[] opciones = {
            //Opcion Listar",
            "1",
            //Opcion Listar",
            "confirmar"
        };
        return opciones;

    }

    private String[] crearCertificado(String indEntidadTipos) {

        String[] opciones = {
            //Opcion 1",
            indEntidadTipos,
            //Opcion Alta",
            "2",
            "nombre" + r(),

            //arquitecto",
            "1",
            //aparejador",
            "2",
            //contable",
            "3",
            //cliente",
            "4",
            "confirmar",
            "confirmar_fecha_solicitud",
            "", // salir
        };

        return opciones;

    }

    private String[] crearCertificado2(String indEntidadTipos) {

        String[] opciones = {
            //Opcion 1",
            indEntidadTipos,
            //Opcion Alta",
            "2",
            "nombre" + r(),
            //arquitecto",
            "6",
            //aparejador",
            "7",
            //contable",
            "8",
            //cliente",
            "9",
            "confirmar",
            "confirmar_fecha_solicitud",
            "", // salir
        };
        return opciones;

    }

    private String[] certificadoArquitecto(String indEntidadTipos, String certificadoId, String edificioId) {

        if (certificadoId.equals("30")) { // 30 CertificadoEficiencia
            String[] opciones = {
                //Opcion 1",
                indEntidadTipos,
                //Opcion Modificar",
                "3",
                certificadoId,
                edificioId,
                "A", // "eficiencia"
                "confirmar"
            };
            return opciones;
        } else {
            String[] opciones = {
                //Opcion 1",
                indEntidadTipos,
                //Opcion Modificar",
                "3",
                certificadoId,
                edificioId,
                "confirmar"
            };
            return opciones;
        }
        

    }

    private String[] certificadoContable(String indEntidadTipos, String certificadoId, String coste) {

        String[] opciones = {
            //Opcion 1",
            indEntidadTipos,
            //Opcion Modificar",
            "3",
            certificadoId,
            coste
        };
        return opciones;

    }

    private String[] crearProyecto(String tipoProyecto) {

        String[] opciones = {
            tipoProyecto,
            //Opcion Alta",
            "2",
            "nombre" + r(),
            //arquitecto",
            "1",
            //aparejador",
            "2",
            //contable",
            "3",
            //cliente",
            "4",
            "confirmar",
            "confirmar_fecha_solicitud"
        };
        return opciones;

    }

    private String[] crearProyecto2(String tipoProyecto) {

        String[] opciones = {
            tipoProyecto,
            //Opcion Alta",
            "2",
            "nombre" + r(),
            //arquitecto",
            "6",
            //aparejador",
            "7",
            //contable",
            "8",
            //cliente",
            "9",
            "confirmar",
            "confirmar_fecha_solicitud"
        };
        return opciones;

    }

    private String[] proyectoArquitecto(String tipoProyecto, String proyectoId, String edificio, String dias) {

        String[] opciones = {
            tipoProyecto,
            //Opcion Modificar",
            "3",
            proyectoId,
            dias,
            edificio,
            "confirmar"
        };
        return opciones;

    }

    private String[] contablePresupuesto(String proyectoId) {

        String[] opciones = {
            // Entrar en presupuestos
            "1",
            proyectoId,
            // alta
            "2",
            // Fecha por defecto,
            "",
            // Iva
            "21",
            //
            "confirmar",
            ""
        };
        return opciones;

    }

    private String[] contableCoste(String tipoTrabajo, String proyectoId) {

        String[] opciones = {
            tipoTrabajo,
            // Editar
            "3",
            // Tipo de proyecto
            proyectoId,
            // Coste
            "" + r(),
            "confirmar",
            // volver
            "",
            ""
        };
        return opciones;

    }

    private String[] contablePresupuestoLinea(String presupuestoId) {

        String[] opciones = {
            // Entrar en lineas presupuesto
            "2",
            presupuestoId,
            // alta
            "2",
            // Cantidad
            "1",
            // P/u
            "25",
            "confirmar",
            ""
        };
        return opciones;

    }

    private String[] crearEdificioResidencial(String indEntidadTipos, String clienteId) {

        String[] opciones = {
        indEntidadTipos,
        //Opcion Alta",
        "2",
        //cliente",
        clienteId,

        //Direccion",
            "Calle" + r(),
        //Sup edificio",
            "" + r(),
        //Sup terreno",
            "" + r(),
        //Plantas",
            "" + r(),
        //Habitaciones",
            "" + r(),
        //Baños",
            "" + 5,

        //Opcion Alta",
            "confirmar"
        };
        return opciones;

    }

    private String[] crearEdificioNoResidencial(String indEntidadTipos, String clienteId) {

        String[] opciones = {
        //Opcion 1",
        indEntidadTipos,
        //Opcion Alta",
        "2",

        clienteId,

        //Direccion",
        "Calle-" + r(),

        //Sup ED",
        "" + r(),
        //Sup TERRENO",
        "" + r(),
        //Finalidad",
            "Finalidad-" + r(),

                    //cliente",

        //Opcion Alta",
            "confirmar"
        };
        return opciones;

    }

    public void test() {
        Administrador_Crear_Personas_y_Trabajos();
        Arquitecto_Crear_Edificios_Asignarlos_A_Trabajos();
        Contable_Agregar_Presupuesto_Y_Costes();
        Arquitecto_Entrega_Proyectos();
        Administrador_Actualiza_Calendario_Obra();
        Aparejador_Visita_Certificado_Eficiencia();
        Aparejador_Visita_Certificado_Habitabilidad();
        Arquitecto_Expedir_Certificado_Eficiencia();
        Arquitecto_Expedir_Certificado_Habitabilidad();
    }

}
