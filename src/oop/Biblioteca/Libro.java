package oop.Biblioteca;

public interface Libro {
    String getTitolo();
    Autore getAutore();
    int getAnnoPubblicazione();
    boolean isDisponibile();
    Genere getGenere();
}
