package src;

import java.util.*;

public class Showroom {
    protected Set<src.Masina> masini = new HashSet<src.Masina>();   //lista de masini
    protected Set<src.Motocicleta> moto = new HashSet<src.Motocicleta>();//lista de motociclete
    protected ArrayList<src.Vanzator> vanzatori = new ArrayList<src.Vanzator>();

    public Showroom() {
        src.Masina a = new src.Masina(3500.00, 2000, 136, 2004, 50.02, "BMW", "YV149MTS6G2409804", "rosu", 4, 5, false);
        this.masini.add(a);
        a = new src.Masina(4999.99, 2298, 143, 2010, 60, "Pegeout", "SG149SRT45SG09804", "galben", 4, 5, false);
        this.masini.add(a);
        a = new src.Masina(2000, 1600, 95, 2006, 52.2, "Dacia", "AR123FDJI32JSAD34", "alb", 4, 5, false);
        this.masini.add(a);
        a = new src.Masina(35000, 2198, 143, 2016, 63.5, "Mercedes-Benz", "RTY783Y4H28329804", "alb", 4, 5, false);
        this.masini.add(a);
        a = new src.Masina(5000, 2298, 143, 2010, 60, "Renault", "SG14FDSF323249804", "alb", 4, 5, false);
        this.masini.add(a);
        a = new src.Masina(15000, 3000, 253, 2010, 61.2, "Audi", "S3249FG245SG09804", "negru", 4, 5, false);
        this.masini.add(a);
        a = new src.Masina(30000, 4200, 420, 2011, 60, "Audi", "GFDG434325SG09803", "gri", 4, 5, false);
        this.masini.add(a);
        a = new src.Masina(5000, 2298, 143, 2010, 59.3, "Pegeout", "MSAKJD213KDS29804", "alb", 4, 5, true);
        this.masini.add(a);
        a = new src.Masina(7420.20, 4200, 220, 2002, 60, "Lancia", "KMER23RT45SG09324", "alb", 4, 5, false);
        this.masini.add(a);
        a = new src.Masina(5000, 4000, 289, 2010, 58.9, "Toyota", "S43290RT45SG09832", "gri", 4, 5, false);
        this.masini.add(a);
        a = new src.Masina(3500.00, 2000, 136, 2004, 50.02, "BMW", "YV432MTS6G2409804", "rosu", 4, 5, false);
        this.masini.add(a);
        a = new src.Masina(4999.99, 2298, 143, 2010, 60, "Opel", "DSF29SRTDGS43204", "albastru", 4, 5, false);
        this.masini.add(a);
        a = new src.Masina(10000.00, 3000, 143, 2010, 61.5, "Opel", "SD149FDS45SGF804", "alb", 4, 5, false);
        this.masini.add(a);
        a = new src.Masina(7800.00, 998, 95, 2018, 52, "Dacia", "SG14COVID19G09804", "alb", 4, 5, true);
        this.masini.add(a);
        a = new src.Masina(5000, 2298, 143, 2004, 60, "Volkswagen", "SHY23LOI45SG098HG", "alb", 4, 5, false);
        this.masini.add(a);
        a = new src.Masina(5000, 3000, 143, 2018, 63, "Honda", "ZAR3GFDT45SG0HG04", "alb", 4, 5, false);
        this.masini.add(a);
        a = new src.Masina(6329.99, 2000, 257, 1998, 63.3, "BMW", "3T249S5435SGF9845", "galben", 4, 5, true);
        this.masini.add(a);
        a = new src.Masina(5000, 2298, 143, 2001, 59, "BMW", "UYF234RT45SG0SARG", "gri", 4, 5, false);
        this.masini.add(a);
        a = new src.Masina(8925.23, 4200, 143, 2010, 60, "Audi", "S3449SRT45SGSA804", "alb", 4, 5, false);
        this.masini.add(a);
        a = new src.Masina(250000, 6000, 589, 2017, 55, "Mercedes AMG", "VA23DSRT45SG09234", "alb", 4, 5, false);
        this.masini.add(a);
        a = new src.Masina(50000, 5200, 342, 2016, 80, "GMC", "MA329SRT465409ASD", "negru", 4, 5, false);
        this.masini.add(a);
        a = new src.Masina(2000, 1600, 95, 2010, 52, "Dacia", "A2139SRT324TGFFGG", "alb", 4, 5, true);
        this.masini.add(a);
        a = new src.Masina(3758.99, 1568, 65, 2011, 64.9, "Renault", "G3209SD9SRFD804", "rosu", 4, 5, true);
        this.masini.add(a);
        a = new src.Masina(5000, 1600, 105, 2010, 60, "Pegeout", "RT4549SSG0SG14", "verde", 4, 5, false);
        this.masini.add(a);
        a = new src.Masina(2500, 1200, 80, 2007, 60, "Seat", "A98G149ST45SGSR04", "alb", 4, 5, false);
        this.masini.add(a);


        src.Motocicleta b = new src.Motocicleta(5000, 589, 80, 2003, 20.00, "Yamaha", "VIN123MOTOCICLETA", "verde", false, false);
        this.moto.add(b);
        b = new src.Motocicleta(7500.00, 1158, 143, 2011, 25.00, "BMW", "VILE23MON1OCICTTA", "neagra", true, true);
        this.moto.add(b);
        b = new src.Motocicleta(2000.00, 589, 80, 2003, 20.00, "Ducati", "VOTOICLETIN123CMA", "rosie", true, false);
        this.moto.add(b);
        b = new src.Motocicleta(3249.99, 650, 80, 2010, 20.00, "Yamaha", "CICLAVITOETN123MO", "neagra", true, true);
        this.moto.add(b);
        b = new src.Motocicleta(2000.00, 589, 80, 2011, 22, "Kawasaki", "1ICLETA23MOTOCVIN", "albastra", true, true);
        this.moto.add(b);
        b = new src.Motocicleta(2000.00, 589, 80, 2003, 28.2, "Honda", "OTIN123MEOCICLVTA", "gri", true, true);
        this.moto.add(b);
        b = new src.Motocicleta(2000.00, 589, 80, 2017, 20.00, "Suzuki", "CLV1TOCIN23MOITA", "neagra", true, false);
        this.moto.add(b);
        b = new src.Motocicleta(8000, 1349, 189, 2019, 26.3, "Aprilia", "VIICLENOCTA23MOT", "rosie", false, true);
        this.moto.add(b);
        b = new src.Motocicleta(4200.68, 589, 80, 2013, 20.00, "Suzuki", "MIICVLETN12OTOC3A", "alba", true, true);
        this.moto.add(b);
        b = new src.Motocicleta(6899.89, 768, 112, 2010, 18.9, "Yamaha", "OCIC23MLEVTN1OTA", "neagra", true, true);
        this.moto.add(b);

        this.vanzatori.add(new src.Vanzator("Ionut", 1));
        this.vanzatori.add(new src.Vanzator("Ana", 2));
        this.vanzatori.add(new src.Vanzator("George", 3));
        Collections.sort(this.vanzatori);//sortare descrescatoare dupa id
    }

