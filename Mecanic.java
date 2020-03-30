package src;

import java.util.Random;

public class Mecanic extends src.Angajat implements src.Operatii {
    protected double vanzare;
    public Mecanic(String nume, int id) {
        super(nume, id);
        this.vanzare = 0;
    }

    public void prezentare(){
        System.out.println(super.toString() + "\nLucrez ca mecanic de masini. Cu ce te pot ajuta?");
        System.out.println("1 - Reparatii la masina\n2 - Revizie\n0 - Inapoi");
    }


    public void efectueazaTranzactie(double pret){
        this.vanzare += pret + pret / 4;
    }

    public double calculeazaDaune(src.Masina a){
        int cc = a.getCapacitateCiclindrica();
        boolean gpl = a.isGpl();
        Random rand = new Random();
        double pret;

        pret = cc % rand.nextInt(1000);
        if (gpl == true)
            return pret * 2;
        else
            return pret * 1.5;
    }

    public double calculeazaDaune(src.Motocicleta a){
        int cc = a.getCapacitateCiclindrica();
        Random rand = new Random();
        double pret;

        pret = cc % rand.nextInt(450);
       return pret;
    }
}
