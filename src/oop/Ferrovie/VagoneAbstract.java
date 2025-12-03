package oop.Ferrovie;

public abstract class VagoneAbstract implements Vagone, Comparable<Vagone>{
    Identificativo ID;
    MassaConcreta.MassaFrenata massaFrenata;
    MassaConcreta massa;
    Velocita velocita;
    Lunghezza lunghezza;

    public VagoneAbstract(Identificativo ID, MassaConcreta.MassaFrenata massaFrenata, MassaConcreta massa, Velocita velocita, Lunghezza lunghezza) {
        this.ID = ID;
        this.massaFrenata = massaFrenata;
        this.massa = massa;
        this.velocita = velocita;
        this.lunghezza = lunghezza;
    }

    public Identificativo getID() {
        return ID;
    }

    public MassaConcreta getMassa() {
        return massa;
    }

    public MassaConcreta.MassaFrenata getMassaFrenata() {
        return massaFrenata;
    }

    public Velocita getVelocita() {
        return velocita;
    }

    public Lunghezza getLunghezza() {
        return lunghezza;
    }

    @Override
    public String toString() {
        return "Vagone{" + ID + ", " +  massa + ", " + velocita + ", " + lunghezza + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        if(o instanceof VagoneAbstract v){
            return this.getID().equals(v.getID());
        }
        return false;
    }

    @Override
    public int hashCode() {
        return this.ID.hashCode();
    }

    @Override
    public int compareTo(Vagone o) {
        return this.getID().compareTo(o.getID());
    }

}
