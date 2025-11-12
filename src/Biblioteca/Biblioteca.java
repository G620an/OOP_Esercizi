package Biblioteca;
import java.util.*;

public class Biblioteca implements Iterable<Libro>{
    private final Set<Autore> autori;
    private final List<Libro> libri;
    private final Map<String, List<Libro>> prestiti;

    public Biblioteca(){
        this.autori = new TreeSet<Autore>();
        this.libri = new ArrayList<Libro>();
        this.prestiti = new HashMap<String, List<Libro>>();
    }

    public Biblioteca(Biblioteca biblioteca){
        this.autori = biblioteca.getAutori();
        this.libri = biblioteca.getLibri();
        this.prestiti = new HashMap<String, List<Libro>>();
    }

    public Set<Autore> getAutori() {
        return autori;
    }

    public List<Libro> getLibri() {
        return libri;
    }

    public Collection<List<Libro>> getPrestiti(){
        return prestiti.values();
    }

    public Iterator<Libro> iterator(){
        return new IteratoreDiLibri();
    }

    public String stampaLibri(){
        StringBuilder s = new StringBuilder();
        for(Libro l : this){
            s.append(l.toString());
            s.append("\n");
        }
        return s.toString();
    }

    public class IteratoreDiLibri implements Iterator<Libro>{
        private boolean okRemove = false;
        private int i = 1;
        private Libro cor = libri.getFirst();
        private Libro pre = null;

        public boolean hasNext(){
            if(cor != null){
                return true;
            }
            return false;
        }

        public Libro next(){
            if(!hasNext()){
                throw new NoSuchElementException();
            }
            Libro ret = cor;
            cor = libri.get(++i);
            pre = ret;
            okRemove = true;
            return ret;
        }

        public void remove(){
            if(!okRemove){
                throw new IllegalStateException();
            }
            libri.remove(pre);
            pre = cor;
            okRemove = false;
        }

    }

}
