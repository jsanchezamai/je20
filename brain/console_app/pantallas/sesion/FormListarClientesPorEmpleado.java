package console_app.pantallas.sesion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import console_app.interfaces.entidades.IEntidad;
import console_app.interfaces.personas.IAparejador;
import console_app.interfaces.personas.IArquitecto;
import console_app.interfaces.personas.ICliente;
import console_app.interfaces.personas.IContable;
import console_app.interfaces.personas.IEmpleado;
import console_app.interfaces.trabajos.ITrabajo;
import console_app.pantallas.aplicacion.MenuFormulario;
import console_app.pantallas.aplicacion.Pantalla;
import console_app.servicios.Io;
import console_app.tipos.entidades.Entidad;
import console_app.tipos.entidades.EntidadTipos;
import console_app.tipos.entidades.Filtro;
import console_app.tipos.personas.Administrador;
import console_app.tipos.personas.Aparejador;
import console_app.tipos.personas.Arquitecto;
import console_app.tipos.personas.Contable;

/**
* Muestra la información de clientes-edificios-trabajos de un cierto empleado
 * (o de todos si el usuario que usar el formulario es administrador)
 *
 * @author Jaime Sánchez
 * @version 1.0.0
 */
public class FormListarClientesPorEmpleado extends MenuFormulario
{

    public FormListarClientesPorEmpleado(IEmpleado usuario)
    {
        super(usuario, EntidadTipos.Cliente);

        if (usuario instanceof Administrador) {
            titulo = String.format(Io.TITULO_LISTAR_CLIENTES_POR_EMPLEADO, Io.TITULO_ADMINISTRADOR);
        } else {

            titulo = String.format(Io.TITULO_LISTAR_CLIENTES_POR_EMPLEADO, usuario.comoRegistro());
        }


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
        String t = "    ";
        int totalRegistros = 0;
        for(IEntidad cliente: datos.keySet()) {

            impresion += n + Io.CAMPO_CLIENTE + ":" + cliente.comoRegistro();

            List<ITrabajo> trabajosDelCliente = datos.get(cliente);
            for(ITrabajo trabajo: trabajosDelCliente) {

                impresion += n + t + trabajo.comoResumen();

                if (usuario instanceof Administrador) {
                    IArquitecto arquitecto = trabajo.getArquitecto();
                    IAparejador aparejador = trabajo.getAparejador();
                    IContable contable = trabajo.getContable();
                    impresion += n + t + t + Io.formatearColumna(Io.CAMPO_ARQUITECTO, 15, " ") + arquitecto.comoRegistro();
                    impresion += n + t + t + Io.formatearColumna(Io.CAMPO_APAREJADOR, 15, " ") + aparejador.comoRegistro();
                    impresion += n + t + t + Io.formatearColumna(Io.CAMPO_CONTABLE, 15, " ") + contable.comoRegistro();
                } 
                totalRegistros++;
            }

        }
        impresion += String.format(Io.ETIQUETA_IMPRESION_TOTAL, totalRegistros);
        return impresion;
    }

    private Map<ICliente, List<ITrabajo>> obtenerDatos() {

        Map<ICliente, List<ITrabajo>> registros = new HashMap<>();

        // Recuperar todos los trabajos
        Filtro filtroTrabajos = new Filtro((entidad) -> {
            ITrabajo trabajo = (ITrabajo) entidad;

            if (usuario instanceof Administrador) {
                return true;    // todos
            }
            if (usuario instanceof Arquitecto) {
                return trabajo.getArquitectoId().equals(usuario.getIdS());
            }

            if (usuario instanceof Aparejador) {
                return trabajo.getArquitectoId().equals(usuario.getIdS());
            }

            if (usuario instanceof Contable) {
                return trabajo.getArquitectoId().equals(usuario.getIdS());
            }
            return false;
        });
        List<ITrabajo> trabajos = Entidad
            .buscar(EntidadTipos.Trabajo, filtroTrabajos)
            .stream()
            .map(entidad -> (ITrabajo) entidad)
            .collect(Collectors.toList());

        for(ITrabajo trabajo: trabajos) {

            ICliente cliente;

            // Buscar si ya se ha agregado este cliente al map
            Optional<ICliente> find = registros
                .keySet()
                .stream()
                .filter((c) -> c.getIdS().equals(trabajo.getClienteId()))
                .findFirst();

            List<ITrabajo> trabajosDelCliente;
            if (find.isPresent()) {
                // El cliente ya existía, tomar la referencia de su lista de trabajos
                cliente = find.get();
                trabajosDelCliente = registros.get(cliente);
            } else {
                // Primera ocurrencia del cliente, incializar su lista de trabajos
                cliente = trabajo.getCliente();
                trabajosDelCliente = new ArrayList<>();
            }
            trabajosDelCliente.add(trabajo);
            registros.put(cliente, trabajosDelCliente);
        }

        return registros;
    }

}
