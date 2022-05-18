package cat.copernic.m03uf4.heroesofvannaria;

/**
 *
 * @author Carles
 * @version 1.0
 */
public class Dado {
    
    int caras;
    
    public Dado(int caras) {
        
        this.caras = caras;
        
    }
    public int tirada() {
        return (int) (Math.random() * caras) + 1;
    }
    
}
