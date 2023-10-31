package console_app.tipos.trabajos;

import java.util.Date;

import console_app.interfaces.entidades.Campos;
import console_app.interfaces.entidades.Campos.CamposEnum;
import console_app.interfaces.personas.IAparejador;
import console_app.interfaces.personas.IArquitecto;
import console_app.interfaces.personas.ICliente;
import console_app.interfaces.personas.IContable;
import console_app.interfaces.trabajos.IEdificacion;
import console_app.interfaces.trabajos.ITrabajo;
import console_app.interfaces.trabajos.ICalendarioDia.Tipos;
import console_app.servicios.Io;
import console_app.servicios.calendario.Empresa;
import console_app.tipos.entidades.Entidad;
import console_app.tipos.entidades.EntidadTipos;
import console_app.tipos.entidades.Fecha;

/**
 * Descripción en {@link console_app.interfaces.trabajos.ITrabajo}
 */
public class Trabajo extends Entidad implements ITrabajo
{

    public Trabajo() {
        super();
        configurar();
    }

    Trabajo(int id) {
        super(id);
        configurar();
    }

    private void configurar() {
        setTipo(EntidadTipos.Trabajo);
        campos = Campos.cargarCamposEntidad(this.getTipo(), campos);
    }

    @Override
    public Date getSolicitud() {
        return Empresa.get().getFecha(Tipos.Solicitud, id);
    }

    @Override
    public Date getEntrega() {
        return Empresa.get().getFecha(Tipos.Entrega, id);
    }

    @Override
    public ICliente getCliente() {
        return (ICliente) buscarPorId(EntidadTipos.Cliente, getClienteId());
    }

    @Override
    public IArquitecto getArquitecto() {
        return (IArquitecto) buscarPorId(EntidadTipos.Arquitecto, getArquitectoId());
    }

    @Override
    public IAparejador getAparejador() {
        return (IAparejador) buscarPorId(EntidadTipos.Aparejador, getAparejadorId());
    }

    @Override
    public IContable getContable() {
        return (IContable) buscarPorId(EntidadTipos.Contable, getContableId());
    }

    @Override
    public Float getCoste() {
        return getCampo(CamposEnum.Coste).valorDecimal();
    }

    @Override
    public boolean agregar() {
        if (super.agregar()) {
            // Creamos una fecha de solicitud, coincidiendo con la fecha de creación
            Empresa.get().agregarSolicitud(id);
            return true;
        }
        return false;
    }

    @Override
    public String getArquitectoId() {
        return getCampo(CamposEnum.Arquitecto).valorForanea();
    }

    @Override
    public String getAparejadorId() {
        return getCampo(CamposEnum.Aparejador).valorForanea();
    }

    @Override
    public String getContableId() {
        return getCampo(CamposEnum.Contable).valorForanea();
    }

    @Override
    public String getClienteId() {
        return getCampo(CamposEnum.Cliente).valorForanea();
    }

    @Override
    public String getEstadoComoEtiqueta() {
        if (this instanceof Proyecto) {
            return ((Proyecto) this).getEstado().toString();
        }
        if (this instanceof Certificado) {
            return ((Certificado) this).getEstado().toString();
        }
        return ITrabajo.Estados.Solicitado.toString();
    }

    @Override
    public Estados getEstado() {
        if (this instanceof Proyecto) {
            return ((Proyecto) this).getEstado();
        }
        if (this instanceof Certificado) {
            return ((Certificado) this).getEstado();
        }
        return null;
    }

    @Override
    public String getTipoComoEtiqueta() {
        String string = this.getClass().getName();
        return string.substring(string.lastIndexOf('.') + 1);
    }

    @Override
    public String comoResumen() {
        return String.format(
            Io.LINEA_ESTADO_TRABAJO_COMO_ETIQUETA,
            getIdS(),
            getTipoComoEtiqueta(),
            getEstadoComoEtiqueta()
        );
    }


    @Override
    public String getFechaEstadoComoEtiqueta() {

        Date fecha = null;
        if (this instanceof Proyecto) {
            fecha = ((Proyecto) this).getFechaEstado();
        }
        if (this instanceof Certificado) {
            fecha = ((Certificado) this).getFechaEstado();
        }
        return Fecha.fechaComoCadena(fecha);
    }

    @Override
    public Date getFechaEstado() {
        if (this instanceof Proyecto) {
            return ((Proyecto) this).getFechaEstado();
        }
        if (this instanceof Certificado) {
            return ((Certificado) this).getFechaEstado();
        }
        return null;
    }

    @Override
    public
    IEdificacion getEdificacion() {
        IEdificacion edificacion;
        switch(this.getTipo()) {
            case ProyectoResidencial:
                edificacion = ((ProyectoResidencial) this).getEdificacion();
                break;
            case ProyectoNoResidencial:
                edificacion = ((ProyectoNoResidencial) this).getEdificacion();
                break;
            case ProyectoRehabilitacion:
                edificacion = ((ProyectoRehabilitacion) this).getEdificacion();
                break;
            case CertificadoEficiencia:
                edificacion = ((CertificadoEficiencia) this).getEdificacion();
                break;
            case CertificadoHabitabilidad:
                edificacion = ((CertificadoHabitabilidad) this).getEdificacion();
                break;
            case CertificadoInforme:
                edificacion = ((CertificadoInforme) this).getEdificacion();
                break;
            case CertificadoInspeccion:
                edificacion = ((CertificadoInspeccion) this).getEdificacion();
                break;
            default:
                return null;
        }
        return edificacion;
    }
}
