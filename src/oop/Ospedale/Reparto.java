package oop.Ospedale;
public interface Reparto extends Comparable<Reparto>{
  CodiceReparto codice();
  NomeReparto nomeReparto();
  CapacitaPazienti capacitaPazienti();
  int medici();
  Superficie superficie();
  Criticità criticità();
  
  @Override
  public default int compareTo(Reparto T){
      return this.codice().codice().compareTo(T.codice().codice());
  }
}