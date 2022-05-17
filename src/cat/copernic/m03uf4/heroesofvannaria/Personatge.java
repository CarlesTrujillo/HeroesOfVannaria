package cat.copernic.m03uf4.heroesofvannaria;

/**
 *
 * @author Carles
 * @version 1.0
 */
public class Personatge {
    
    public String nom;
    public String clase;
    public String arma;
    public int forca;
    public int constitucio;
    public int velocitat;
    public int intelligencia;
    public int sort;

    public Personatge(String nom, String clase, String arma, int forca, int constitucio, int velocitat, int intelligencia, int sort) {
        this.nom = nom;
        this.clase = clase;
        this.arma = arma;
        this.forca = forca;
        this.constitucio = constitucio;
        this.velocitat = velocitat;
        this.intelligencia = intelligencia;
        this.sort = sort;
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

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getClase() {
        return clase;
    }

    public void setClase(String clase) {
        this.clase = clase;
    }

    public String getArma() {
        return arma;
    }

    public void setArma(String arma) {
        this.arma = arma;
    }
}
