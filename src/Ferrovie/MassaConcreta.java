package Ferrovie;

import java.util.Objects;

public class MassaConcreta extends Massa{
    public MassaConcreta(double m){
        super(m);
    }

    public class MassaFrenata extends Massa{
        double m;
        public MassaFrenata(double m){
            if(this.m<0 || this.m>super.getMassa()){
                throw new IllegalArgumentException("Massa non valida");
            }
            this.m = m;
        }
    }

}

