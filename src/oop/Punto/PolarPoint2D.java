package oop.Punto;

public class PolarPoint2D implements Point2D{
    private double theta;
    private double ro;

    public PolarPoint2D(double x, double y){
        this.theta = Math.atan2(x , y); // arctg(y/x) = angolo theta
        this.ro = Math.sqrt(x*x + y*y); //calcolo modulo del vettore (x , y)
    }

    public PolarPoint2D(Point2D p){
        this(p.getX() , p.getY()); //Richiamo il costruttore
    }

    public double getX(){
        return ro*Math.cos(theta);
    }

    public double getY(){
        return ro*Math.sin(theta);
    }

    @Override
    public Point2D somma(Point2D p){
        return new PolarPoint2D(getX()+p.getX() , getY()+p.getY());
    }

    @Override
    public Point2D copy(){
        return new PolarPoint2D(getX(), getY());
    }
}
