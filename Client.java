package src;

import java.util.ArrayList;
import java.util.Scanner;

public class Client {
    protected String nume;
    protected double buget;

    public Client() {
        Scanner sc = new Scanner (System.in);
        System.out.println("Salut! Care este numele tau?");
        this.nume = sc.nextLine();
        System.out.println("Ce buget ai?");
        this.buget = sc.nextDouble();
    }

    public double getBuget() {
        return buget;
    }

    public void setBuget(double buget) {
        this.buget = buget;
    }

    protected void dialogCumparare(int x, src.Showroom sh, int ind) {
        String veh;
        if (x == 1)
            veh = "masina";
        else if (x == 2)
            veh = "motocicleta";
        else {
            System.out.println("Input gresit");
            return;
        }

        System.out.println("Ce marca de " + veh + " cauti?");
        Scanner sc = new Scanner(System.in);
        String marca = sc.nextLine();

        if (x == 1){
            ArrayList<src.Masina> listaMasini = new ArrayList<src.Masina>();
            listaMasini = sh.cautaMasini(marca);
            System.out.println("Pe care dintre masini de mai sus o vrei?");
            x = sc.nextInt();
            x--;

            src.Masina mas = listaMasini.get(x);
            System.out.println(mas);
            if (this.buget > mas.getPret()){
                sh.vanzatori.get(ind).efectueazaTranzactie(mas.getPret());
                sh.masini.remove(mas);
                System.out.println("Felicitari " + this.nume + "!\nEsti proprietarul unei masini noi!");
            }
            else
                System.out.println("Imi pare rau, dar nu ai banii necesari pentru a completa tranzactia.");
    }
        else {
            ArrayList<src.Motocicleta> listaMoto = new ArrayList<src.Motocicleta>();
            listaMoto = sh.cautaMotociclete(marca);
            System.out.println("Pe care dintre masini de mai sus o vrei?");
            x = sc.nextInt();
            x--;

            src.Motocicleta motor = listaMoto.get(x);
            System.out.println(motor);
            if (this.buget > motor.getPret()){
                sh.vanzatori.get(ind).efectueazaTranzactie(motor.getPret());
                sh.masini.remove(motor);
                this.setBuget(this.getBuget() - motor.getPret());
                System.out.println("Felicitari " + this.nume + "!\nEsti proprietarul unei motociclete noi!");
            }
            else
                System.out.println("Imi pare rau, dar nu ai banii necesari pentru a completa tranzactia.");
        }

    }

    protected void cumparaVehicul (){
        src.Showroom sh = new src.Showroom();
        int ind = sh.indexAngajatLiber();
        if (ind == -1)
            System.out.println("Nu exista angajati liberi.");

        sh.vanzatori.get(ind).prezentare();
        sh.vanzatori.get(ind).setOcupat(true);
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt(), conf;

        switch (x){
            case 1:
                sh.printMasini();
                System.out.println("Esti interesat de ceva? Apasa 1 pentru comfirmare.");
                conf = sc.nextInt();
                if (conf == 1)
                    dialogCumparare(x, sh, ind);
                break;

            case 2:
                sh.printMoto();
                System.out.println("Esti interesat de ceva? Apasa 1 pentru comfirmare.");
                conf = sc.nextInt();
                if (conf == 1)
                    dialogCumparare(x, sh, ind);
                break;

            case 3:
                sh.printMasini();
                sh.printMoto();
                System.out.println("Esti interesat de ceva? Apasa 1 pentru comfirmare.");
                conf = sc.nextInt();
                System.out.println("Doresti o masina (1) sau o motocicleta(2)?");
                x = sc.nextInt();
                if (conf == 1)
                    dialogCumparare(x, sh, ind);
                break;

            case 0:
                sh.vanzatori.get(ind).setOcupat(false);
                break;
            default:
                    System.out.println("Input gresit.");
            }
        }

