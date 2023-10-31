package console_app.pantallas.sesion;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import console_app.interfaces.entidades.IEntidad;
import console_app.interfaces.personas.IEmpleado;
import console_app.interfaces.trabajos.ICertificadoHabitabilidad;
import console_app.interfaces.trabajos.IEdificacion;
import console_app.pantallas.aplicacion.MenuFormulario;
import console_app.pantallas.aplicacion.Pantalla;
import console_app.servicios.Io;
import console_app.tipos.entidades.Entidad;
import console_app.tipos.entidades.EntidadTipos;
import console_app.tipos.entidades.Fecha;
import console_app.tipos.trabajos.CertificadoHabitabilidad;

/**
 * Listado de edificios que tienen el {@link console_app.interfaces.trabajos.ICertificadoHabitabilidad} caducado.
 *
 *
 * @author Jaime Sánchez
 * @version 1.0.0
 */
public class FormListarEdificiosConCertificadoHabitabilidad extends MenuFormulario
{

    private boolean filtrarPorCaducados;

    public FormListarEdificiosConCertificadoHabitabilidad(IEmpleado usuario, boolean filtrarPorCaducados)
    {
        super(usuario, EntidadTipos.Edificacion);
        this.filtrarPorCaducados = filtrarPorCaducados;

        if (filtrarPorCaducados) {
            titulo = Io.TITULO_LISTAR_CLIENTES_EDIFICACION_CERTIFICADO_HABITABILIDAD;
        } else {
            titulo = Io.TITULO_LISTAR_VIVIENDAS_HABITABILIDAD;
        }
    }

    public String pedirOpcion() {

        return Pantalla.volcar(
            listaAPantalla(
                obtenerDatos()
            )
        );
    }

    private String listaAPantalla(Map<IEdificacion, ICertificadoHabitabilidad> datos) {

        String impresion = "";
        String n = "\n";

        boolean primero = true;
        for(IEntidad edificacion: datos.keySet()) {

            if (primero) {
                impresion += n + Io.CAMPO_EDIFICACION + ":" + edificacion.comoRegistroCabecera();
                primero = false;
            }

            impresion += n + Io.CAMPO_EDIFICACION + ":" + edificacion.comoRegistro();
            ICertificadoHabitabilidad certificado = datos.get(edificacion);
            impresion += n + " .. (" + certificado.getIdS() + ") " + certificado.getTipo();

            impresion += " >> " + Io.CAMPO_FECHA_CERTIFICACION + ": " + certificado.getFechaEstadoComoEtiqueta();

            impresion += " >> " + Io.CAMPO_FECHA_CADUCA + ": " + Fecha.fechaComoCadena(certificado.getCaduca());

            impresion += n + " >>>> " + Io.CAMPO_CLIENTE + ": " + certificado.getCliente().comoRegistro();

        }
        return impresion;
    }

    public Map<IEdificacion, ICertificadoHabitabilidad> obtenerDatos() {

        Map<IEdificacion, ICertificadoHabitabilidad> registros = new HashMap<>();

        // Recuperar todos los certificados
        List<CertificadoHabitabilidad> Certificados = Entidad
            .buscar(
                EntidadTipos.CertificadoHabitabilidad, 
                CertificadoHabitabilidad.getFiltro(filtrarPorCaducados))
            .stream()
            .map(entidad -> (CertificadoHabitabilidad) entidad)
            .sorted(CertificadoHabitabilidad.ordenarFechaCertificacion) // <--- ordernamos ascendente for fecha
            .collect(Collectors.toList());

        for(CertificadoHabitabilidad certificado: Certificados) {

            IEdificacion edificacion;

            Optional<IEdificacion> find = registros
                .keySet()
                .stream()
                .filter((c) -> c.getIdS().equals(entidad.getIdS()))
                .findFirst();

                if (find.isPresent()) {
                    edificacion = find.get();
                } else {
                    edificacion = certificado.getEdificacion();

                }
                registros.put(edificacion, certificado); // <--- sobrescribimos en caso de más de uno
        }

        return registros;
    }

}
