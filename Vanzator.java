package src;

public class Vanzator extends src.Angajat implements src.Operatii, Comparable {
    protected double vanzare;
    public Vanzator(String nume, int id) {
        super(nume, id);
        this.vanzare = 0;
    }

    public void prezentare(){
        System.out.println(super.toString() + "\nLucrez ca vanzator de masini. Cu ce te pot ajuta?");
        System.out.println("1 - Vreau sa cumpar o masina.\n2 - Vreau sa cumpar o motocicleta\n3 - Doar ma uit.\n0 - Inapoi");
    }

    public boolean isOcupat(){
        return super.isOcupat();
    }

    public void efectueazaTranzactie(double pret){
        this.vanzare += pret + pret / 5;
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public int compareTo(Object o) {
        return ((src.Angajat) o).getId()- this.id;
    }
}