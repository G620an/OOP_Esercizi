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

  long n = 1024; //sono 4 MB di roba perchè gli int sono a 4 byte
  String path = "prova.txt";
  try{
      Utile.generaRandom(new BufferedOutputStream(new FileOutputStream(path), 8128), n);
      Utile.printFile(new FileInputStream(path));
      Utile.naturalMergeSort(new File(path));
      System.out.println("-----------------");
      Utile.printFile(new FileInputStream(path));
  }catch(IOException e){
      e.printStackTrace();
  }

}