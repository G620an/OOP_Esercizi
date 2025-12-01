package Magazino;
public record Materiale(String nome, int qta) implements Serializzable{
  public Materiale{
    if(nome == null || wta < 0){
      throw new IllegalArgumentException();
    }
  }
}