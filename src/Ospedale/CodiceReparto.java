package Ospedale;
public record CodiceReparto(String codice){
  public CodiceReparto{
      if(codice.length() != 6){throw new IllegalArgumentException("Il codice deve essere 6 lettere");}
      for(int i = 0; i < 6; i++){
          if(i < 3){
              if(!Character.isAlphabetic(codice.charAt(i))){throw new IllegalArgumentException("Il codice è del tipo XXX000");}
          }else{
              if(!Character.isDigit(codice.charAt(i))){throw new IllegalArgumentException("Il codice è del tipo XXX000");}
          }
      }
  }
}