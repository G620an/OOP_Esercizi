package oop.Collezioni;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ListaConcatenata <T> implements Iterable<T>{
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

    public void aggiungiInTesta(Nodo<T> nodo){
        if(this.testa == null){
            this.testa = nodo;
            if(this.coda == null){
                this.coda = nodo;
            }
            this.size++;
            return;
        }
        this.testa.pre = nodo;
        nodo.next = this.testa;
        this.testa = nodo;
        this.testa.pre = null;
        this.size++;
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
        this.coda.next = nodo;
        nodo.pre = this.coda;
        this.coda = nodo;
        this.coda.next = null;
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
        return (Iterator<T>) new IteratoreLista<>(this.getTesta());
    }

    public IteratoreLista<T> listIterator(){
        return new IteratoreLista<>(this.getTesta());
    }

}
