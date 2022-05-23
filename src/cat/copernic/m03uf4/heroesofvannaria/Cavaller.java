package cat.copernic.m03uf4.heroesofvannaria;

/**
 *
 * @author Carles
 * @version 1.0
 */
public class Cavaller extends Personatge {

    public Cavaller(int forca, int cons, int vel, int inte, int sor, Arma arma) {
        super(forca, cons, vel, inte, sor, arma);
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
