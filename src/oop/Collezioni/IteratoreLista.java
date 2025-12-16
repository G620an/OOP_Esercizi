package oop.Collezioni;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class IteratoreLista<T> implements Iterator<T>{
    private ListaConcatenata.Nodo<T> cor; //Nel corrente viene conservato il valore appena saltato
    private ListaConcatenata.Nodo<T> pre;
    private boolean forward = true;
    private boolean okElimina = false;

    public IteratoreLista(ListaConcatenata.Nodo<T> testa){
        this.pre = null;
        T a = null;
        ListaConcatenata.Nodo<T> n = new ListaConcatenata.Nodo<T>(a);
        n.next = testa;
        this.cor = n;
    }

    public boolean hasNext(){
        if(this.cor == null) return false;
        return true;
    }

    public boolean hasPre(){
        if(this.pre == null) return false;
        return true;
    }

    public T next(){
        if(!hasNext()) throw new NoSuchElementException();
        pre = cor;
        cor = cor.next;
        okElimina = true;
        forward = true;
        return cor.info;
    }

    public T previous(){
        if(!hasPre()) throw new NoSuchElementException();
        cor = pre;
        pre = pre.pre;
        okElimina = true;
        forward = false;
        return pre.info;
    }

    public void remove(){
        if(!okElimina) throw new IllegalStateException();
        if(forward){
            pre.next = cor.next; //Saltiamo il cor
            cor.next.pre = pre; //cor.next mi manda al prossimo e con il pre definisco il pre
        }else{
            /*
            cor.pre.next = pre.next;
            pre.next.pre = cor.pre;
            Da rivedere
            */
        }
        okElimina = false;
    }

}
