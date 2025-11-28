package Utile;
import java.io.*;
import java.util.*;

public class Utile{
    private Utile(){}
    public void generaRandom(DataOutputStream out, long n)throw new IOException(){
       Random r = new Random();
       for(int i=0 ; i<n ; i++){
           out.writeLong(r.nextLong());
       }
    }
}