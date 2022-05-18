package cat.copernic.m03uf4.heroesofvannaria;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Carles
 * @version 1.0
 */
public class HeroesOfVannaria {

    static Scanner in;

    public static final String SEPARATOR = ";";

    public static void main(String[] args) {
        crearPersonaje();
    }

    public static void crearPersonaje() {

        System.out.print("Escull el nom del teu personatge: ");
        String nom = in.nextLine();

        boolean claseValida = true;

        System.out.print("Selecciona la clase: ");
        String clase = in.nextLine();

        do {
            if (clase.equalsIgnoreCase("Guerrer")) {

            } else if (clase.equalsIgnoreCase("Cavaller")) {

            } else if (clase.equalsIgnoreCase("Valquiria")) {

            } else if (clase.equalsIgnoreCase("Assassi")) {

            } else {
                System.out.println("Clase no valida!!");
                claseValida = false;
            }
        } while (claseValida);

        System.out.print("Selecciona la teva arma: ");
        String arma = in.nextLine();

        Personatge personatge = new Personatge(nom, clase, arma, 15, 9, 6, 7, 7);
    }

    public static void cargarPersonajes() throws IOException {
        BufferedReader bufferLectura = null;
        try {
            // Abrir el .csv en buffer de lectura
            bufferLectura = new BufferedReader(new FileReader("personatges.csv"));

            // Leer una linea del archivo
            String linea = bufferLectura.readLine();

            while (linea != null) {
                // Sepapar la linea leída con el separador definido previamente
                String[] campos = linea.split(SEPARATOR);

                System.out.println(Arrays.toString(campos));

                // Volver a leer otra línea del fichero
                linea = bufferLectura.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // Cierro el buffer de lectura
            if (bufferLectura != null) {
                try {
                    bufferLectura.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
