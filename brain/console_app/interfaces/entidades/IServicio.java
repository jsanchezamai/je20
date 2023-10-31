package console_app.interfaces.entidades;


/**
 * Un IServicio es un proceso de trabajo, por ejemplo, {@link console_app.interfaces.entidades.IEntidad} o {@link console_app.interfaces.pantallas.IPantalla}; 
 * mantenidos en un punto central y superior como en {@link console_app.interfaces.pantallas.IAplicacion#servicios}.
 * 
 * @author Jaime Sánchez 
 * @version 1.0.0
 */

public interface IServicio
{
   boolean inicializar();

   void test(String[] secuencia);
   void test(String secuencia);
   int testSize();

   void testMode(boolean b);

   void inputTest(boolean b);
}
