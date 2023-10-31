package console_app.tipos.trabajos;

import console_app.interfaces.entidades.Campos;
import console_app.interfaces.entidades.Campos.CamposEnum;
import console_app.interfaces.trabajos.ICertificadoEficiencia;
import console_app.interfaces.trabajos.IEdificacion;
import console_app.tipos.entidades.Entidad;
import console_app.tipos.entidades.EntidadTipos;

/**
 * Descripción en {@link console_app.interfaces.trabajos.ICertificadoEficiencia }.
 */
public class CertificadoEficiencia extends Certificado implements ICertificadoEficiencia
{
    String eficiencia;

    public CertificadoEficiencia(int id) {
        super(id);
        configurar();
    }

    private void configurar() {
        setTipo(EntidadTipos.CertificadoEficiencia);
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
    public EficienciaTipos getEficiencia() {
        Integer ordinal = getCampo(CamposEnum.EnumeracionEficiencia).valorNumerico();
        if (ordinal == null) return null;
        return EficienciaTipos.values()[ordinal];
    }

}
