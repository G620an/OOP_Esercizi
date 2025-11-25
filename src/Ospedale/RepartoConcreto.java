package Ospedale;
public class RepartoConcreto extends RepartoAbstract{
  private CodiceReparto codice;
  private NomeReparto nome;
  private CapacitaPazienti capacitaPazienti;
  private int medici;
  private Superficie superficie;
  private Criticità criticità;
  
  public RepartoConcreto(CodiceReparto codice , NomeReparto nome, CapacitaPazienti capacitaPazienti , int medici, Superficie superficie , Criticità criticità){
    super(); //Chiamata esplicita al costruttore della classe genitore , anche se non ha un costruttore esplicito la abstract
    this.codice = codice;
    this.nome = nome;
    this.capacitaPazienti = capacitaPazienti;
    if(medici <= 0 || medici > 50){
      throw new IllegalArgumentException("Valore dei medici invalido");
    }
    this.superficie = superficie;
    this.criticità = criticità;
  }
  
  @Override
  public CodiceReparto codice(){
    return codice;
  }
  
  @Override
  public NomeReparto nomeReparto(){
    return nome;
  }
  
  @Override
  public CapacitaPazienti capacitaPazienti(){return capacitaPazienti;}
  
  @Override
  public int medici(){
    return medici;
  }
  
  @Override
  public Criticità criticità(){
    return criticità;
  }
  
  
}