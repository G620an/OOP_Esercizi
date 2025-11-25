public abstract class RepartoAbstract{
  @Override
  public String toString(){
    return ""+ codiceReparto()+ " " + nomeReparto() + " " + capacitaPazienti() + " " + medici() + " " + superficie() + " " + criticità(); 
  }
  
  @Override
  public boolean equals(Object o){
    if(o == this){
      return true;
    }
    if(o == null){
      return false;
    }else if(o instanceof RepartoAbstract rep){
      return this.codiceReparto().equals(rep.codiceReparto());
    }
    return false
  }
}