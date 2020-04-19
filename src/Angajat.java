package src;

public abstract class Angajat {
    protected String nume;
    protected boolean ocupat;
    protected int id;

    public Angajat(String nume, int id) {
        this.nume = nume;
        this.ocupat = false;
        this.id = id;
    }

    public String getNume() {
        return nume;
    }

    public boolean isOcupat() {
        return this.ocupat;
    }

    public int getId() {
        return id;
    }

    public void setOcupat(boolean ocupat) {
        this.ocupat = ocupat;
    }

    @Override
    public String toString() {
        return "Salut! Ma numesc " + this.nume + ".";
    }

    @Override
    public int hashCode() {
        return this.id;
    }

    public boolean equals(Object obj) {
        return (obj instanceof Angajat && ((Angajat) obj).nume == this.nume);
    }
}
