package oop.Punto;
import java.util.*;

public class PianoCartesiano implements Iterable<Point2D>{
    private Set<Point2D> points;

    public PianoCartesiano(){
        points = new HashSet<Point2D>();
    }

    public PianoCartesiano(Set<Point2D> points){
        for(Point2D p : points){
            this.points.add(p.copy());
        }
    }

    public Iterator<Point2D> iterator(){
        return points.iterator();
    }

    public boolean add(Point2D p){
        return points.add(p.copy());
    }

    public boolean remove(Point2D p){
        if(points.contains(p)){
            return points.remove(p);
        }else{
            return false;
        }
    }

    public void clear(){
        points.clear();
    }

    public void stampa(){
        for(Point2D p : points){
            System.out.println(p);
        }
    }

    public int size(){
        return points.size();
    }

}
