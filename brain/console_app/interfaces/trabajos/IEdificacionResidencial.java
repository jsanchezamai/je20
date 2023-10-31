package console_app.interfaces.trabajos;

/**
 * En el caso de proyectos residenciales tendrá que constar la {@link console_app.servicios.Io#CAMPO_DIRECCION}, 
 * {@link console_app.servicios.Io#CAMPO_SUPERFICIE_TERRENO}, {@link console_app.servicios.Io#CAMPO_SUPERFICIE_EDIFICIO}, 
 * {@link console_app.servicios.Io#CAMPO_PLANTAS}, {@link console_app.servicios.Io#CAMPO_HABITACIONES} 
 * y {@link console_app.servicios.Io#CAMPO_LAVABOS}.
 * 
 * @author Jaime Sánchez 
 * @version 1.0.0
 */

public interface IEdificacionResidencial extends IEdificacion
{
        int getPlantas();
        int getHabitaciones();
        int getLavabos();
}
