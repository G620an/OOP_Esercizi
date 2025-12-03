package oop.Ferrovie;

public record Velocita(double kmh) implements Comparable<Velocita>{
    public Velocita{
        if(kmh < 0){
            throw new IllegalArgumentException("Velocita kmh negativo");
        }
    }

    @Override
    public int compareTo(Velocita o) {
        return Double.compare(this.kmh(), o.kmh());
    }

}
