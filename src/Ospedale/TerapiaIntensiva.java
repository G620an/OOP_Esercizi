package Ospedale;

public class TerapiaIntensiva extends RepartoConcreto{
    private Monitoraggio monitoraggio;
    public TerapiaIntensiva(CodiceReparto codice , NomeReparto nome, CapacitaPazienti capacitaPazienti , int medici, Superficie superficie , Criticità criticità,  Monitoraggio monitoraggio) {
        super(codice, nome, capacitaPazienti, medici, superficie, criticità);
        if(medici < 15){
            throw new IllegalArgumentException("Medici deve essere maggiore di 15 per la terapia intensiva");
        }
        this.monitoraggio = monitoraggio;
    }

    public Monitoraggio getMonitoraggio() {
        return monitoraggio;
    }

    @Override
    public String toString(){
        return super.toString() + ", Monitoraggio: " + monitoraggio;
    }


}
