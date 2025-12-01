package CifrarioDiCesare;
import java.IO.*;

public static void main(String[] args){
  if(args.length != 3){
    throw new IllegalArgumentException("Numero di argomenti diverso da tre");
  }
  String path = args[0];
  String metodo = args[1];
  int key = Integer.parseInt(args[2]);
  metodo += metodo.toLower();
  if(metodo.equals("cifra")){
    CesarCipher.cifra(path , key);
  }else if(metodo.equals("decifra")){
    CesarCipher.decifra(path , key);
  }
}