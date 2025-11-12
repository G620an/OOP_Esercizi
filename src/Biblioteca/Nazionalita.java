package Biblioteca;

import java.util.Objects;

public class Nazionalita{
    private String sig;
    private int ISO;
    public Nazionalita(String sig , int ISO){
        if(sig == null  || sig.length()>3 || ISO > 1000){
            throw new IllegalArgumentException("Sigla o valore ISO errato");
        }
        this.sig = sig;
        this.ISO = ISO;
    }

    public String getSig() {
        return sig;
    }

    public int getISO() {
        return ISO;
    }

    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if(o == null){
            return false;
        }else if(o instanceof Nazionalita n){
            return sig.equals(n.sig) && ISO == n.ISO;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(sig, ISO);
    }

    @Override
    public String toString() {
        return "Nazionalita{" +
                "sig='" + sig + '\'' +
                ", ISO=" + ISO +
                '}';
    }
}
