package oop.CorpiCelesti;

public record Distanza(double distanza){
    public Distanza{
        if(distanza < 0){
            throw new IllegalArgumentException("La distanza non può essere negativa");
        }
    }

    public double getDistanzaAnniLuce(){
        return distanza;
    }

    public double getDistanzaUnitaAstronomiche(){
        return distanza * 63241.1;
    }

    public double getDistanzaParsec(){
        return distanza / 3.26;
    }

    public double getDistanzaMegaParsec(){
        return distanza / 3.26e+6;
    }

    @Override
    public String toString(){
        return getDistanzaAnniLuce() +" al";
    }

}
