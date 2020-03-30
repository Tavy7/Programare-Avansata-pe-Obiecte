package src;

import java.util.ArrayList;

public class Service {
    public ArrayList <src.Mecanic> mecanici = new ArrayList<src.Mecanic>();
    public boolean spatiu[] = new boolean[4];

    public Service() {
        for (int i = 0; i < 4; i++)
            this.spatiu[i] = false;
        this.mecanici.add(new src.Mecanic("Florin", 10));
        this.mecanici.add(new src.Mecanic("Radu", 11));
        this.mecanici.add(new src.Mecanic("Mircea", 12));
    }

    public src.Mecanic findMechanic (){
        for (src.Mecanic i : this.mecanici)
            if (i.isOcupat() == false)
                return i;
        return  null;
    }

    public eSpatiuOcupat(int i){
        return this.spatiu[i];
    }
    
    public setSpatiu(int i, boolean x){
        this.spatiu[i] = x;
    }
}
