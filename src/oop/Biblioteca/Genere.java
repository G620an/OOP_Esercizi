package oop.Biblioteca;

import java.io.Serializable;

public enum Genere implements Serializable{
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
