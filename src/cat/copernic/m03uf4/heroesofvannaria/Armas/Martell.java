package cat.copernic.m03uf4.heroesofvannaria.Armas;

/**
 *
 * @author Carles
 * @version 1.0
 */
public class Martell extends Armas {
    
    public Martell(int wpow, int wvel) {
        this.wpow = wpow;
        this.wvel = wvel;
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
