package console_app.pantallas.sesion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import console_app.interfaces.entidades.IEntidad;
import console_app.interfaces.personas.ICliente;
import console_app.interfaces.personas.IEmpleado;
import console_app.interfaces.trabajos.ICertificado;
import console_app.interfaces.trabajos.ITrabajo;
import console_app.interfaces.trabajos.ITrabajo.Estados;
import console_app.pantallas.aplicacion.Pantalla;
import console_app.servicios.Io;
import console_app.tipos.entidades.Entidad;
import console_app.tipos.entidades.EntidadTipos;
import console_app.tipos.entidades.Filtro;

/**
 * Muestra la información de clientes-edificios-trabajos de los Aparejadores
 *
 * @author Jaime Sánchez
 * @version 1.0.0
 */
public class FormListarClientesPorAparejador extends FormListarClientesPorEmpleado
{

    public FormListarClientesPorAparejador(IEmpleado usuario)
    {
        super(usuario);

        titulo = Io.TITULO_LISTAR_CLIENTES_POR_CONTABLE;

    }

    public String pedirOpcion() {

        return Pantalla.volcar(
            listaAPantalla(
                obtenerDatos()
            )
        );
    }

    private String listaAPantalla(Map<ICliente, List<ITrabajo>> datos) {

        String impresion = "";
        String n = "\n";
        int totalRegistros = 0;
        for(IEntidad cliente: datos.keySet()) {

            impresion += n + Io.CAMPO_CLIENTE + ":" + cliente.comoRegistro();

            List<ITrabajo> trabajosDelCliente = datos.get(cliente);
            for(ITrabajo trabajo: trabajosDelCliente) {

                impresion += n + " .. (" + trabajo.getIdS() + ") " + trabajo.getTipo() + " > " + trabajo.getEstado();
                totalRegistros++;
            }

        }
        impresion += String.format(Io.ETIQUETA_IMPRESION_TOTAL, totalRegistros);
        return impresion;
    }

    private Map<ICliente, List<ITrabajo>> obtenerDatos() {

        Map<ICliente, List<ITrabajo>> registros = new HashMap<>();

        // Recuperar todos los certificados
        Filtro filtroTrabajos = new Filtro((entidad) -> {
            ICertificado certificado = (ICertificado) entidad;
            return certificado.getAparejadorId().equals(usuario.getIdS()) &&
                certificado.getEstado() == Estados.Solicitado;
        });
        List<ITrabajo> trabajos = Entidad
            .buscar(EntidadTipos.Certificado, filtroTrabajos)
            .stream()
            .map(entidad -> (ITrabajo) entidad)
            .collect(Collectors.toList());

        for(ITrabajo trabajo: trabajos) {

            ICliente cliente;

            Optional<ICliente> find = registros
                .keySet()
                .stream()
                .filter((c) -> c.getIdS().equals(trabajo.getClienteId()))
                .findFirst();

            List<ITrabajo> trabajosDelCliente;
            if (find.isPresent()) {
                cliente = find.get();
                trabajosDelCliente = registros.get(cliente);
            } else {
                cliente = trabajo.getCliente();
                trabajosDelCliente = new ArrayList<>();
            }
            trabajosDelCliente.add(trabajo);
            registros.put(cliente, trabajosDelCliente);
        }

        return registros;
    }

}
