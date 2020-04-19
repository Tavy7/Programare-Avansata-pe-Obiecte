package src;

public class Main {
    public static void main (String args[]){
        Singleton sing = Singleton.getInstance();

        ClasaSerivce sv = new ClasaSerivce();
        sing.citire(sv.getServ(), sv);
        sing.citire(sv.getShow(), sv);

        Client client = new Client("Tavy", 100);

        sv.magazin(client, sing);
    }
}