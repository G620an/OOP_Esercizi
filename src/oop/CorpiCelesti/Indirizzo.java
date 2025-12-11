package oop.CorpiCelesti;

import java.io.Serializable;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Indirizzo implements Comparable<Indirizzo>, Serializable{
    private String indirizzo;
    private String regex = "([a-zA-Z]{8})";
    private Pattern pattern = Pattern.compile(regex);
    public Indirizzo(String indirizzo){
        if(indirizzo == null)throw new NullPointerException("Indirizzo nullo");
        indirizzo = indirizzo.trim();
        if(indirizzo.length() != 8) throw new IllegalArgumentException("Indirizzo non valido");
        Matcher matcher = pattern.matcher(indirizzo);
        if(!matcher.matches()) throw new IllegalArgumentException("Indirizzo non valido");
        this.indirizzo = indirizzo;
    }

    public String getIndirizzo(){
        return this.indirizzo;
    }

    @Override
    public int compareTo(Indirizzo i){
        return this.getIndirizzo().compareTo(i.getIndirizzo());
    }

    @Override
    public boolean equals(Object o){
        if(o == null)return false;
        if(o == this) return true;
        if(o instanceof Indirizzo i){
            return this.getIndirizzo().equals(i.getIndirizzo());
        }
        return false;
    }

    @Override
    public int hashCode(){
        return Objects.hash(this.getIndirizzo());
    }

    @Override
    public String toString(){
        return this.getIndirizzo();
    }

}
