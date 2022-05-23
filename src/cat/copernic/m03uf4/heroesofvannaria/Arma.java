package cat.copernic.m03uf4.heroesofvannaria;

/**
 *
 * @author Carles
 * @version 1.0
 */
public class Arma {
    
    private String nom;
    private int wpow;
    private int wvel;
    
    public Arma(String nom, int wpow, int wvel) {
        this.nom    = nom;
        this.wpow   = wpow;
        this.wvel   = wvel;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getWpow() {
        return wpow;
    }

    public void setWpow(int wpow) {
        this.wpow = wpow;
    }

    public int getWvel() {
        return wvel;
    }

    public void setWvel(int wvel) {
        this.wvel = wvel;
    }
    
}
