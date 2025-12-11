package oop.Biblioteca;
import java.io.Serializable;

public interface Libro extends Serializable {
    String getTitolo();
    Autore getAutore();
    int getAnnoPubblicazione();
    boolean isDisponibile();
    Genere getGenere();
}
