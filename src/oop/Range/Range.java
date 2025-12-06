package oop.Range;

import java.util.Iterator;
import java.util.*;

public class Range implements Iterable<Integer>{
    private int start;
    private int end;
    public Range(int start, int end){
        if(end <= start){
            throw new IllegalArgumentException("L'inizo deve venire prima della fine");
        }
        this.start = start;
        this.end = end;
    }

    public Iteratore iterator(){
        return new Iteratore(start, end);
    }

    private class Iteratore implements Iterator<Integer> {
        private int end;
        private int cor;
        boolean rimuovi = false;

        public Iteratore(int start, int end){
            this.cor = start;
            this.end = end;
        }

        @Override
        public boolean hasNext(){
            if(cor < end){
                return true;
            }else{
                return false;
            }
        }

        @Override
        public Integer next(){
            if(!hasNext()) throw new NoSuchElementException("Non ci sono più elementi");
            return cor++;
        }

        @Override
        public void remove(){
            if(!rimuovi) throw new UnsupportedOperationException("Non puoi rimuovere due volte o prima di saltare");
            //niente non fa niente
        }

    }

}
