package console_app.pantallas.sesion;

import java.util.Timer;
import java.util.TimerTask;

import console_app.interfaces.entidades.Campos.CamposEnum;
import console_app.pantallas.aplicacion.MenuAplicacion;
import console_app.pantallas.aplicacion.MenuOpcionOperativa;
import console_app.servicios.Io;
import console_app.tipos.entidades.Fecha;
import console_app.tipos.entidades.Opcion;
import worlds.EdenGardenWorld;
import worlds.JardinEden;

/**
 * Define el menú inicial de la aplicación
 *
 * @author Jaime Sánchez
 * @version 1.0.0
 */
public class MenuInicial extends MenuAplicacion
{
    private Timer timer;
    EdenGardenWorld world;
    private boolean tempted;

    public MenuInicial()
    {
        super();

        titulo = Io.TITULO_INICIAL;

        world = JardinEden.EdenGardenWorld;

        timer = new Timer();

        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                setOptions();
                mostrarOpciones();
           }
        }, 0, 5000);

    }

    private void setOptions() {
        opciones.clear();
        opciones.add(new Opcion(Io.OPCION_SESSION, "1"));

        opciones.addAll(world.opciones());

        opciones.add(new Opcion(String.format(Io.OPCION_CLOCK, Fecha.ahora()), CamposEnum.Fecha.toString()));
    }

    public String pedirOpcion() {

        opcion.entrada(super.pedirOpcion());

        switch(opcion.entrada()) {
            case "1":
                menuOpcion = new MenuOpcionOperativa(new FormConectarse());
                menuOpcion.ejecutar();
                break;

            case "2":

                if (tempted)
                    JardinEden.EdenGardenWorld.StopSnakeToTempEve();
                 else
                    JardinEden.EdenGardenWorld.SendSnakeToTempEve();
                tempted = !tempted;

                setOptions();
                mostrarOpciones();

                return pedirOpcion();
            case "":
                return "";
            default:
                opcionNoEncontrada();
        }
        return opcion.entrada();
    }    
  }
