import oop.Utile.Utile;
import oop.Range.*;
import oop.Punto.*;

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

  long n = 5; //sono 4 MB di roba perchè gli int sono a 4 byte
  String path = "prova.dat";
  File file = new File(path);
  try{
      Utile.generaRandom(new BufferedOutputStream(new FileOutputStream(path), 8192), n);
      Utile.printFile(new FileInputStream(file), file.length());
      Utile.naturalMergeSort(file);
      System.out.println("-------------------------------------------");
      Utile.printFile(new FileInputStream(file), file.length());
  }catch(IOException e){
      e.printStackTrace();
  }
  


}