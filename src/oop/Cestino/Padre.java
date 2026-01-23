package oop.Cestino;

import java.util.Objects;

public class Padre {
    private String nome;
    private String cognome;

    public Padre(String nome, String cognome) {
        if(nome == null || cognome == null) throw new NullPointerException();
        this.nome = nome;
        this.cognome = cognome;
    }

    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }

    public String toString(){
        return "Nome: " + this.getNome() + ", Cognome: " + this.getCognome();
    }

    public boolean equals(Object o){
        if(o == null) return false;
        if(o == this) return true;
        if(o instanceof Padre p){
            return this.getNome().equals(p.getNome()) && this.getCognome().equals(p.getCognome());
        }
        return false;
    }

    public int hashCode(){
        return Objects.hash(this.getNome(), this.getCognome());
    }
}
