package oop.Utile;
import java.io.*;
import java.util.*;

public class Utile{
    private Utile(){}

    public static void generaRandom(OutputStream out, long n)throws IOException{
       Random r = new Random();
       DataOutputStream dos = new DataOutputStream(out);
        for(int i=0 ; i<n ; i++){
            dos.writeInt(r.nextInt());
        }
    }

    public static void naturalMergeSort(File f){
        File f1 = null;
        File f2 = null;
        String temp1 = "temp1.txt";
        String temp2 = "temp2.txt";
        while(!crescente(f)){
            f1 = new File(temp1);
            f2 = new File(temp2);
            try(DataOutputStream dos1 = new DataOutputStream(new FileOutputStream(f1)); DataOutputStream dos2 = new DataOutputStream(new FileOutputStream(f2)); DataInputStream dis = new DataInputStream(new FileInputStream(f));){
                boolean primo = true;
                int pre = Integer.MIN_VALUE;
                int cor;
                try{
                    while(true){
                        cor = dis.readInt();
                        if(pre <= cor){
                            if(primo){
                                dos1.writeInt(cor);
                            }else{
                                dos2.writeInt(cor);
                            }
                        }else{
                            primo = !primo;
                            if(primo){
                                dos1.writeInt(cor);
                            }else{
                                dos2.writeInt(cor);
                            }
                        }
                        pre = cor;
                    }
                }catch(EOFException eof){
                    ricostruisci(f, f1, f2);
                }
            }catch (IOException e){
                e.printStackTrace();
            }
        }
        try{
            f1.delete();
            f2.delete();
        }catch(NullPointerException nsfe){
            System.out.println("File già ordinato in modo crescente");
        }
    }

    public static boolean crescente(File f){
        try(DataInputStream dos = new DataInputStream(new FileInputStream(f));){
            int pre = Integer.MIN_VALUE;
            int cor;
            while(true){
                cor = dos.readInt();
                if(pre > cor){
                    return false;
                }
                pre = cor;
            }
        }catch(IOException e) {
            return true;
        }
    }

    public static void ricostruisci(File f, File f1, File f2){
        boolean stato = false;
        try(DataInputStream dis1 = new DataInputStream(new FileInputStream(f1)); DataInputStream dis2 = new DataInputStream(new FileInputStream(f2)); DataOutputStream dos = new DataOutputStream(new FileOutputStream(f))){
            try{
                int uno = dis1.readInt();
                int due = dis2.readInt();

                while(true){
                    if(uno <= due){
                        dos.writeInt(uno);
                        stato = false;
                        uno = dis1.readInt();
                    }else{
                        dos.writeInt(due);
                        stato = true;
                        due = dis2.readInt();
                    }
                }

            }catch(EOFException eof){
                if(stato){
                    while(true){
                        dos.writeInt(dis1.readInt());
                    }
                }else{
                    while(true){
                        dos.writeInt(dis2.readInt());
                    }
                }
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
     

}