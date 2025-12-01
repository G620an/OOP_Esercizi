package Magazino;
public record Materiale(String nome, int qta){
  public Materiale{
    if(nome == null || wta < 0){
      throw new IllegalArgumentException();
    }
  }
}