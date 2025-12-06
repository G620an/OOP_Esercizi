package oop.Magazzino;
import java.util.*;

public class Magazzino implements Iterable<Materiale>{
    private List<Materiale> materiali;

    public Magazzino(){
        materiali = new ArrayList<>();
    }

    public void add(Materiale m){
        materiali.add(m);
    }

    public Materiale remove(int index){
        if(index >= materiali.size() || index < 0){
            throw new IndexOutOfBoundsException("Indice non valido");
        }
        return materiali.remove(index);
    }

    public boolean remove(Materiale m){
        return materiali.remove(m);
    }

    public Iterator<Materiale> iterator(){
        return materiali.iterator();
    }
}