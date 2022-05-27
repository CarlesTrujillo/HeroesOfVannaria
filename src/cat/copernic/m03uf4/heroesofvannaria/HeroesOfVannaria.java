package cat.copernic.m03uf4.heroesofvannaria;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Carles
 * @version 1.0
 */
public class HeroesOfVannaria {

    static Scanner in = new Scanner(System.in);

    private ArrayList<Personatge> personatges;
    private Arma[] armas;

    public HeroesOfVannaria() {

        armas = new Arma[3];
        armas[0] = new Arma("Daga", 5, 15);
        armas[1] = new Arma("Espasa", 10, 10);
        armas[2] = new Arma("Martell de combat", 15, 5);

        personatges = llegirFitxer("personatges.csv");

    }
    //public static final String SEPARATOR = ";";

    public static void main(String[] args) {
        HeroesOfVannaria joc = new HeroesOfVannaria();
        joc.juego();
    }

    public static void juego() {
        Scanner in = new Scanner(System.in);

        boolean finalJoc = false;
        while (!finalJoc) {
            // Mostrar menu
            System.out.println("\n\n*** HEROES OF VANNARIA ***\n");

            System.out.println("1. Crear personaje");
            System.out.println("2. Iniciar combate");
            System.out.println("X. Salir");

            System.out.println("Selecciona una opcion:");
            String opcion = in.nextLine();
            // Seleccionar opcio i cridar el metode corresponent
            switch (opcion) {
                case "1":
                    crearPersonaje();
                    break;
                case "2":
                    combat();
                    break;
                case "X":
                case "x":
                    finalJoc = true;
                    break;
                default:
                    System.out.println("Opcio incorrecta!");
            }
        }
    }

    public static void crearPersonaje() {
        Scanner in = new Scanner(System.in);

        System.out.print("Escull el nom del teu personatge: ");
        String nom = in.nextLine();

        boolean claseValida = false;

        System.out.print("Selecciona la clase: ");
        String clase = in.nextLine();

        System.out.print("Selecciona la teva arma: ");
        String arma = in.nextLine();

    }

    public static void combat() {

    }

    public static void tirada() {
        Dado dau1 = new Dado(25);
        Dado dau2 = new Dado(25);
        Dado dau3 = new Dado(25);

        int valor = dau1.tirada() + dau2.tirada() + dau3.tirada();
        System.out.println("Valor tirada: " + valor);
    }

    private ArrayList<Personatge> llegirFitxer(String nomFitxer) {

        ArrayList<Personatge> personatges = new ArrayList<Personatge>();
        try {
            BufferedReader entrada = new BufferedReader(
                    new FileReader(nomFitxer));

            int i = 0;
            String personatgeStr;
            while ((personatgeStr = entrada.readLine()) != null) {
                String[] caracteristiques = personatgeStr.split(";");
                String classe = caracteristiques[1];

                Arma laMevaArma = null;
                if (caracteristiques[7].equals("Daga")) // Nom arma
                {
                    laMevaArma = armas[0];
                } else if (caracteristiques[7].equals("Espasa")) {
                    laMevaArma = armas[1];
                } else if (caracteristiques[7].equals("Martell de combat")) {
                    laMevaArma = armas[2];
                }

                String nom = caracteristiques[0];
                int forca = Integer.parseInt(caracteristiques[2]);
                int constitucio = Integer.parseInt(caracteristiques[3]);
                int velocitat = Integer.parseInt(caracteristiques[4]);
                int intelligencia = Integer.parseInt(caracteristiques[5]);
                int sort = Integer.parseInt(caracteristiques[6]);

                Personatge personatge = null;
                switch (classe) {
                    case "Guerrer":
                        personatge = new Guerrer(nom, forca, constitucio, velocitat,
                                intelligencia, sort, laMevaArma);
                        break;
                    case "Cavaller":
                        personatge = new Cavaller(nom, forca, constitucio, velocitat,
                                intelligencia, sort, laMevaArma);
                        break;
                    case "Valkiria":
                        personatge = new Valquiria(nom, forca, constitucio, velocitat,
                                intelligencia, sort, laMevaArma);
                        break;
                    case "Assassí":
                        personatge = new Assassi(nom, forca, constitucio, velocitat,
                                intelligencia, sort, laMevaArma);
                        break;
                }

                personatges.add(personatge);
            }
            entrada.close();

        } catch (FileNotFoundException fnf) {
            //fnf.printStackTrace();
            System.out.println("Error fitxer no trobat.");
        } catch (IOException ioe) {
            System.out.println("Error I/O: " + ioe.getMessage());
        }

        return personatges;

    }
}
