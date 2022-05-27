package cat.copernic.m03uf4.heroesofvannaria;

/**
 *
 * @author Carles
 * @version 1.0
 */
public class Assassi extends Personatge implements Personatge.Caos {

    public Assassi(String nom, int forca, int cons, int vel, int inte, int sor, Arma arma) {
        super(nom, forca, cons, vel, inte, sor, arma);
    }
    
    @Override
    public void caos() {
        
    }
}
