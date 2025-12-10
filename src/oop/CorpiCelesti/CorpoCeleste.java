package oop.CorpiCelesti;

import java.io.Serializable;

public interface CorpoCeleste extends Serializable{
    Massa getMassa();
    Raggio getRaggio();
    Distanza getDistanzaDallaTerra();
    Codice getCodice();
    String getNickname();
}
