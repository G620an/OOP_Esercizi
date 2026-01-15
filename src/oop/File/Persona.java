package oop.File;

import java.util.Objects;

public class Persona {
    private String nome;
    private String cognome;
    private int eta;
    private double peso;

    public Persona(String nome, String cognome, int eta, double peso) {
        if(nome == null || cognome == null || eta < 0 || peso < 0) throw new IllegalArgumentException();
        this.nome = nome;
        this.cognome = cognome;
        this.eta = eta;
        this.peso = peso;
    }
    
    public Persona(Persona p) {
        this.nome = p.getNome();
        this.cognome = p.getCognome();
        this.eta = p.getEta();
        this.peso = p.getPeso();
    }

    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }

    public int getEta() {
        return eta;
    }

    public double getPeso() {
        return peso;
    }

    @Override
    public boolean equals(Object o) {
        if(o == null) return false;
        if(o == this) return true;
        if(o instanceof Persona p){
            return this.getNome().equals(p.getNome()) && this.getCognome().equals(p.getCognome());
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, cognome);
    }

    @Override
    public String toString() {
        return "Nome: " + this.getNome() + ", Cognome: " + this.getCognome() +  ", Eta: " + this.getEta() + ", Peso: " + this.getPeso() + "kg";
    }
}
