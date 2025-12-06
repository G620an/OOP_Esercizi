package oop.CorpiCelesti;
import java.lang.IllegalArgumentException;


public record Massa(double massa){
    public Massa{
        if(massa < 0){
            throw new IllegalArgumentException("La massa non può essere negativa");
        }
    }

    @Override
    public String toString(){
        return massa + " kg";
    }
}
