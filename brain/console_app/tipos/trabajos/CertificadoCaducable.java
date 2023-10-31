package console_app.tipos.trabajos;


import java.time.LocalDateTime;
import java.util.Date;

import console_app.interfaces.trabajos.ICalendarioDia;
import console_app.interfaces.trabajos.ICertificadoCaducable;
import console_app.interfaces.trabajos.ICalendarioDia.Tipos;
import console_app.servicios.calendario.Empresa;
import console_app.tipos.entidades.Fecha;

/**
 * Descripción en {@link console_app.interfaces.trabajos.ICertificadoCaducable}
 */
public class CertificadoCaducable implements ICertificadoCaducable
{
    private int anyosVigencia;
    private int id;

    public CertificadoCaducable(int id, int anyosVigencia) {
        this.id = id;
        this.anyosVigencia = anyosVigencia;
    }

    @Override
    public boolean getCaducado() {
        return getCaducado(Fecha.ahoraLocalDate());
    }

    @Override
    public boolean getCaducado(LocalDateTime date) {
        if (date == null) {
            date = Fecha.ahoraLocalDate();
        }

        return Fecha.dateToLocal(getCaduca()).isBefore(date);
    }

    @Override
    public Date getCaduca() {

        ICalendarioDia dia = Empresa.get().getDia(Tipos.Certificacion, id);

        LocalDateTime caduca = Fecha.dateToLocal(dia.getFecha());
        return Fecha.localToDate(caduca.plusYears(anyosVigencia));
    }

}
