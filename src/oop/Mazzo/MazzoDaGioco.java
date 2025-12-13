package oop.Mazzo;

public class MazzoDaGioco extends Mazzo{
    public MazzoDaGioco(){
        super();
    }

    public static int getValore(Carta c){
        return 0;
    }

    public int compare(Carta c1, Carta c2){
        Valore v1 = c1.getValore();
        Valore v2 = c2.getValore();
        return MazzoDaGioco.getValore(c1) -  MazzoDaGioco.getValore(c2);
    }

}
