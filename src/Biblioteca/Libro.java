package Biblioteca;

public interface Libro {
    String getTitolo();
    Autore getAutore();
    int getAnnoPubblicazione();
    boolean isDisponibile();
    void presta(String utente , String titolo);
    void restituisci(String utente , String titolo);
}
