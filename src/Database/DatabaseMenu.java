package src.Database;

import src.Entitati.Mecanic;
import src.Entitati.Vanzator;
import src.Vehicule.Masina;
import src.Vehicule.Motocicleta;

import java.util.Scanner;

public class DatabaseMenu {
    MotocicletaDatabase motoDB;
    MasinaDatabase masinaDB;
    VanzatorDatabase vanzatorDB;
    MecanicDatabase mecanicDB;

    public DatabaseMenu() {
        this.motoDB = MotocicletaDatabase.getInstance();
        this.masinaDB = MasinaDatabase.getInstance();
        this.vanzatorDB = VanzatorDatabase.getInstance();
        this.mecanicDB = MecanicDatabase.getInstance();
    }

    public void afisareMeniu() {
        int ok = 0;
        int x = 0;
        Scanner sc = new Scanner(System.in);

        while (x != -1){
            System.out.println(" Selectati operatia: ");
            System.out.println(" 1 - Save item\n 2 - Find item\n 3 - Update item\n 4 - Delete item\n 5 - Find newest item");

            ok = sc.nextInt();

            int[] verif = new int[]{1, 2, 3, 4, 5};
            for (int i : verif){
                if (ok == i){
                    x = -1;
                }
            }
        }

        x = 0;
        sc.nextLine();
        while (x != -1){
            System.out.println(" Selectati data de baze pe care se aplice operatia: ");
            System.out.println(" 1 - Motocicleta\n 2 - Masina\n 3 - Vanzator\n 4 - Mecanic");

            x = sc.nextInt();
            switch (x) {
                case 1:
                    switch (ok) {
                        case 1:
                            System.out.println(x);
                            x = -1;
                            System.out.println(x);
                            this.motoDB.saveMotocicleta(new Motocicleta());
                            break;
                        case 2:
                            System.out.println("Introduceti seria: ");
                            String serie = sc.nextLine();
                            this.motoDB.findMotocicleta(serie);
                            x = -1;
                            break;
                        case 3:
                            //update item
                            x = -1;
                            break;
                        case 4:
                            //delete item
                            x = -1;
                            break;
                        case 5:
                            this.motoDB.findNewestmotocicleta();
                            x = -1;
                    }
                    break;
                case 2:
                    switch (ok) {
                        case 1:
                            this.masinaDB.saveMasina(new Masina());
                            x = -1;
                            break;
                        case 2:
                            System.out.println("Introduceti seria: ");
                            String serie = sc.nextLine();
                            this.masinaDB.findMasina(serie);
                            x = -1;
                            break;
                        case 3:
                            x = -1;
                            break;
                        //update item
                        case 4:
                            //delete item
                            x = -1;
                            break;
                        case 5:
                            this.masinaDB.findNewestMasina();
                            x = -1;
                    }
                    break;
                case 3:
                    switch (ok) {
                        case 1:
                            this.vanzatorDB.saveVanzator(new Vanzator());
                            x = -1;
                            break;
                        case 2:
                            System.out.println("Introduceti id: ");
                            int id = sc.nextInt();
                            this.vanzatorDB.findVanzator(id);
                            x = -1;
                            break;
                        case 3:
                            x = -1;
                            break;
                        //update item
                        case 4:
                            x = -1;
                            break;
                        //delete item
                        case 5:
                            this.vanzatorDB.findNewestMember();
                            x = -1;
                    }
                    break;
                case 4:
                    switch (ok) {
                        case 1:
                            this.mecanicDB.saveMecanic(new Mecanic());
                            x = -1;
                            break;
                        case 2:
                            System.out.println("Introduceti id: ");
                            int id = sc.nextInt();
                            this.mecanicDB.findMecanic(id);
                            x = -1;
                            break;
                        case 3:
                            x = -1;
                            break;
                        //update item
                        case 4:
                            x = -1;
                            break;
                        //delete item
                        case 5:
                            this.mecanicDB.findNewestMember();
                            x = -1;
                            break;
                        default:
                            System.out.println(" Input incorect!");
                    }
                    break;
                default:
                    System.out.println(" Input incorect!");
            }
        }
    }
}
