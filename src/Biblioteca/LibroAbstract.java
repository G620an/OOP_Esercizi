package Biblioteca;

import java.util.Objects;

public abstract class LibroAbstract implements Libro, Comparable<Libro>{
    private String titolo;
    private Autore autore;
    private int annoPubblicazione;
    boolean disponibile;

    public LibroAbstract(String titolo, Autore autore, int annoPubblicazione){
        if(titolo==null || autore==null || annoPubblicazione<0){
            throw new IllegalArgumentException();
        }
        this.titolo = titolo;
        this.autore = autore;
        this.annoPubblicazione = annoPubblicazione;
        this.disponibile = true;
    }

    @Override
    public int getAnnoPubblicazione() {
        return annoPubblicazione;
    }

    @Override
    public String getTitolo() {
        return titolo;
    }

    @Override
    public Autore getAutore() {
        return autore;
    }

    @Override
    public boolean isDisponibile() {
        return disponibile;
    }

    public void setDisponibile(boolean disponibile) {
        this.disponibile = disponibile;
    }

    @Override
    public int compareTo(Libro c) {
        if(!(titolo.equals(c.getTitolo()))){
            return titolo.compareTo(c.getTitolo());
        }else{
            return autore.compareTo(c.getAutore());
        }
    }

    @Override
    public String toString(){
        return "Libro{Titolo= " + titolo + ", Autore= " + autore.toString() + ", Anno Pubblicazione= " + annoPubblicazione + ", Disponibile= " + disponibile + "}";
    }

    @Override
    public boolean equals(Object o){
        if(this == o){return true;}
        if(o == null){
            return false;
        }else if(o instanceof LibroAbstract c){
            return titolo.equals(c.getTitolo()) && autore.equals(c.getAutore()) && annoPubblicazione == c.getAnnoPubblicazione();
        }
        return false;
    }

    @Override
    public int hashCode(){
        return Objects.hash(titolo, autore, annoPubblicazione);
    }

}
