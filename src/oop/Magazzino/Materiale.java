package oop.Magazzino;
import java.io.*;

public record Materiale(String nome, int qta) implements Serializable {
  public Materiale{
    if(nome == null || qta < 0){
      throw new IllegalArgumentException();
    }
  }
}