package oop.Collezioni;

import java.util.*;

public class ListaConcatenata <T>  extends LinkedList<T> implements Iterable<T>{
    //------------------------------------------------------------------------------------------------------------------
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
            this.pre = pre;
        }
        public Nodo(T info, Nodo<T> next, Nodo<T> pre){
            this.info = info;
            this.next = next;
            this.pre = pre;
        }
        public Nodo(Nodo<T> nodo){
            this(nodo.info, nodo.next, nodo.pre);
        }
    }
    //------------------------------------------------------------------------------------------------------------------
    private Nodo<T> testa;
    private Nodo<T> coda;
    private int size;

    public ListaConcatenata(){
        this.testa = null;
        this.coda = null;
        this.size = 0;
    }
    public ListaConcatenata(ListaConcatenata<T> lista){
        this.testa = new Nodo<>(lista.getTesta());
        this.coda = new Nodo<>(lista.getCoda());
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


    public T remove(){
        Nodo<T> ret = this.coda;
        this.coda = this.coda.pre; //rimuove in coda
        this.coda.next = null; //rimuove il next della coda
        return ret.info;
    }


    public T removeFirst(){
        Nodo<T> ret = this.testa;
        this.testa = this.testa.next; //rimuovo la testa spostandola al next
        this.testa.pre = null; //rimuovo il pre della nuova testa
        return ret.info;
    }


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
        return this.new Iter();
    }

    public ListIterator<T> listIterator(){
        return this.new IteratoreL();
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

    //-----------------------------------------------------------------------------------------------------------------
    public class Iter implements Iterator<T>{
        private ListaConcatenata.Nodo<T> cor; //Nel corrente viene conservato il valore appena saltato
        private ListaConcatenata.Nodo<T> pre;
        private boolean okElimina = false;

        public Iter(){
            this.pre = null;
            T a = null;
            ListaConcatenata.Nodo<T> n = new ListaConcatenata.Nodo<>(a);
            n.next = testa;
            this.cor = n;
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
            if(pre.info == null){ //Se l'info del pre è null allora elimino la testa
                testa = testa.next;
                return;
            }
            pre.next = cor.next; //Saltiamo il cor
            okElimina = false;
        }
    }

    //-------------------------------------------------------------------------------------------------------------------

    public class IteratoreL implements ListIterator<T> {
        private Nodo<T> cor; //Nel corrente viene conservato il valore appena saltato
        private Nodo<T> pre; //Valore saltato in precedenza
        private int index = 0; //Indice del valore da saltare
        private boolean forward = true;
        private boolean okElimina = false; //Controllo per verificare se posso eliminare

        public IteratoreL(){
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
            cor = pre; //Faccio tornare indietro il cor
            pre = cor.pre; //Il pre diventa il pre del corrente
            okElimina = true; //Controllo per elimina
            forward = false; //Controllo per elimina
            index --; //Aggiornamento index
            return cor.info; //Restituisco il pre.info che ho in cor.info
        }

        public void remove(){
            if(!okElimina) throw new IllegalStateException();
            if(pre.info == null){//Considero la rimozione in testa
                testa = testa.next;
                testa.pre = null;
                okElimina = false;
                return;
            }
            if(cor.next == null){//Considero la rimozione in coda
                coda = coda.pre;
                coda.next = null;
                okElimina = false;
                return;
            }
            pre.next = cor.next; //Saltiamo il cor cioè l'elemento appena saltato
            cor.next.pre = pre; //Collego bene il nodo dopo l'eliminazione
            /*
            if(forward){
                pre.next = cor.next; //Saltiamo il cor cioè l'elemento appena saltato
                cor.next.pre = pre; //Collego bene il nodo dopo l'eliminazione
            }
            */
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
            return;
        }

    }


}
