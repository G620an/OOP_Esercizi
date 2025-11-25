public interface Reparto extends Comparable{
  CodiceReparto codice();
  NomeReparto nomeReparto;
  CapacitaPazienti capacitaPazienti;
  int medici();
  Superficie superficie();
  Criticità criticità();
}