package Ospedale;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class OspedaleImpl implements Ospedale{
  private final HashSet<Reparto> reparti = new HashSet<>();
  public OspedaleImpl(){}
  
  @Override
  public boolean rimuoviReparto(Reparto r){
      if(reparti.remove(r)){
          return true;
      }else{
          return false;
      }
  }
  
  @Override
  public void aggiungiReparto(Reparto r){
    reparti.add(r);
  }
  
  @Override
  public Iterator<Reparto> iterator() {
      return reparti.iterator(); //Restituisco un iteratore della struttura dati che definisco all'inizio
  }

  public String toString(){
      StringBuilder sb = new StringBuilder();
      for(Reparto r : this){
          sb.append(r.toString());
      }
      return sb.toString();
  }



}