package src;

import src.Locatii.Service;
import src.Locatii.Showroom;
import src.Service.ClasaSerivce;
import src.Entitati.*;
import src.Persistence.*;


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
        fisiereMecanici citireMecanici = fisiereMecanici.getInstance();
        citireMecanici.citire(service);

        return service;
    }

    public static void main(String args[]) {
        ClasaSerivce serv = new ClasaSerivce();
        Client client = new Client("Tavy", 100);

        Showroom showroom = initializareShowroom();
        serv.setShow(showroom);
        Service service = initializareService();
        serv.setServ(service);

        serv.magazin(client);
    }
}