package cat.copernic.m03uf4.heroesofvannaria;

import java.util.Scanner;

/**
 *
 * @author Carles
 * @version 1.0
 */
public class HeroesOfVannaria {

    static Scanner in;

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
        
        Personatge personatge = new Personatge(nom, clase ,arma, 15,9,6,7,7);
    }
}
