package Ferrovie;

import java.util.Objects;

public abstract class Massa implements Comparable<Massa>{
    private double m;
    public Massa(double m){
        if(m<0.0 || m>255.00){
            throw new IllegalArgumentException("Massa in Tonnellate non compresa [0 ; 255]");
        }
        this.m = m;
    }

    public Massa(){}

    public double getMassa(){ return this.m;}

    @Override
    public String toString(){
        return "Massa: " + this.getMassa();
    }

    @Override
    public boolean equals(Object o){
        if(this == o){return true;}
        if(o == null){return false;}
        if(o instanceof Massa c){
            return this.getMassa() == c.getMassa();
        }
        return false;
    }

    @Override
    public int hashCode(){
        return Objects.hash(this.m);
    }

    @Override
    public int compareTo(Massa o) {
        return Double.compare(this.m, o.getMassa());
    }

}
