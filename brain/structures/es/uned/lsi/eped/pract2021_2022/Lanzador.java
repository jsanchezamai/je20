package structures.es.uned.lsi.eped.pract2021_2022;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.StringTokenizer;

import structures.es.uned.lsi.eped.DataStructures.IteratorIF;

public class Lanzador {

    private String pathBase;
	private Integer logFactor;
	private Integer maximo;

    public Lanzador(String pathBase, Integer maximo, Integer logFactor) {
        this.pathBase = pathBase;
		this.logFactor = logFactor;
		this.maximo = maximo;
    }

    /* Comprueba que el fichero de entrada exista y puede ser leido */
	public static Boolean checkInput(String file) {
		File f = new File(file);
		// Se comprueba que el fichero existe y es, realmente, un fichero
		if ( !f.exists() || !f.isFile() ) {
			System.out.println("ERROR: no existe el fichero de entrada "+file+".");
			return false;
		}
		// Se comprueba que el fichero puede ser leido
		if ( !f.canRead() ) {
			System.out.println("ERROR: el fichero de entrada "+file+" no puede leerse.");
			return false;
		}
		return true;
	}

    void Lanzar(SparseArrayIF<String> SA, String input, String tipo, String tipo2) {

		// Fichero de entrada
		String output = pathBase + tipo2 + tipo + input;
		input = pathBase + tipo2 + input;
		if ( !checkInput(input) ) { return; }

		long total = 0, t0 = 0, t1 = 0, step = 0;
		NumberFormat formatter = new DecimalFormat("#0.000");

		try {
			BufferedReader br;
			br = new BufferedReader(new InputStreamReader(new FileInputStream(input), "utf-8"));

			BufferedWriter bw = new BufferedWriter(
				new OutputStreamWriter(
					new FileOutputStream(output),
					"utf-8"
				));
			String line;

			total = System.currentTimeMillis();
			step = System.currentTimeMillis();

			boolean lFactor = true;
			int index = -1;

			while ((line = br.readLine())!=null) {

				t0 = System.currentTimeMillis();

				StringTokenizer st = new StringTokenizer(line, " ");
				String op = st.nextToken().toLowerCase();
				String result = new String("-");
				index = -1;
				String elem;

				switch(op){
					case "set":
						// Tiene dos parametros: el primero el indice
						index = Integer.parseInt(st.nextToken());
						// y el segundo el elemento
						elem = st.nextToken();
						// Se aplica la operacion set sobre el array disperso
						SA.set(index, elem);
						break;
					case "get":
						// Tiene un parametro: el indice
						index = Integer.parseInt(st.nextToken());
						// Se aplica la operacion get sobre el array disperso
						result = SA.get(index);
						if ( result == null ) {
							result = "null";
						} 
						break;
				}

				t1 = System.currentTimeMillis() - t0;
				if (index % logFactor == 0) {
					String label = "Prueba: " + op + " Indice: " + index + " Coste: " + t1 + " ms";
					System.out.println(label);
					bw.write(label);
					bw.newLine();
					lFactor = !lFactor;
				}
				if (index % logFactor == 0 && lFactor) {

					long step1 = System.currentTimeMillis() - step;

					String label = "Coste paso (" + logFactor + "): " +  formatter.format((step1 / 1000.0)) + " s";
					System.out.println(label);
					bw.write(label);
					bw.newLine();

					long total1 = System.currentTimeMillis() - total;
					label = "Coste para " + (tipo2.equals("ASC_") ? index : maximo - index) + " elementos: " + formatter.format((total1 / 1000.0) / 60.0) + " mins";
					bw.write(label);
					bw.newLine();
					System.out.println(label);

					// Resetar contador de pasos
					step = System.currentTimeMillis();
				}
			}
			br.close();
			bw.close();
		} catch (UnsupportedEncodingException | FileNotFoundException e) {
			e.printStackTrace();
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

    }

    /*Convierte un iterador en cadena de caracteres
	 * @param it: iterador
	 */
	public static <E> String toString(IteratorIF<E> it){
		StringBuilder result = new StringBuilder();
		while(it.hasNext()){
			result.append(it.getNext().toString());
			if(it.hasNext()){
				result.append(" ");
			}
		}
		return result.toString();

	}
}