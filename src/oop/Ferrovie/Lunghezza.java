package oop.Ferrovie;

public record Lunghezza(double l) implements Comparable<Lunghezza>{
    public Lunghezza{
        if(l<5.0 || l>35.0){
            throw new IllegalArgumentException("Lunghezza deve stare tra 5m e 35m");
        }
    }

    @Override
    public int compareTo(Lunghezza o) {
        return Double.compare(this.l(),o.l());
    }

}
