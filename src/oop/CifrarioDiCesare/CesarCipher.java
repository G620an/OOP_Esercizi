package oop.CifrarioDiCesare;
import java.io.*;
import java.util.Scanner;

public class CesarCipher{
  private CesarCipher(){};
  private static int spStart = 192;
  private static int spFinish = 255;
  private static int N = 25; //Lettere dell'alfabeto
  private static int spN = 63; //Lettere speciali

  public static void cifra(String path , int key)throws IOException{
      if(key > 1024) throw new IllegalArgumentException();
      String pathTemp = "temp.txt";
      File OUT = new File(pathTemp) ; File IN = new File(path);
      if(!IN.exists()) throw new FileNotFoundException();
      OUT.createNewFile();
      try(BufferedReader br = new BufferedReader(new FileReader(IN)) ; PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(OUT , true)))){
            boolean continua = true;
            while(continua){
                int i = br.read();
                if(i == -1){ continua = false; break;}
                char c = CF((char)i , key);
                pw.print(c);
            }
            OUT.renameTo(IN);
      }
  }

  private static char CF(char c , int key){
      if(c >= spStart && c <= spFinish){
          int som = key%spN;
          return (char)(c + som);
      }
      if(Character.isLetter(c)){
          int som = key%N;
          return (char)(c + som);
      }
      return c;
  }
  
  public static void decifra(String path,  int key)throws IOException{
      cifra(path , -key);
  }

  public static void prova(){
      String p = "cif.txt";
      try{
          CesarCipher.cifra(p , 128);
      }catch(Exception e){
          e.printStackTrace();
      }
      String path = "dec.txt";
      try{
          CesarCipher.decifra(path , 128);
      }catch(Exception e){
          e.printStackTrace();
      }
  }
}