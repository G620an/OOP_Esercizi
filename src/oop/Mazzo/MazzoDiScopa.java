package oop.Mazzo;

public class MazzoDiScopa extends MazzoDaGioco{
    public MazzoDiScopa(){
        super();
    }


    public static int getValore(Carta c){
        Valore v = c.getValore();
        return switch(v){
            case ASSO -> 1;
            case DUE -> 2;
            case TRE -> 3;
            case QUATTRO -> 4;
            case CINQUE -> 5;
            case SEI -> 6;
            case SETTE -> 7;
            case DONNA -> 8;
            case CIUCCIO -> 9;
            case RE -> 10;
        };
    }


}
