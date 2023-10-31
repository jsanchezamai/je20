package worlds;

import console_app.interfaces.entidades.IServicio;

public class JardinEden implements IServicio {

    public static final float DIMENSION = 150;
    public static EdenGardenWorld EdenGardenWorld = new EdenGardenWorld();

    @Override
    public boolean inicializar() {

        EdenGardenWorld.create();

        return true;
    }

    @Override
    public void test(String[] secuencia) {
        // TODO Auto-generated method stub

    }

    @Override
    public void test(String secuencia) {
        // TODO Auto-generated method stub

    }

    @Override
    public int testSize() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public void testMode(boolean b) {
        // TODO Auto-generated method stub

    }

    @Override
    public void inputTest(boolean b) {
        // TODO Auto-generated method stub

    }

}
