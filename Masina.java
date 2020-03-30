package src;

public class Masina extends src.Vehicul {
    protected int numarPortiere;
    protected int numarLocuri;
    protected boolean gpl;


    public Masina(double pret, int capacitateCiclindrica, int putere, int anFabricatie, double capacitateRezervor, String denumire, String serie, String culoare, int numarPortiere, int numarLocuri, boolean gpl) {
        super(pret, capacitateCiclindrica, putere, anFabricatie, capacitateRezervor, denumire, serie, culoare);
        this.numarPortiere = numarPortiere;
        this.numarLocuri = numarLocuri;
        this.gpl = gpl;
    }

    public int getNumarPortiere() {
        return numarPortiere;
    }

    public int getNumarLocuri() {
        return numarLocuri;
    }

    public boolean isGpl() {
        return gpl;
    }

    @Override
    public String toString() {
        return super.toString() + "\nVehiculul este o masina cu " + this.numarLocuri + " locuri in " +
                this.numarPortiere + " portiere.\n";
    }
}