    public int indexAngajatLiber() {
        for (int i = 0; i < this.vanzatori.size(); i++)
            if ((this.vanzatori.get(i)).isOcupat() == false)
                return i;
        return -1;
    }

    public int countAngajati() {
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

    public ArrayList<src.Masina> cautaMasini(String marca) {
        int count = 1;
        ArrayList<src.Masina> a = new ArrayList<src.Masina>();
        for (src.Masina i : this.masini)
            if (i.getDenumire().equals(marca)) {
                System.out.println(count + ". " + i);
                a.add(i);
                count++;
            } else continue;
        return a;

    }

    public ArrayList<src.Motocicleta> cautaMotociclete(String marca) {
        int count = 1;
        ArrayList<src.Motocicleta> a = new ArrayList<src.Motocicleta>();
        for (src.Motocicleta i : this.moto)
            if (i.getDenumire().equals(marca)) {
                System.out.println(count + ". " + i);
                a.add(i);
                count++;
            } else continue;
        return a;

    }

    public int masiniCount() {
        return this.masini.size();
    }

    public int motoCount() {
        return this.moto.size();
    }

    public src.Masina fastestCar() {
        int cai = 0;
        src.Masina obj = null;
        for (src.Masina i : this.masini) {
            if (i.getPutere() > cai) {
                cai = i.getPutere();
                obj = i;
            }
        }
        return obj;
    }

    public src.Motocicleta fastestMoto() {
        int cai = 0;
        src.Motocicleta obj = null;
        for (src.Motocicleta i : this.moto) {
            if (i.getPutere() > cai) {
                cai = i.getPutere();
                obj = i;
            }
        }
        return obj;
    }

    public void fastest(){
        src.Masina a = this.fastestCar();
        src.Motocicleta b = this.fastestMoto();

        if (a.getPutere() > b.getPutere())
            System.out.println(a);
        else
            System.out.println(b);
    }

    public void afisareDupaAn(int an){
        int c = 0;
        for (src.Masina i : this.masini)
            if (i.getAnFabricatie() >= an) {
                System.out.println(c + 1 + ". " + i);
                c++;
            }
        if (c == 0)
            System.out.println("Nu exista inregistrari.");
        else
            System.out.println("S-au afisat " + c + " inregistrari.");
    }

    public void afisareMotoareMaiMari(int x){
        int c = 0;
        for (src.Masina i : this.masini)
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

