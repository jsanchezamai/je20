package console_app.tipos.trabajos;

import java.time.LocalDateTime;
import java.util.Date;

import console_app.interfaces.entidades.Campos;
import console_app.interfaces.entidades.Campos.CamposEnum;
import console_app.interfaces.trabajos.ICertificadoHabitabilidad;
import console_app.interfaces.trabajos.IEdificacionResidencial;
import console_app.tipos.entidades.Entidad;
import console_app.tipos.entidades.EntidadTipos;
import console_app.tipos.entidades.Filtro;

/**
 * Descripción en {@link console_app.interfaces.trabajos.ICertificadoHabitabilidad }.
 */
public class CertificadoHabitabilidad extends Certificado implements ICertificadoHabitabilidad
{
    private CertificadoCaducable caducable;

    public CertificadoHabitabilidad(int id) {
        super(id);
        configurar();
    }

    private void configurar() {
        setTipo(EntidadTipos.CertificadoHabitabilidad);
        campos = Campos.cargarCamposEntidad(this.getTipo(), campos);
        caducable = new CertificadoCaducable(id, 45);
    }

    @Override
    public IEdificacionResidencial getEdificacion() {
        EdificacionResidencial e = (EdificacionResidencial) Entidad
            .buscarPorId(
                EntidadTipos.EdificacionResidencial,
                getCampo(CamposEnum.EdificacionResidencial).valorForanea()
            );
        return e;
    }

    @Override
    public boolean getCaducado() {
        return caducable.getCaducado();
    }

    @Override
    public boolean getCaducado(LocalDateTime date) {
        return caducable.getCaducado(date);
    }

    @Override
    public Date getCaduca() {
        return caducable.getCaduca();
    }

    /**
     * @param filtrarPorCaducados Restringe la lista a los que estén, además, caducados
     * @return una lista de todos los certificados de este tipo que estén
     *  {@link console_app.interfaces.trabajos.ITrabajo.Estados#Certificado}.
     */
    public static Filtro getFiltro(boolean filtrarPorCaducados) {
        Filtro filtroCertificados = new Filtro((entidad) -> {
            ICertificadoHabitabilidad p = ((ICertificadoHabitabilidad) entidad);
            boolean condicionPrincipal = p.getEstado() == Estados.Certificado || p.getEstado() == Estados.Entregado;
            boolean condicionSecundaria = true;
            if (filtrarPorCaducados && condicionPrincipal) {
                condicionSecundaria = p.getCaducado();
            }
            return condicionPrincipal && condicionSecundaria;
        });
        return filtroCertificados;
    }

}
