package Ferrovie;

public interface Vagone {
    Identificativo getID();
    Lunghezza getLunghezza();
    MassaConcreta getMassa();
    MassaConcreta.MassaFrenata getMassaFrenata();
    Velocita getVelocita();
}
