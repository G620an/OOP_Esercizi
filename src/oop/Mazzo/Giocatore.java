package oop.Mazzo;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Random;

public class Giocatore implements Iterable<Carta>{
    private LinkedList<Carta> carte;
    private int points;
    private String username;

    public Giocatore(String username) {
        carte = new LinkedList<>();
        points = 0;
        this.username = username;
    }

    @Override
    public Iterator<Carta> iterator(){
        return carte.iterator();
    }

    public void addCarta(Carta carta){
        carte.add(carta);
    }

    public int getPoints(){
        return points;
    }

    public void addPoints(int points){
        this.points += points;
    }

    public void removePoints(int points){
        this.points -= points;
    }

    public String getUsername(){
        return username;
    }

    public Carta giocaCarta(){
        int n = new Random().nextInt(carte.size());
        return carte.get(n);
    }

    public Carta giocaCarta(int n){
        return carte.get(n);
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        int i = 0;
        for(Carta c : this){
            sb.append(i).append(". ").append(c);
        }
        return sb.toString();
    }

    @Override
    public boolean equals(Object o){
        if(o == null) return false;
        if(o == this) return true;
        if(o instanceof Giocatore g){
            return this.getUsername().equals(g.getUsername());
        }
        return false;
    }

    @Override
    public int hashCode(){
        return this.getUsername().hashCode();
    }

}
