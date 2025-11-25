package Ospedale;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedReparti implements Iterable<Reparto>{

    private static class Nodo{
        private Reparto r;
        private Nodo prossimo = null;
        public Nodo(Reparto r){
            this.r = r;
        }
        public Nodo(){}
        public Reparto r(){
            return this.r;
        }
    }

    private Nodo head;
    private int size;
    public LinkedReparti(Reparto r){
        this.head = new Nodo(r);
        size = 1;
    }

    public LinkedReparti(){
        this.head = null;
        this.size = 0;
    }

    public void aggiungiInTesta(Reparto r){
        if(r == null){ throw new NullPointerException();}
        Nodo n = new Nodo(r);
        n.prossimo = head;
        head = n;
        size++;
    }

    public boolean rimuoviElemento(Reparto r){
        Iterator<Reparto> it = iterator();
        while(it.hasNext()){
            Reparto p = it.next();
            if(p.equals(r)){
                it.remove();
                return true;
            }
        }
        return false;
    }

    public Iterator<Reparto> iterator(){
        return new IteratoreLink();
    }

    public class IteratoreLink implements Iterator<Reparto>{
        private Nodo cor = new Nodo();
        private Nodo pre = null;
        public IteratoreLink(){
            this.cor.prossimo = head; // uso questo trucchetto per mettermi prima di head come un vero iteratore
        }
        public boolean hasNext(){
            return cor != null;
        }

        public Reparto next(){
            if(!hasNext()){ throw new NoSuchElementException();}
            pre = cor;
            cor = cor.prossimo;
            return cor.r();
        }

        public void remove(){
            if(cor == pre || pre == null){throw new UnsupportedOperationException("Non puoi eliminare due volte di seguito");}
            pre.prossimo = cor.prossimo;
            pre = cor;
            size --;
        }
    }

}
