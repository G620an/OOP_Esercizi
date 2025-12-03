package oop.Ferrovie;

public class Motrice extends VagoneAbstract {
    private MassaConcreta trazione;
    private String desc;

    public Motrice(Identificativo ID, MassaConcreta.MassaFrenata massaFrenata, MassaConcreta massa, Velocita velocita, Lunghezza lunghezza , MassaConcreta trazione, String desc) {
        super(ID, massaFrenata, massa, velocita, lunghezza);
        if(trazione == null || desc == null){
            throw new IllegalArgumentException();
        }
        this.desc = desc;
        this.trazione = trazione;
    }

    public MassaConcreta getTrazione() {
        return trazione;
    }

    public String getDesc() {
        return desc;
    }

    @Override
    public String toString(){
        String s = super.toString();
        s = s.substring(0 , s.length()-1);
        return s + ", " + trazione + ", " + desc +"}";
    }
}
