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

    public void ordina(){
        mazzo.sort(
        (o1, o2)->{//Lambda Expression che sostituisce una inner class privata comparatore
            if(o1.getSeme().equals(o2.getSeme())){
                return o1.getValore().compareTo(o2.getValore());
            }
            return o1.getSeme().compareTo(o2.getSeme());
        }
        );
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Mazzo{\n");
        for(Carta c : this){
            sb.append(c + "\n");
        }
        sb.append("}\n");
        return sb.toString();
    }

}
