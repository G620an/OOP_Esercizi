package Biblioteca;

import java.util.Locale;
import java.util.Objects;

public class Autore {
    private String nome;
    private String cognome;
    private Nazionalita nazio;
    public Autore(String nome, String cognome, Nazionalita nazio){
        if(nome == null || cognome == null || nazio == null){
            throw new IllegalArgumentException("!Attenzione campo null!");
        }
        this.nome = nome.toLowerCase();
        this.cognome = cognome.toLowerCase();
        this.nazio = nazio;
    }

    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }

    public Nazionalita getNazio() {
        return nazio;
    }

    @Override
    public boolean equals(Object o) {
        if(this == o){return true;}
        if(o==null){
            return false;
        }else{
            if(o instanceof Autore a){
                return nome.equals(a.getNome()) && cognome.equals(a.getCognome()) && nazio.equals(a.getNazio());
            }
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, cognome, nazio);
    }

    @Override
    public String toString() {
        return "Autore{" + "nome= " + nome + ", cognome= " + cognome + ", nazionalità= " + nazio + '}';
    }
}
