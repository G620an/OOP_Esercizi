public interface Reparto extends Comparable{
  CodiceReparto codice();
  NomeReparto nomeReparto;
  CapacitaPazienti capacitaPazienti;
  int medici();
  Superficie superficie();
  Criticità criticità();
  
  @Override
  public int compareTo(Reparto T){
    return codice.codice().compareTo(T.codice.codice());
  }
}