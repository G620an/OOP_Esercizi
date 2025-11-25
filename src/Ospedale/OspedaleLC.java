package Ospedale;

import java.util.Iterator;

public class OspedaleLC implements Ospedale{
    public OspedaleLC(){}

    @Override
    public boolean rimuoviReparto(Reparto r){
        return true;
    }

    @Override
    public void aggiungiReparto(Reparto r){

    }

    @Override
    public Iterator<Reparto> iterator() {
        return null;
    }

}
