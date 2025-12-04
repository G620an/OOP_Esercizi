package Punto;

public class CartesianPoint2D implements Point2D {
    private double x;
    private double y;

    public CartesianPoint2D(double x, double y){
        this.x = x;
        this.y = y;
    }

    public CartesianPoint2D(Point2D p){
        this.x = p.getX();
        this.y = p.getY();
    }

    public double getX(){
        return x;
    }

    public double getY(){
        return y;
    }

    @Override
    public Point2D somma(Point2D p){
        return new CartesianPoint2D(getX()+p.getX() , getY() + p.getY());
    }

    @Override
    public Point2D copy(){
        return new CartesianPoint2D(getX(), getY());
    }

}
