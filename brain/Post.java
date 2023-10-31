
public class Post {
    int h = 15;
    int i = getJ();
    int j = 10;
    int hh = getH();
    
    public String message = "En post";

    void enviar() {
        System.out.println(message);
    }

    private int getH() {
        return h;
    }

    private int getJ() {
        return j;
    }
}