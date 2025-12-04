package oop.Punto;

import java.util.Objects;

public abstract class AbstractPoint2D implements Point2D{

    @Override
    public boolean equals(Object o){
        if(o == null) return false;
        if(o == this) return true;
        if(o instanceof Point2D p){ //instanceof Point2D
            return getX() == p.getX() && getY() == p.getY();
        }
        return false;
    }

    @Override
    public int hashCode(){
        return Objects.hash(getX(), getY());
    }

    @Override
    public String toString(){
        return "(" + getX() + " , " + getY() + ")";
    }

}
