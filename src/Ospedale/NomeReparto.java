package Ospedale;

import java.nio.charset.Charset;

public record NomeReparto(String nome){
  public NomeReparto{
      if(nome.isBlank()){throw new IllegalArgumentException("Il nome non può essere vuoto");}
      if(nome.length()<4 || nome.length()>50){throw new IllegalArgumentException("Nome troppo lungo");}
      if(!Character.isAlphabetic(nome.charAt(0))){throw new IllegalArgumentException("Il primo carattere deve essere una lettera");}
      //Character è una bella classe di caratteri per capire se un carattere è alfanumerico o solo numerico etc
      nome = nome.trim();
  }
}