package oop.Mazzo;

import java.util.*;

public enum Seme{
    COPPA, DENARI, BASTONI, SPADA;

    @Override
    public String toString() {
        return switch(this){
            case SPADA -> "Spada";
            case DENARI -> "Denari";
            case BASTONI -> "Bastoni";
            case COPPA -> "Coppa";
        };
    }

    public static Seme generaSeme(){
        Random r = new Random();
        int n = r.nextInt(4);
        return switch(n){
            case 0 -> SPADA;
            case 1 -> DENARI;
            case 2 -> BASTONI;
            case 3 -> COPPA;
            default -> null;
        };
    }


}
