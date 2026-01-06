package oop.Collezioni;

import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

public class IteratoreLista<T> implements ListIterator<T> {
    private ListaConcatenata.Nodo<T> cor; //Nel corrente viene conservato il valore appena saltato
    private ListaConcatenata.Nodo<T> pre; //Valore saltato in precedenza
    private int index = 0; //Indice del valore da saltare
    private boolean forward = true;
    private boolean okElimina = false; //Controllo per verificare se posso eliminare

    public IteratoreLista(ListaConcatenata.Nodo<T> testa){
        T a = null; //Creo un elemento T null
        this.cor  = new ListaConcatenata.Nodo<T>(a); //Creo un nodo fittizio con next che punta alla testa della lista
        this.cor.next = testa;
    }

    public boolean hasNext(){
        if(this.cor.next == null) return false;
        return true;
    }

    public boolean hasPrevious(){
        if(this.pre == null) return false;
        return true;
    }

    public T next(){
        if(!hasNext()) throw new NoSuchElementException();
        pre = cor; //Il precedente diventa il vecchio corrente
        cor = cor.next; //Sostituisco il corrente vecchio con il nuovo
        okElimina = true; //Controllo per elimina
        forward = true; //Controllo per elimina
        index ++; //Incremento per index
        return cor.info; //Restituisco il corrente nuovo
    }

    public T previous(){
        if(!hasPrevious()) throw new NoSuchElementException();
        cor = pre; //Il corrente diventa il precedente
        pre = pre.pre; //Faccio tornare indietro anche il precedente
        okElimina = true; //Controllo per elimina
        forward = false; //Controllo per elimina
        index --; //Aggiornamento index
        return cor.info; //Restituisco il pre.info che ho in cor.info
    }

    public void remove(){
        if(!okElimina) throw new IllegalStateException();
        pre.next = cor.next; //Saltiamo il cor cioè l'elemento appena saltato (sia in un verso che nell'altro)
        cor = pre;//Il nuovo corrente diventa il precedente
        okElimina = false;
    }

    public void set(T e){
        cor.info = e; //In ogni caso il cor è l'elemento appena saltato sia in un verso che nell'altro
    }

    public int nextIndex(){
        return index;
    }

    public int previousIndex(){
        return index - 1;
    }

    public void add(T e){

    }

}
