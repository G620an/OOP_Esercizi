package oop.Range;

import java.util.Iterator;
import java.util.*;

public class Range implements Iterable<Integer>{
    private int start;
    private int end;
    
    public Range(int start, int end){
        if(start < 0 || end <= start){
            throw new IllegalArgumentException("L'inizo deve venire prima della fine e deve essere positivo.");
        }
        this.start = start;
        this.end = end;
    }

    public Iteratore iterator(){
        return new Iteratore();
    }

    private class Iteratore implements Iterator<Integer> {
        private int cor = Range.this.start;
        boolean rimuovi = false;

        @Override
        public boolean hasNext(){
            if(cor < Range.this.end){
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
