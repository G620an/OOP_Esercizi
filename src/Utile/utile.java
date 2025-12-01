package Utile;
import java.io.*;
import java.util.*;

public class Utile{
    private Utile(){}

    public static void generaRandom(OutputStream out, long n)throw new IOException(){
       Random r = new Random();
       for(int i=0 ; i<n ; i++){
           out.writeLong(r.nextLong());
       }
    }

    public static void naturalMergeSort(InputStream in)throw new IOException(){
        
    }

     

}