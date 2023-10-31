package console_app.tipos.trabajos;

import java.util.Comparator;
import java.util.Date;

import console_app.interfaces.trabajos.ICertificado;
import console_app.interfaces.trabajos.ICalendarioDia.Tipos;
import console_app.servicios.calendario.Empresa;
import console_app.tipos.entidades.EntidadTipos;

/**
 * Descripción en {@link console_app.interfaces.trabajos.ICertificado}
 */
public class Certificado extends Trabajo implements ICertificado {

    public Certificado() {
        super();
        configurar();
    }

    public Certificado(int id) {
        super(id);
        configurar();
    }

    private void configurar() {
        setTipo(EntidadTipos.Certificado);
    }

    @Override
    public Estados getEstado() {

        if (getEntrega() != null)
            return Estados.Entregado;

        if (getFechaCertificacion() != null)
            return Estados.Certificado;

        if (getFechaVisita() != null)
            return Estados.Visitado;

        return Estados.Solicitado;
    }

    @Override
    public Date getFechaCertificacion() {
        return Empresa.get().getFecha(Tipos.Certificacion, id);
    }

    @Override
    public Date getFechaVisita() {
        return Empresa.get().getFecha(Tipos.Visita, id);
    }

    @Override
    public Date getFechaEstado() {

        if (getEntrega() != null)
            return getEntrega();

        if (getFechaCertificacion() != null)
            return getFechaCertificacion();

        if (getFechaVisita() != null)
            return getFechaVisita();

        return getSolicitud();
    }

    public static Comparator<ICertificado> ordenarFechaCertificacion =  new Comparator<ICertificado>() {
        public int compare(ICertificado s1, ICertificado s2) {
            return s1.getFechaCertificacion().compareTo(s2.getFechaCertificacion());
        }
    };
}
