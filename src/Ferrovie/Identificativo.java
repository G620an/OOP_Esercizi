package Ferrovie;

public record Identificativo(String ID) implements Comparable<Identificativo>{
    public Identificativo{
        String pre = ID.substring(0, 3);
        String post = ID.substring(3);
        for(int i = 0; i < pre.length(); i++){
            char c = pre.charAt(i);
            if(!Character.isAlphabetic(c)){
                throw new IllegalArgumentException("ERRORE ID");
            }
        }

        for(int i = 0; i < post.length(); i++){
            char c = post.charAt(i);
            if(!Character.isDigit(c)){
                throw new IllegalArgumentException("ERRORE ID");
            }
        }
    }

    @Override
    public int compareTo(Identificativo o) {
        return this.ID.compareTo(o.ID);
    }
}
