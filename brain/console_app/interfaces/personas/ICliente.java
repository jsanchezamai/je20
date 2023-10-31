package console_app.interfaces.personas;

/**
 * La primera vez que acude un cliente al {@link Estudio} hay que darle de alta
 *  {@link console_app.pantallas.entidad.FormAltaEntidad} en el sistema.
 *
 * Un {@link console_app.tipos.personas.Cliente} puede solicitar todos los {@link console_app.tipos.trabajos.Proyecto} que desee 
 * y cada {@link console_app.interfaces.trabajos.ICalendarioDia.Tipos#Solicitud}
 * tiene que registrar {@link console_app.tipos.personas.Cliente#configurar()} los datos del cliente
 * y del {@link console_app.tipos.personas.Arquitecto} que los desarrollaron. 
 *
 * @author Jaime Sánchez 
 * @version 1.0.0
 */
public interface ICliente extends IPersona
{
}
