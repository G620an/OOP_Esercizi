package Biblioteca;

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
}
