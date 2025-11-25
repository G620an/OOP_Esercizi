package Ospedale;

import java.util.Iterator;

public class OspedaleLC implements Ospedale{
    private final LinkedReparti reparti;
    public OspedaleLC(){
        this.reparti = new LinkedReparti();
    }

    @Override
    public boolean rimuoviReparto(Reparto r){
        return true;
    }

    @Override
    public void aggiungiReparto(Reparto r){

    }

    @Override
    public Iterator<Reparto> iterator(){
        return reparti.iterator();
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        for(Reparto r : this){
            sb.append(r.toString());
        }
        return sb.toString();
    }
}
