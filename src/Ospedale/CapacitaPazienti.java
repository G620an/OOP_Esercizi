package Ospedale;
public record CapacitaPazienti(int cap){
  public CapacitaPazienti{
      if(cap < 2 || cap > 120){throw new IllegalArgumentException("Il numero di pazienti deve essere compreso tra 2 e 120");}
  }
}