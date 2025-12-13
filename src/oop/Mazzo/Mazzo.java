package oop.Mazzo;

import java.util.*;

public class Mazzo implements Iterable<Carta>{
    private ArrayList<Carta> mazzo;

    public Mazzo(){
        mazzo = new ArrayList<>(52);
        for(Seme s : Seme.values()){
            for(Valore v : Valore.values()){
                this.addCarta(s , v);
            }
        }
        this.mescola();
    }

    public int getSize(){
        return mazzo.size();
    }

    @Override
    public Iterator<Carta> iterator(){
        return mazzo.iterator();
    }

    public void addCarta(Carta c){
        mazzo.add(c);
    }

    public void mescola(){
        Collections.shuffle(mazzo);
    }

    public Carta prendiUnaCarta(){
        Random r = new Random();
        if(mazzo.isEmpty()) return null;
        int n = r.nextInt(mazzo.size());
        return mazzo.remove(n);
    }

    public void addCarta(Seme s , Valore v){
        mazzo.add(new Carta(s, v));
    }
}
