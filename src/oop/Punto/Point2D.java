package oop.Punto;

public interface Point2D {
    public double getX();
    public double getY();
    public default double distanza(Point2D p){
        return Math.sqrt(getX()*getX() + getY()*getY());
    }
    public Point2D somma(Point2D p);
    public Point2D copy();
}
