package structures.es.uned.lsi.eped.pract2021_2022;

import java.io.IOException;

import structures.es.uned.lsi.eped.DataStructures.List;

public class c {

    static Integer a = 7;

    public void set() {
        System.out.println(a);
    }
    public static void main(String[] args) throws IOException { 
        new c().set();

        List<Integer> l = new List<>();
        l.insertarFinal(1);
        l.insertarFinal(2);
        l.insertarFinal(3);

        for(int i = 1; i <= l.size(); i++) {
            System.out.println("" + l.get(i));
        }
        l.insertarFinal(4);
        for(int i = 1; i <= l.size(); i++) {
            System.out.println("" + l.get(i));
        }
    }
}
