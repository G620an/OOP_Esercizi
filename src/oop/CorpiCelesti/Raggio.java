package oop.CorpiCelesti;

import java.io.Serializable;

public record Raggio(double raggio)implements Serializable {
    public Raggio{
        if(raggio < 0){
            throw new IllegalArgumentException("Il raggio non può essere negativo");
        }
    }

    public double getRaggioKilometri(){
        return raggio;
    }

    public double getRaggioAnniLuce(){
        return raggio / CorpoCelesteAbstract.al;
    }

    public double getRaggioUnitaAstronomiche(){
        return raggio / CorpoCelesteAbstract.u;

    }

    @Override
    public String toString(){
        return getRaggioKilometri() + " km";
    }

}
