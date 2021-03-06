package src.Vehicule;

public abstract class Vehicul implements Comparable {
    protected double pret;
    protected int capacitateCiclindrica;
    protected int putere;
    protected int anFabricatie;
    protected double capacitateRezervor;
    protected String denumire;
    protected String serie;
    protected String culoare;

    public Vehicul(double pret, int capacitateCiclindrica, int putere, int anFabricatie, double capacitateRezervor, String denumire, String serie, String culoare) {
        this.pret = pret;
        this.capacitateCiclindrica = capacitateCiclindrica;
        this.putere = putere;
        this.anFabricatie = anFabricatie;
        this.capacitateRezervor = capacitateRezervor;
        this.denumire = denumire;
        this.serie = serie;
        this.culoare = culoare;
    }

    public Vehicul() {

    }

    public void setPret(double pret) {
        this.pret = pret;
    }

    public void setCapacitateCiclindrica(int capacitateCiclindrica) {
        this.capacitateCiclindrica = capacitateCiclindrica;
    }

    public void setPutere(int putere) {
        this.putere = putere;
    }

    public void setAnFabricatie(int anFabricatie) {
        this.anFabricatie = anFabricatie;
    }

    public void setCapacitateRezervor(double capacitateRezervor) {
        this.capacitateRezervor = capacitateRezervor;
    }

    public void setDenumire(String denumire) {
        this.denumire = denumire;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public void setCuloare(String culoare) {
        this.culoare = culoare;
    }

    public double getPret() {
        return pret;
    }

    public String getCuloare() {
        return culoare;
    }

    public int getCapacitateCiclindrica() {
        return capacitateCiclindrica;
    }

    public int getPutere() {
        return putere;
    }

    public int getAnFabricatie() {
        return anFabricatie;
    }

    public double getCapacitateRezervor() {
        return capacitateRezervor;
    }

    public String getDenumire() {
        return denumire;
    }

    public String getSerie() {
        return serie;
    }

    public int compareTo(Object obj) {
        return this.putere - ((Vehicul) obj).getPutere();
    }

    @Override
    public String toString() {
        return this.denumire + " cu VIN: " + this.serie + " fabricat in " + this.anFabricatie + ".\nCu un motor de " +
                this.capacitateCiclindrica + " care produce " + this.putere + " cai putere la pretul de: $" + this.pret + ".";
    }
}
