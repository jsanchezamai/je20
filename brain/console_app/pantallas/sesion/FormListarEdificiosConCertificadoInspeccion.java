package console_app.pantallas.sesion;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import console_app.interfaces.entidades.IEntidad;
import console_app.interfaces.personas.IEmpleado;
import console_app.interfaces.trabajos.ICertificadoInspeccion;
import console_app.interfaces.trabajos.IEdificacion;
import console_app.pantallas.aplicacion.MenuFormulario;
import console_app.pantallas.aplicacion.Pantalla;
import console_app.servicios.Io;
import console_app.tipos.entidades.Entidad;
import console_app.tipos.entidades.EntidadTipos;
import console_app.tipos.trabajos.CertificadoInspeccion;

/**
 * Listado de edificios que tienen el {@link console_app.interfaces.trabajos.ICertificadoInspeccion} caducado.
 *
 * @author Jaime Sánchez
 * @version 1.0.0
 */
public class FormListarEdificiosConCertificadoInspeccion extends MenuFormulario
{

    public FormListarEdificiosConCertificadoInspeccion(IEmpleado usuario)
    {
        super(usuario, EntidadTipos.Edificacion);
        titulo = Io.TITULO_LISTAR_CLIENTES_EDIFICACION_CERTIFICADO_INSPECCION;

    }

    public String pedirOpcion() {

        return Pantalla.volcar(
            listaAPantalla(
                obtenerDatos()
            )
        );
    }

    private String listaAPantalla(Map<IEdificacion, ICertificadoInspeccion> datos) {

        String impresion = "";
        String n = "\n";

        boolean primero = true;
        for(IEntidad edificacion: datos.keySet()) {

            if (primero) {
                impresion += n + Io.CAMPO_EDIFICACION + ":" + edificacion.comoRegistroCabecera();
                primero = false;
            }

            impresion += n + Io.CAMPO_EDIFICACION + ":" + edificacion.comoRegistro();
            ICertificadoInspeccion certificado = datos.get(edificacion);
            impresion += n + " .. (" + certificado.getIdS() + ") " + certificado.getTipo();

            impresion += " >> " + Io.CAMPO_FECHA_CERTIFICACION + ": " + certificado.getFechaCertificacion();
            impresion += " >>>> " + Io.CAMPO_CLIENTE + ": " + certificado.getCliente().comoRegistro();

        }

        impresion += String.format(Io.ETIQUETA_IMPRESION_TOTAL, datos.size());
        return impresion;
    }

    private Map<IEdificacion, ICertificadoInspeccion> obtenerDatos() {

        Map<IEdificacion, ICertificadoInspeccion> registros = new HashMap<>();

        List<CertificadoInspeccion> Certificados = Entidad
            .buscar(
                EntidadTipos.CertificadoInspeccion, 
                CertificadoInspeccion.getFiltro(true))
            .stream()
            .map(entidad -> (CertificadoInspeccion) entidad)
            .sorted(CertificadoInspeccion.ordenarFechaCertificacion) // <--- ordernamos ascendente for fecha
            .collect(Collectors.toList());

        for(CertificadoInspeccion certificado: Certificados) {

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
