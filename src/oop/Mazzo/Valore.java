package oop.Mazzo;

import java.util.Random;

public enum Valore{
    ASSO, DUE, TRE , QUATTRO, CINQUE, SEI, SETTE, DONNA, CIUCCIO, RE;

    @Override
    public String toString(){
        return switch(this){
            case ASSO -> "Asso";
            case DUE -> "Due";
            case TRE -> "Tre";
            case QUATTRO -> "Quattro";
            case CINQUE -> "Cinque";
            case SEI -> "Sei";
            case SETTE -> "Sette";
            case DONNA -> "Otto";
            case CIUCCIO -> "Nove";
            case RE -> "Dieci";
        };
    }


    public static Valore generaValore(){
        Random r = new Random();
        int n = r.nextInt(10);
        return switch(n){
            case 0 -> Valore.ASSO;
            case 1 -> Valore.DUE;
            case 2 -> Valore.TRE;
            case 3 -> Valore.QUATTRO;
            case 4 -> Valore.CINQUE;
            case 5 -> Valore.SEI;
            case 6 -> Valore.SETTE;
            case 7 -> Valore.DONNA;
            case 8 -> Valore.CIUCCIO;
            case 9 -> Valore.RE;
            default -> Valore.ASSO;
        };
    }

}
