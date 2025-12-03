import oop.*;
import oop.Utile.Utile; 

public static void main(String[] args){
  /*
  if(args.length != 3){
    throw new IllegalArgumentException("Numero di argomenti diverso da tre");
  }
  String path = args[0];
  String metodo = args[1];
  int key = Integer.parseInt(args[2]);
  metodo += metodo.toLowerCase();

  if(metodo.equals("cifra")){
    CesarCipher.cifra(path , key);
  }else if(metodo.equals("decifra")){
    CesarCipher.decifra(path , 1);
  }else{
    throw new IllegalArgumentException("Parametro di cifratura errato");
  }
  */

  long n = 1024*1024;
  try{
      Utile.generaRandom(new BufferedOutputStream(new FileOutputStream("prova.txt"), 8128), n);
  }catch(IOException e){
      e.printStackTrace();
  }

}