package oop.Biblioteca;

public enum Genere {
    GIALLO , ROSA , FANTASCIENZA, SAGGIO, FANTASY;
    @Override
    public String toString(){
        return switch (this) {
            case GIALLO -> "Giallo";
            case ROSA -> "Rosa";
            case FANTASCIENZA -> "Fantascienza";
            case SAGGIO -> "Saggio";
            case FANTASY -> "Fantasy";
            default -> "";
        };
    }
}
