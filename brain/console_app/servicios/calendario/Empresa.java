package console_app.servicios.calendario;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import console_app.interfaces.trabajos.ICalendario;
import console_app.interfaces.trabajos.ICalendarioDia;
import console_app.interfaces.trabajos.IEmpresa;
import console_app.interfaces.trabajos.IProyecto;
import console_app.interfaces.trabajos.ICalendarioDia.Tipos;
import console_app.pantallas.aplicacion.Pantalla;
import console_app.servicios.Io;
import console_app.tipos.entidades.Entidad;
import console_app.tipos.entidades.EntidadTipos;
import console_app.tipos.entidades.Fecha;
import console_app.tipos.entidades.Filtro;

/**
 * Una empresa puede llevar hasta 3 proyectos a la vez.
 * 
 * El {@link Estudio} mediante el {@link console_app.interfaces.personas.IAdministrador} 
 * tendrá que ponerse en contacto con el @link console_app.interfaces.personas.ICliente} 
 * para informar {@link console_app.interfaces.trabajos.notificador.INotificacion} de {@link console_app.interfaces.trabajos.IRenovacion} 
 * y preguntar por su posible renovación.
 *
 * @author jsm
 * @version 1.0
 */
public class Empresa implements IEmpresa
{
    static Empresa empresa;

    int capacidad;
    List<ICalendario> capacidadLista;

    public Empresa(int capacidad) {

        this.capacidad = capacidad;

        capacidadLista = new ArrayList<>();
        for(int i = 1; i <= capacidad; i++) {
            capacidadLista.add(new Calendario(i));
        }

    }

    @Override
    public boolean inicializar() {
        empresa = this;
        return true;
    }

    public static Empresa get() {
        
        if (empresa == null) {
            empresa = new Empresa(3);
        }
        return empresa;
    }

    @Override
    public List<ICalendario> getCapacidad() {
        return this.capacidadLista;
    }

    @Override
    public List<Date> disponibilidad(IProyecto trabajo) {

        List<Date> disponibles = new ArrayList<>();
        for(ICalendario capacidad: getCapacidad()) {
            disponibles.add(
                capacidad.disponibilidad(trabajo)
            );
        }
        return disponibles;

    }

    public boolean agregar(Dia dia, boolean alCalendarioPorDefecto) {

        if (alCalendarioPorDefecto) {
            dia.setCalendarioId(1);
            dia.agregar();
            return true;
        }

        for(ICalendario capacidad: getCapacidad()) {
            dia.setCalendarioId(capacidad.getId());
            if (capacidad.fechaPermitida(dia)) {
                dia.agregar();
                return true;
            } else {
                Pantalla.volcar("DEBUG Calendario: " + capacidad.getId() + " ocupado para fecha: " + dia.getFecha());
            }
        }

        Pantalla.error(Io.ERROR_FECHA_OCUPADA);
        return false;

    }

    @Override
    public ICalendarioDia getDia(Tipos tipoFecha, Integer trabajoId) {
        Filtro filtro = new Filtro((entidad) -> {
            ICalendarioDia dia = (ICalendarioDia) entidad;
            return dia.getTipoFecha() == tipoFecha && dia.getTrabajoId() == trabajoId;
        });
        List<Dia> dia = Entidad
            .buscar(EntidadTipos.Dia, filtro)
            .stream()
            .map(entidad -> (Dia) entidad)
            .collect(Collectors.toList());

        return dia.size() > 0 ? dia.get(0) : null;
    }

    @Override
    public Date getFecha(Tipos tipoFecha, Integer trabajoId) {
        Dia dia = (Dia) getDia(tipoFecha, trabajoId);
        return dia == null ? null : dia.getFecha();
    }

    @Override
    public void test(String[] secuencia) {
        // TODO Auto-generated method stub

    }

    @Override
    public void test(String secuencia) {
        // TODO Auto-generated method stub

    }

    @Override
    public void agregarSolicitud(Integer trabajoId) {
        Dia dia = (Dia) Entidad.porDefecto(EntidadTipos.Dia);
        dia.setValor(Tipos.Solicitud, Fecha.ahoraDate(), trabajoId);
        agregar(dia, true);
    }

    @Override
    public int testSize() {
        return 0;
    }

    @Override
    public void testMode(boolean b) {
        //
    }

    @Override
    public void inputTest(boolean b) {
        // TODO Auto-generated method stub
        
    }


}
