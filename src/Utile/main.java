package Utile;

public static void main(String[] args){
  long n = 1024*1024;
  Utile.generaRandom(new BufferedOutputStream(FileOutputStream("prova.txt"), 8128), n);
}