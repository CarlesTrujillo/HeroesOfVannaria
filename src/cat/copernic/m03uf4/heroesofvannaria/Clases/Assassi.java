package cat.copernic.m03uf4.heroesofvannaria.Clases;

/**
 *
 * @author Carles
 * @version 1.0
 */
public class Assassi extends Clases {
    
    public Assassi(int pow, int con, int vel, int inte, int sor) {
        forca = pow;
        constitucio = con;
        velocitat = vel;
        intelligencia = inte;
        sort = sor;
    }

    public int getForca() {
        return forca;
    }

    public void setForca(int forca) {
        this.forca = forca;
    }

    public int getConstitucio() {
        return constitucio;
    }

    public void setConstitucio(int constitucio) {
        this.constitucio = constitucio;
    }

    public int getVelocitat() {
        return velocitat;
    }

    public void setVelocitat(int velocitat) {
        this.velocitat = velocitat;
    }

    public int getIntelligencia() {
        return intelligencia;
    }

    public void setIntelligencia(int intelligencia) {
        this.intelligencia = intelligencia;
    }

    public int getSort() {
        return sort;
    }

    public void setSort(int sort) {
        this.sort = sort;
    }
}
