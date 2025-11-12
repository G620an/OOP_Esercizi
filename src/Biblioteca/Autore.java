package Biblioteca;

import java.util.Objects;

public class Autore {
    private String nome;
    private String cognome;
    private String nazio;
    public Autore(String nome, String cognome, String nazio){
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

    public String getNazio() {
        return nazio;
    }

    @Override
    public String toString() {
        return "Autore{" +
                "nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                ", nazio=" + nazio +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if(o==null){
            return false;
        }else if(o instanceof Autore a){
            return this.nome.equals(a.nome) && this.cognome.equals(a.cognome) && this.nazio.equals(a.nazio);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, cognome, nazio);
    }
}
