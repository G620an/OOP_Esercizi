from Ristrutturazioni import *

class RistrutturazioniStrutturale(RistrutturazioneImpiantistica):
    def __init__(self , ID:Identificatore , nome:NomeProgetto , capOperai:CapacitaOperai , superficie:Superficie , budget:Budget , complessita:Complessita , codiceProgetto:CodiceProgetto , cila:CILA):
        super().__init__(ID , nome , capOperai , superficie , budget , complessita)
        self._codiceProgetto = codiceProgetto
        self._cila = cila

    def getCodiceProgetto(self):
        return self._codiceProgetto

    def getCila(self):
        return self._cila

    def __str__(self):
        return super().__str__() + ", Codice Progetto: " + self.getCodiceProgetto() + ", CILA: " + self.getCila()

    def __repr__(self):
        return self.__str__()
