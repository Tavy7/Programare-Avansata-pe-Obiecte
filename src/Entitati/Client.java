package src.Entitati;
import java.util.Scanner;

public class Client {
    protected String nume;
    protected double buget;

    public Client(String nume, int buget) {
        this.nume = nume;
        this.buget = buget;
    }

    public Client() {
        Scanner sc = new Scanner(System.in);
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

    public String getNume() {
        return nume;
    }
}