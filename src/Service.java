package src;

import java.util.ArrayList;

public class Service {
    protected ArrayList <Mecanic> mecanici = new ArrayList<Mecanic>();
    protected boolean spatiu[] = new boolean[4];

    public Service() {
        for (int i = 0; i < 4; i++)
            this.spatiu[i] = false;
    }

    public void addMecanic (Mecanic x){
        this.mecanici.add(x);
    }

    public Mecanic findMechanic (){
        for (Mecanic i : this.mecanici)
            if (i.isOcupat() == false)
                return i;
        return  null;
    }
}
