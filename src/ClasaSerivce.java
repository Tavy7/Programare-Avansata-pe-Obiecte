package src;

import java.util.ArrayList;
import java.util.Scanner;

public class ClasaSerivce {
    private Showroom show;
    private Service serv;

    public ClasaSerivce() {
        this.show = new Showroom();
        this.serv = new Service();
    }

    public Showroom getShow() {
        return show;
    }

    public Service getServ() {
        return serv;
    }

    public void setShow(Showroom show) {
        this.show = show;
    }

    public void setServ(Service serv) {
        this.serv = serv;
    }

    protected int dialogCumparare(int x, Showroom sh, int ind, Client cli) {
        String veh;
        if (x == 1)
            veh = "masina";
        else if (x == 2)
            veh = "motocicleta";
        else {
            System.out.println("Input gresit");
            return -1;
        }

        System.out.println("Ce marca de " + veh + " cauti?");
        Scanner sc = new Scanner(System.in);
        String marca = sc.nextLine();

        if (x == 1){
            ArrayList<Masina> listaMasini = new ArrayList<Masina>();
            listaMasini = sh.cautaMasini(marca);
            System.out.println("Pe care dintre masini de mai sus o vrei?");
            x = sc.nextInt();
            x--;

            Masina mas = listaMasini.get(x);
            System.out.println(mas);
            if (cli.buget > mas.getPret()){
                sh.vanzatori.get(ind).efectueazaTranzactie(mas.getPret());
                sh.masini.remove(mas);
                System.out.println("Felicitari " + cli.nume + "!\nEsti proprietarul unei masini noi!");
                return 1;
            }
            else
                System.out.println("Imi pare rau, dar nu ai banii necesari pentru a completa tranzactia.");
        }
        else {
            ArrayList<Motocicleta> listaMoto = new ArrayList<Motocicleta>();
            listaMoto = sh.cautaMotociclete(marca);
            System.out.println("Pe care dintre masini de mai sus o vrei?");
            x = sc.nextInt();
            x--;

            Motocicleta motor = listaMoto.get(x);
            System.out.println(motor);
            if (cli.buget > motor.getPret()){
                sh.vanzatori.get(ind).efectueazaTranzactie(motor.getPret());
                sh.masini.remove(motor);
                cli.setBuget(cli.getBuget() - motor.getPret());
                System.out.println("Felicitari " + cli.nume + "!\nEsti proprietarul unei motociclete noi!");
                return 10;
            }
            else
                System.out.println("Imi pare rau, dar nu ai banii necesari pentru a completa tranzactia.");
        }
        return 0;
    }

    protected void cumparaVehicul (Client cli, Singleton sing){
        int ind = show.indexAngajatLiber();
        if (ind == -1)
            System.out.println("Nu exista angajati liberi.");

        show.vanzatori.get(ind).prezentare();
        show.vanzatori.get(ind).setOcupat(true);
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt(), conf;

        switch (x){
            case 1:
                sing.scrie("show_masini");
                show.printMasini();
                System.out.println("Esti interesat de ceva? Apasa 1 pentru comfirmare.");
                conf = sc.nextInt();

                if (conf == 1) {
                    conf = dialogCumparare(x, show, ind, cli);
                    if (conf == 1){
                        sing.scrie("car_bought");
                    }
                    if(conf == 10){
                        sing.scrie("moto_bought");
                    }
                }
                break;

            case 2:
                sing.scrie("show_moto");
                show.printMoto();
                System.out.println("Esti interesat de ceva? Apasa 1 pentru comfirmare.");
                conf = sc.nextInt();
                if (conf == 1)
                    dialogCumparare(x, show, ind, cli);
                break;

            case 3:
                show.printMasini();
                show.printMoto();
                System.out.println("Esti interesat de ceva? Apasa 1 pentru comfirmare.");
                conf = sc.nextInt();
                System.out.println("Doresti o masina (1) sau o motocicleta(2)?");
                x = sc.nextInt();
                if (conf == 1)
                    dialogCumparare(x, show, ind, cli);
                break;

            case 0:
                show.vanzatori.get(ind).setOcupat(false);
                break;
            default:
                System.out.println("Input gresit.");
        }
    }

