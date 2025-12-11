package oop.CorpiCelesti;

public abstract class CorpoCelesteAbstract implements CorpoCeleste, Comparable<CorpoCeleste>{
    public static final double c = 299792; // Velocità della luce in [km/s] (nel vuoto ovviamente)
    public static final double u = 1.496e+8; // Unità astronomica in [km]
    public static final double al = 9.461e+12; //anno luce in [km]

    @Override
    public boolean equals(Object o){
        if(o == null) return false;
        if(this == o) return true;
        if(o instanceof CorpoCeleste c){
            return this.getCodice().equals(c.getCodice());
        }
        return false;
    }

    @Override
    public int hashCode(){
        return getCodice().hashCode();
    }

    @Override
    public String toString(){
        return " Codice: " + getCodice() + ", Massa[kg]: " + getMassa() + ", Distanza[al]: " + getDistanzaDallaTerra() + ", Raggio[km]: " + getRaggio() + ", Nickname: " + getNickname();
    }

    @Override
    public int compareTo(CorpoCeleste o){
        return this.getCodice().getCodice().compareTo(o.getCodice().getCodice());
    }

}
