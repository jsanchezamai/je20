import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import console_app.interfaces.entidades.Campos;
import console_app.interfaces.entidades.IEntidad;
import console_app.interfaces.entidades.IServicio;
import console_app.interfaces.entidades.Campos.CamposEnum;
import console_app.interfaces.pantallas.IAplicacion;
import console_app.interfaces.pantallas.IMenu;
import console_app.pantallas.aplicacion.Pantalla;
import console_app.pantallas.sesion.MenuInicial;
import console_app.servicios.calendario.Empresa;
import console_app.tipos.entidades.Entidad;
import console_app.tipos.entidades.EntidadTipos;
import console_app.tipos.entidades.Filtro;
import worlds.JardinEden;
import console_app.Tester;

/**
 * POO PED 2022 Estudio de arquitectura. Ver detalles en {@link console-app.interfaces.pantallas.IAplicacion}.
 *
 * @author jsm
 * @version 1
 */
public class ConsoleApp implements IAplicacion
{
    private IMenu menu;
    private List<IServicio> servicios;
    private Entidad factoriaEntidad;

    static void test(Integer a) {
        a++;
        a = 3;
    }

    static void test(String a) {
        a = "sss";
    }

    static void test(Boolean a) {
        a = !a;
    }

    static void test(Post a) {
        a.message = "ddd";
        a = new Post();
        a.message = "aaa";
    }
    public ConsoleApp()
    {

        Post a = new Post();
        System.out.println(a.i);
        System.out.println(a.hh);

        Integer b = new Integer(0);
        test(0);
        test(a);

        String s = "";
        Boolean bol = false;

        test(s);
        test(bol);
        System.out.println(b);
        System.out.println(a);
        /*Post a = new Post();
        Post p = new Post2();

        Post2 p2 = new Post2();
        Post2 p3 = (Post2) p;

        Post p4 = p2;
        Post p5 = p3;

        p.enviar();
        System.out.println(p.message);

        p2.enviar();
        System.out.println(p2.message);

        p3.enviar();
        System.out.println(p3.message);

        p4.enviar();
        System.out.println(p4.message);

        p5.enviar();
        System.out.println(p5.message);

        // inicializarServicios();
        // buclePrincipal();*/

    }

    public static void main(String[] args) {

        // Logs to console that application has started
        System.out.println("Application Main starts here!");

        // Creates a new instance of ConsoleApp
        ConsoleApp brain = new ConsoleApp();

        // Arranca la aplicación
        brain.inicializarServicios();
        brain.buclePrincipal();

        // Informa al usuario de que la aplicación se ha arrancado
        System.out.println("Application Main finishes, here, bye!");

    }

    /**
     *  Ver {@link IAplicacion#getServicios()}
     */
    public List<IServicio> getServicios() {
        return this.servicios;
    }

    public Optional<IServicio> getServicios(Class<?> cls) {
        return servicios
            .stream()
            .filter((s) -> s.getClass().equals(cls))
            .findFirst();

    }

    /**
     *  Ver {@link IAplicacion#getMenu()}
     */
    public IMenu getMenu() {
        return this.menu;
    }

    /**
     *  Ver {@link IAplicacion#inicializarServicios()}
     */
    public boolean inicializarServicios() {

        servicios = new ArrayList<>();
        new Campos();
        this.factoriaEntidad = new Entidad();
        servicios.add(factoriaEntidad);

        IServicio pantalla = new Pantalla();
        servicios.add(pantalla);

        IServicio empresa = new Empresa(3);
        servicios.add(empresa);

        IServicio jardin = new JardinEden();
        servicios.add(jardin);

        for(IServicio servicio: servicios) {
            servicio.inicializar();
        }

        pantalla.testMode(false);
        pantalla.inputTest(false);
        Tester test = new Tester(pantalla);
        // test.test();
        return true;
    }

    /**
     *  Ver {@link IAplicacion#buclePrincipal()}
     */
    public void buclePrincipal() {

        menu = new MenuInicial();

        String opcion = "loop";
        while(!opcion.isEmpty())
        {
            menu.mostrarOpciones();
            opcion = menu.pedirOpcion();
        }

    }

    @Override
    public List<IEntidad> getAlmacen() {
        return Entidad.factoria.buscar(EntidadTipos.Entidad, null);
    }

    @Override
    public List<IEntidad> getAlmacen(EntidadTipos tipo, Filtro filtro) {
        return Entidad.factoria.buscar(tipo, filtro);
    }

    @Override
    public List<IEntidad> buscarPorCampo(EntidadTipos tipo, CamposEnum campo, String valorFiltro) {

        return Entidad.factoria.buscarPorCampo(tipo, campo, valorFiltro);
    }
}
