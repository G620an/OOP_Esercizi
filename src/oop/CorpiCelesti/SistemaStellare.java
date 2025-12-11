package oop.CorpiCelesti;

import java.io.Serializable;
import java.util.Iterator;
import java.util.TreeMap;

public class SistemaStellare implements Comparable<SistemaStellare>, Serializable, Iterable<Stella>{
    private TreeMap<Codice, Stella> stelle;
    private Indirizzo indirizzo;

    public SistemaStellare(Indirizzo indirizzo){
        stelle = new TreeMap<>();
        this.indirizzo = indirizzo;
    }

    public SistemaStellare(Indirizzo indirizzo, TreeMap<Codice, Stella> stelle){
        this.stelle = stelle;
        this.indirizzo = indirizzo;
    }

    public void addStella(Stella s){
        this.getStelle().put(s.getCodice(), s);
    }

    public TreeMap<Codice, Stella> getStelle(){
        return stelle;
    }

    public Indirizzo getIndirizzo(){
        return indirizzo;
    }

    @Override
    public Iterator<Stella> iterator(){
        return stelle.values().iterator();
    }

    @Override
    public int compareTo(SistemaStellare o) {
        return this.getIndirizzo().compareTo(o.getIndirizzo());
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("SistemaStellare{\n");
        for(Stella s : this){
            sb.append(" Stella: ").append(s).append(s.stampaPianeti()).append("\n");
        }
        sb.append("\n}");
        return sb.toString();
    }

    @Override
    public boolean equals(Object o){
        if(o == null) return false;
        if(o == this) return true;
        if(o instanceof SistemaStellare sl){
            return this.indirizzo.equals(sl.indirizzo);
        }
        return false;
    }

}
