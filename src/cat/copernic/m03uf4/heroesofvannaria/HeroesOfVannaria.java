package cat.copernic.m03uf4.heroesofvannaria;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
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

    private final ArrayList<Personatge> personatges;
    private final Arma[] armas;

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

    public void juego() {
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
                    combat(personatges);
                    break;
                case "X":
                case "x":
                    finalJoc = true;
                    guardarPersonajes();
                    break;
                default:
                    System.out.println("Opcio incorrecta!");
            }
        }
    }

    public void crearPersonaje() {
        Scanner in = new Scanner(System.in);

        System.out.print("Escull el nom del teu personatge: ");
        String nom = in.nextLine();

        boolean claseValida = false;
        boolean armaValida = false;
        boolean errorPunts = false;

        Arma laMevaArma = null;
        Personatge personatge = null;

        while (!armaValida) {
            System.out.println("1. Daga");
            System.out.println("2. Espasa");
            System.out.println("3. Martell de combat");

            System.out.print("Selecciona la teva arma: ");
            String arma = in.nextLine();

            switch (arma) {
                case "Daga":
                    laMevaArma = new Arma("Daga", 5, 15);
                    break;
                case "Espasa":
                    laMevaArma = new Arma("Espasa", 10, 10);
                    break;
                case "Martell de combat":
                    laMevaArma = new Arma("Martell de combat", 15, 5);
                    break;
                default:
                    System.out.println("Arma no valida!");
                    armaValida = false;
            }

        }

        int forca = 0, cons = 0, vel = 0, inte = 0, sor = 0;
        while (!errorPunts) {
            System.out.println("Posa en un maxim de 60 punts, els atributs del teu personatge...");

            int puntsRestants = 60;

            System.out.println("Punts restants: " + puntsRestants);
            System.out.print("For??a: ");
            forca = in.nextInt();
            puntsRestants = puntsRestants - forca;
            System.out.println("");

            System.out.println("Punts restants: " + puntsRestants);
            System.out.print("Constituci??: ");
            cons = in.nextInt();
            puntsRestants = puntsRestants - cons;
            System.out.println("");

            System.out.println("Punts restants: " + puntsRestants);
            System.out.print("Velocitat: ");
            vel = in.nextInt();
            puntsRestants = puntsRestants - vel;
            System.out.println("");

            System.out.println("Punts restants: " + puntsRestants);
            System.out.print("Intelligencia: ");
            inte = in.nextInt();
            puntsRestants = puntsRestants - inte;
            System.out.println("");

            System.out.println("Punts restants: " + puntsRestants);
            System.out.print("Sort: ");
            sor = in.nextInt();
            puntsRestants = puntsRestants - sor;
            System.out.println("");

            if (puntsRestants < 0) {
                errorPunts = false;
                System.out.println("No pots assignar mes punts, torna a intentar-ho");
            } else {
                errorPunts = true;
            }
        }

        while (!claseValida) {
            System.out.println("1. Guerrer");
            System.out.println("2. Cavaller");
            System.out.println("3. Valquiria");
            System.out.println("4. Assassi");

            System.out.print("Selecciona la clase: ");
            String clase = in.nextLine();

            switch (clase) {
                case "Guerrer":
                    claseValida = true;
                    personatge = new Guerrer(nom, forca, cons, vel, inte, sor, laMevaArma);
                    break;
                case "Cavaller":
                    claseValida = true;
                    personatge = new Cavaller(nom, forca, cons, vel, inte, sor, laMevaArma);
                    break;
                case "Valquiria":
                    claseValida = true;
                    personatge = new Valquiria(nom, forca, cons, vel, inte, sor, laMevaArma);
                    break;
                case "Assassi":
                    claseValida = true;
                    personatge = new Assassi(nom, forca, cons, vel, inte, sor, laMevaArma);
                    break;
                default:
                    System.out.println("Clase no valida!");
                    claseValida = false;
            }
        }
        personatges.add(personatge);
    }

    public void combat(ArrayList<Personatge> arrayPersonatges) {
        Dado dau1 = new Dado(20);
        Dado dau2 = new Dado(20);
        Dado dau3 = new Dado(20);
        System.out.println("Selecciona el primer combatent:");
        for (int i = 0; i < arrayPersonatges.size(); i++) {
            System.out.printf("%d - %s%n", (i + 1), arrayPersonatges.get(i));
        }
        int c1 = Utils.llegeixEnterRang(in, 1, arrayPersonatges.size());
        Personatge atacant = arrayPersonatges.remove(c1 - 1);

        System.out.println("Selecciona el segon combatent: ");
        for (int i = 0; i < arrayPersonatges.size(); i++) {
            System.out.printf("%d - %s%n", (i + 1), arrayPersonatges.get(i));
        }

        int c2 = Utils.llegeixEnterRang(in, 1, arrayPersonatges.size());
        Personatge defensor = arrayPersonatges.get(c2 - 1);
        arrayPersonatges.add(c1 - 1, atacant);
        Personatge tmp;
        if (atacant.getVelocitat() < defensor.getVelocitat()) {
            tmp = atacant;
            atacant = defensor;
            defensor = tmp;
        }
        System.out.println("------ INICI DEL COMBAT ------");
        System.out.println(atacant.getNom() + " contra " + defensor.getNom());

        boolean combatFinalitzat = false;
        int ronda = 1;
        while (!combatFinalitzat) {
            System.out.println(" Ronda`" + ronda);
            ronda++;

            if (atacant.ataca(dau1, dau2, dau3)) {
                System.out.println(atacant.getNom() + "ataca");
                if (!defensor.esquiva(dau1, dau2, dau3)) {
                    System.out.println(defensor.getNom() + "falla l'esquiva");
                    defensor.repDany(atacant);
                    System.out.println(defensor.getNom() + "rep" + atacant.getPd() + "punts de dany i la seva PS baixa a " + defensor.getPs());
                } else {
                    System.out.println(defensor.getNom() + " esquiva l'atac ");
                }
            } else {
                System.out.println(atacant.getNom() + "falla l'atac ");
            }
            if (defensor.getPs() <= 0) {
                combatFinalitzat = true;
                System.out.println(defensor.getNom() + " cau derrotat ");
                System.out.println(atacant.getNom() + " guanya el combat!!");          
            } else {
                tmp = atacant;
                atacant = defensor;
                defensor = tmp;
            }
        }
    }

    public void tirada() {
        Dado dau1 = new Dado(25);
        Dado dau2 = new Dado(25);
        Dado dau3 = new Dado(25);

        int valor = dau1.tirada() + dau2.tirada() + dau3.tirada();
        System.out.println("Valor tirada: " + valor);
    }

    private ArrayList<Personatge> llegirFitxer(String nomFitxer) {

        ArrayList<Personatge> personatges = new ArrayList<>();
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
                    case "Assass??":
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

    public void guardarPersonajes() {

    }
}
