package console_app.tipos.entidades;

/**
 * Enumeration class EntidadTipos - Tipos de usuario
 * 
 * @author (your name here)
 * @version (version number or date here)
 */
public enum EntidadTipos
{
    Empleado,
        Administrador, Arquitecto, Aparejador, Contable,
    Cliente,
    Trabajo,
        Proyecto,
            ProyectoResidencial, ProyectoNoResidencial, ProyectoRehabilitacion,
            Edificacion,
                EdificacionResidencial, EdificacionNoResidencial, EdificacionResidencialComunitario,
            Presupuesto,
                PresupuestoLinea,
        Certificado,
            CertificadoHabitabilidad, CertificadoInspeccion, CertificadoEficiencia, CertificadoInforme,
        Dia, Persona, Entidad
}
