package src;

import src.Database.DatabaseConnection;
import src.Locatii.Service;
import src.Locatii.Showroom;
import src.Service.ClasaSerivce;
import src.Entitati.*;
import src.Persistence.*;
import java.sql.SQLException;
import src.Database.DatabaseMenu;


public class Main {
    public static Showroom initializareShowroom(){
        Showroom showroom = new Showroom();

        fisiereVanzatori citireVanzatori = fisiereVanzatori.getInstance();
        citireVanzatori.citire(showroom);

        fisiereMasini citireMasini = fisiereMasini.getInstance();
        citireMasini.citire(showroom);

        fisiereMoto citireMoto = fisiereMoto.getInstance();
        citireMoto.citire(showroom);

        return showroom;

    }

    public static Service initializareService(){
        Service service = new Service();
        fisiereMecanic citireMecanici = fisiereMecanic.getInstance();
        citireMecanici.citire(service);

        return service;
    }

    public static void databaseConection() throws SQLException {
        DatabaseConnection db_instance = DatabaseConnection.getInstance();

        String schema = db_instance.getConnection().toString();
        System.out.println(schema);
    }

    public static void main(String args[]) {
        try {
            databaseConection();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        ClasaSerivce serv = new ClasaSerivce();
        Client client = new Client("Tavy", 100);

        Showroom showroom = initializareShowroom();
        serv.setShow(showroom);
        Service service = initializareService();
        serv.setServ(service);

//        try {
//            serv.magazin(client);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        DatabaseMenu meniuSql = new DatabaseMenu();
        meniuSql.afisareMeniu();
    }
}