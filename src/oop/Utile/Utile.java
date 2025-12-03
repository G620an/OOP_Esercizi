package oop.Utile;
import java.io.*;
import java.util.*;

public class Utile{
    private Utile(){}

    public static void generaRandom(OutputStream out, long n)throws IOException{
       Random r = new Random();
       DataOutputStream dos = new DataOutputStream(out);
        for(int i=0 ; i<n ; i++){
            dos.writeLong(r.nextLong());
        }
    }

    public static void naturalMergeSort(InputStream in)throws IOException{
        
    }

     

}