    protected void intrareService(){
        src.Service serv = new src.Service();
        src.Mecanic mecanic = serv.findMechanic();
        if (mecanic == null){
            System.out.println("Nu exista niciun mecanic disponibil momentan.");
            return;
        }

        mecanic.prezentare();
        mecanic.setOcupat(true);

        System.out.println("Va fi necesar sa facem fisa service, nu iti face griji, ne intereseaza doar cateva informatii.");
        System.out.println("Detineti o masina (1) sau o motocileta(2)?");

        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        if (x == 1){
            System.out.println("Capacitatea cilindrica : ");
            int cc = sc.nextInt();
            System.out.println("Are gpl? 1 - da");
            boolean gpl = sc.nextBoolean();
            src.Masina deReparat = new src.Masina(-1, cc, -1, -1, -1, "", "", "", -1, -1, gpl);

            double daune = mecanic.calculeazaDaune(deReparat);
            System.out.println("Daunele masinii sunt in valoare de $" + daune);
            System.out.println("Buget curent: " + this.getBuget() + ".");
            System.out.println("Doriti sa reparati masina? Apasa 1 pentru confirmare.");
            cc = sc.nextInt();

            if (cc == 1) {
                if (this.buget > daune) {
                    mecanic.efectueazaTranzactie(daune);
                    this.setBuget(this.getBuget() - daune);
                    System.out.println("Masina a fost reparata cu succes!");
                }
                else
                    System.out.println("Imi pare rau, dar nu ai banii necesari pentru a completa tranzactia.");
            }
        }
        else if (x == 2){
            System.out.println("Capacitatea cilindrica : ");
            int cc = sc.nextInt();
            src.Motocicleta deReparat = new src.Motocicleta(-1, cc, -1, -1, -1, "", "", "", false, false);

            double daune = mecanic.calculeazaDaune(deReparat);
            System.out.println("Daunele masinii sunt in valoare de $" + daune);
            System.out.println("Buget curent: " + this.getBuget() + ".");
            System.out.println("Doriti sa reparati motocicleta? Apasa 1 pentru confirmare.");
            cc = sc.nextInt();

            if (cc == 1) {
                if (this.buget > daune) {
                    mecanic.efectueazaTranzactie(daune);
                    this.setBuget(this.getBuget() - daune);
                    System.out.println("Motocicleta a fost reparata cu succes!");
                    System.out.println("Buget curent: " + this.getBuget());
                }
                else
                    System.out.println("Imi pare rau, dar nu ai banii necesari pentru a completa tranzactia.");
            }
        }
        else {
            System.out.println("Input incorect!");
            return;
        }

    }

    protected void intrebari(){
        src.Showroom show = new src.Showroom();
        int sw = -1, x;
        String num;

        while (sw != 0){
            Scanner sc = new Scanner(System.in);

            System.out.println("------------------------------------------");
            System.out.println("1 - Numar masini\n2 - Numar motocilete\n3 - Cel mai puternic vehicul");
            System.out.println("4 - Cea mai puternica masina\n5 - Cea mai puternica motocicleta");
            System.out.println("6 - Afisare masini cu motorul mai mare decat x.\n7 - Cautare masini mai recente decat x");
            System.out.println("8 - Cautare masina dupa nume\n9 - Cautare motocicleta dupa nume\n0 - Inapoi");

            sw = sc.nextInt();

            switch (sw){
                case 1:
                    System.out.println("In service avem in momentul de fata " + show.masiniCount() + " masini.");
                    break;
                case 2:
                    System.out.println("In service avem in momentul de fata " + show.motoCount() + " motociclete.");
                    break;
                case 3:
                    System.out.println("Cel mai puternic vehicul este : ");
                    show.fastest();
                    break;
                case 4:
                    System.out.println("Cea mai puternica masina este : ");
                    System.out.println(show.fastestCar());
                    break;
                case 5:
                    System.out.println("Cea mai puternica motocicleta este : ");
                    System.out.println(show.fastestMoto());
                    break;
                case 6:
                    System.out.print("Capacitatea cilindrica x = ");
                    x = sc.nextInt();
                    show.afisareMotoareMaiMari(x);
                    break;
                case 7:
                    System.out.print("Anul x = ");
                    x = sc.nextInt();
                    show.afisareDupaAn(x);
                    break;
                case 8:
                    sc.nextLine();
                    System.out.print("Nume : ");
                    num = sc.nextLine();
                    show.cautaMasini(num);
                    break;
                case 9:
                    sc.nextLine();
                    System.out.print("Nume : ");
                    num = sc.nextLine();
                    show.cautaMotociclete(num);
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Input incorect!");

            }
        }

    }

    public void intraMagazin () {
        int sw = -1;

        System.out.println("Bine ai venit la Showroom-ul ProiectPAO, " + this.nume);
        System.out.println("-----------------------------------\n");

        while (sw != 0) {
            Scanner sc = new Scanner(System.in);
            System.out.println("1 - Cauta vehicul\n2 - Intrare vehicul in service\n3 - Intrebari despre stock\n0 - Iesire");
            sw = sc.nextInt();
            switch (sw){
                case 1:
                    this.cumparaVehicul();
                    break;
                case 2:
                    this.intrareService();
                    break;
                case 3:
                    this.intrebari();
                    break;
                case 0:
                    System.out.println("La revedere!");
                    break;
                default:
                    System.out.println("Input gresit.");
            }
            System.out.println("\n\n-----------------------------------");
        }
    }
}