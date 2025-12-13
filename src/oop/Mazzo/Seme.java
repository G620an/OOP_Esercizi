package oop.Mazzo;

import java.util.*;

public enum Seme{
    SPADA, DENARI, MAZZA, COPPA;

    @Override
    public String toString() {
        return switch(this){
            case SPADA -> "Cuori";
            case DENARI -> "Quadri";
            case MAZZA -> "Fiori";
            case COPPA -> "Picche";
        };
    }



    public static Seme generaSeme(){
        Random r = new Random();
        int n = r.nextInt(4);
        return switch(n){
            case 0 -> SPADA;
            case 1 -> DENARI;
            case 2 -> MAZZA;
            case 3 -> COPPA;
            default -> null;
        };
    }


}
