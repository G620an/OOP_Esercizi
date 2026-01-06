package oop.Collezioni;

import java.util.*;

public class ListaConcatenata <T> extends LinkedList<T> implements Iterable<T>{
    public static class Nodo <T>{
        public T info;
        public Nodo<T> next;
        public Nodo<T> pre;

        public Nodo(T info){
            this.info = info;
            this.next = null;
            this.pre = null;
        }
        public Nodo(T info, Nodo<T> pre){
            this.info = info;
            this.pre = new Nodo<T>(pre.info);
        }
        public Nodo(T info, Nodo<T> next, Nodo<T> pre){
            this.info = info;
            this.next = new Nodo<T>(next.info);
            this.pre = new Nodo<T>(pre.info);
        }
        public Nodo(Nodo<T> nodo){
            this(nodo.info, nodo.next, nodo.pre);
        }
    }

    private Nodo<T> testa;
    private Nodo<T> coda;
    private int size;

    public ListaConcatenata(){
        this.testa = null;
        this.coda = null;
        this.size = 0;
    }
    public ListaConcatenata(ListaConcatenata<T> lista){
        this.testa = new Nodo<T>(lista.getTesta());
        this.coda = new Nodo<T>(lista.getCoda());
        this.size = lista.getSize();
    }


    public Nodo<T> getTesta(){
        return this.testa;
    }

    public Nodo<T> getCoda(){
        return this.coda;
    }

    public int getSize(){
        return this.size;
    }

    @Override
    public T remove(){
        Nodo<T> ret = this.coda;
        this.coda = this.coda.pre; //rimuove in coda
        this.coda.next = null; //rimuove il next della coda
        return ret.info;
    }

    @Override
    public T removeFirst(){
        Nodo<T> ret = this.testa;
        this.testa = this.testa.next; //rimuovo la testa spostandola al next
        this.testa.pre = null; //rimuovo il pre della nuova testa
        return ret.info;
    }

    @Override
    public boolean add(T el){
        this.aggiungiInCoda(el);
        return true;
    }
    public void add(Nodo<T> n){
        this.aggiungiInCoda(n);
    }

    public void aggiungiInTesta(Nodo<T> nodo){
        if(this.testa == null){
            this.testa = nodo;
            if(this.coda == null){
                this.coda = nodo;
            }
            this.size++;
            return;
        }
        this.testa.pre = nodo; //Testa precedente
        nodo.next = this.testa; //La prossima testa ha come next la testa corrente
        this.testa = nodo; //Sostituisco
        this.testa.pre = null; //La nuova testa non ha pre
        this.size++; //Incremento grandezza
    }
    public void aggiungiInTesta(T info){
        this.aggiungiInTesta(new Nodo<T>(info));
    }

    public void aggiungiInCoda(Nodo<T> nodo){
        if(this.coda == null){
            this.coda = nodo;
            if(this.testa == null){
                this.testa = nodo;
            }
            this.size++;
            return;
        }
        this.coda.next = nodo; //Il next della vecchia coda è la nuova coda
        nodo.pre = this.coda; //Il precedente della nuova coda è la vecchia coda
        this.coda = nodo; //Sostituisco la coda
        this.coda.next = null;//La nuova coda non ha next
    }
    public void aggiungiInCoda(T info){
        this.aggiungiInCoda(new Nodo<T>(info));
    }

    public Nodo<T> getValue(int index){
        Nodo<T> cor = this.testa;
        for(int i = 0 ; i < index; i++){
            cor = cor.next;
        }
        return cor;
    }


    public Iterator<T> iterator(){
        return new Iteratore<>(this.getTesta());
    }

    public IteratoreLista<T> listIterator(){
        return new IteratoreLista<>(this.getTesta() , this);
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("ListaConcatenata{\n");
        for(T el : this){
            sb.append(" ").append(el).append(",").append("\n");
        }
        sb.append("}\n");
        return sb.toString();
    }

    @Override
    public boolean equals(Object o){
        if(o == null) return false;
        if(o == this) return true;
        if(o instanceof ListaConcatenata l){
            Iterator<T> it = l.iterator();
            for(T el : this){
                if(el != it.next()){
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    @Override
    public int hashCode(){
        return Objects.hash(this.toString());
    }

}
