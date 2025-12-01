package CifrarioDiCesare;
import java.IO.*;

public static void main(String[] args){
  if(args.length != 2){
    throw new IllegalArgumentException("Numero di argomenti diverso da tre");
  }
  String path = args[0];
  String metodo = args[1];
}