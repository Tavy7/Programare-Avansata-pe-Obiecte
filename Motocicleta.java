package src;

public class Motocicleta extends src.Vehicul{
    protected boolean permitePasager;
    protected boolean permiteAtas;

    public Motocicleta(double pret, int capacitateCiclindrica, int putere, int anFabricatie, double capacitateRezervor, String denumire, String serie, String culoare, boolean permitePasager, boolean permiteAtas) {
        super(pret, capacitateCiclindrica, putere, anFabricatie, capacitateRezervor, denumire, serie, culoare);
        this.permiteAtas = permiteAtas;
        this.permitePasager = permitePasager;
    }

    public boolean isPermiteAtas() {
        return permiteAtas;
    }


    public boolean isPermitePasager() {
        return permitePasager;
    }

    public void setPermitePasager(boolean permitePasager) {
        this.permitePasager = permitePasager;
    }

    public void setPermiteAtas(boolean permiteAtas) {
        this.permiteAtas = permiteAtas;
    }

    @Override
    public String toString() {
        String x, y;
        if (this.permitePasager)
            x = "permite pasager";
        else
            x = "nu permite pasager";

        if (this.permiteAtas)
            y = "permite atas";
        else
            y = "nu permite atas";
        return super.toString() + "\nVehiculul este o motocicleta care " + x + " si " + y + ".\n";
    }
}
