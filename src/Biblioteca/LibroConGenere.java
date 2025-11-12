package Biblioteca;

public class LibroConGenere extends LibroAbstract{
    private Genere genere;
    public LibroConGenere(String titolo, Autore autore, int annoPubblicazione, Genere genere) {
        super(titolo, autore, annoPubblicazione);
        this.genere = genere;
    }

    public Genere getGenere() {
        return genere;
    }

    public String toString(){
        return "LibroConGenere{titolo= "+ getTitolo() + ", autore= " +  getAutore() + ", anno pubblicazione= " + getAnnoPubblicazione() + ", genere= " + getGenere() + ", disponibile= " + isDisponibile() + '}';
    }
}
