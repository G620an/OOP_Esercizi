package Biblioteca;

public abstract class LibroAbstract implements Libro, Comparable<Libro>{
    private String titolo;
    private Autore autore;
    private int annoPubblicazione;
    boolean disponibile;

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

    @Override
    public int compareTo(Libro c) {
        if(!(titolo.equals(c.getTitolo()))){
            return titolo.compareTo(c.getTitolo());
        }else{
            return autore.compareTo(c.getAutore());
        }
    }

}
