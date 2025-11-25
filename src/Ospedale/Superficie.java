package Ospedale;
public record Superficie(double area){
  public Superficie{
    if(area < 20.0 || area > 2000.0){
      throw new IllegalArgumentException("Valore dell'Area non valido");
    }
  }
}