package oop.Mazzo;

import java.util.Objects;
import java.util.Random;

public class Carta {
    private Seme seme;
    private Valore valore;

    public Carta(Seme seme, Valore valore) {
        this.seme = seme;
        this.valore = valore;
    }

    public Carta(){
        this.seme = Seme.generaSeme();
        this.valore = Valore.generaValore();
    }

    public Carta(Seme seme){
        this.seme = seme;
        this.valore = Valore.generaValore();
    }

    public Carta(Carta c){
        this.seme = c.getSeme();
        this.valore = c.getValore();
    }

    public Seme getSeme() {
        return seme;
    }

    public Valore getValore() {
        return valore;
    }

    @Override
    public String toString(){
        return "[" + this.getValore() + " " + this.getSeme() + "]";
    }

    @Override
    public boolean equals(Object o){
        if(o == null) return false;
        if(o == this) return true;
        if( o instanceof Carta c){
            return this.getSeme() == c.getSeme() && this.getValore().equals(c.getValore());
        }
        return false;
    }

    @Override
    public int hashCode(){
        return Objects.hash(this.getSeme(), this.getValore());
    }

}
