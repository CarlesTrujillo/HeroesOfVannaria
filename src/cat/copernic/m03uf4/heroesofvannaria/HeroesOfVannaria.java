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
        Scanner in = new Scanner(System.in);

        System.out.print("Escull el nom del teu personatge: ");
        String nom = in.nextLine();

        boolean claseValida = true;

        System.out.print("Selecciona la clase: ");
        String clase = in.nextLine();
        
        System.out.print("Selecciona la teva arma: ");
        String arma = in.nextLine();
        
        do {
            if (clase.equalsIgnoreCase("Guerrer")) {
                Guerrer guerrer = new Guerrer((15, 9, 6, 7, 7, Arma("Daga")));
                claseValida = true;
            } else if (clase.equalsIgnoreCase("Cavaller")) {
                claseValida = true;
            } else if (clase.equalsIgnoreCase("Valquiria")) {
                claseValida = true;
            } else if (clase.equalsIgnoreCase("Assassi")) {
                claseValida = true;
            } else {
                System.out.println("Clase no valida!!");
                claseValida = false;
            }
        } while (claseValida != false);

        

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
    public static void tirada() {
        Dado dau1 = new Dado(25);
        Dado dau2 = new Dado(25);
        Dado dau3 = new Dado(25);
        
        int valor = dau1.tirada() + dau2.tirada() + dau3.tirada();
        System.out.println(valor);
    }
    public static void juego() {
        Scanner in = new Scanner(System.in);
        
        // Mostrar menu
        System.out.println("\n\n*** HEROES OF VANNARIA ***\n\n");
        
        System.out.println("1. Crear personaje");
        System.out.println("2. Iniciar combate");
        System.out.println("X. Salir");
        
        System.out.println("Selecciona una opcion:");
        String opcion = in.nextLine();
        // Seleccionar opcio i cridar el metode corresponent
    }
}
