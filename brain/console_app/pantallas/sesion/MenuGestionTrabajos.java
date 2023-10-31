package console_app.pantallas.sesion;

import java.util.ArrayList;
import java.util.List;

import console_app.interfaces.pantallas.IOpcion;
import console_app.interfaces.personas.IEmpleado;
import console_app.pantallas.aplicacion.MenuOpcionOperativa;
import console_app.pantallas.aplicacion.MenuOperativa;
import console_app.pantallas.aplicacion.Pantalla;
import console_app.servicios.Io;
import console_app.tipos.entidades.EntidadTipos;
import console_app.tipos.entidades.Opcion;
import console_app.tipos.personas.Arquitecto;

/**
 * Desarrollo de un {@link console_app.tipos.trabajos.Proyecto} arquitectónico: los {@link console_app.tipos.personas.Cliente} 
 * acuden al {@link Estudio} para solicitar un proyecto arquitectónico.  
 *  <p>
 * Este proyecto puede ser de los tipos {@link console_app.tipos.trabajos.ProyectoResidencial},
 * {@link console_app.tipos.trabajos.ProyectoNoResidencial} o {@link console_app.tipos.trabajos.ProyectoRehabilitacion},
 * y será necesario:  
 *  <p>
 * <li> almacenar la fecha de solicitud {@link console_app.servicios.Io#CAMPO_FECHA_SOLICITUD},  
 * <li> de {@link console_app.servicios.Io#CAMPO_FECHA_ENTREGA} al cliente,  
 * <li> {@link console_app.servicios.Io#CAMPO_DURACION}/{@link console_app.servicios.Io#CAMPO_FECHA_PREVISTO} prevista de la obra,  
 * <li> y {@link console_app.tipos.trabajos.Presupuesto} de ejecución.  
 *  <p>
 * Una vez contratada la construcción también será necesario:  
 *   
 *<li> almacenar las {@link console_app.servicios.Io#CAMPO_FECHA_INICIO} de construcción  
 * <li> y duración prevista,  
 * <li> y al finalizar la obra la {@link console_app.servicios.Io#CAMPO_FECHA_FIN} de la obra.  
 *  <p>
 * Desarrollo de un  {@link console_app.tipos.trabajos.Certificado}:  
 * los {@link console_app.tipos.personas.Cliente} acuden al estudio para  
 * solicitar {@link console_app.servicios.Io#OPCION_GESTION_CERTIFICADO} un certificado.  
 *  <p>
 * Este certificado puede ser de los tipos:
 * {@link  console_app.tipos.trabajos.CertificadoEficiencia}, {@link  console_app.tipos.trabajos.CertificadoHabitabilidad},
 * {@link  console_app.tipos.trabajos.CertificadoInforme}, {@link  console_app.tipos.trabajos.CertificadoInspeccion}
 *  y será necesario:  
 * <li> almacenar la {@link console_app.servicios.Io#CAMPO_FECHA_SOLICITUD},  
 * <li> de {@link console_app.servicios.Io#CAMPO_FECHA_ENTREGA} al cliente.   
 *  <p>
 * @author Jaime Sánchez
 * @version 1.0.0
 */
public class MenuGestionTrabajos extends MenuOperativa
{
    /**
     * Constructor for objects of class MenuInicial
     */
    public MenuGestionTrabajos(IEmpleado usuario)
    {
        super(usuario);

        titulo = Io.OPCION_GESTION_TRABAJOS;

        opciones.addAll(opcionesProyecto());
        opciones.addAll(opcionesCertificado(4));

        if (usuario instanceof Arquitecto) {
            opciones.addAll(opcionesEficio());
        }

    }

    public void mostrarOpciones(List<IOpcion> opciones) {

        limpiarPantalla();

        Pantalla.titulo(Io.TITULO_APP);
        Pantalla.titulo(titulo);

        int i = 1;
        for(IOpcion opcion: opciones) {
            if (opcion != null ) {

                String e = String.format(Io.OPCION_ENUMERACION, i++);
                Pantalla.opcion(e + opcion.etiqueta());
            }
        }
    }

    /**
     * Carga las opciones de Trabajos y Edificios
     */
    public void mostrarOpciones() {

        mostrarOpciones(opciones);
    }

    public List<IOpcion> opcionesProyecto() {

        List<IOpcion> ops = new ArrayList<>();
        String pre = Io.OPCION_GESTION_PROYECTO + " > ";
        ops.add(new Opcion(pre + Io.OPCION_GESTION_RESIDENCIAL, "1", EntidadTipos.ProyectoResidencial));
        ops.add(new Opcion(pre + Io.OPCION_GESTION_NORESIDENCIAL, "2", EntidadTipos.ProyectoNoResidencial));
        ops.add(new Opcion(pre + Io.OPCION_GESTION_PROYECTO_REHABILITACION, "3", EntidadTipos.ProyectoRehabilitacion));

        return ops;
    }

    public List<IOpcion> opcionesCertificado(Integer llaveInicial) {

        List<IOpcion> ops = new ArrayList<>();
        String pre = Io.OPCION_GESTION_CERTIFICADO + " > ";
        ops.add(new Opcion(pre + Io.OPCION_GESTION_CERTIFICADO_EFICIENCIA, "" + llaveInicial, EntidadTipos.CertificadoEficiencia));
        ops.add(new Opcion(pre + Io.OPCION_GESTION_CERTIFICADO_HABITABILIDAD, "" + (llaveInicial + 1), EntidadTipos.CertificadoHabitabilidad));
        ops.add(new Opcion(pre + Io.OPCION_GESTION_CERTIFICADO_INSPECCION, "" + (llaveInicial + 2), EntidadTipos.CertificadoInspeccion));
        ops.add(new Opcion(pre + Io.OPCION_GESTION_CERTIFICADO_INFORME, "" + (llaveInicial + 3), EntidadTipos.CertificadoInforme));

        return ops;
    }

    public List<IOpcion> opcionesEficio() {

        List<IOpcion> ops = new ArrayList<>();
        String pre = Io.OPCION_GESTION_EDIFICACIONES + " > ";
        ops.add(new Opcion(pre + Io.OPCION_GESTION_RESIDENCIAL, "8", EntidadTipos.EdificacionResidencial));
        ops.add(new Opcion(pre + Io.OPCION_GESTION_NORESIDENCIAL, "9", EntidadTipos.EdificacionNoResidencial));
        ops.add(new Opcion(pre + Io.OPCION_GESTION_RESIDENCIAL_COMUNITARIO, "10", EntidadTipos.EdificacionResidencialComunitario));

        return ops;
    }

    public String pedirOpcion() {

        opcion.entrada(super.pedirOpcion());

        if (opcion.entrada().isEmpty()) {
            return "";
        }

        IOpcion opcionConocida = buscarEntrada(opcion.entrada());
        if (opcionConocida == null) {
            opcionNoEncontrada();
            return pedirOpcion();
        }

        tipo = opcionConocida.llaveTipo();
        menuOpcion = new MenuOpcionOperativa(new MenuGestionEntidad(usuario, tipo));
        menuOpcion.ejecutar();
        return opcion.entrada();

    }

}
