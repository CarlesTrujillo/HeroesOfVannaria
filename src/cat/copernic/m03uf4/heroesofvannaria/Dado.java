package cat.copernic.m03uf4.heroesofvannaria;

/**
 *
 * @author Carles
 * @version 1.0
 */
public class Dado {
    
    int max = 6;
    int min = 1;
    int tirada;
    
    public Dado() {
        
        max = 6;
        min = 1;
        
        tirada = (int) (Math.random() * (max - min) + min);
    }
    
}
