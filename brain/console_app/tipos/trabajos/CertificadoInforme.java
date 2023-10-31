package console_app.tipos.trabajos;

import java.util.Date;

import console_app.interfaces.entidades.Campos;
import console_app.interfaces.entidades.Campos.CamposEnum;
import console_app.interfaces.trabajos.ICertificadoInforme;
import console_app.interfaces.trabajos.IEdificacion;
import console_app.tipos.entidades.Entidad;
import console_app.tipos.entidades.EntidadTipos;

/**
 * Descripción en {@link console_app.interfaces.trabajos.ICertificadoInforme}.
 */
public class CertificadoInforme extends Certificado implements ICertificadoInforme
{

    public CertificadoInforme(int id) {
        super(id);
        configurar();
    }

    private void configurar() {
        setTipo(EntidadTipos.CertificadoInforme);
        campos = Campos.cargarCamposEntidad(this.getTipo(), campos);
    }

    @Override
    public IEdificacion getEdificacion() {
        return (IEdificacion) Entidad.buscarPorId(
            EntidadTipos.Edificacion,
            getCampo(CamposEnum.Edificacion).valorForanea()
        );
    }

    @Override
    public Date getFechaEmision() {
        return super.getFechaCertificacion();
    }
}
