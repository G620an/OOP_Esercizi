package oop.Mazzo;

public class MazzoDiStoppa extends MazzoDaGioco{
    public MazzoDiStoppa(){
        super();
    }


    public static int getValore(Carta c){
        Valore v = c.getValore();
        return switch(v){
            case ASSO -> 16;
            case DUE -> 12;
            case TRE -> 13;
            case QUATTRO -> 14;
            case CINQUE -> 15;
            case SEI -> 18;
            case SETTE -> 21;
            default -> 10;
        };
    }

    public static int compareGiocatori(Giocatore g1, Giocatore g2){
        return MazzoDiStoppa.calcolaValoreMano(g1)-MazzoDiStoppa.calcolaValoreMano(g2);
    }

}