    protected void intrareService(Client cli, Singleton sing){
        Mecanic mecanic = serv.findMechanic();
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
            Masina deReparat = new Masina(-1, cc, -1, -1, -1, "", "", "", -1, -1, gpl);

            double daune = mecanic.calculeazaDaune(deReparat);
            System.out.println("Daunele masinii sunt in valoare de $" + daune);
            System.out.println("Buget curent: " + cli.getBuget() + ".");
            System.out.println("Doriti sa reparati masina? Apasa 1 pentru confirmare.");
            cc = sc.nextInt();

            if (cc == 1) {
                if (cli.buget > daune) {
                    mecanic.efectueazaTranzactie(daune);
                    cli.setBuget(cli.getBuget() - daune);
                    System.out.println("Masina a fost reparata cu succes!");
                    sing.scrie("reparatie_masina_" + mecanic.getNume());
                }
                else
                    System.out.println("Imi pare rau, dar nu ai banii necesari pentru a completa tranzactia.");
            }
        }
        else if (x == 2){
            System.out.println("Capacitatea cilindrica : ");
            int cc = sc.nextInt();
            Motocicleta deReparat = new Motocicleta(-1, cc, -1, -1, -1, "", "", "", false, false);

            double daune = mecanic.calculeazaDaune(deReparat);
            System.out.println("Daunele masinii sunt in valoare de $" + daune);
            System.out.println("Buget curent: " + cli.getBuget() + ".");
            System.out.println("Doriti sa reparati motocicleta? Apasa 1 pentru confirmare.");
            cc = sc.nextInt();

            if (cc == 1) {
                if (cli.buget > daune) {
                    mecanic.efectueazaTranzactie(daune);
                    cli.setBuget(cli.getBuget() - daune);
                    System.out.println("Motocicleta a fost reparata cu succes!");
                    System.out.println("Buget curent: " + cli.getBuget());
                    sing.scrie("reparatie_motocicleta_" + mecanic.getNume());
                }
                else
                    System.out.println("Imi pare rau, dar nu ai banii necesari pentru a completa tranzactia.");
            }
        }
        else {
            System.out.println("Input incorect!");
            return;
        }
        mecanic.setOcupat(false);
    }

    protected void intrebari(Singleton sing){
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
                    sing.scrie("masini_count");
                    System.out.println("In service avem in momentul de fata " + show.masiniCount() + " masini.");
                    break;
                case 2:
                    sing.scrie("moto_count");
                    System.out.println("In service avem in momentul de fata " + show.motoCount() + " motociclete.");
                    break;
                case 3:
                    sing.scrie("most_powerful");
                    System.out.println("Cel mai puternic vehicul este : ");
                    show.fastest();
                    break;
                case 4:
                    sing.scrie("most_powerful_car");
                    System.out.println("Cea mai puternica masina este : ");
                    System.out.println(show.fastestCar());
                    break;
                case 5:
                    sing.scrie("most_powerful_moto");
                    System.out.println("Cea mai puternica motocicleta este : ");
                    System.out.println(show.fastestMoto());
                    break;
                case 6:
                    sing.scrie("searc_CC");
                    System.out.print("Capacitatea cilindrica x = ");
                    x = sc.nextInt();
                    show.afisareMotoareMaiMari(x);
                    break;
                case 7:
                    sing.scrie("search_year");
                    System.out.print("Anul x = ");
                    x = sc.nextInt();
                    show.afisareDupaAn(x);
                    break;
                case 8:
                    sing.scrie("search_car_name");
                    sc.nextLine();
                    System.out.print("Nume : ");
                    num = sc.nextLine();
                    show.cautaMasini(num);
                    break;
                case 9:
                    sing.scrie("search_moto_name");
                    sc.nextLine();
                    System.out.print("Nume : ");
                    num = sc.nextLine();
                    show.cautaMotociclete(num);
                    break;
                case 0:
                    sing.scrie("quit_interogari");
                    break;
                default:
                    System.out.println("Input incorect!");

            }
        }

    }

    public void magazin (Client cli, Singleton sing) {
        int sw = -1;

        System.out.println("Bine ai venit la Showroom-ul ProiectPAO, " + cli.nume);
        sing.scrie("rulat_main,user_" + cli.nume);

        while (sw != 0) {
            Scanner sc = new Scanner(System.in);
            System.out.println("-----------------------------------\n");
            System.out.println("1 - Cauta vehicul\n2 - Intrare vehicul in service\n3 - Intrebari despre stock\n0 - Iesire");
            sw = sc.nextInt();
            switch (sw){
                case 1:
                    this.cumparaVehicul(cli, sing);
                    sing.scrie("start_showroom");
                    break;
                case 2:
                    this.intrareService(cli, sing);
                    sing.scrie("start_service");
                    break;
                case 3:
                    this.intrebari(sing);
                    sing.scrie("start_interogari");
                    break;
                case 0:
                    sing.scrie("quit_program");
                    System.out.println("La revedere!");
                    break;
                default:
                    System.out.println("Input gresit.");
            }
            System.out.println("\n\n\n\n\n");
        }
    }

}
