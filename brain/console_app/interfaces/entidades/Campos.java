package console_app.interfaces.entidades;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import console_app.servicios.Io;
import console_app.tipos.entidades.Campo;
import console_app.tipos.entidades.EntidadTipos;
import console_app.tipos.entidades.Fecha;
import console_app.tipos.entidades.TiposDato;
import console_app.tipos.personas.Arquitecto;
import console_app.tipos.personas.Contable;

public class Campos {

    public enum CamposEnum {
        Nombre,
        Apellidos,

        Direccion,
        SuperficieTerreno,
        SuperFicieEdificio,
        Cliente,

        Lavabos,
        Habitaciones,
        Plantas,

        Finalidad,

        EdificacionResidencialComunitario, Edificacion, EdificacionResidencial,
        EnumeracionEficiencia,
        Duracion,
        EdificacionNoResidencial,
        Arquitecto, Aparejador, Contable, Coste,
        FechaInicio, FechaFin, FechaEntrega, FechaVisita, FechaCertificacion, FechaFiltro,
        Proyecto, CosteIva, Fecha, CosteCantidad,
        Presupuesto, CostePrecioUnidad
    }

    public static HashMap<EntidadTipos, ICampo[]> entidades = new HashMap<>();

    public Campos() {

        Campo[] entidades = {
            new Campo(CamposEnum.Nombre, Io.CAMPO_NOMBRE, TiposDato.Cadena)
        };
        Campos.entidades.put(EntidadTipos.Entidad,entidades);

        Campo[] personas = {
            new Campo(CamposEnum.Apellidos, Io.CAMPO_APELLIDO, TiposDato.Cadena)
        };
        Campos.entidades.put(EntidadTipos.Persona, personas);

        Campo[] edificios = {
            new Campo(CamposEnum.Cliente, Io.CAMPO_CLIENTE, TiposDato.Cliente, Arquitecto.class),
            new Campo(CamposEnum.Direccion, Io.CAMPO_DIRECCION, TiposDato.Cadena, Arquitecto.class),
            new Campo(CamposEnum.SuperFicieEdificio, Io.CAMPO_SUPERFICIE_EDIFICIO, TiposDato.Numero, Arquitecto.class)
        };
        Campos.entidades.put(EntidadTipos.Edificacion, edificios);

        Campo[] edificiosResidencial = {
            new Campo(CamposEnum.SuperficieTerreno, Io.CAMPO_SUPERFICIE_TERRENO, TiposDato.Numero, Arquitecto.class),
            new Campo(CamposEnum.Plantas, Io.CAMPO_PLANTAS, TiposDato.Numero, Arquitecto.class),
            new Campo(CamposEnum.Habitaciones, Io.CAMPO_HABITACIONES, TiposDato.Numero, Arquitecto.class),
            new Campo(CamposEnum.Lavabos, Io.CAMPO_LAVABOS, TiposDato.Numero, Arquitecto.class)
        };
        Campos.entidades.put(EntidadTipos.EdificacionResidencial, edificiosResidencial);

        Campo[] edificacionNoResidencial = {
            new Campo(CamposEnum.SuperficieTerreno, Io.CAMPO_SUPERFICIE_TERRENO, TiposDato.Numero, Arquitecto.class),
            new Campo(CamposEnum.Finalidad, Io.CAMPO_FINALIDAD, TiposDato.Cadena, Arquitecto.class)
        };
        Campos.entidades.put(EntidadTipos.EdificacionNoResidencial, edificacionNoResidencial);

        Campo[] trabajo = {
            new Campo(CamposEnum.Arquitecto, Io.CAMPO_ARQUITECTO, TiposDato.Arquitecto),
            new Campo(CamposEnum.Aparejador, Io.CAMPO_APAREJADOR, TiposDato.Aparejador),
            new Campo(CamposEnum.Contable, Io.CAMPO_CONTABLE, TiposDato.Contable),
            new Campo(CamposEnum.Cliente, Io.CAMPO_CLIENTE, TiposDato.Cliente),
            new Campo(CamposEnum.Coste, Io.CAMPO_COSTE, TiposDato.Decimal, false, "0", Contable.class)
        };
        Campos.entidades.put(EntidadTipos.Trabajo, trabajo);

        Campo[] certificadoInspeccion = {
            new Campo(CamposEnum.EdificacionResidencialComunitario, Io.CAMPO_EDIFICACION, TiposDato.EdificacionResidencialComunitario, Arquitecto.class)
        };
        Campos.entidades.put(EntidadTipos.CertificadoInspeccion, certificadoInspeccion);

        Campo[] certificadoInforme = {
            new Campo(CamposEnum.Edificacion, Io.CAMPO_EDIFICACION, TiposDato.Edificacion, Arquitecto.class)
        };
        Campos.entidades.put(EntidadTipos.CertificadoInforme, certificadoInforme);

        Campo[] certificadoHabitabilidad = {
            new Campo(CamposEnum.EdificacionResidencial, Io.CAMPO_EDIFICACION, TiposDato.EdificacionResidencial, Arquitecto.class)
        };
        Campos.entidades.put(EntidadTipos.CertificadoHabitabilidad, certificadoHabitabilidad);

        Campo[] certificadoEficiencia = {
            new Campo(CamposEnum.Edificacion, Io.CAMPO_EDIFICACION, TiposDato.Edificacion, Arquitecto.class),
            new Campo(CamposEnum.EnumeracionEficiencia, Io.CAMPO_EFICIENCIA, TiposDato.EnumeracionEficiencia, Arquitecto.class)
        };
        Campos.entidades.put(EntidadTipos.CertificadoEficiencia, certificadoEficiencia);

        Campo[] proyecto = {
            new Campo(CamposEnum.Duracion, Io.CAMPO_DURACION, TiposDato.Numero, Arquitecto.class)
        };
        Campos.entidades.put(EntidadTipos.Proyecto, proyecto);

        Campo[] proyectoNoResidencial = {
            new Campo(CamposEnum.EdificacionNoResidencial, Io.CAMPO_EDIFICACION, TiposDato.EdificacionNoResidencial, Arquitecto.class)
        };
        Campos.entidades.put(EntidadTipos.ProyectoNoResidencial, proyectoNoResidencial);

        Campo[] proyectoResidencial = {
            new Campo(CamposEnum.EdificacionResidencial, Io.CAMPO_EDIFICACION, TiposDato.EdificacionResidencial, Arquitecto.class),
        };
        Campos.entidades.put(EntidadTipos.ProyectoResidencial, proyectoResidencial);

        Campo[] proyectoRehabilitacion = {
            new Campo(CamposEnum.Edificacion, Io.CAMPO_EDIFICACION, TiposDato.Edificacion, Arquitecto.class)
        };
        Campos.entidades.put(EntidadTipos.ProyectoRehabilitacion, proyectoRehabilitacion);

        Campo[] presupuesto = {
            new Campo(CamposEnum.Fecha, Io.CAMPO_FECHA, TiposDato.Fecha, true, Fecha.ahora(), Contable.class),
            new Campo(CamposEnum.CosteIva, Io.CAMPO_COSTE_IVA, TiposDato.Numero, true, "21", Contable.class),
            new Campo(CamposEnum.Proyecto, Io.TITULO_PROYECTO, TiposDato.Trabajo, false, false)
        };
        Campos.entidades.put(EntidadTipos.Presupuesto, presupuesto);

        Campo[] presupuestoLinea = {
            new Campo(CamposEnum.CosteCantidad, Io.CAMPO_COSTE_CANTIDAD, TiposDato.Numero, false, "1", Contable.class),
            new Campo(CamposEnum.CostePrecioUnidad, Io.CAMPO_COSTE_PRECIO_UNIDAD, TiposDato.Numero, false, "1", Contable.class),
            new Campo(CamposEnum.Presupuesto, Io.CAMPO_PRESUPUESTO, TiposDato.Presupuesto, false, false)
        };
        Campos.entidades.put(EntidadTipos.PresupuestoLinea, presupuestoLinea);

    }

    public static  List<ICampo> cargarCamposEntidad(EntidadTipos entidad, List<ICampo> campos) {
        campos = campos == null ? new ArrayList<>(): campos;

        if (entidades.size() == 0) {
            new Campos();
        }
        List<ICampo> lista = new ArrayList<>();
        for(ICampo campo: entidades.get(entidad)) {
            lista.add(campo.clone());
        }
        return Stream.concat(
            campos.stream(),
            lista.stream()
        ).collect(Collectors.toList());
    }
}

