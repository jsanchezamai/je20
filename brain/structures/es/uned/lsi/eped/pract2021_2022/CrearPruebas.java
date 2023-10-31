package structures.es.uned.lsi.eped.pract2021_2022;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class CrearPruebas {

    private String basePath;
    private Integer maximo;

    public CrearPruebas(String pathBase, Integer maximo) {
        this.basePath = pathBase;
        this.maximo = maximo;
    }

    void crearFicheroDeLLenado(String output, String tipo) {
        try (// Se abre la escritura en el fichero de salida
        BufferedWriter bw = new BufferedWriter(
            new OutputStreamWriter(
                new FileOutputStream(basePath + tipo + output),
                "utf-8"
            )
        )) {
            if (tipo.equals("ASC_")) {
                for(int i = 0; i < maximo; i++) {

                    String line = "set " + i + " " + i;
                    bw.write(line);
                    bw.newLine();

                    line = "get " + i;
                    bw.write(line);
                    bw.newLine();
                }
            } else {
                for(int i = maximo; i > 0; i--) {

                    String line = "set " + i + " " + i;
                    bw.write(line);
                    bw.newLine();

                    line = "get " + i;
                    bw.write(line);
                    bw.newLine();
                }
            }

            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

	public static void main(String[] args) throws IOException {

        String pathBase = "/Users/morente/Desktop/DESK/2021/UNED/EPED/MyPED/ped_eped/es/uned/lsi/eped/pract2021_2022/coste/";
        String fichero = "Test.txt";

        Integer dimension = 10000 * 10;
        CrearPruebas p = new CrearPruebas(pathBase, dimension);

        String tipo = "ASC_";
        p.crearFicheroDeLLenado(fichero, tipo);

        Lanzador l = new Lanzador(pathBase, dimension, dimension / 10);
        l.Lanzar(new SparseArraySequence<>(), fichero, "SEQ_", tipo);
        l.Lanzar(new SparseArrayBTree<>(), fichero, "BTREE_", tipo);

        tipo = "DSC_";
        p.crearFicheroDeLLenado(fichero, tipo);

        l.Lanzar(new SparseArraySequence<>(), fichero, "SEQ_", tipo);
        l.Lanzar(new SparseArrayBTree<>(), fichero, "BTREE_", tipo);
    }
}
