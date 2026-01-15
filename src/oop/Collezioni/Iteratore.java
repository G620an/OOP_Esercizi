package oop.Collezioni;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Iteratore<T> implements Iterator<T>{
        private ListaConcatenata.Nodo<T> cor; //Nel corrente viene conservato il valore appena saltato
        private ListaConcatenata.Nodo<T> pre;
        private boolean okElimina = false;
        private ListaConcatenata.Nodo<T> h;

        public Iteratore(ListaConcatenata.Nodo<T> testa){
            this.pre = null;
            T a = null;
            ListaConcatenata.Nodo<T> n = new ListaConcatenata.Nodo<T>(a);
            n.next = testa;
            this.cor = n;
            this.h = testa;
        }

        public boolean hasNext(){
            if(this.cor.next == null) return false; //Se il next è null non posso fare cor.info nel next()
            return true;
        }

        public T next(){
            if(!hasNext()) throw new NoSuchElementException();
            pre = cor;
            cor = cor.next;
            okElimina = true;
            return cor.info;
        }

        public void remove(){
            if(!okElimina) throw new IllegalStateException();
            if(pre == null){
                h = h.next;
                return;
            }
            pre.next = cor.next; //Saltiamo il cor
            okElimina = false;
        }
}
