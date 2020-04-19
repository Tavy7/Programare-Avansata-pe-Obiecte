package src;

import java.util.*;

public class Showroom {
    protected HashSet<Masina> masini = new HashSet<>();   //lista de masini
    protected HashSet<Motocicleta> moto = new HashSet<>();//lista de motociclete
    protected ArrayList<Vanzator> vanzatori = new ArrayList<Vanzator>();

    public Showroom() {//citire masini, motociclete si vanzatori

    }

    public void addMasina(Masina x){
        this.masini.add(x);
    }

    public void addMoto(Motocicleta x){
        this.moto.add(x);
    }

    public void addVanzator(Vanzator x){
        this.vanzatori.add(x);
    }

    public int indexAngajatLiber() {
        for (int i = 0; i < this.vanzatori.size(); i++)
            if ((this.vanzatori.get(i)).isOcupat() == false)
                return i;
        return -1;
    }

    public int countAngajatLiber() {
        int c = 0;
        for (int i = 0; i < this.vanzatori.size(); i++)
            if ((this.vanzatori.get(i)).isOcupat() == false)
                c++;
        return c;
    }

    public void printMasini() {
        System.out.println(this.masini);
    }

    public void printMoto() {
        System.out.println(this.moto);
    }

    public ArrayList<Masina> cautaMasini(String marca) {//returnam lista de masini sortata dupa putere
        int count = 1;
        ArrayList<Masina> a = new ArrayList<Masina>();
        for (Masina i : this.masini)
            if (i.getDenumire().equals(marca)) {
                System.out.println(count + ". " + i);
                a.add(i);
                count++;
            } else {
                continue;
            }

        Collections.sort(a);
        return a;
    }

    public ArrayList<Motocicleta> cautaMotociclete(String marca) {//returnam lista de motocicleta sortata dupa putere
        int count = 1;
        ArrayList<Motocicleta> a = new ArrayList<Motocicleta>();
        for (Motocicleta i : this.moto)
            if (i.getDenumire().equals(marca)) {
                System.out.println(count + ". " + i);
                a.add(i);
                count++;
            } else {
                continue;
            }

        Collections.sort(a);
        return a;
    }

    public int masiniCount() {
        return this.masini.size();
    }

    public int motoCount() {
        return this.moto.size();
    }

    public Masina fastestCar() {
        int cai = 0;
        Masina obj = null;
        for (Masina i : this.masini) {
            if (i.getPutere() > cai) {
                cai = i.getPutere();
                obj = i;
            }
        }
        return obj;
    }

    public Motocicleta fastestMoto() {
        int cai = 0;
        Motocicleta obj = null;
        for (Motocicleta i : this.moto) {
            if (i.getPutere() > cai) {
                cai = i.getPutere();
                obj = i;
            }
        }
        return obj;
    }

    public void fastest() {
        Masina a = this.fastestCar();
        Motocicleta b = this.fastestMoto();

        if (a.getPutere() > b.getPutere())
            System.out.println(a);
        else
            System.out.println(b);
    }

    public void afisareDupaAn(int an) {
        int c = 0;
        for (Masina i : this.masini)
            if (i.getAnFabricatie() >= an) {
                System.out.println(c + 1 + ". " + i);
                c++;
            }
        if (c == 0)
            System.out.println("Nu exista inregistrari.");
        else
            System.out.println("S-au afisat " + c + " inregistrari.");
    }

    public void afisareMotoareMaiMari(int x) {
        int c = 0;
        for (Masina i : this.masini)
            if (i.getCapacitateCiclindrica() >= x) {
                System.out.println(c + 1 + ". " + i);
                c++;
            }
        if (c == 0)
            System.out.println("Nu exista inregistrari.");
        else
            System.out.println("S-au afisat " + c + " inregistrari.");
    }
}

