public interface Ospedale extends Iterable<Reparto>{ //Sara la nostra struttura dati
  void aggiungiReparto(Reparto r)<
  boolean rimuoviReparto(Reparto r)<
  Reparto getReparto(int index);
  double calcolaRatioMediciPazienti()<
  boolean verificaStandard();
}