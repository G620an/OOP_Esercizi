package oop.Ospedale;
public abstract class RepartoAbstract implements Reparto{

  @Override
  public String toString(){
    return "Codice: "+ codice()+ ", Nome Reparto: " + nomeReparto() + ", Capacità Pazienti: " + capacitaPazienti() + ", Medici: " + medici() + ", Superficie: " + superficie() + ", Criticità: " + criticità();
  }
  
  @Override
  public boolean equals(Object o){
    if(o == this){
      return true;
    }
    if(o == null){
      return false;
    }else if(o instanceof RepartoAbstract rep){
      return this.codice().equals(rep.codice());
    }
    return false;
  }
  
  @Override
  public int hashCode(){
      return this.codice().hashCode();
  }
}