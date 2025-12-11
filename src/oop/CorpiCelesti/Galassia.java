package oop.CorpiCelesti;

import java.io.Serializable;
import java.util.Iterator;
import java.util.Objects;
import java.util.TreeMap;

public class Galassia implements Serializable, Iterable<SistemaStellare>, Comparable<Galassia>{
    private String nome;
    private TreeMap<Indirizzo , SistemaStellare> galassia;

    public Galassia(String nome){
        if(nome == null)throw new IllegalArgumentException();
        this.nome = nome;
        galassia = new TreeMap<>();
    }

    public Galassia(String nome , TreeMap<Indirizzo, SistemaStellare> galassia){
        if(nome == null)throw new IllegalArgumentException();
        if(galassia == null)throw new IllegalArgumentException();
        this.nome = nome;
        this.galassia = galassia;
    }

    public Galassia(Galassia galassia){
        if(galassia == null)throw new IllegalArgumentException();
        this.nome = galassia.getNome();
        this.galassia = this.getGalassia();
    }

    public TreeMap<Indirizzo, SistemaStellare> getGalassia() {
        return galassia;
    }

    public void addSistemaStellare(SistemaStellare s){
        galassia.put(s.getIndirizzo(), s);
    }

    public String getNome() {
        return nome;
    }

    @Override
    public Iterator<SistemaStellare> iterator(){
        return galassia.values().iterator();
    }

    @Override
    public int compareTo(Galassia galassia){
        return this.nome.compareTo(galassia.getNome());
    }

    @Override
    public boolean equals(Object o){
        if(o == null)return false;
        if(o == this)return true;
        if(o instanceof Galassia g){
            return this.nome.equals(g.getNome());
        }
        return false;
    }

    @Override
    public int hashCode(){
        return Objects.hash(this.getNome());
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Galassia: " + this.getNome() + " {");
        for(SistemaStellare sl : this){
            sb.append("\n").append("  Sistema Stellare: " + sl.stampa()).append(sl).append("\n");
        }
        sb.append("}");
        return sb.toString();
    }



}
